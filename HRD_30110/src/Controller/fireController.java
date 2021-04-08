package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import departmemt.departDAO;
import departmemt.departVO;

@WebServlet("/fire.do")
public class fireController extends HttpServlet{
	
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
		System.out.println("왜 안들어옴");
		req.setCharacterEncoding("UTF-8");
		departDAO instance = departDAO.getInstance();
		
		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("id"));
		
		System.out.println(name);
		System.out.println(id);
		boolean rst = instance.checkDept(id, name);
		
		String msg = "";
		int del=0;
		if(rst) {
			del = instance.deleteDept(id);
			msg = "퇴직 성공";
		}else {
			msg = "도비는 아직 노예에요";
		}
		try {
			if(del>0) {
				RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
				rd.forward(req, resp);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
