package sec03.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 로그인 테스트 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.29 Sat 02:19:21
 */
@WebServlet("/login")
public class LoginTest extends HttpServlet
{
	/**
	 * POST 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws IOException 데이터 입출력 예외
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.setContentType("text/html; charset=UTF-8");
		
		String user_name = req.getParameter("user_name");
		String user_pw = req.getParameter("user_pw");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("이름은 " + user_name + "<br>");
		out.println("비밀번호는 " + user_pw + "<br>");
		out.println("</body></html>");
	}
}
