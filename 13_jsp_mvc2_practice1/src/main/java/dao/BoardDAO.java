package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BoardDTO;

public class BoardDAO {
	
	private BoardDAO() {}
	private static BoardDAO instance = new BoardDAO();
	public static BoardDAO getInstance() {
		return instance;
	}
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private void getConnection() {
		
		try {
			
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/board");
			conn = ds.getConnection();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void getClose() {
		
		if(rs != null) try {rs.close();}catch(Exception e) {e.printStackTrace();}
		if(pstmt != null) try {pstmt.close();}catch(Exception e) {e.printStackTrace();}
		if(conn != null) try {conn.close();}catch(Exception e) {e.printStackTrace();}
	}
	
	
	public void insertBoard(BoardDTO boardDTO) { // 이미 뷰로부터 값을 입력받아 BoardDTO 객체에 저장한 상태의 BoardDTO 객체를 파라미터로 받는다.
		
		try {
			getConnection();
			
			String sql = """
					INSERT INTO BOARD
					VALUES (? , ? , ? , ? , ? , 0 , NOW())
					""";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getWriter());
			pstmt.setString(2, boardDTO.getEmail());
			pstmt.setString(3, boardDTO.getSubject());
			pstmt.setString(4, boardDTO.getPassword());
			pstmt.setString(5, boardDTO.getContent());
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
	}
	
	public ArrayList<BoardDTO> getBoardList() {
		
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();
		
		try {
			getConnection();
			
			String sql = """
					SELECT  *
					FROM	BOARD
					""";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		
			BoardDTO boardDTO = new BoardDTO();
			while(rs.next()) {
				boardDTO.setBoardId(rs.getLong("BOARD_ID"));
				boardDTO.setWriter(rs.getString("WRITER"));
				boardDTO.setEnrollDt(rs.getDate("ENROLL_DT"));
				boardDTO.setSubject(rs.getString("SUBJECT"));
				boardDTO.setReadCnt(rs.getLong("READ_CNT"));
				
				boardList.add(boardDTO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		System.out.println("boadList : "+ boardList);
		
		return boardList;
		
	}
	
	public BoardDTO getBoardDetail(long boardId) {
		
		BoardDTO boardDTO = new BoardDTO();
		
		try {
			getConnection();
			
			String sql = """
					SELECT	*
					FROM	BOARD
					WHERE	BOARD_ID = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, boardId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				boardDTO.setBoardId(rs.getLong("BOARD_ID"));
				boardDTO.setWriter(rs.getString("WRITER"));
				boardDTO.setSubject(rs.getString("SUBJECT"));
				boardDTO.setContent(rs.getString("CONTENT"));
				boardDTO.setEnrollDt(rs.getDate("ENROLL_DT"));
				boardDTO.setEmail(rs.getString("EMAIL"));
				boardDTO.setReadCnt(rs.getLong("READ_CNT"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		
		return boardDTO;
	}
	
	public boolean checkAuthentication(BoardDTO boardDTO) {
		
		boolean isChecked = false;
		
		try {
			
			getConnection();
			
			String sql = """
					SELECT	*
					FROM	BOARD
					WHERE	BOARD_ID = ?
					AND		PASSWORD = ?
					""";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, boardDTO.getBoardId());
			pstmt.setString(2, boardDTO.getPassword());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isChecked = true;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			getClose();
		}
		return isChecked;
	}
	
	public void upadateBoard(BoardDTO boardDTO) {
		
		try {
			getConnection();
			
			String sql = """
					UPDATE BOARD
					SET    SUBJECT  = ? ,
						   CONTENT  = ?
				    WHERE  BOARD_ID = ?
					""";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, boardDTO.getSubject());
			pstmt.setString(2, boardDTO.getContent());
			pstmt.setLong(3, boardDTO.getBoardId());
			
		} catch(Exception e)	 {
			e.printStackTrace();
		} finally {
			getClose();
		}
	}
}
