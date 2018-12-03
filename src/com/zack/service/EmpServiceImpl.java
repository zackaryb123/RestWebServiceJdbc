package com.zack.service;

import com.zack.dao.EmpDao;
import com.zack.dao.EmpDaoImp;
import com.zack.model.Emp;

import java.util.List;

public class EmpServiceImpl implements EmpService {

	private EmpDao empDao = new EmpDaoImp();

	@Override
	public Emp addEmp(Emp emp) {
		return empDao.addEmp(emp);
	}

	@Override
	public Emp getEmpById(int id) {
		return empDao.getEmpById(id);
	}

	@Override
	public List<Emp> getAllEmp() {
		return empDao.getAllEmp();
	}

	@Override
	public Emp updateEmp(int id, Emp emp) {
		return empDao.updateEmp(id, emp);
	}

	@Override
	public int deleteEmp(int id) {
		return empDao.deleteEmp(id);
	}
}
