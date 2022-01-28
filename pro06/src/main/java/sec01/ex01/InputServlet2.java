package sec01.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

/**
 * 입력2 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.26 Wed 13:20:16
 */
@WebServlet("/input2")
public class InputServlet2 extends HttpServlet
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
	 * @throws UnsupportedEncodingException 지원하지 않는 인코딩 예외
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException
	{
		req.setCharacterEncoding("UTF-8");
		
		Enumeration<String> enu = req.getParameterNames();
		
		while (enu.hasMoreElements())
		{
			String name = enu.nextElement();
			
			String[] values = req.getParameterValues(name);
			
			for (String value : values)
			{
				System.out.println("name=" + name + ", value=" + value);
			}
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
