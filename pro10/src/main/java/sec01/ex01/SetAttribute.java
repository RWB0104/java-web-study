package sec01.ex01;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 속성 설정 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.29 Sat 01:10:50
 */
@WebServlet("/set")
public class SetAttribute extends HttpServlet
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
		
		String ctxMesg = "context에 바인딩됩니다.";
		String sesMesg = "session에 바인딩됩니다.";
		String reqMesg = "request에 바인딩됩니다.";
		
		ServletContext ctx = getServletContext();
		ctx.setAttribute("context", ctxMesg);
		
		HttpSession session = req.getSession();
		session.setAttribute("session", sesMesg);
		
		req.setAttribute("request", reqMesg);
		
		PrintWriter out = resp.getWriter();
		out.print("바인딩을 수행합니다.");
	}
}
