package sec02.ex02;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

/**
 * 회원4 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.27 Thu 10:09:06
 */
@WebServlet("/member4")
public class MemberServlet4 extends HttpServlet
{
	/**
	 * GET 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws IOException 데이터 입출력 예외
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		doHandle(req, resp);
	}
	
	/**
	 * POST 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws IOException 데이터 입출력 예외
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		doHandle(req, resp);
	}
	
	/**
	 * 수행 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws IOException 데이터 입출력 예외
	 */
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		MemberDAO dao = new MemberDAO();
		
		String command = req.getParameter("command");
		
		// 회원 추가 명령어일 경우
		if (command != null && command.equals("addMember"))
		{
			String _id = req.getParameter("id");
			String _pwd = req.getParameter("pwd");
			String _name = req.getParameter("name");
			String _email = req.getParameter("email");
			
			MemberVO vo = new MemberVO();
			
			vo.setId(_id);
			vo.setPwd(_pwd);
			vo.setName(_name);
			vo.setEmail(_email);
			
			dao.addMember(vo);
		}
		
		// 회원 삭제 명령어일 경우
		else if (command != null && command.equals("delMember"))
		{
			String id = req.getParameter("id");
			
			dao.delMember(id);
		}
		
		List<MemberVO> list = dao.listMembers();
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for (MemberVO memberVO : list)
		{
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td><td><a href='/pro07/member4?command=delMember&id=" + id + "'>삭제</a></td></tr>");
		}
		
		out.print("</table>");
		out.print("<a href='/pro07/memberForm.html'>새 회원 등록하기</a>");
		out.print("</body></html>");
	}
}