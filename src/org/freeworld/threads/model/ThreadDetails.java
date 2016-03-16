package org.freeworld.threads.model;

public class ThreadDetails {

	private int liveThreadcount;
	private int deamonThreadcount;
	private long totalStartedthreads;
	private int peakThreadcount;
	private int loadedClassCount;
	private long unloadedClassCount;
	
	
	
	public int getLoadedClassCount() {
		return loadedClassCount;
	}
	public void setLoadedClassCount(int loadedClassCount) {
		this.loadedClassCount = loadedClassCount;
	}
	public long getUnloadedClassCount() {
		return unloadedClassCount;
	}
	public void setUnloadedClassCount(long unloadedClassCount) {
		this.unloadedClassCount = unloadedClassCount;
	}
	public int getLiveThreadcount() {
		return liveThreadcount;
	}
	public void setLiveThreadcount(int liveThreadcount) {
		this.liveThreadcount = liveThreadcount;
	}
	public int getDeamonThreadcount() {
		return deamonThreadcount;
	}
	public void setDeamonThreadcount(int deamonThreadcount) {
		this.deamonThreadcount = deamonThreadcount;
	}
	
	public int getPeakThreadcount() {
		return peakThreadcount;
	}
	public void setPeakThreadcount(int peakThreadcount) {
		this.peakThreadcount = peakThreadcount;
	}
	public long getTotalStartedthreads() {
		return totalStartedthreads;
	}
	public void setTotalStartedthreads(long totalStartedthreads) {
		this.totalStartedthreads = totalStartedthreads;
	}
	
	
	
}
