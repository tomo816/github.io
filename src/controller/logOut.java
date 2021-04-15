package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class logOut
 */
@WebServlet("/logOut")
public class logOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public logOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		HttpSession session =  request.getSession();
		model.UserInfoDto userInfoOnSession = (model.UserInfoDto)session.getAttribute("LOGIN_INFO");

		if(userInfoOnSession != null) {

		PrintWriter out = response.getWriter();

		session.invalidate();

		out.println("<html>");
		out.println("<head>");
		out.println("<title>ログアウト完了</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>ログアウトしました</p>");
		out.println("<a href=\"login\">ログイン画面に戻る</a>");
		out.println("</body>");
		out.println("</html>");


	}else {
		response.sendRedirect("login");
	}
}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
