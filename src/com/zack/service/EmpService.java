package com.zack.service;

import com.zack.model.Emp;

import java.util.List;

public interface EmpService {
    Emp addEmp(Emp emp);

    Emp getEmpById(int id);

    List<Emp> getAllEmp();

    int deleteEmp(int id);

    Emp updateEmp(int id, Emp emp);
}
