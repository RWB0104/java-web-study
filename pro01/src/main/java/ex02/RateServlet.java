package ex02;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

/**
 * 환율 계산 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.25 Tue 22:50:48
 */
public class RateServlet
{
	private static final float USD_RATE = 1197.88F;
	private static final float JPY_RATE = 10.50F;
	private static final float CNY_RATE = 189.25F;
	private static final float GBP_RATE = 1614.16F;
	private static final float EUR_RATE = 1351.51F;
	
	/**
	 * 페이지 출력 메서드
	 *
	 * @param won: [float] 원화
	 * @param command: [String] 명령어
	 */
	public void page(float won, String command)
	{
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		
		// 계산 명령어일 경우
		if (command != null && command.equals("calculate"))
		{
			String result = calculate(won, command);
			
			pw.print("<html><font size=10>변환결과</font><br>");
			pw.print("<html><font size=10>" + result + "</font><br><br><br>");
			pw.print("<a href='/rateServer/calc'>환율 계산기</a>");
			pw.close();
			
			return;
		}
		
		pw.print("<html><title>환율 계산기</title>");
		pw.print("<font size=5>환율 계산기</font><br>");
		pw.print("<form name='frmCalc' method='post' action='/rateServer/calc' />");
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
		// 달러일 경우
		if (operator.equals("달러"))
		{
			return String.format("%.6f", won / USD_RATE);
		}
		
		// 엔화일 경우
		else if (operator.equals("엔화"))
		{
			return String.format("%.6f", won / JPY_RATE);
		}
		
		// 위안일 경우
		else if (operator.equals("위안"))
		{
			return String.format("%.6f", won / CNY_RATE);
		}
		
		// 파운드일 경우
		else if (operator.equals("파운드"))
		{
			return String.format("%.6f", won / GBP_RATE);
		}
		
		// 유로일 경우
		else if (operator.equals("유로"))
		{
			return String.format("%.6f", won / EUR_RATE);
		}
		
		// 유효하지 않은 명령어일 경우
		else
		{
			return null;
		}
	}
}