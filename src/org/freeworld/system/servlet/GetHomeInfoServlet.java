package org.freeworld.system.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.lang.reflect.Type;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.freeworld.system.model.HomeModel;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

/**
 * Servlet implementation class GetFullMemoryDetailsServlet
 */
@WebServlet("/GetHomeInfoServlet")
public class GetHomeInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetHomeInfoServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HomeModel hm = new HomeModel();
		
		RuntimeMXBean vmBean = ManagementFactory.getRuntimeMXBean();
		hm.setJava_ver(vmBean.getSpecVersion());
		hm.setVm_name(vmBean.getVmName());
		
		SystemInfo si = new SystemInfo();
		OperatingSystem os = si.getOperatingSystem();
		System.out.println(os);

		System.out.println("Family :" + os.getFamily());
		System.out.println("Manufacturer :" + os.getManufacturer());
		System.out.println("Version :" + os.getVersion());
		
		HardwareAbstractionLayer hal = si.getHardware();
		
		hm.setOs(os.toString());
		hm.setOsVer(os.getVersion().toString());
		hm.setNo_processor(hal.getProcessors().length);
		
		OSFileStore[] filestoresArray = hal.getFileStores();
		for (OSFileStore osFileStore : filestoresArray) {
			if(osFileStore.getDescription().contains("Local Disk")){
				hm.setAvailSpace(bytesToGb(osFileStore.getUsableSpace()));
				hm.setTotSpace(bytesToGb(osFileStore.getTotalSpace()));
			}
			System.out.println(osFileStore.getName());
			System.out.println(osFileStore.getDescription());
			System.out.println(osFileStore.getTotalSpace());
			System.out.println(osFileStore.getUsableSpace());
		}
		
		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		Gson gson = new Gson();
		Type type = new TypeToken<HomeModel>() {
		}.getType();
		String jsonStr = gson.toJson(hm, type);

		System.out.println(jsonStr);

		out.print(jsonStr);
		out.flush();


	}

	private static double bytesToGb(long bytes) {

		if (bytes < 0) {
			return 0;
		}
		double GIGABYTE = 1000 * 1000 * 1000;
		double val = bytes / GIGABYTE;
		return Math.round(val * 100.0) / 100.0;
	}
}
