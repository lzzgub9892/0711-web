package com.lzz.service.impl;

import java.util.List;

import com.lzz.dao.IDeptDao;
import com.lzz.dao.impl.DeptDaoImpl;
import com.lzz.domain.Dept;
import com.lzz.domain.Page;
import com.lzz.service.IDeptService;

public class DeptServiceImpl implements IDeptService {
	private IDeptDao dao=new DeptDaoImpl();
	@Override
	public void save(Dept dept) {
		dao.save(dept);
	}

	@Override
	public void delete(Integer did) {
		dao.delete(did);
	}

	@Override
	public void update(Dept dept) {
		dao.update(dept);
	}

	@Override
	public List<Dept> find() {
		return dao.find();
	}

	@Override
	public Dept find(Integer did) {
		return dao.find(did);
	}

	@Override
	public Page<Dept> findPageData(int p, int size) {
		int rowCount=dao.getRowCount();
		Page<Dept> page=new Page<Dept>(p, rowCount, size);
		List<Dept> list=dao.find(page.getStartLine(), page.getSize());
		page.setList(list);
		return page;
	}

}
