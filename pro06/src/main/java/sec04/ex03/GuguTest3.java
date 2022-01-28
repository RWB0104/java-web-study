package sec04.ex03;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 구구단 테스트3 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.26 Wed 16:34:26
 */
@WebServlet("/guguTest3")
public class GuguTest3 extends HttpServlet
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
		
		PrintWriter out = resp.getWriter();
		
		int dan = Integer.parseInt(req.getParameter("dan"));
		
		out.print("<table border=1 width=800 align=center>");
		out.print("<tr align=center bgcolor='#FFFF66'>");
		out.print("<td colspan=2>" + dan + " 단 출력</td>");
		out.print("</tr>");
		
		for (int i = 1; i < 10; i++)
		{
			if (i % 2 == 0)
			{
				out.print("<tr align=center bgcolor='#ACFA58'>");
			}
			
			else
			{
				out.print("<tr align=center bgcolor='#81BEF7'>");
			}
			
			out.print("<td width=200>");
			out.print("<input type='radio' />" + i);
			out.print("</td>");
			out.print("<td width=200>");
			out.print("<input type='checkbox' />" + i);
			out.print("</td>");
			out.print("<td width=400>");
			out.print(dan + " * " + i);
			out.print("</td>");
			out.print("<td width=400>");
			out.print(dan * i);
			out.print("</td>");
			out.print("</tr>");
		}
		
		out.print("</table>");
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
