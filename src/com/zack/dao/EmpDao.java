package com.zack.dao;

import com.zack.model.Emp;

import java.util.List;

public interface EmpDao {
    Emp addEmp(Emp emp);
	
	Emp getEmpById(int id);

	List<Emp> getAllEmp();

	Emp updateEmp(int id, Emp cust);

	public int deleteEmp(int id);
}
