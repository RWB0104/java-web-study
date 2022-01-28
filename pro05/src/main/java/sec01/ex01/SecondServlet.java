package sec01.ex01;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.26 Wed 00:55:06
 */
public class SecondServlet extends HttpServlet
{
	/**
	 * 초기화 메서드
	 */
	@Override
	public void init()
	{
		System.out.println("init 메서드 호출 >>>>>");
	}
	
	/**
	 * GET 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
		System.out.println("doGet 메서드 호출 >>>>>");
	}
	
	/**
	 * 종료 메서드
	 */
	@Override
	public void destroy()
	{
		System.out.println("destroy 메서드 호출 >>>>>");
	}
}
