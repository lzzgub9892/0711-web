package com.lzz.dao;

import java.util.List;

import com.lzz.domain.Dept;

public interface IDeptDao {
	void save(Dept dept);
	void delete(Integer did);
	void update(Dept dept);
	List<Dept> find();
	Dept find(Integer did);
	int getRowCount();
	List<Dept> find(int startLine,int size);

}
