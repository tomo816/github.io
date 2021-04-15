package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BusinessLogic;
import model.UserInfoDto;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);

	}



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		HttpSession session =  request.getSession();
		UserInfoDto userInfoOnSession = (UserInfoDto)session.getAttribute("LOGIN_INFO");


		if(userInfoOnSession != null) {
			response.sendRedirect("home");



		}else {


		String userId						=request.getParameter("USER_ID");
		String  passWord					=request.getParameter("PASSWORD");

		BusinessLogic logic = new BusinessLogic();
		UserInfoDto dto = logic.executeSelectUserInfo(userId, passWord);


		if(dto.getUserId() != null && userId != "" && passWord != "") {
			session.setAttribute("LOGIN_INFO", dto);
			response.sendRedirect("home");

		}else if(userId != dto.getUserId() ||passWord != dto.getPassWord()){

			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/loginForm-error.jsp");
			dispatch.forward(request, response);

		}else {
			RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/loginForm.jsp");
			dispatch.forward(request, response);



		}
		}
	}
}



