package test;

import java.sql.SQLException;
import java.util.ArrayList;

import beans.EmployeeBean;
import model.EmployeeLogic;

public class TestEmployeeLogic {
	
	public static void main(String[] args) {
		
		//EmployeeLogicの初期化
		EmployeeLogic employeeLogic = new EmployeeLogic();
		
		/**EmployeeLogic.getEmployeeのテスト*/
		try {
			 //
			EmployeeBean employeeBean = employeeLogic.getEmployee("0001");
			//EmployeeBeanのテスト（値を取得し、表示する）
			System.out.println("社員ID : " + employeeBean.getEmployee_id());
			System.out.println("社員名 : " + employeeBean.getEmployee_name());
			System.out.println("部署名 : " + employeeBean.getDepartment_name());
			System.out.println("入社日 : " + employeeBean.getEnter_date());
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println("IDエラー: " + e.getMessage());
		}
		
		System.out.println();
		System.out.println("全社員の表示");
		/**EmployeeLogic.getAllEmployeeのテスト*/
		try {
			ArrayList<EmployeeBean> employeeList = employeeLogic.getAllEmployee();
			//全社員Beanのテスト結果を表示する
			for(EmployeeBean emp : employeeList) {
				System.out.println("-------------------------------------------------");
				System.out.println("社員ID : " + emp.getEmployee_id());
				System.out.println("社員名 : " + emp.getEmployee_name());
				System.out.println("部署名 : " + emp.getDepartment_name());
				System.out.println("入社日 : " + emp.getEnter_date());
			}
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
