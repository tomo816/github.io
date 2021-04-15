package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BusinessLogic;
import model.textDto;
/**
 * Servlet implementation class home
 */
@WebServlet("/home")
public class home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public home() {
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
		model.UserInfoDto userInfoOnSession = (model.UserInfoDto)session.getAttribute("LOGIN_INFO");

		if(userInfoOnSession != null) {

		List<textDto> Dto= new ArrayList<textDto>();

		BusinessLogic logic = new BusinessLogic();

		String deleteText  =request.getParameter("deleteText");
		String deleteUser  =request.getParameter("deleteUser");
		String deleteTime   =request.getParameter("deleteTime");



			logic.executeDelete(deleteText,deleteUser, deleteTime);
		Dto = logic.executeSelect();










		request.setAttribute("userInfo", userInfoOnSession);
		request.setAttribute("message", Dto);
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/myHome.jsp");
		dispatch.forward(request, response);
		}else {
			response.sendRedirect("login");
		}
	}

	}

