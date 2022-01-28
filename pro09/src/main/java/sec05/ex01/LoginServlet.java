package sec05.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 로그인 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 22:40:57
 */
@WebServlet("/login5")
public class LoginServlet extends HttpServlet
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
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		PrintWriter out = resp.getWriter();
		
		MemberVO memberVO = new MemberVO();
		memberVO.setId(user_id);
		memberVO.setPwd(user_pw);
		
		MemberDAO dao = new MemberDAO();
		
		boolean result = dao.isExisted(memberVO);
		
		// 존재하는 회원일 경우
		if (result)
		{
			HttpSession session = req.getSession();
			session.setAttribute("isLogon", true);
			session.setAttribute("login.id", user_id);
			session.setAttribute("login.pwd", user_pw);
			
			out.print("<html><body>");
			out.print("안녕하세요 " + user_id + "님!!!<br>");
			out.print("<a href='/pro09/show'>회원정보 보기</a>");
			out.print("</body></html>");
		}
		
		// 아닐 경우
		else
		{
			out.print("<html><body><center>회원 아이디가 틀립니다.</center>");
			out.print("<a href='/pro09/login5.html'>다시 로그인하기</a>");
			out.print("</body></html>");
		}
	}
}
