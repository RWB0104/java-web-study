package sec04.ex01;

import jakarta.servlet.http.HttpSessionBindingEvent;
import jakarta.servlet.http.HttpSessionBindingListener;

/**
 * 로그인 이벤트 클래스
 *
 * @author RWB
 * @since 2022.01.29 Sat 02:48:57
 */
public class LoginImpl implements HttpSessionBindingListener
{
	public String user_id;
	public String user_pw;
	
	public static int total_user = 0;
	
	/**
	 * 생성자 메서드
	 */
	public LoginImpl()
	{
		// 없음
	}
	
	/**
	 * 생성자 메서드
	 *
	 * @param user_id: [String] 아이디
	 * @param user_pw: [String] 비밀번호
	 */
	public LoginImpl(String user_id, String user_pw)
	{
		this.user_id = user_id;
		this.user_pw = user_pw;
	}
	
	/**
	 * 바인딩 메서드
	 *
	 * @param event: [HttpSessionBindingEvent] 바인딩 이벤트 객체
	 */
	@Override
	public void valueBound(HttpSessionBindingEvent event)
	{
		System.out.println("사용자 접속");
		
		++total_user;
	}
	
	/**
	 * 언바인딩 메서드
	 *
	 * @param event: [HttpSessionBindingEvent] 바인딩 이벤트 객체
	 */
	@Override
	public void valueUnbound(HttpSessionBindingEvent event)
	{
		System.out.println("사용자 접속 해제");
		
		total_user--;
	}
}
