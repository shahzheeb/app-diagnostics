package org.freeworld.threads.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeLoggerServlet
 */
@WebServlet("/GetThreadDumpServlet")
public class GetThreadDumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetThreadDumpServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    ThreadMXBean bean = ManagementFactory.getThreadMXBean(); 
	    System.out.println("Bean: " + bean); 
	    
		final StringBuilder dump = new StringBuilder();
        final ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        final ThreadInfo[] threadInfos = threadMXBean.getThreadInfo(threadMXBean.getAllThreadIds(), 100);
        for (ThreadInfo threadInfo : threadInfos) {
            dump.append("<br> <b>Thread Name :</b> ");
            dump.append(threadInfo.getThreadName());
            dump.append("<br> ");
            final Thread.State state = threadInfo.getThreadState();
            dump.append("<br> java.lang.Thread.State: ");
            dump.append(state);
            dump.append("<br>");
            final StackTraceElement[] stackTraceElements = threadInfo.getStackTrace();
            for (final StackTraceElement stackTraceElement : stackTraceElements) {
                dump.append("<br>        at ");
                dump.append(stackTraceElement);
            }
            dump.append("<br>");
            dump.append("<hr>");
        }
        //System.out.println("Thread dump :"+dump.toString());
        
        /*String filename = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime()) +"_thread.bin";
		String location = "/Users/acv631/Documents/Temp/";
        String fileNameTosave = location + filename;
        
        try {
			Files.write(Paths.get(fileNameTosave), dump.toString().getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Thread Dump</title>");
        out.println("</head>");

        out.println("<body bgcolor=\"black\" text=\"white\">");
        out.println("<center>");
        out.println("<h1>Thread Dump</h1>");
        out.println("</center>");
        System.out.println("Writing Thread dump");
        out.println(dump.toString());
        out.println("</body>");
        out.println("</html>");
        out.close();
     
    
	}

}
