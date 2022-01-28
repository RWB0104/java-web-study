package sec03.ex02;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;

/**
 * 로그인4 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.26 Wed 14:24:49
 */
@WebServlet("/login4")
public class LoginServlet4 extends HttpServlet
{
	/**
	 * 초기화 메서드
	 */
	@Override
	public void init()
	{
		System.out.println("init 메서드 호출");
	}
	
	/**
	 * GET 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws UnsupportedEncodingException 지원하지 않는 인코딩 예외
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException
	{
		System.out.println("doGet 메서드 호출");
		
		doHandle(req, resp);
	}
	
	/**
	 * POST 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws UnsupportedEncodingException 지원하지 않는 인코딩 예외
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException
	{
		System.out.println("doPost 메서드 호출");
		
		doHandle(req, resp);
	}
	
	/**
	 * 수행 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws UnsupportedEncodingException 지원하지 않는 인코딩 예외
	 */
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException
	{
		req.setCharacterEncoding("UTF-8");
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		System.out.println("doHandle 메서드 호출");
		System.out.println("아이디: " + user_id);
		System.out.println("비밀번호: " + user_pw);
	}
	
	/**
	 * 종료 메서드
	 */
	@Override
	public void destroy()
	{
		System.out.println("destroy 메서드 호출");
	}
}
