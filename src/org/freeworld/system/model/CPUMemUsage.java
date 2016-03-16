package org.freeworld.system.model;

public class CPUMemUsage {
	
	private String sysCpuLoad;
	private double sysLoadAvg;
	
	private double totMem;
	private double availMem;
	
	public String getSysCpuLoad() {
		return sysCpuLoad;
	}
	public void setSysCpuLoad(String sysCpuLoad) {
		this.sysCpuLoad = sysCpuLoad;
	}
	public double getSysLoadAvg() {
		return sysLoadAvg;
	}
	public void setSysLoadAvg(double sysLoadAvg) {
		this.sysLoadAvg = sysLoadAvg;
	}
	public double getTotMem() {
		return totMem;
	}
	public void setTotMem(double totMem) {
		this.totMem = totMem;
	}
	public double getAvailMem() {
		return availMem;
	}
	public void setAvailMem(double availMem) {
		this.availMem = availMem;
	}
	
}
