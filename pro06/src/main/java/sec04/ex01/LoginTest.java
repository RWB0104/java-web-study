package sec04.ex01;

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
 * @since 2022.01.26 Wed 15:30:05
 */
@WebServlet("/loginTest")
public class LoginTest extends HttpServlet
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
		
		PrintWriter out = resp.getWriter();
		
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		
		System.out.println("아이디: " + id);
		System.out.println("패스워드: " + pw);
		
		// 아이디가 유효할 경우
		if (id != null && id.length() != 0)
		{
			out.print("<html>");
			out.print("<body>");
			out.print(id + "님!! 로그인 하셨습니다.");
			out.print("</body>");
			out.print("</html>");
		}
		
		// 아이디가 유효하지 않을 경우
		else
		{
			out.print("<html>");
			out.print("<body>");
			out.print("아이디를 입력하세요!!!");
			out.print("<br>");
			out.print("<a href='/pro06/test01/login.html'>로그인 창으로 이동</a>");
			out.print("</body>");
			out.print("</html>");
		}
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
