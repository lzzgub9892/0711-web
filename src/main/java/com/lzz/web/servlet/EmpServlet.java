package com.lzz.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzz.domain.Dept;
import com.lzz.domain.Emp;
import com.lzz.domain.Page;
import com.lzz.service.IDeptService;
import com.lzz.service.IEmpService;
import com.lzz.service.impl.DeptServiceImpl;
import com.lzz.service.impl.EmpServiceImpl;
import com.lzz.utils.WebUtils;

public class EmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEmpService empService=new EmpServiceImpl();
	private IDeptService deptService=new DeptServiceImpl();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method==null) {
			findAll(request,response);
		}else if(method.equals("add")) {
			add(request,response);
		}else if(method.equals("addForm")) {
			addForm(request,response);
		}else if(method.equals("delete")) {
			delete(request,response);
		}else if(method.equals("editForm")) {
			editForm(request,response);
		}else if(method.equals("edit")) {
			edit(request,response);
		}
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Emp emp=WebUtils.request2Bean(request, Emp.class);
		empService.update(emp);
		response.sendRedirect("emp.do");
	}

	private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer eid=Integer.parseInt(request.getParameter("eid"));
		Emp emp = empService.find(eid);
		request.setAttribute("emp", emp);
		List<Dept> deptList=deptService.find();
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/emp/edit.jsp").forward(request, response);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Integer eid=Integer.parseInt(request.getParameter("eid"));
		empService.delete(eid);
		response.sendRedirect("emp.do");
		
	}

	private void addForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Dept> deptList=deptService.find();
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("/emp/add.jsp").forward(request, response);
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Emp emp=WebUtils.request2Bean(request, Emp.class);
		empService.save(emp);
		response.sendRedirect("emp.do");
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pStr=request.getParameter("p");
		HttpSession session = request.getSession();
		int p;
		if(pStr==null) {
			Integer x=(Integer) session.getAttribute("x");
			if(x!=null) {
				p=x;
			}else {
				p=1;
			}
		}else {
			try {
				p = Integer.parseInt(pStr);
			} catch (NumberFormatException e) {
				p=1;
			}
		}
		session.setAttribute("x", p);
		int size=5;
		Page<Emp> pb=empService.findPageData(p, size);
		pb.setServletName("emp.do");
		request.setAttribute("page", pb);
		request.getRequestDispatcher("/emp/empList.jsp").forward(request, response);
	}

}
