package org.freeworld.memory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.management.MBeanServer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetFullMemoryDetailsServlet
 */
@WebServlet("/GetHeapDumpServlet")
public class GetHeapDumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String HOTSPOT_BEAN_NAME =
	         "com.sun.management:type=HotSpotDiagnostic";

	private static volatile Object hotspotMBean;
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetHeapDumpServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
        
		// default heap dump file name
		String filename = new SimpleDateFormat("yyyyMMdd_HHmm").format(Calendar.getInstance().getTime()) +"_heap.bin";
		String location = "/tmp/";
        String fileNameTosave = location + filename;
        // by default dump only the live objects
        boolean live = true;
        // dump the heap
        dumpHeap(fileNameTosave, live);
        
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        
        pw.println(filename + " created. Please download the dump from "+location);
        pw.close();
    }
	
	static void dumpHeap(String fileName, boolean live) {
        // initialize hotspot diagnostic MBean
        initHotspotMBean();
        try {
            Class clazz = Class.forName("com.sun.management.HotSpotDiagnosticMXBean");
            Method m = clazz.getMethod("dumpHeap", String.class, boolean.class);
            m.invoke( hotspotMBean , fileName, live);
        } catch (RuntimeException re) {
            throw re;
        } catch (Exception exp) {
            throw new RuntimeException(exp);
        }
    }
    private static void initHotspotMBean() {
        if (hotspotMBean == null) {
            synchronized (GetHeapDumpServlet.class) {
                if (hotspotMBean == null) {
                    hotspotMBean = getHotspotMBean();
                }
            }
        }
    }
    
	private static Object getHotspotMBean() {
	        try {
	            Class clazz = Class.forName("com.sun.management.HotSpotDiagnosticMXBean");
	            MBeanServer server = ManagementFactory.getPlatformMBeanServer();
	            Object bean = 
	                ManagementFactory.newPlatformMXBeanProxy(server,
	                HOTSPOT_BEAN_NAME, clazz);
	            return bean;
	        } catch (RuntimeException re) {
	            throw re;
	        } catch (Exception exp) {
	            throw new RuntimeException(exp);
	        }
	    }

}
