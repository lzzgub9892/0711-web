package com.lzz.service;

import java.util.List;

import com.lzz.domain.Emp;
import com.lzz.domain.Page;

public interface IEmpService {
	void save(Emp emp);
	void delete(Integer eid);
	void update(Emp emp);
	Emp find(Integer eid);
	List<Emp> find();
	Page<Emp> findPageData(int p,int size);

}
