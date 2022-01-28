package sec04.ex03;

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
 * @since 2022.01.28 Fri 10:31:48
 */
public class MemberDAO
{
	private DataSource dataFactory;
	private Connection con;
	private PreparedStatement pstmt;
	
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
			con = dataFactory.getConnection();
			
			String query = "SELECT * FROM T_MEMBER";
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			
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
	 * 회원 추가 메서드
	 *
	 * @param memberVO: [MemberVO] 회원 객체
	 */
	public void addMember(MemberVO memberVO)
	{
		// 회원 추가 시도
		try
		{
			con = dataFactory.getConnection();
			
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			
			String query = "INSERT INTO T_MEMBER(ID, PWD, NAME, EMAIL) VALUES(?, ?, ?, ?)";
			System.out.println("PreparedStatement: " + query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
			
			con.close();
		}
		
		// 예외
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 회원 삭제 메서드
	 *
	 * @param id: [String] 아이디
	 */
	public void delMember(String id)
	{
		// 회원 삭제 시도
		try
		{
			con = dataFactory.getConnection();
			
			String query = "DELETE FROM T_MEMBER WHERE ID = ?";
			System.out.println("PrepareStatement: " + query);
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
			
			con.close();
		}
		
		// 예외
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}