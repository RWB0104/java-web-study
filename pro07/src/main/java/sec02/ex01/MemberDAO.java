package sec02.ex01;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 회원 데이터베이스 클래스
 *
 * @author RWB
 * @since 2022.01.27 Thu 10:02:00
 */
public class MemberDAO
{
	private DataSource dataFactory;
	
	/**
	 * 생성자 메서드
	 */
	public MemberDAO()
	{
		// 인스턴스 초기화 시도
		try
		{
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			
			dataFactory = (DataSource) envContext.lookup("test/mariadb");
		}
		
		// 예외
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 회원 리스트 반환 메서드
	 *
	 * @return [List] 회원 리스트
	 */
	public List<MemberVO> listMembers()
	{
		List<MemberVO> list = new ArrayList<>();
		
		// 회원 리스트 조회 시도
		try
		{
			Connection con = dataFactory.getConnection();
			
			String query = "SELECT * FROM T_MEMBER";
			System.out.println(query);
			
			PreparedStatement pstmt = con.prepareStatement(query);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next())
			{
				String id = rs.getString("ID");
				String pwd = rs.getString("PWD");
				String name = rs.getString("NAME");
				String email = rs.getString("EMAIL");
				Date joinDate = rs.getDate("JOINDATE");
				
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();
			con.close();
		}
		
		// 예외
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
	}
}