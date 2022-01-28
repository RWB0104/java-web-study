package sec04.ex03;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * 회원 서블릿 클래스
 *
 * @author RWB
 * @since 2022.01.28 Fri 10:31:59
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet
{
	/**
	 * GET 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws ServletException 서블릿 예외
	 * @throws IOException 데이터 입출력 예외
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doHandle(req, resp);
	}
	
	/**
	 * POST 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws ServletException 서블릿 예외
	 * @throws IOException 데이터 입출력 예외
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		doHandle(req, resp);
	}
	
	/**
	 * 수행 메서드
	 *
	 * @param req: [HttpServletRequest] 요청 객체
	 * @param resp: [HttpServletResponse] 응답 객체
	 *
	 * @throws ServletException 서블릿 예외
	 * @throws IOException 데이터 입출력 예외
	 */
	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		MemberDAO dao = new MemberDAO();
		
		List<MemberVO> membersList = dao.listMembers();
		
		req.setAttribute("membersList", membersList);
		
		RequestDispatcher dispatch = req.getRequestDispatcher("viewMembers");
		dispatch.forward(req, resp);
	}
}