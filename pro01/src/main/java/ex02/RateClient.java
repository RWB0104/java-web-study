package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * 환율 계산기 클라이언트 클래스
 *
 * @author RWB
 * @since 2022.01.25 Tue 22:12:13
 */
public class RateClient
{
	/**
	 * 명령 클래스
	 */
	private static class Operand
	{
		private String text;
		
		public Operand(String text)
		{
			this.text = text;
		}
		
		/**
		 * 문자열 반환 메서드
		 *
		 * @return [String] 문자열
		 */
		public String getText()
		{
			return text;
		}
		
		/**
		 * 문자열 할당 메서드
		 *
		 * @param text: [String] 문자열
		 */
		public void setText(String text)
		{
			this.text = text;
		}
	}
	
	/**
	 * 명령어 enum
	 */
	private enum Operation
	{
		USD("달러"),
		JPY("엔화"),
		CNY("위안"),
		GBP("파운드"),
		EUR("유로");
		
		private final String string;
		
		/**
		 * 생성자 메서드
		 *
		 * @param string: [String] 문자열
		 */
		Operation(String string)
		{
			this.string = string;
		}
		
		/**
		 * 문자열 반환 메서드
		 *
		 * @return [String] 문자열
		 */
		@Override
		public String toString()
		{
			return this.string;
		}
	}
	
	/**
	 * 명령어 선택자 클래스
	 */
	private static class OperationSelection
	{
		private int index;
		
		/**
		 * 생성자 메서드
		 *
		 * @param index: [int] 인덱스
		 */
		public OperationSelection(int index)
		{
			this.index = index;
		}
		
		/**
		 * 인덱스 반환 메서드
		 *
		 * @return [int] 인덱스
		 */
		public int getIndex()
		{
			return index;
		}
		
		/**
		 * 인덱스 할당 메서드
		 *
		 * @param index: [int] 인덱스
		 */
		public void setIndex(int index)
		{
			this.index = index;
		}
		
		/**
		 * 선택된 명령어 반환 메서드
		 *
		 * @return [Operation] 명령어
		 */
		public Operation getSelectionItem()
		{
			return switch (index)
					{
						case 1 -> Operation.USD;
						case 2 -> Operation.JPY;
						case 3 -> Operation.CNY;
						case 4 -> Operation.GBP;
						default -> Operation.EUR;
					};
		}
	}
	
	/**
	 * 문자열 결과 클래스
	 */
	private static class TextResult
	{
		private String text;
		
		/**
		 * 문자열 반환 메서드
		 *
		 * @return [String] 문자열
		 */
		public String getText()
		{
			return text;
		}
		
		/**
		 * 문자열 할당 메서드
		 *
		 * @param text: [String] 문자열
		 */
		public void setText(String text)
		{
			this.text = text;
			
			System.out.println(text);
		}
	}
	
	Operand operand1 = new Operand("469000");
	
	OperationSelection opSelection = new OperationSelection(1);
	
	TextResult txtResult = new TextResult();
	
	/**
	 * 계산 메서드
	 */
	private void calculate()
	{
		float won = Integer.parseInt(operand1.getText());
		
		String result;
		String operator = opSelection.getSelectionItem().toString();
		
		OutputStream os;
		InputStream is;
		
		BufferedReader br;
		BufferedWriter bw;
		PrintWriter pw;
		
		// 계산 시도
		try
		{
			Socket s1 = new Socket("127.0.0.1", 5434);
			
			os = s1.getOutputStream();
			is = s1.getInputStream();
			
			System.out.println("전송 데이터: " + won + ", " + operator);
			
			bw = new BufferedWriter(new OutputStreamWriter(os));
			
			pw = new PrintWriter(bw, true);
			pw.println(won + ", " + operator);
			
			br = new BufferedReader(new InputStreamReader(is));
			
			result = br.readLine();
			
			System.out.println("클라이언트 수신 데이터: " + result);
			
			txtResult.setText(result);
			
			s1.close();
		}
		
		// 예외
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 메인 메서드
	 *
	 * @param args: [String[]] 파라미터
	 */
	public static void main(String[] args)
	{
		RateClient client = new RateClient();
		client.calculate();
	}
}