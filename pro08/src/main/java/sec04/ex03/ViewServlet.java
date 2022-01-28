package sec04.ex03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

/**
 * 뷰 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 10:36:09
 */
@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		List<MemberVO> membersList = (List<MemberVO>) req.getAttribute("membersList");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일</td><td>삭제</td></tr>");
		
		for (MemberVO memberVO : membersList)
		{
			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();
			Date joinDate = memberVO.getJoinDate();
			
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name + "</td><td>" + email + "</td><td>" + joinDate + "</td><td><a href='/pro08/member?command=delMember&id=" + id + "'>삭제</a></td></tr>");
		}
		
		out.print("</table>");
		out.print("<a href='/pro08/memberForm.html'>새 회원 등록하기</a>");
		out.print("</body></html>");
	}
}
