package exp1.controller;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import com.mysql.cj.Session;

import exp1.model.tool.DbConnect;

/**
 * Servlet implementation class StuUpdateServlet
 */
@WebServlet("/stuAddServlet")
public class StuAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取填写好的修改数据，然后执行修改的sql，再查询所有检验修改是否完成。
		String Id =request.getParameter("id");
		String Name =request.getParameter("name");
		String Gender =request.getParameter("gender");
		String Major =request.getParameter("major");
		String Grade =request.getParameter("grade");
		Connection con=DbConnect.getConnect();
		String sql="INSERT INTO student VALUES ('"+Id+"','"+Name+"','"+Gender+"','"+Major+"','"+Grade+"')"; 
		try {
			System.out.println(sql);
			System.out.println(con.prepareStatement(sql).executeUpdate());
			sql="select * from student ";
			ResultSet rs=con.prepareStatement(sql).executeQuery();
			
			
			
			
			HttpSession session =request.getSession();
			session.setAttribute("rs", rs);
			response.sendRedirect("studentList.jsp");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
