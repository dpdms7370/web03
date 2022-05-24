package com.shop.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.shop.common.Board1VO;
import com.shop.common.JDBCConnection;

public class Board1DAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	String sql ="";
	int cnt =0;
	public ArrayList<Board1VO> getBoardList(){
		ArrayList<Board1VO> list = null;
		try {
			
			conn = JDBCConnection.getConnection();
			sql = "select * from board1";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Board1VO>();
			while(rs.next()) {
				Board1VO bb = new Board1VO();
				bb.setBno(rs.getInt("bno"));
				bb.setBobe(rs.getString("bobe"));
				bb.setBsub(rs.getString("bsub"));
				bb.setBw(rs.getString("bw"));
				bb.setBdate(rs.getString("bdate"));
				list.add(bb);
			}
			}catch(ClassNotFoundException e) {
			e.printStackTrace();
			}catch(SQLException e) {
			e.printStackTrace();
			}catch(Exception e) {
			e.printStackTrace();
			}finally {
			JDBCConnection.close(rs,pstmt,conn);
			}
			return list;
		
	}
	
	public Board1VO getBoard1(int bno) {
		Board1VO bb = new Board1VO();
		try {
			conn = JDBCConnection.getConnection();
			sql = "select * from board1 where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bno);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				bb.setBno(rs.getInt("bno"));
				bb.setBobe(rs.getString("bobe"));
				bb.setBsub(rs.getString("bsub"));
				bb.setBw(rs.getString("bw"));
				bb.setBdate(rs.getString("bdate"));
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}
		return bb;
	}
	public ArrayList<Board1VO> getConditionSearch(String cd, String key) {
		ArrayList<Board1VO> boardList = null; 
		try {
			conn = JDBCConnection.getConnection();
			if(cd.equals("bobe")) {
				sql = "select * from board1 where bobe like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+key+"%");
			} else {
				sql = "select * from board where content like ?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+key+"%");
			}
			rs = pstmt.executeQuery();
			boardList = new ArrayList<Board1VO>();
			while(rs.next()) {
				Board1VO board = new Board1VO();
				board.setBno(rs.getInt("bno"));
				board.setBobe(rs.getString("bobe"));
				board.setBsub(rs.getString("bsub"));
				board.setBw(rs.getString("bw"));
				board.setBdate(rs.getString("bdate"));
				boardList.add(board);
			}
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(rs, pstmt, conn);
		}	
		return boardList; 
	}
	
	public int addBoard(Board1VO bb) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "insert into board1 values((select nvl(max(seq), 0)+1 from board), ?, ?, ?, sysdate)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bb.getBobe());
			pstmt.setString(2, bb.getBsub());
			pstmt.setString(3, bb.getBw());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int editBoard(Board1VO bb) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "update board1 set bobe=?, bsub=?, bw=?, bdate=sysdate where bno=?";
			pstmt.setString(1, bb.getBobe());
			pstmt.setString(2, bb.getBsub());
			pstmt.setString(3, bb.getBw());
			pstmt.setInt(4, bb.getBno());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
	
	public int delBoard(Board1VO bb) {
		try {
			conn = JDBCConnection.getConnection();
			sql = "delete from board1 where bno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bb.getBno());
			cnt = pstmt.executeUpdate();
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩이 실패되었습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("SQL구문이 처리되지 못했습니다.");
			e.printStackTrace();
		} catch(Exception e) {
			System.out.println("잘못된 요청으로 업무를 처리하지 못했습니다.");
			e.printStackTrace();
		} finally {
			JDBCConnection.close(pstmt, conn);
		}
		return cnt;
	}
}
	


