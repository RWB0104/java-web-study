package sec03.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;

/**
 * 로그인3 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.26 Wed 14:20:54
 */
@WebServlet("/login3")
public class LoginServlet3 extends HttpServlet
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
		req.setCharacterEncoding("UTF-8");
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
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
