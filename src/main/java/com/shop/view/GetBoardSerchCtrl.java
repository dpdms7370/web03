package com.shop.view;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.Board1VO;
import com.shop.model.Board1DAO;

@WebServlet("/GetBoardSerchCtrl")
public class GetBoardSerchCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public GetBoardSerchCtrl() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cd = request.getParameter("scd");
		String key = request.getParameter("key");
		Board1DAO dao = new Board1DAO();
		ArrayList<Board1VO> list = dao.getConditionSearch("scd","key");
		request.setAttribute("list", list);
		RequestDispatcher view = request.getRequestDispatcher("./board/GetBoardList.jsp");
		view.forward(request, response);
	}

}
