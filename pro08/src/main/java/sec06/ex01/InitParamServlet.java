package sec06.ex01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 초기 파라미터 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 16:34:24
 */
@WebServlet(
		name = "InitParamServlet",
		urlPatterns = { "/sInit", "/sInit2" },
		initParams = { @WebInitParam(name = "email", value = "admin@jweb.com"), @WebInitParam(name = "tel", value = "010-1111-2222") })
public class InitParamServlet extends HttpServlet
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
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("<table><tr>");
		out.print("<td>email: </td><td>" + email + "</td></tr>");
		out.print("<tr><td>tel: </td><td>" + tel + "</td>");
		out.print("</tr></table></body></html>");
		out.close();
	}
}
