package sec04.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 두 번째 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 10:22:12
 */
@WebServlet("/second6")
public class SecondServlet extends HttpServlet
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
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String address = (String) req.getAttribute("address");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("주소: " + address);
		out.println("<br />");
		out.println("redirect를 이용한 바인딩 실습입니다.");
		out.println("</body></html>");
	}
}
