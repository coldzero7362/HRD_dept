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
import oracle.net.aso.r;

@WebServlet("/update.do")
public class updateController extends HttpServlet{
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
		
		System.out.println("¤·¤·¤·");
		String name = req.getParameter("name");
		int id = Integer.parseInt(req.getParameter("id"));
		String dept = req.getParameter("dept");
		String position = req.getParameter("position");
		String duty = req.getParameter("duty");
		String phone = req.getParameter("phone");
		
		departVO vo = new departVO();
		
		vo.setName(name);
		vo.setId(id);
		vo.setDept(dept);
		vo.setPosition(position);
		vo.setDuty(duty);
		vo.setPhone(phone);
		
		
		int rst = instance.updateDept(vo);
		
		try {
			if(rst >0) {
				RequestDispatcher rd = req.getRequestDispatcher("main.jsp");
				rd.forward(req, resp);
			}
			
		} catch (Exception e) {
		e.printStackTrace();
		}
		
	}
}
