package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserInfoDto;

/**
 * Servlet implementation class submitService
 */
@WebServlet("/submitService")
public class submitService extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public submitService() {
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
			model.textDto dto = new model.textDto();

			dto.setUserName(userInfoOnSession.getUserName());
			dto.setText(request.getParameter("text_body"));
			dto.setInsert_date(new Timestamp(System.currentTimeMillis()));
			dto.setUpdate_date(new Timestamp(System.currentTimeMillis()));
			dto.setProfileIcon(userInfoOnSession.getProfileImage());

System.out.println(dto.getUserName());



			System.out.println(dto.getProfileIcon());

			model.BusinessLogic logic = new model.BusinessLogic();
			boolean succesInsert = logic.textInsert(dto);

			if(succesInsert) {

				response.sendRedirect("home");
			}else {
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/submitServiceForm.jsp");
				dispatch.forward(request, response);


			}



		}else {
response.sendRedirect("login");

		}
	}
}


