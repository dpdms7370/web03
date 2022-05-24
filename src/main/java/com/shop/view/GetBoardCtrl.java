package com.shop.view;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shop.common.Board1VO;
import com.shop.model.Board1DAO;


@WebServlet("/GetBoardCtrl")
public class GetBoardCtrl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GetBoardCtrl() {
        super();
       
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int su = Integer.parseInt(request.getParameter("bno"));
		Board1DAO dao = new Board1DAO();
		Board1VO bo = new Board1VO();
		bo = dao.getBoard1(su);
		if(bo != null) {
			request.setAttribute("bo", bo);
			RequestDispatcher view = request.getRequestDispatcher("GetBoardList.jsp");
			view.forward(request, response);
			response.sendRedirect("GetBoardListCtrl");
			
			
			
			
		}
	}

}
