package sec01.ex02;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 두 번째 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 17:55:55
 */
@WebServlet("/second")
public class SecondServlet extends HttpServlet
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
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		String user_address = req.getParameter("user_address");
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		
		// 아이디가 유효할 경우
		if (user_id != null && user_id.length() != 0)
		{
			out.println("이미 로그인 상태입니다!<br><br>");
			out.println("첫 번째 서블릿에서 넘겨준 아이디: " + user_id + "<br>");
			out.println("첫 번째 서블릿에서 넘겨준 비밀번호: " + user_pw + "<br>");
			out.println("첫 번째 서블릿에서 넘겨준 주소: " + user_address + "<br>");
		}
		
		// 아닐 경우
		else
		{
			out.println("로그인 하지 않았습니다.<br><br>");
			out.println("다시 로그인하세요!!<br>");
			out.println("<a href='/pro09/login2.html'>로그인창으로 이동하기</a>");
		}
		
		out.println("</body></html>");
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
