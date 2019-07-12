package com.lzz.web.servlet;

import java.io.IOException;
import java.util.List;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lzz.domain.Dept;
import com.lzz.domain.Page;
import com.lzz.service.IDeptService;
import com.lzz.service.impl.DeptServiceImpl;
import com.lzz.utils.WebUtils;

public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDeptService service=new DeptServiceImpl();
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method=request.getParameter("method");
		if(method==null) {
			findAll(request,response);
		}else if(method.equals("add")) {
			add(request,response);
		}else if(method.equals("delete")) {
			delete(request,response);
		}else if(method.equals("editForm")) {
			editForm(request,response);
		}else if(method.equals("edit")) {
			edit(request,response);
		}
	}
	private void edit(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Dept d=WebUtils.request2Bean(request, Dept.class);
		service.update(d);
		response.sendRedirect("dept.do");

		
	}
	private void editForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer did=Integer.parseInt(request.getParameter("did"));
		Dept d=service.find(did);
		request.setAttribute("dept", d);
		request.getRequestDispatcher("/dept/edit.jsp").forward(request, response);
	}
	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int did = Integer.parseInt(request.getParameter("did"));
		service.delete(did);
		response.sendRedirect("dept.do");
	}
	private void add(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Dept d=WebUtils.request2Bean(request, Dept.class);
		service.save(d);
		response.sendRedirect("dept.do");
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
		Page<Dept> pb=service.findPageData(p, size);
		pb.setServletName("dept.do");
		request.setAttribute("page", pb);
		request.getRequestDispatcher("/dept/deptList.jsp").forward(request, response);
	}

}
