package com.cruzeiro;


import jakarta.annotation.Resource;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/dbStudent")
	private DataSource dataSource;
       
    @Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		try {
			studentDbUtil = new StudentDbUtil(dataSource);
		}catch(Exception e){
			throw new ServletException(e);
		}
	}

	/**
     * @see HttpServlet#HttpServlet()
     */
    public StudentControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			//verificar o valor do parametro "command"
			String command = request.getParameter("command");
			
			//escolher a opção correta da operação
			if(command == null) {
				command = "LIST";
			}
			
			switch(command) {
			
			case "LIST":
				listStudents(request, response);
				break;
				
			case "ADD":
				addStudents(request, response);
				break;	
				
			default:
				listStudents(request, response);
			
			}
			
		}catch (Exception e) {
			throw new ServletException(e);
			
		}
	}

	private void addStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//recuperar as informações enviadas
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		
		//criar um novo objeto de estudante
		Student student = new Student(0, firstName, lastName, email);
		
		//gravar na base
		studentDbUtil.addStudent(student);
		
		//voltar para a lista de estudante
		listStudents(request, response);
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		//recuperar estudante do bando de dados
		List<Student> student = studentDbUtil.getStudents();
		
		//adicionar os dados do request
		request.setAttribute("STUDENT_LIST", student);
		
		//enviar para a página JSP (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jps");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
