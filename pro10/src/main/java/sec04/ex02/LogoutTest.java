package sec04.ex02;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 로그아웃 테스트 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.29 Sat 14:03:54
 */
@WebServlet("/logout")
public class LogoutTest extends HttpServlet
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
	@SuppressWarnings("unchecked")
	protected void doHandle(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String user_id = req.getParameter("user_id");
		
		HttpSession session = req.getSession();
		session.invalidate();
		
		ServletContext context = getServletContext();
		
		List<String> user_list = (List<String>) context.getAttribute("user_list");
		user_list.remove(user_id);
		
		context.removeAttribute("user_list");
		context.setAttribute("user_list", user_list);
		
		PrintWriter out = resp.getWriter();
		out.println("<br>로그아웃했습니다.");
	}
}
