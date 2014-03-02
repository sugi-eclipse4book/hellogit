package blog;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * �g�s�b�N�����ʂ���T�[�u���b�g
*/
public class ReadServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException,IOException{
	perform(request,response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException,IOException{
	perform(request,response);
	}

	protected void perform(HttpServletRequest request,
			HttpServletResponse response)
					throws ServletException,IOException{
		BlogController ctrl = BlogController.getInstance();
		List topics = ctrl.getTopics();

		request.setAttribute("topics", topics);

		request.getRequestDispatcher("/read.jsp")
		.forward(request, response);
	}
}