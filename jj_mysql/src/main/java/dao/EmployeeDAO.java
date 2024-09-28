package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.EmployeeBean;

//EmployeeDAOでemployee.idからemployeeBeanを作成するメソッドを作るためにSQLを作る
public class EmployeeDAO extends ConnectionBase {
	
	/**
	 * 全社員を取得する
	 * @param
	 * @retrun employeeList
	 * @throws SQLException
	 * */
	public ArrayList<EmployeeBean> getAllEmployee(Connection con) throws SQLException {
		//ArrayListの初期化
		ArrayList<EmployeeBean> employeeList = new ArrayList<>();
		
		//employee_idで取得するSQL
		final String sql = "select employee.id, employee.name, department.department_name, employee.enter_date\n"
				+ "from employee_master employee, department_master department\n"
				+ "where employee.department_id = department.department_id";
		
		//SQLの実行の準備
		try(PreparedStatement stmt = con.prepareStatement(sql);) {
			//SQL実行
			try(ResultSet rs = stmt.executeQuery();) {
				
				while(rs.next()) {
					EmployeeBean employeeBean = new EmployeeBean();
					
					String employee_id = rs.getString("employee.id");
					String employee_name = rs.getString("employee.name");
					String department_name = rs.getString("department.department_name");
					String enter_date = rs.getString("employee.enter_date");
					
					employeeBean.setEmployee_id(employee_id);
					employeeBean.setEmployee_name(employee_name);
					employeeBean.setDepartment_name(department_name);
					employeeBean.setEnter_date(enter_date);
					
					employeeList.add(employeeBean);
				}
			} 
		}catch(SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}
		return employeeList;
	}
	
	
	
	
	/**
	* 社員IDから社員Beanを取得
	* @param con, employee_id
	* @return int EmployeeBean
	* @throws SQLException
	*/
	public EmployeeBean getEmployee(Connection con, String employee_id) throws SQLException {
		//社員Beanの初期化
		EmployeeBean employeeBean = new EmployeeBean();

		//社員IDで取得するSQL
		final String sql = "\n"
				+ "SELECT employee.id, employee.name, department.department_name, employee.enter_date \n"
				+ "FROM employee_master employee, department_master department \n"
				+ "WHERE employee.department_id = department.department_id AND employee.id = ?;";

		//SQL実行の準備
		try (PreparedStatement stmt = con.prepareStatement(sql);) {
			stmt.setString(1, employee_id); //一番目の？に(1つしかないけど)入れるemployee_idをセットする 

			//SQL実行
			try (ResultSet rs = stmt.executeQuery();) {

				//SQLで検索市結果があると、if文の中に入る
				if (rs.next()) {

					//一行目の値を取得
					String employee_name = rs.getString("employee.name");
					String department_name = rs.getString("department.department_name");
					String enter_date = rs.getString("employee.enter_date");

					//取得した値を社員Beanにセット
					employeeBean.setEmployee_id(employee_id);
					employeeBean.setEmployee_name(employee_name);
					employeeBean.setDepartment_name(department_name);
					employeeBean.setEnter_date(enter_date);

				}

			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
			e.printStackTrace();
			throw e;
		}

		return employeeBean;
	}

}
//
//select employee.id, employee.name, department.department_name, employee.enter_date
//from employee_master employee, department_master department
//where employee.department_id = department.department_id;
//
