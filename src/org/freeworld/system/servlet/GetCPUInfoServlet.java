package org.freeworld.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import java.lang.reflect.Type;
import java.text.DecimalFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.freeworld.system.model.CPUMemUsage;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.Processor;
import oshi.util.FormatUtil;

/**
 * Servlet implementation class GetFullMemoryDetailsServlet
 */
@WebServlet("/GetCPUMemoryDetailsServlet")
public class GetCPUInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetCPUInfoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		SystemInfo si = new SystemInfo();
		HardwareAbstractionLayer hal = si.getHardware();
		System.out.println(hal.getProcessors().length + " CPU(s):");
		
		Processor[] processorArray = hal.getProcessors();
		
		//Returns the "recent cpu usage" for the whole system. This value is a double in the [0.0,1.0] interval.
		//A value of 0.0 means that all CPUs were idle during the recent period of time observed, while a value of 1.0 
		//means that all CPUs were actively running 100% of the time during the recent period being observed. 
		//All values betweens 0.0 and 1.0 are possible depending of the activities going on in the system. 
		//If the system recent cpu usage is not available, the method returns a negative value.

		//System.out.println("CPU Load : "+processorArray[0].getSystemCpuLoad()+"\n");
		//System.out.println("CPU getSystemLoadAverage : "+processorArray[0].getSystemLoadAverage()+"\n");
		
		OperatingSystemMXBean osBean = ManagementFactory.getOperatingSystemMXBean(); 
	    System.out.println("System Load Average: " + osBean.getSystemLoadAverage()); 
		
		System.out.println("Memory: " +
		    FormatUtil.formatBytes(hal.getMemory().getAvailable()) + "/" +
		    FormatUtil.formatBytes(hal.getMemory().getTotal()));
		
		//CentralProcessor centralProcessor = new CentralProcessor(1);
		DecimalFormat dec = new DecimalFormat("#.##");
		
		CPUMemUsage cpuMemUsage = new CPUMemUsage();
		//System.out.println("XXX: "+new Double(processorArray[0].getSystemCpuLoad()).toString());
		cpuMemUsage.setSysCpuLoad(new Double(processorArray[0].getSystemCpuLoad()).toString());
		cpuMemUsage.setSysLoadAvg(roundDouble(osBean.getSystemLoadAverage()));
		cpuMemUsage.setTotMem(bytesToGb(hal.getMemory().getTotal()));
		cpuMemUsage.setAvailMem(bytesToGb(hal.getMemory().getAvailable()));
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		Gson gson = new Gson();
		Type type = new TypeToken<CPUMemUsage>() {
		}.getType();
		String jsonStr = gson.toJson(cpuMemUsage, type);

		System.out.println(jsonStr);

		out.print(jsonStr);
		out.flush();
	}
	
	private double roundDouble(double val){
		
		return Math.round(val * 100.0) / 100.0;
	}
	
	
	private double bytesToGb(long bytes){
		
		
		if(bytes < 0) {
			return 0;
		}
		double GIGABYTE = 1024L * 1024L * 1024L;
		double val = bytes / GIGABYTE;
		return Math.round(val * 100.0) / 100.0;
	}
}
