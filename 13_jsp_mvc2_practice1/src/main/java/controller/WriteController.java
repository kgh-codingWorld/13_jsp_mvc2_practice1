package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

@WebServlet("/write")
public class WriteController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	// write.jsp로 이동
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dis = request.getRequestDispatcher("write.jsp");
		dis.forward(request, response);
	}
	
	// write.jsp로 이동 후 글쓰기 처리 동작(BoardDTO 사용하여 뷰에서 가져온 값을 BoardDAO에 전달할 것임)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setWriter(request.getParameter("writer"));
		boardDTO.setSubject(request.getParameter("subject"));
		boardDTO.setEmail(request.getParameter("email"));
		boardDTO.setPassword(request.getParameter("password"));
		boardDTO.setContent(request.getParameter("content"));
		
		BoardDAO.getInstance().insertBoard(boardDTO);
		
		// 리액션
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter pw = response.getWriter(); // Spring에서의 @ResponseBody
		
		String jsScript = """
				<script>
					alert('게시글이 등록되었습니다.');
					location.href='bList';
				</script>
				"""; // location.href='url'; > 해당 url로 이동하는 자바스크립트 함수
		
		pw.print(jsScript);
	}

}
