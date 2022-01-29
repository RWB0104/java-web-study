package sec04.ex02;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

/**
 * 로그인 이벤트 클래스
 *
 * @author RWB
 * @since 2022.01.29 Sat 14:15:47
 */
@WebListener
public class LoginImpl implements HttpSessionListener
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
	 * 세션 생성 이벤트 메서드
	 *
	 * @param se: [HttpSessionEvent] 세션 이벤트 객체
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se)
	{
		System.out.println("세션 시작");
		
		++total_user;
	}
	
	/**
	 * 세션 소멸 이벤트 메서드
	 *
	 * @param se: [HttpSessionEvent] 세션 이벤트 객체
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se)
	{
		System.out.println("세션 소멸");
		
		--total_user;
	}
}
