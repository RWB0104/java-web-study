package ex02;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 환율 계산기 서버 클래스
 *
 * @author RWB
 * @since 2022.01.25 Tue 21:21:54
 */
public class RateServer
{
	/**
	 * 메인 메서드
	 *
	 * @param args: [String] 파라미터
	 */
	public static void main(String[] args)
	{
		ServerSocket serverSocket;
		
		Socket s1;
		
		InputStream is;
		OutputStream os;
		
		BufferedReader br;
		BufferedWriter bw;
		PrintWriter pw;
		
		// 서버 실행 시도
		try
		{
			serverSocket = new ServerSocket(5434);
			
			System.out.println("서버 실행 중");
			
			while (true)
			{
				s1 = serverSocket.accept();
				
				is = s1.getInputStream();
				os = s1.getOutputStream();
				
				br = new BufferedReader(new InputStreamReader(is));
				
				String data = br.readLine();
				System.out.println("서버 수신 데이터: " + data);
				
				// 종료가 입력됐을 경우
				if (data.equalsIgnoreCase("exit"))
				{
					break;
				}
				
				String result = calculate(data);
				System.out.println(result);
				
				bw = new BufferedWriter(new OutputStreamWriter(os));
				
				pw = new PrintWriter(bw, true);
				pw.println(result);
				pw.close();
			}
		}
		
		// 예외
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * 계산 결과 반환 메서드
	 *
	 * @param data: [String] 데이터
	 *
	 * @return [String] 계산 결과
	 */
	private static String calculate(String data)
	{
		return data + "1";
	}
}