package sec03.ex03;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 로그인5 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.26 Wed 15:23:26
 */
@WebServlet("/login5")
public class LoginServlet5 extends HttpServlet
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
		resp.setContentType("text/html;charset=UTF-8");
		
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		String address = req.getParameter("user_address");
		
		StringBuilder builder = new StringBuilder();
		builder.append("<html>");
		builder.append("<body>");
		builder.append("아이디: ").append(id);
		builder.append("<br>");
		builder.append("비밀번호: ").append(pw);
		builder.append("<br>");
		builder.append("주소: ").append(address);
		builder.append("</body>");
		builder.append("</html>");
		
		PrintWriter out = resp.getWriter();
		out.print(builder);
	}
	
	/**
	 * 종료 메서드
	 */
	@Override
	public void destroy()
	{
		System.out.println("destroy 메서드 호출");
	}
}
