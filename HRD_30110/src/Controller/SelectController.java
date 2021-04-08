package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import departmemt.departDAO;
import departmemt.departVO;

@WebServlet("/select.do")
public class SelectController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(req, resp);
	}
	
	protected void doProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		departDAO instance = departDAO.getInstance();
		
		req.setCharacterEncoding("utf-8");
		int mode = Integer.parseInt(req.getParameter("mode"));
		ArrayList<departVO> list = new ArrayList<departVO>();
		String member = "";
		int id = 0;
		if(mode == 1) {
			id = Integer.parseInt(req.getParameter("id"));
			list = instance.selectDeptID(id);
		}else {
			member = req.getParameter("dept");
			list = instance.selectDeptDepart(member);
		}
		
		try {
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("select.jsp");
			rd.forward(req, resp);
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
}
