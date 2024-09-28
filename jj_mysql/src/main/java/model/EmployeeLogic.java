package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.EmployeeBean;
import dao.EmployeeDAO;

public class EmployeeLogic {
	//一社員を取得するメソッド
	public EmployeeBean getEmployee(String employee_id) throws ClassNotFoundException, SQLException {

		//社員IDのチェック(数字以外がないか)
		boolean isNumeric = employee_id.matches("[+-]?\\d*(\\.\\d+)?");
		if (!isNumeric) {
			throw new IllegalArgumentException("数字以外が入っています");
		}

		try (Connection con = EmployeeDAO.getConnection();) {
			//社員DAOの初期化
			EmployeeDAO employeeDao = new EmployeeDAO();
			
			return employeeDao.getEmployee(con, employee_id);
		}
	}
	
	//全社員取得メソッド
	public ArrayList<EmployeeBean> getAllEmployee() throws ClassNotFoundException, SQLException {
		try(Connection con = EmployeeDAO.getConnection();) {
			//EmployeeDAOの初期化
			EmployeeDAO employeeDao = new EmployeeDAO();
			return employeeDao.getAllEmployee(con);
		}
	}
	
	
	
}
