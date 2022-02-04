package sec01.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 세션 테스트 서블릿 클래스
 *
 * @author RWB
 * @since 2022.02.04 Fri 00:35:12
 */
@WebServlet("/sess")
public class SessionTest extends HttpServlet
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
		
		HttpSession session = req.getSession();
		session.setAttribute("name", "이순신");
		
		PrintWriter out = resp.getWriter();
		out.print("<html><body>");
		out.print("<h1>세션에 이름을 바인딩합니다.</h1>");
		out.print("<a href='/pro12/test01/session1.jsp'>첫 번째 페이지로 이동하기</a>");
		out.print("</body></html>");
	}
}
