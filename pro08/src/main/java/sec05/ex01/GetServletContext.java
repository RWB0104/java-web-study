package sec05.ex01;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 서블릿 컨텍스트 확인 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 15:05:14
 */
@WebServlet("/cget")
public class GetServletContext extends HttpServlet
{
	/**
	 * GET 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws ServletException 서블릿 예외
	 * @throws IOException 데이터 입출력 예외
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		resp.setContentType("text/html; charset=UTF-8");
		
		ServletContext context = getServletContext();
		
		List<Object> member = (List<Object>) context.getAttribute("member");
		
		String name = member.get(0).toString();
		int age = Integer.parseInt(member.get(1).toString());
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print(name + "<br>");
		out.print(age + "<br>");
		out.print("</body></html>");
	}
}
