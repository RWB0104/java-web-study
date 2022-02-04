package sec01.ex01;

import java.sql.Date;

/**
 * 회원 객체 클래스
 *
 * @author RWB
 * @since 2022.02.05 Sat 02:04:58
 */
public class MemberBean
{
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Date joinDate;
	
	/**
	 * 생성자 메서드
	 */
	public MemberBean()
	{
		// 빈 메서드
	}
	
	/**
	 * 생성자 메서드
	 *
	 * @param id: [String] 아이디
	 * @param pwd: [String] 비밀번호
	 * @param name: [String] 이름
	 * @param email: [String] 이메일
	 */
	public MemberBean(String id, String pwd, String name, String email)
	{
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	
	/**
	 * 아이디 반환 메서드
	 *
	 * @return [String] 아이디
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * 아이디 할당 메서드
	 *
	 * @param id: [String] 아이디
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	
	/**
	 * 비밀번호 반환 메서드
	 *
	 * @return [String] 비밀번호
	 */
	public String getPwd()
	{
		return pwd;
	}
	
	/**
	 * 비밀번호 할당 메서드
	 *
	 * @param pwd: [String] 비밀번호
	 */
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	
	/**
	 * 이름 반환 메서드
	 *
	 * @return [String] 이름
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * 이름 할당 메서드
	 *
	 * @param name: [String] 이름
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * 이메일 반환 메서드
	 *
	 * @return [String] 이메일
	 */
	public String getEmail()
	{
		return email;
	}
	
	/**
	 * 이메일 할당 메서드
	 *
	 * @param email: [String] 이메일
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * 가입일자 반환 메서드
	 *
	 * @return [Date] 가입일자
	 */
	public Date getJoinDate()
	{
		return joinDate;
	}
	
	/**
	 * 가입일자 할당 메서드
	 *
	 * @param joinDate: [Date] 가입일자
	 */
	public void setJoinDate(Date joinDate)
	{
		this.joinDate = joinDate;
	}
}