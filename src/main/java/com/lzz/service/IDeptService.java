package com.lzz.service;

import java.util.List;

import com.lzz.domain.Dept;
import com.lzz.domain.Page;

public interface IDeptService {
	void save(Dept dept);
	void delete(Integer did);
	void update(Dept dept);
	List<Dept> find();
	Dept find(Integer did);
	Page<Dept> findPageData(int p,int size);
}
