package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

@WebServlet("/authentication")
public class AuthenticationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("menu", request.getParameter("menu"));
		
		long boardId = Long.parseLong(request.getParameter("boardId"));
		BoardDTO boardDTO = BoardDAO.getInstance().getBoardDetail(boardId);
		
		request.setAttribute("boardDTO", boardDTO);
		
		RequestDispatcher dis = request.getRequestDispatcher("authentication.jsp");
		dis.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		
		BoardDTO boardDTO = new BoardDTO();
		long boardId = Long.parseLong(request.getParameter("boardId"));
		
		boardDTO.setBoardId(boardId);
		boardDTO.setPassword(request.getParameter("password"));
		
		boolean isChecked = BoardDAO.getInstance().checkAuthentication(boardDTO);
		String jsScript = "";
		
		if(isChecked) {
			
			String menu = request.getParameter("menu");
			if(menu.equals("update")) {
				jsScript += "<script>";
				jsScript += "location.href='update?boardId=" + boardId + "';";
				jsScript += "</script>";
			}
		}
	}

}
