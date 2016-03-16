package org.freeworld.system.model;

public class HomeModel {

	private String os;
	private String osVer;
	private String java_ver;
	private String vm_name;
	private int no_processor;
	private double totSpace;
	private double availSpace;
	
	
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getOsVer() {
		return osVer;
	}
	public void setOsVer(String osVer) {
		this.osVer = osVer;
	}

	public String getJava_ver() {
		return java_ver;
	}
	public void setJava_ver(String java_ver) {
		this.java_ver = java_ver;
	}
	public String getVm_name() {
		return vm_name;
	}
	public void setVm_name(String vm_name) {
		this.vm_name = vm_name;
	}
	public int getNo_processor() {
		return no_processor;
	}
	public void setNo_processor(int no_processor) {
		this.no_processor = no_processor;
	}
	public double getTotSpace() {
		return totSpace;
	}
	public void setTotSpace(double totSpace) {
		this.totSpace = totSpace;
	}
	public double getAvailSpace() {
		return availSpace;
	}
	public void setAvailSpace(double availSpace) {
		this.availSpace = availSpace;
	}
	
	
	
}
