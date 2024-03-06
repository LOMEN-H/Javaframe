package exp1.controller;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exp1.model.tool.DbConnect;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//处理登录请求
		//1.获取传递过来的数据
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		//2.验证
		if(name.equals("zhangsan") && pass.equals("123")) {
			//2.1验证通过，跳转到学生列表页面
			//在跳转之前，应当访问数据库，把学生数据集合获取过来，存在会话中，在跳转到的目标页面里，就可以遍历它了。
			Connection conn=DbConnect.getConnect();
			try {
				PreparedStatement pst=conn.prepareStatement("select * from student");
				ResultSet rs=pst.executeQuery();
				//创建会话对象session
				HttpSession session=request.getSession();
				session.setAttribute("rs", rs);
				response.sendRedirect("studentList.jsp");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//request.getRequestDispatcher("/studentList.jsp").forward(request, response);
		}else {
			//2.2验证不通过，跳转到登录页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
