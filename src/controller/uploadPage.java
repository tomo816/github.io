package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class uploadPage
 */
@WebServlet("/uploadPage")
public class uploadPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadPage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/uploadForm.jsp");
		dispatch.forward(request, response);
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


			model.UserInfoDto dto = new model.UserInfoDto();

			dto.setUserId(request.getParameter("newId"));
			dto.setPassWord(request.getParameter("newUPPassword"));
			dto.setUserName(request.getParameter("name"));
			dto.setProfileImage(request.getParameter("profileUPImage"));
			String originalId = userInfoOnSession.getUserId();





			model.BusinessLogic logic = new model.BusinessLogic();
			boolean succesInsert = logic.executeUpdateUserInfo(dto,originalId);


			if(succesInsert) {
				model.textDto Dto = new model.textDto();
				Dto.setProfileIcon(dto.getProfileImage());
				Dto.setUserName(dto.getUserName());
				String originalid =userInfoOnSession.getUserName();


				logic.executeTextUpdate(Dto,originalid);

				
				session.setAttribute("LOGIN_INFO", dto);
				response.sendRedirect("home");
			}else {
				RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/uploadForm.jsp");
				dispatch.forward(request, response);
			}


		}else {
			response.sendRedirect("login");

		}
		}
	}



