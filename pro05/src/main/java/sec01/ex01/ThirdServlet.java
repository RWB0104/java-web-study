package sec01.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.26 Wed 00:59:17
 */
@WebServlet("/third")
public class ThirdServlet extends HttpServlet
{
	/**
	 * 초기화 메서드
	 */
	@Override
	public void init()
	{
		System.out.println("ThirdServlet init 메서드 호출");
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
		System.out.println("ThirdServlet doGet 메서드 호출");
	}
	
	/**
	 * POST 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	{
		System.out.println("ThirdServlet doPost 메서드 호출");
	}
}
