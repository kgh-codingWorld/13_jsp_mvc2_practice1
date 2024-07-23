package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dto.BoardDTO;

public class BoardDAO {
	
	// 생성자
	private BoardDAO() {}
	// 고정 객체 생성
	private static BoardDAO instance = new BoardDAO();
	// 게터 메서드 생성
	public static BoardDAO getInstance() {
		return instance;
	}
	
	// 데이터베이스 연동 객체 생성
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	// 데이터베이스 연동 메서드 생성
	private void getConnection() {
		
		try {
			Context initctx = new InitialContext();
			Context envctx = (Context) initctx.lookup("java:comp/env");
			DataSource ds = (DataSource) envctx.lookup("jdbc/board");
			conn = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
	
	// 데이터베이스 연동 해지 메서드 생성
	private void getClose() {
		if(rs != null) 		try {rs.close();}	catch(Exception e) {e.printStackTrace();}
		if(pstmt != null) 	try {pstmt.close();}catch(Exception e) {e.printStackTrace();}
		if(conn != null) 	try {conn.close();}	catch(Exception e) {e.printStackTrace();}
	}
	
	// 게시글 등록
	public void insertBoard(BoardDTO boardDTO) {
		
		try {
			getConnection();
			
			String sql = """
					INSERT INTO BOARD
					VALUES ( ? , ? , ? , ? , ? , 0 , NOW())
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
}
