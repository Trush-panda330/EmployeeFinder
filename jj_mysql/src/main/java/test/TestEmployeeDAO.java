package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.EmployeeBean;
import dao.EmployeeDAO;

public class TestEmployeeDAO {

	public static void main(String[] args) {
		try(Connection con = EmployeeDAO.getConnection();) {
			
			//EmployeeDAOの初期化
			EmployeeDAO employeeDAO = new EmployeeDAO();
			
			/*EmployeeDAO.getEmployeeのテスト*/
			//EmployeeID
			String employee_id = "0001";
					
			//employeeBeanの取得
			EmployeeBean employeeBean = employeeDAO.getEmployee(con, employee_id);
			
			//employeeBeanのテスト結果
			System.out.println("社員ID : " + employeeBean.getEmployee_id());
			System.out.println("社員名 : " + employeeBean.getEmployee_name());
			System.out.println("部署名 : " + employeeBean.getDepartment_name());
			System.out.println("入社日 : " + employeeBean.getEnter_date());
			System.out.println();
			
			
			/**EmployeeDAO.getAllEmployeeのテスト*/
			ArrayList<EmployeeBean> employeeList = new ArrayList<>();
						
			//全社員Beanの取得
			employeeList = employeeDAO.getAllEmployee(con);
			
			//全社員Beanのテスト結果
			System.out.println("全社員Beanのテスト結果表示");
			for(EmployeeBean employee : employeeList) {
				System.out.println("------------------------------------");
				System.out.println("社員ID : " + employee.getEmployee_id());
				System.out.println("社員名 : " + employee.getEmployee_name());
				System.out.println("部署名 : " + employee.getDepartment_name());
				System.out.println("入社日 : " + employee.getEnter_date());
			}
			
		}catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
		} {
			
		}

	}

}
