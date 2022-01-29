package sec04.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 로그인 테스트 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.29 Sat 02:41:27
 */
@WebServlet("/login2")
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
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		
		HttpSession session = req.getSession();
		
		// 새로운 세션일 경우
		if (session.isNew())
		{
			session.setAttribute("loginUser", loginUser);
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<script type='text/javascript'>");
		out.println("setTimeout('history.go(0);', 5000)");
		out.println("</script>");
		out.println("</head>");
		out.println("<body>");
		out.println("아이디는 " + loginUser.user_id + "<br>");
		out.println("총 접속자수는 " + LoginImpl.total_user + "<br>");
		out.println("</body>");
		out.println("</html>");
	}
}
