package com.lzz.service.impl;

import java.util.List;

import com.lzz.dao.IEmpDao;
import com.lzz.dao.impl.EmpDaoImpl;
import com.lzz.domain.Emp;
import com.lzz.domain.Page;
import com.lzz.service.IEmpService;

public class EmpServiceImpl implements IEmpService {
	IEmpDao dao=new EmpDaoImpl();
	
	@Override
	public void save(Emp emp) {
		dao.save(emp);
	}

	@Override
	public void delete(Integer eid) {
		dao.delete(eid);
	}

	@Override
	public void update(Emp emp) {
		dao.update(emp);
	}

	@Override
	public Emp find(Integer eid) {
		return dao.find(eid);
	}

	@Override
	public List<Emp> find() {
		return dao.find();
	}

	@Override
	public Page<Emp> findPageData(int p, int size) {
		int rowCount=dao.getRowCount();
		Page<Emp> page=new Page<>(p, rowCount, size);
		List<Emp> list=dao.find(page.getStartLine(), size);
		page.setList(list);
		return page;
	}


}
