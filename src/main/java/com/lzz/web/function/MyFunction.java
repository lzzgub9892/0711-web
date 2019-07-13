package com.lzz.web.function;

import com.lzz.domain.Dept;
import com.lzz.service.IDeptService;
import com.lzz.service.impl.DeptServiceImpl;

public class MyFunction {
	private static IDeptService deptService=new DeptServiceImpl();

	public static Dept getDeptByDid(Integer did) {
		return deptService.find(did);
	}
}
