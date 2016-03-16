package org.freeworld.memory.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryPoolMXBean;
import java.lang.reflect.Type;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.freeworld.memory.model.MemoryDetail;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class GetFullMemoryDetailsServlet
 */
@WebServlet("/GetFullMemoryDetailsServlet")
public class GetFullMemoryDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetFullMemoryDetailsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemoryDetail memorydetail = new MemoryDetail();
		List<MemoryPoolMXBean> mpmxList = ManagementFactory.getMemoryPoolMXBeans();

		for (MemoryPoolMXBean pl : mpmxList) {

			String poolname = pl.getName();
			
			if(poolname.contains("Eden")){
				poolname = "PS Eden Space";
			}
			if(poolname.contains("Survivor")){
				poolname = "PS Survivor Space";
			}
			if(poolname.contains("Old Gen") || poolname.contains("Tenured Gen")){
				poolname = "PS Old Gen";
			}
			
			System.out.println("Pool Name: "+poolname);
			switch (poolname) {
			case "Compressed Class Space":
				memorydetail.setCompressedclassname(pl.getName());
				memorydetail.setCompressedclassinit(bytesToMb(pl.getUsage().getInit()));
				memorydetail.setCompressedclasscommitted(bytesToMb(pl.getUsage().getCommitted()));
				memorydetail.setCompressedclassmax(bytesToMb(pl.getUsage().getMax()));
				memorydetail.setCompressedclassused(bytesToMb(pl.getUsage().getUsed()));
				break;
			case "Metaspace":
				memorydetail.setMetaspacename(pl.getName());
				memorydetail.setMetaspaceinit(bytesToMb(pl.getUsage().getInit()));
				memorydetail.setMetaspacecommitted(bytesToMb(pl.getUsage().getCommitted()));
				memorydetail.setMetaspacemax(bytesToMb(pl.getUsage().getMax()));
				memorydetail.setMetaspaceused(bytesToMb(pl.getUsage().getUsed()));
				break;
			case "Code Cache":
				memorydetail.setCodecachename(pl.getName());
				memorydetail.setCodecacheinit(bytesToMb(pl.getUsage().getInit()));
				memorydetail.setCodecachecommitted(bytesToMb(pl.getUsage().getCommitted()));
				memorydetail.setCodecachemax(bytesToMb(pl.getUsage().getMax()));
				memorydetail.setCodecacheused(bytesToMb(pl.getUsage().getUsed()));
				break;

			case "PS Eden Space":
				memorydetail.setPsedenname(pl.getName());
				memorydetail.setPsedeninit(bytesToMb(pl.getUsage().getInit()));
				memorydetail.setPsedencommitted(bytesToMb(pl.getUsage().getCommitted()));
				memorydetail.setPsedenmax(bytesToMb(pl.getUsage().getMax()));
				memorydetail.setPsedenused(bytesToMb(pl.getUsage().getUsed()));
				break;

			case "PS Survivor Space":
				memorydetail.setPssurvivorspname(pl.getName());
				memorydetail.setPssurvivorspinit(bytesToMb(pl.getUsage().getInit()));
				memorydetail.setPssurvivorspcommitted(bytesToMb(pl.getUsage().getCommitted()));
				memorydetail.setPssurvivorspmax(bytesToMb(pl.getUsage().getMax()));
				memorydetail.setPssurvivorspused(bytesToMb(pl.getUsage().getUsed()));
				break;

			case "PS Old Gen":
				memorydetail.setPsoldgenname(pl.getName());
				memorydetail.setPsoldgeninit(bytesToMb(pl.getUsage().getInit()));
				memorydetail.setPsoldgencommitted(bytesToMb(pl.getUsage().getCommitted()));
				memorydetail.setPsoldgenmax(bytesToMb(pl.getUsage().getMax()));
				memorydetail.setPsoldgenused(bytesToMb(pl.getUsage().getUsed()));
				break;

			default:
				break;
			}
		}

		MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

		memorydetail.setHeapinit(bytesToMb(memoryMXBean.getHeapMemoryUsage().getInit()));
		memorydetail.setHeapcommitted(bytesToMb(memoryMXBean.getHeapMemoryUsage().getCommitted()));
		memorydetail.setHeapmax(bytesToMb(memoryMXBean.getHeapMemoryUsage().getMax()));
		memorydetail.setHeapused(bytesToMb(memoryMXBean.getHeapMemoryUsage().getUsed()));

		memorydetail.setNonheapinit(bytesToMb(memoryMXBean.getNonHeapMemoryUsage().getInit()));
		memorydetail.setNonheapcommitted(bytesToMb(memoryMXBean.getNonHeapMemoryUsage().getCommitted()));
		memorydetail.setNonheapmax(bytesToMb(memoryMXBean.getNonHeapMemoryUsage().getMax()));
		memorydetail.setNonheapused(bytesToMb(memoryMXBean.getNonHeapMemoryUsage().getUsed()));

		response.setContentType("application/json");
		PrintWriter out = response.getWriter();

		Gson gson = new Gson();
		Type type = new TypeToken<MemoryDetail>() {
		}.getType();
		String jsonStr = gson.toJson(memorydetail, type);

		System.out.println(jsonStr);

		out.print(jsonStr);
		out.flush();

	}
	
	
	private long bytesToMb(long bytes){
		if(bytes < 0) {
			return 0;
		}
		long MEGABYTE = 1024L * 1024L;
		return bytes / MEGABYTE;
	}

}
