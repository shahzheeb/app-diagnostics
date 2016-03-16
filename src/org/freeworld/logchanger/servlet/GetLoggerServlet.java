package org.freeworld.logchanger.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Category;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerRepository;
import org.freeworld.logchanger.model.LogComparator;
import org.freeworld.logchanger.model.LogData;

/**
 * Servlet implementation class ChangeLoggerServlet
 */
@WebServlet("/GetLoggerServlet")
public class GetLoggerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Logger root;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLoggerServlet() {
        super();
        this.root = Logger.getRootLogger();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<LogData> logList = new ArrayList<LogData>();

        LoggerRepository repo = this.root.getLoggerRepository();

        Enumeration loggers = repo.getCurrentLoggers();

        while (loggers.hasMoreElements()) {
            Logger currentLogger = (Logger) loggers.nextElement();
            try {
                String logger = currentLogger.getName();
                String level = null;

                if (currentLogger.getLevel() != null) {
                    level = currentLogger.getLevel().toString();
                }

                if ((level == null) || (level.equalsIgnoreCase("null"))) {
                    level = derivedLevel(currentLogger.getParent());
                }
                
                if(! logger.contains("org.")){
                    LogData logdata = new LogData();
                    logdata.setLogger(logger);
                    logdata.setLogLevel(level.replaceAll("inherits:", ""));
                    logList.add(logdata);     
                }
                        
               
            } catch (Exception e) {
                //output.put(currentLogger.getName(), e.getMessage());
                e.printStackTrace();
            }
        }
        
        Collections.sort(logList, new LogComparator());
      
        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        //String json = gson.toJson(logList);
        
//        PrintWriter out = response.getWriter();
//        out.print(json);    
//        out.flush();        
        
        request.setAttribute("loglist",logList);

        RequestDispatcher rd = request.getRequestDispatcher("showloggers.jsp");
        rd.forward(request, response);
    
	}
	
    private String derivedLevel(Category logger) {
        String level = logger.getLevel().toString();
        if ((level == null) && (logger.getParent() != null)) {
            level = derivedLevel(logger.getParent());
        }

        return "inherits:" + level;
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
