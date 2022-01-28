package ex01;

/**
 * 계산기 클래스
 *
 * @author RWB
 * @since 2022.01.25 Tue 13:12:48
 */
public class Calculator
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
	
	private static final float USD_RATE = 1197.88F;
	private static final float JPY_RATE = 10.50F;
	private static final float CNY_RATE = 189.25F;
	private static final float GBP_RATE = 1614.16F;
	private static final float EUR_RATE = 1351.51F;
	
	Operand operand1 = new Operand("469000");
	
	OperationSelection opSelection = new OperationSelection(1);
	
	TextResult txtResult = new TextResult();
	
	/**
	 * 계산 메서드
	 */
	private void calculate()
	{
		float won = Float.parseFloat(operand1.getText());
		
		String result = null;
		String operator = opSelection.getSelectionItem().toString();
		
		// 달러일 경우
		if (operator.equals("달러"))
		{
			result = String.format("%.6f", won / USD_RATE);
		}
		
		// 엔화일 경우
		else if (operator.equals("엔화"))
		{
			result = String.format("%.6f", won / JPY_RATE);
		}
		
		// 위안일 경우
		else if (operator.equals("위안"))
		{
			result = String.format("%.6f", won / CNY_RATE);
		}
		
		// 파운드일 경우
		else if (operator.equals("파운드"))
		{
			result = String.format("%.6f", won / GBP_RATE);
		}
		
		// 유로일 경우
		else if (operator.equals("유로"))
		{
			result = String.format("%.6f", won / EUR_RATE);
		}
		
		txtResult.setText(result);
	}
	
	/**
	 * 메인 메서드
	 * 
	 * @param args: [String[]] 파라미터
	 */
	public static void main(String[] args)
	{
		Calculator calculator = new Calculator();
		calculator.calculate();
	}
}