package spacebattle;

import java.util.Date;

public class UpdateRunnable implements Runnable {
	private static Object synchLock = new Object();
	private static UpdateRunnable currentRunnable = null;
	private volatile boolean keepRunning = true;
	
	public UpdateRunnable() {
		// make 100% sure we never have synch issues here, because then we could get multiple update threads.
		synchronized (synchLock) {
			if (currentRunnable != null) {
				currentRunnable.keepRunning = false;
			}
			currentRunnable = this;			
		}
	}
	@Override
	public void run() {
		while (this.keepRunning) {
			try {
				System.err.println("updating at "+new Date());
				Game.updateState();
				Thread.sleep(1000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.err.println("**** bailing gracefully");
	}

}
