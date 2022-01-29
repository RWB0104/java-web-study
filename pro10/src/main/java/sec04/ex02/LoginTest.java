package sec04.ex02;

import jakarta.servlet.ServletContext;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * 로그인 테스트 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.29 Sat 14:03:54
 */
@WebServlet("/login3")
public class LoginTest extends HttpServlet
{
	List<String> user_list = new ArrayList<>();
	
	/**
	 * POST 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws IOException 데이터 입출력 예외
	 */
	@Override
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		ServletContext context = getServletContext();
		
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		
		HttpSession session = req.getSession();
		
		// 새로운 세션일 경우
		if (session.isNew())
		{
			session.setAttribute("loginUser", loginUser);
			
			user_list.add(user_id);
			
			context.setAttribute("user_list", user_list);
		}
		
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("아이디는 " + loginUser.user_id + "<br>");
		out.println("총 접속자 수는 " + LoginImpl.total_user + "<br><br>");
		out.println("접속 아이디:<br>");
		
		List<String> list = (List<String>) context.getAttribute("user_list");
		
		for (String item : list)
		{
			out.println(item + "<br>");
		}
		
		out.println("<a href='/pro10/logout?user_id=" + user_id + "'>로그아웃</a>");
		out.println("</body></html>");
	}
}
