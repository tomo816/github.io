package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class enrollFin
 */
@WebServlet("/enrollFin")
public class enrollFin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public enrollFin() {
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

		HttpSession session =  request.getSession();
		model.UserInfoDto userInfoOnSession = (model.UserInfoDto)session.getAttribute("LOGIN_INFO");

		if(userInfoOnSession != null) {


		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>新規登録完了</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ログイン完了画面</h1>");
		out.println("<p>新規登録できました</p>");
		out.println("<a href=\"home\">Home画面へ進む</a>");
		out.println("</body>");
		out.println("</html>");
	}else {
		RequestDispatcher dispatch = request.getRequestDispatcher("/WEB-INF/view/enrollForm.jsp");
		dispatch.forward(request, response);
	}
	}
}
