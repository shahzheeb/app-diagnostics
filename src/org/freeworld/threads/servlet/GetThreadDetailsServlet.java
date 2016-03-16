package org.freeworld.threads.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.lang.reflect.Type;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.freeworld.threads.model.ThreadDetails;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class ChangeLoggerServlet
 */
@WebServlet("/GetThreadDetailsServlet")
public class GetThreadDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetThreadDetailsServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean(); 
	    System.out.println("Bean: " + bean); 
	    
	    long[] ids = bean.getAllThreadIds(); 
	    
	    System.out.println("Live thread ids: " + Arrays.toString(ids)); 
	   
	    System.out.println("Daemon thread count: " + bean.getDaemonThreadCount()); 
	    System.out.println("Peak thread count: " + bean.getPeakThreadCount()); 
	    System.out.println("Thread count: " + bean.getThreadCount()); 
	    
	    System.out.println("Total started threads: " + bean.getTotalStartedThreadCount()); 
	    
	    ThreadDetails threadDetails = new ThreadDetails();
        threadDetails.setDeamonThreadcount(bean.getDaemonThreadCount());
        threadDetails.setLiveThreadcount(bean.getThreadCount());
        threadDetails.setPeakThreadcount(bean.getPeakThreadCount());
        threadDetails.setTotalStartedthreads(bean.getTotalStartedThreadCount());
        
        
	    ClassLoadingMXBean classloaderbean = ManagementFactory.getClassLoadingMXBean(); 

	    threadDetails.setLoadedClassCount(classloaderbean.getLoadedClassCount());
	    threadDetails.setUnloadedClassCount(classloaderbean.getUnloadedClassCount());

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        
        
        Gson gson = new Gson();
        Type type = new TypeToken<ThreadDetails>() {}.getType();
        String jsonStr = gson.toJson(threadDetails, type);
        
        out.print(jsonStr);    
        out.flush();
    
	}

}
