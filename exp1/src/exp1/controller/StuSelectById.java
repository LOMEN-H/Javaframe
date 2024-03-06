package exp1.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exp1.model.entity.Student;
import exp1.model.tool.DbConnect;

/**
 * Servlet implementation class StuSelectById
 */
@WebServlet("/stuSelectById")
public class StuSelectById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StuSelectById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//�Ѵ��ݹ�����ID�Ŷ�ȡ����������ID�Ż�ȡ��Ӧ��ѧ����Ϣ�����ֻ��һ����¼�������ѯ�ķ���ֵ��ѧ������
		//�ѽ�����ص��޸Ĳ������ͼ����ѧ����¼��ÿ���ֶ�ֵ��Ĭ��ֵ����ʽ��ʾ���޸ı����������
		String id=request.getParameter("id");
		try {
			ResultSet rs=DbConnect.getConnect().prepareStatement("select* from student where id="+id).executeQuery();
			while(rs.next()){
				 Student st=new Student(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				 HttpSession session=request.getSession();
					session.setAttribute("st", st);
					response.sendRedirect("studentUpdate.jsp");
					
			 }
			
			
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
