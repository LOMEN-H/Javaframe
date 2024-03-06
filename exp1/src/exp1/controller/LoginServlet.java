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
		//�����¼����
		//1.��ȡ���ݹ���������
		String name=request.getParameter("username");
		String pass=request.getParameter("password");
		//2.��֤
		if(name.equals("zhangsan") && pass.equals("123")) {
			//2.1��֤ͨ������ת��ѧ���б�ҳ��
			//����ת֮ǰ��Ӧ���������ݿ⣬��ѧ�����ݼ��ϻ�ȡ���������ڻỰ�У�����ת����Ŀ��ҳ����Ϳ��Ա������ˡ�
			Connection conn=DbConnect.getConnect();
			try {
				PreparedStatement pst=conn.prepareStatement("select * from student");
				ResultSet rs=pst.executeQuery();
				//�����Ự����session
				HttpSession session=request.getSession();
				session.setAttribute("rs", rs);
				response.sendRedirect("studentList.jsp");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//request.getRequestDispatcher("/studentList.jsp").forward(request, response);
		}else {
			//2.2��֤��ͨ������ת����¼ҳ��
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
