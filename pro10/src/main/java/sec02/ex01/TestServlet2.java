package sec02.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 테스트2 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.29 Sat 01:57:41
 */
@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet
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
		
		String context = req.getContextPath();
		String url = req.getRequestURL().toString();
		String mapping = req.getServletPath();
		String uri = req.getRequestURI();
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Test Servlet2</title>");
		out.println("</head>");
		out.println("<body bgcolor='yellow'>");
		out.println("<b>TestServlet2입니다.</b><br>");
		out.println("<b>컨텍스트 이름: " + context + "</b><br>");
		out.println("<b>전체 경로: " + url + "</b><br>");
		out.println("<b>매핑 이름: " + mapping + "</b><br>");
		out.println("<b>URI: " + uri + "</b>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
