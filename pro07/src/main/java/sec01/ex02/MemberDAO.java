package sec01.ex02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 회원 데이터베이스 클래스
 *
 * @author RWB
 * @since 2022.01.26 Wed 22:39:24
 */
public class MemberDAO
{
	private Connection con;
	
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
			connDB();
			
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
	
	/**
	 * 데이터베이스 연결 메서드
	 */
	private void connDB()
	{
		// 데이터베이스 연결 시도
		try
		{
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Mariadb 드라이버 로딩 성공");
			
			con = DriverManager.getConnection("", "", "");
			System.out.println("Connection 생성 성공");
		}
		
		// 예외
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}