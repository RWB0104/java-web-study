package sec05.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 회원 표시 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 22:55:19
 */
@WebServlet("/show")
public class ShowMember extends HttpServlet
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
		
		HttpSession session = req.getSession(false);
		
		// 세션이 유효할 경우
		if (session != null)
		{
			boolean isLogon = Boolean.parseBoolean(session.getAttribute("isLogon").toString());
			
			// 로그인 상태일 경우
			if (isLogon)
			{
				String id = session.getAttribute("login.id").toString();
				String pwd = session.getAttribute("login.pwd").toString();
				
				PrintWriter out = resp.getWriter();
				out.print("<html><body>");
				out.print("아이디: " + id + "<br>");
				out.print("비밀번호: " + pwd + "<br>");
				out.print("</body></html>");
			}
			
			// 아닐 경우
			else
			{
				resp.sendRedirect("/pro09/login5");
			}
		}
		
		// 아닐 경우
		else
		{
			resp.sendRedirect("/pro09/login5.html");
		}
	}
}
