package edu.web.jsp02.web.user;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.web.jsp02.domain.User;
import edu.web.jsp02.service.UserService;
import edu.web.jsp02.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;

/**
 * Servlet implementation class UserDetailController
 */
@Slf4j
@WebServlet(name = "userDetailController", urlPatterns = { "/user/detail" })
public class UserDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private UserService userService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserDetailController() {
        userService = UserServiceImpl.getInstance();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("doGet()");
		
		Integer id = Integer.valueOf(request.getParameter("id"));
		log.info("id = {}", id);
		
		User user = userService.read(id);
		log.info("user = {}", user);
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/user/detail.jsp")
		    .forward(request, response);
	}

}
