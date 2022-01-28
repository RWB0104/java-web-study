package sec04.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 세션 테스트5 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 22:28:07
 */
@WebServlet("/login4")
public class SessionTest5 extends HttpServlet
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
		
		PrintWriter out = resp.getWriter();
		
		HttpSession session = req.getSession();
		
		// 새로운 세션일 경우
		if (session.isNew())
		{
			// 아이디가 유효할 경우
			if (user_id != null)
			{
				session.setAttribute("user_id", user_id);
				
				String url = resp.encodeURL("/pro09/login4");
				
				out.println("<a href='" + url + "'>로그인 상태 확인</a>");
			}
			
			// 아닐 경우
			else
			{
				out.println("<a href='/pro09/login4.html'>다시 로그인 하세요!!</a>");
				
				session.invalidate();
			}
		}
		
		// 기존에 존재하던 세션일 경우
		else
		{
			user_id = session.getAttribute("user_id").toString();
			
			// 아이디가 유효할 경우
			if (user_id != null && user_id.length() != 0)
			{
				out.println("안녕하세요 " + user_id + "님!!!");
			}
			
			// 아닐 경우
			else
			{
				out.println("<a href='/pro09/login4.html'>다시 로그인 하세요!!</a>");
				
				session.invalidate();
			}
		}
	}
}
