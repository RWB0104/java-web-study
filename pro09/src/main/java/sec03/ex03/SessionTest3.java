package sec03.ex03;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * 세션 테스트3 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 22:13:05
 */
@WebServlet("/sess3")
public class SessionTest3 extends HttpServlet
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
		
		PrintWriter out = resp.getWriter();
		out.println("세션 아이디: " + session.getId() + "<br>");
		out.println("최초 세션 생성 시각: " + new Date(session.getCreationTime()) + "<br>");
		out.println("최근 세션 접근 시각: " + new Date(session.getLastAccessedTime()) + "<br>");
		out.println("세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");
		
		// 신규 세션일 경우
		if (session.isNew())
		{
			out.println("새 세션이 만들어졌습니다.");
		}
		
		session.invalidate();
	}
}
