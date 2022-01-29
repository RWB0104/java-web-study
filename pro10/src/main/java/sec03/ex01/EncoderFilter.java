package sec03.ex01;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/**
 * 인코더 필터 클래스
 *
 * @author RWB
 * @since 2022.01.29 Sat 02:23:54
 */
@WebFilter("/*")
public class EncoderFilter implements Filter
{
	private ServletContext context;
	
	/**
	 * 초기화 메서드
	 *
	 * @param filterConfig: [FilterConfig] 필터 설정 객체
	 */
	@Override
	public void init(FilterConfig filterConfig)
	{
		System.out.println("UTF-8 인코딩............");
		
		context = filterConfig.getServletContext();
	}
	
	/**
	 * 필터 메서드
	 *
	 * @param request: [ServletRequest] 서블릿 요청 객체
	 * @param response: [ServletResponse] 서블릿 응답 객체
	 * @param chain: [FilterChain] 필터 체인 객체
	 *
	 * @throws IOException 데이터 입출력 예외
	 * @throws ServletException 서블릿 예외
	 */
	@Override
	@SuppressWarnings("deprecation")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
	{
		System.out.println("doFilter 호출");
		
		request.setCharacterEncoding("UTF-8");
		
		String context = ((HttpServletRequest) request).getContextPath();
		String pathinfo = ((HttpServletRequest) request).getRequestURI();
		String realPath = request.getRealPath(pathinfo);
		
		StringBuilder builder = new StringBuilder();
		builder.append("Context 정보: ").append(context).append("\n");
		builder.append("URI 정보: ").append(pathinfo).append("\n");
		builder.append("물리적 경로: ").append(realPath);
		
		System.out.println(builder);
		
		long begin = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long end = System.currentTimeMillis();
		
		System.out.println("작업 시간: " + (end - begin) + "ms");
	}
	
	/**
	 * 소멸 메서드
	 */
	@Override
	public void destroy()
	{
		System.out.println(context.getContextPath());
		System.out.println("destroy 호출");
	}
}
