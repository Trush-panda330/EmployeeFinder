package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import beans.EmployeeBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.EmployeeLogic;

/**
 * Servlet implementation class Employee
 */
@WebServlet("/Employee")
public class Employee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字コード設定
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		// <input type="text" name="employee_id" /> index.jspのここでIDを受け取っている
		String employee_id = request.getParameter("employee_id");
		//コンソールに出してみて受け取れているか確認している
		System.out.println("employee_id:" + employee_id);
		
		//社員ロジックの初期化
		EmployeeLogic empLogic = new EmployeeLogic();
		
		//社員リストの初期化
		ArrayList<EmployeeBean> employeeList = new ArrayList<>();
		
		//社員リストの取得したものが"all"だった時
		try {
			if(employee_id.equals("all")) {
				employeeList = empLogic.getAllEmployee();
			}else {
				EmployeeBean employeeBean = empLogic.getEmployee(employee_id);
				
				employeeList.add(employeeBean);
			}
			
			//employee.jspに送り込む
			request.setAttribute("employeeList", employeeList);
			
			//変なのが入力されたときの処理
		}catch(IllegalArgumentException e) {
			request.setAttribute("error_msg",e.getMessage());
			request.getRequestDispatcher("WEB-INF/error.jsp").forward(request, response);
			return;
			
		}catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/employee.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
