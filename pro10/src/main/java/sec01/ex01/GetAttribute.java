package sec01.ex01;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 속성 할당 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.29 Sat 01:15:03
 */
@WebServlet("/get")
public class GetAttribute extends HttpServlet
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
		
		ServletContext ctx = getServletContext();
		HttpSession session = req.getSession();
		
		String ctxMesg = (String) ctx.getAttribute("context");
		String sesMesg = (String) session.getAttribute("session");
		String reqMesg = (String) req.getAttribute("request");
		
		PrintWriter out = resp.getWriter();
		out.print("context값: " + ctxMesg + "<br>");
		out.print("session값: " + sesMesg + "<br>");
		out.print("request값: " + reqMesg + "<br>");
	}
}
