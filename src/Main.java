
import java.awt.EventQueue;

import gui.LoginPage;

public class Main {
	/*
	// Conversion for performance testing
	private static final long MEGABYTE = 1024L * 1024L;

    public static long bytesToMegabytes(long bytes) {
        return bytes / MEGABYTE;
    }*/
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		/*
		// MEMORY PERFORMANCE TEST
		 Runtime runtime = Runtime.getRuntime();
        // Run the garbage collector
        runtime.gc();
        // Calculate the used memory
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Used memory is bytes: " + memory);
        System.out.println("Used memory is megabytes: "
                + bytesToMegabytes(memory));*/
	}
}
