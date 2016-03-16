package org.freeworld.memory.model;

public class MemoryDetail {

	private String codecachename;
	private long codecacheinit;
	private long codecachecommitted;
	private long codecacheused;
	private long codecachemax;
	
	private String metaspacename;
	private long metaspaceinit;
	private long metaspacecommitted;
	private long metaspaceused;
	private long metaspacemax;
	
	private String compressedclassname;
	private long compressedclassinit;
	private long compressedclasscommitted;
	private long compressedclassused;
	private long compressedclassmax;
	
	private String psedenname;
	private long psedeninit;
	private long psedencommitted;
	private long psedenused;
	private long psedenmax;
	
	private String pssurvivorspname;
	private long pssurvivorspinit;
	private long pssurvivorspcommitted;
	private long pssurvivorspused;
	private long pssurvivorspmax;
	
	private String psoldgenname;
	private long psoldgeninit;
	private long psoldgencommitted;
	private long psoldgenused;
	private long psoldgenmax;
	
	private long heapinit;
	private long heapcommitted;
	private long heapused;
	private long heapmax;
	
	private long nonheapinit;
	private long nonheapcommitted;
	private long nonheapused;
	private long nonheapmax;
	
	
	public String getCodecachename() {
		return codecachename;
	}
	public void setCodecachename(String codecachename) {
		this.codecachename = codecachename;
	}
	public long getCodecacheinit() {
		return codecacheinit;
	}
	public void setCodecacheinit(long codecacheinit) {
		this.codecacheinit = codecacheinit;
	}
	public long getCodecachecommitted() {
		return codecachecommitted;
	}
	public void setCodecachecommitted(long codecachecommitted) {
		this.codecachecommitted = codecachecommitted;
	}
	public long getCodecacheused() {
		return codecacheused;
	}
	public void setCodecacheused(long codecacheused) {
		this.codecacheused = codecacheused;
	}
	public long getCodecachemax() {
		return codecachemax;
	}
	public void setCodecachemax(long codecachemax) {
		this.codecachemax = codecachemax;
	}
	public String getMetaspacename() {
		return metaspacename;
	}
	public void setMetaspacename(String metaspacename) {
		this.metaspacename = metaspacename;
	}
	public long getMetaspaceinit() {
		return metaspaceinit;
	}
	public void setMetaspaceinit(long metaspaceinit) {
		this.metaspaceinit = metaspaceinit;
	}
	public long getMetaspacecommitted() {
		return metaspacecommitted;
	}
	public void setMetaspacecommitted(long metaspacecommitted) {
		this.metaspacecommitted = metaspacecommitted;
	}
	public long getMetaspaceused() {
		return metaspaceused;
	}
	public void setMetaspaceused(long metaspaceused) {
		this.metaspaceused = metaspaceused;
	}
	public long getMetaspacemax() {
		return metaspacemax;
	}
	public void setMetaspacemax(long metaspacemax) {
		this.metaspacemax = metaspacemax;
	}

	
	public String getCompressedclassname() {
		return compressedclassname;
	}
	public void setCompressedclassname(String compressedclassname) {
		this.compressedclassname = compressedclassname;
	}
	public long getCompressedclassinit() {
		return compressedclassinit;
	}
	public void setCompressedclassinit(long compressedclassinit) {
		this.compressedclassinit = compressedclassinit;
	}
	public long getCompressedclasscommitted() {
		return compressedclasscommitted;
	}
	public void setCompressedclasscommitted(long compressedclasscommitted) {
		this.compressedclasscommitted = compressedclasscommitted;
	}
	public long getCompressedclassused() {
		return compressedclassused;
	}
	public void setCompressedclassused(long compressedclassused) {
		this.compressedclassused = compressedclassused;
	}
	public long getCompressedclassmax() {
		return compressedclassmax;
	}
	public void setCompressedclassmax(long compressedclassmax) {
		this.compressedclassmax = compressedclassmax;
	}
	public String getPsedenname() {
		return psedenname;
	}
	public void setPsedenname(String psedenname) {
		this.psedenname = psedenname;
	}
	public long getPsedeninit() {
		return psedeninit;
	}
	public void setPsedeninit(long psedeninit) {
		this.psedeninit = psedeninit;
	}
	public long getPsedencommitted() {
		return psedencommitted;
	}
	public void setPsedencommitted(long psedencommitted) {
		this.psedencommitted = psedencommitted;
	}
	public long getPsedenused() {
		return psedenused;
	}
	public void setPsedenused(long psedenused) {
		this.psedenused = psedenused;
	}
	public long getPsedenmax() {
		return psedenmax;
	}
	public void setPsedenmax(long psedenmax) {
		this.psedenmax = psedenmax;
	}

	public long getHeapinit() {
		return heapinit;
	}
	public void setHeapinit(long heapinit) {
		this.heapinit = heapinit;
	}
	public long getHeapcommitted() {
		return heapcommitted;
	}
	public void setHeapcommitted(long heapcommitted) {
		this.heapcommitted = heapcommitted;
	}
	public long getHeapused() {
		return heapused;
	}
	public void setHeapused(long heapused) {
		this.heapused = heapused;
	}
	public long getHeapmax() {
		return heapmax;
	}
	public void setHeapmax(long heapmax) {
		this.heapmax = heapmax;
	}
	public long getNonheapinit() {
		return nonheapinit;
	}
	public void setNonheapinit(long nonheapinit) {
		this.nonheapinit = nonheapinit;
	}
	public long getNonheapcommitted() {
		return nonheapcommitted;
	}
	public void setNonheapcommitted(long nonheapcommitted) {
		this.nonheapcommitted = nonheapcommitted;
	}
	public long getNonheapused() {
		return nonheapused;
	}
	public void setNonheapused(long nonheapused) {
		this.nonheapused = nonheapused;
	}
	public long getNonheapmax() {
		return nonheapmax;
	}
	public void setNonheapmax(long nonheapmax) {
		this.nonheapmax = nonheapmax;
	}
	public String getPssurvivorspname() {
		return pssurvivorspname;
	}
	public void setPssurvivorspname(String pssurvivorspname) {
		this.pssurvivorspname = pssurvivorspname;
	}
	public long getPssurvivorspinit() {
		return pssurvivorspinit;
	}
	public void setPssurvivorspinit(long pssurvivorspinit) {
		this.pssurvivorspinit = pssurvivorspinit;
	}
	public long getPssurvivorspcommitted() {
		return pssurvivorspcommitted;
	}
	public void setPssurvivorspcommitted(long pssurvivorspcommitted) {
		this.pssurvivorspcommitted = pssurvivorspcommitted;
	}
	public long getPssurvivorspused() {
		return pssurvivorspused;
	}
	public void setPssurvivorspused(long pssurvivorspused) {
		this.pssurvivorspused = pssurvivorspused;
	}
	public long getPssurvivorspmax() {
		return pssurvivorspmax;
	}
	public void setPssurvivorspmax(long pssurvivorspmax) {
		this.pssurvivorspmax = pssurvivorspmax;
	}
	public String getPsoldgenname() {
		return psoldgenname;
	}
	public void setPsoldgenname(String psoldgenname) {
		this.psoldgenname = psoldgenname;
	}
	public long getPsoldgeninit() {
		return psoldgeninit;
	}
	public void setPsoldgeninit(long psoldgeninit) {
		this.psoldgeninit = psoldgeninit;
	}
	public long getPsoldgencommitted() {
		return psoldgencommitted;
	}
	public void setPsoldgencommitted(long psoldgencommitted) {
		this.psoldgencommitted = psoldgencommitted;
	}
	public long getPsoldgenused() {
		return psoldgenused;
	}
	public void setPsoldgenused(long psoldgenused) {
		this.psoldgenused = psoldgenused;
	}
	public long getPsoldgenmax() {
		return psoldgenmax;
	}
	public void setPsoldgenmax(long psoldgenmax) {
		this.psoldgenmax = psoldgenmax;
	}
	
}
