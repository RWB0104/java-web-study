package sec02.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

/**
 * 쿠키 확인 메서드
 *
 * @author RWB
 * @since 2022.01.28 Fri 18:34:12
 */
@WebServlet("/get")
public class GetCookieValue extends HttpServlet
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
		
		Cookie[] allValues = req.getCookies();
		
		PrintWriter out = resp.getWriter();
		
		for (Cookie allValue : allValues)
		{
			out.println("<h2>Cookie 값 가져오기: " + URLDecoder.decode(allValue.getValue(), StandardCharsets.UTF_8) + "</h2>");
		}
	}
}
