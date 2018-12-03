package com.zack.dao;

import com.zack.model.Emp;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.zack.dao.DBUtil.getConnection;

public class EmpDaoImp implements EmpDao {

	public Emp addEmp(Emp emp) {
		Connection conn = getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO EMP VALUES (?, ?,?)");
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setString(3, emp.getAddress());
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return  emp;
	}
	
	public Emp getEmpById(int id) {
		Connection conn = getConnection();
		Emp emp = new Emp();

		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from EMP WHERE ID = ?");
			pstmt.setInt(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setAddress(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}
	
	public List<Emp> getAllEmp() {
		Connection conn = getConnection();
		List<Emp> empList = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from EMP");
			while(rs.next()) {
				Emp emp = new Emp();
				emp.setId(rs.getInt(1));
				emp.setName(rs.getString(2));
				emp.setAddress(rs.getString(3));
				empList.add(emp);
			}
			return empList;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	}


	@Override
	public Emp updateEmp(int id, Emp emp) {
		Connection conn = getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement("UPDATE EMP SET NAME = ?, ADDRESS = ? WHERE id = ?");
			pstmt.setString(1, emp.getName());
			pstmt.setString(2, emp.getAddress());
			pstmt.setInt(3, id);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public int deleteEmp(int id) {
		Connection conn = getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement("delete FROM EMP where id = ?");
			pstmt.setInt(1, id);
			pstmt.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
	}
}
