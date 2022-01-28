package sec03.ex01;

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
 * @since 2022.01.28 Fri 10:06:44
 */
@WebServlet("/second5")
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
		resp.setContentType("text/html; charset=UTF-8");
		
		String name = req.getParameter("name");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("이름: " + name);
		out.println("<br />");
		out.println("dispatch를 이용한 forward 실습입니다.");
		out.println("</body></html>");
	}
}
