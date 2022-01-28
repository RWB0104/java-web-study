package sec01.ex02;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 첫 번째 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 09:52:05
 */
@WebServlet("/first2")
public class FirstServlet extends HttpServlet
{
	/**
	 * GET 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	{
		resp.setContentType("text/html; charset=UTF-8");
		resp.addHeader("Refresh", "1; url=second2");
	}
}
