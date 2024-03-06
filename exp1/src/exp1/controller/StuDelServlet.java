package exp1.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exp1.model.tool.DbConnect;

/**
 * Servlet implementation class StuDelServlet
 */
@WebServlet("/stuDelServlet")
public class StuDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StuDelServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 处理删除请求
		try {
			DbConnect
					.getConnect()
					.prepareStatement(
							"delete from student where id = "
									+ request.getParameter("id"))
					.executeUpdate();
			Connection conn = DbConnect.getConnect();
			//删除操作完成后，跳转到学生信息列表页面，以查看删除是否成功。
			PreparedStatement pst = conn
					.prepareStatement("select * from student");
			ResultSet rs = pst.executeQuery();
			// 创建会话对象session
			HttpSession session = request.getSession();
			session.setAttribute("rs", rs);
			response.sendRedirect("studentList.jsp");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
