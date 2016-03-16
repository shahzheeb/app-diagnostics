package org.freeworld.logchanger.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Servlet implementation class ChangeLoggerServlet
 */
@WebServlet("/ChangeLoggerServlet")
public class ChangeLoggerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger root;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeLoggerServlet() {
        super();
        this.root = Logger.getRootLogger();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    String status = "Successful";
	    
	        try {
	            
	            Level level = Level.toLevel(request.getParameter("level"));
	            Logger logger = Logger.getLogger(request.getParameter("logger"));
	            logger.setLevel(level);
	            request.setAttribute("message", "Log level for "+ request.getParameter("logger") +" changed to "+ request.getParameter("level"));
	            
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            request.setAttribute("message", "log Level change failed due to "+ e.getMessage());
	        }
	        
	     //   PrintWriter out = response.getWriter();
	     //   out.print(status);    
	     //   out.flush(); 

	        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
	        rd.forward(request, response);
	        
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
