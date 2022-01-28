package sec01.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 로그인 서블릿
 *
 * @author RWB
 * @since 2022.01.28 Fri 17:45:29
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet
{
	/**
	 * 초기화 메서드
	 */
	@Override
	public void init()
	{
		System.out.println("init 메서드 호출");
	}
	
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
		String user_address = req.getParameter("user_address");
		String user_email = req.getParameter("user_email");
		String user_hp = req.getParameter("user_hp");
		
		StringBuilder builder = new StringBuilder();
		builder.append("<html><body>");
		builder.append("안녕하세요!<br>로그인하셨습니다.<br><br>");
		builder.append("아이디: ").append(user_id).append("<br>");
		builder.append("비밀번호: ").append(user_pw).append("<br>");
		builder.append("주소: ").append(user_address).append("<br>");
		builder.append("email: ").append(user_email).append("<br>");
		builder.append("휴대전화: ").append(user_hp);
		builder.append("</body></html>");
		
		PrintWriter out = resp.getWriter();
		out.print(builder);
	}
	
	/**
	 * 소멸 메서드
	 */
	@Override
	public void destroy()
	{
		System.out.println("destory 메서드 호출");
	}
}
