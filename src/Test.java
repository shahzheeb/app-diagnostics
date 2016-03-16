import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OSFileStore;
import oshi.software.os.OperatingSystem;

public class Test {

	public static void main(String[] args) {

		
		    SystemInfo si = new SystemInfo();
			
			OperatingSystem os = si.getOperatingSystem();
			System.out.println(os);
			
			System.out.println("Family :"+os.getFamily());
			System.out.println("Manufacturer :"+ os.getManufacturer());
			System.out.println("Version :"+os.getVersion());
			
			HardwareAbstractionLayer hal = si.getHardware();
			
			OSFileStore[] filestoresArray = hal.getFileStores();
			for (OSFileStore osFileStore : filestoresArray) {
				System.out.println(osFileStore.getName());
				System.out.println(osFileStore.getDescription());
				System.out.println(osFileStore.getTotalSpace());
				System.out.println(osFileStore.getUsableSpace());
				
				System.out.println("converted total:"+ bytesToGb(osFileStore.getTotalSpace()));
				System.out.println("converted usable:"+ bytesToGb(osFileStore.getUsableSpace()));
				
			}
			
			System.out.println(hal.getProcessors().length + " CPU(s):");
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
