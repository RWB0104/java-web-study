package sec02.ex01;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 계산 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.26 Wed 13:46:55
 */
@WebServlet("/calc")
public class CalcServlet extends HttpServlet
{
	private static final float USD_RATE = 1197.88F;
	private static final float JPY_RATE = 10.50F;
	private static final float CNY_RATE = 189.25F;
	private static final float GBP_RATE = 1614.16F;
	private static final float EUR_RATE = 1351.51F;
	
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
		
		PrintWriter pw = resp.getWriter();
		
		String command = req.getParameter("command");
		String won = req.getParameter("won");
		String operator = req.getParameter("operator");
		
		// 계산 명령어일 경우
		if (command != null && command.equals("calculate"))
		{
			String result = calculate(Float.parseFloat(won), operator);
			
			pw.print("<html><font size=10>변환결과</font><br>");
			pw.print("<html><font size=10>" + result + "</font><br><br><br>");
			pw.print("<a href='/pro06/calc'>환율 계산기</a>");
			pw.close();
			
			return;
		}
		
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form name='frmCalc' method='get' action='/pro06/calc' />");
		pw.print("원화: <input type='text' name='won' size=10 />");
		pw.print("<select name='operator'>");
		pw.print("<option value='dollor'>달러</option>");
		pw.print("<option value='en'>엔</option>");
		pw.print("<option value='wian'>위안</option>");
		pw.print("<option value='pound'>파운드</option>");
		pw.print("<option value='euro'>유로</option>");
		pw.print("</select>");
		pw.print("<input type='hidden' name='command' value='calculate' />");
		pw.print("<input type='submit' value='변환' />");
		pw.print("</form>");
		pw.print("</html>");
		
		pw.close();
	}
	
	/**
	 * 계산 결과 반환 메서드
	 *
	 * @param won: [float] 원화
	 * @param operator: [String] 명령어
	 *
	 * @return [String] 계산 결과
	 */
	private String calculate(float won, String operator)
	{
		String result = null;
		
		// 달러일 경우
		if (operator.equals("dollor"))
		{
			result = String.format("%.6f", won / USD_RATE);
		}
		
		// 엔화일 경우
		else if (operator.equals("en"))
		{
			result = String.format("%.6f", won / JPY_RATE);
		}
		
		// 위안일 경우
		else if (operator.equals("wian"))
		{
			result = String.format("%.6f", won / CNY_RATE);
		}
		
		// 파운드일 경우
		else if (operator.equals("pound"))
		{
			result = String.format("%.6f", won / GBP_RATE);
		}
		
		// 유로일 경우
		else if (operator.equals("euro"))
		{
			result = String.format("%.6f", won / EUR_RATE);
		}
		
		return result;
	}
}
