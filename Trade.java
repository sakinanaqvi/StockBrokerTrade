import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import java.util.*;

public class Trade extends Thread {
	private Schedule schedule;
	private Lock lock;
	Thread prevThread;
	
	public Trade(Schedule schedule, Lock lock) {
		this.schedule = schedule;
		this.lock = new ReentrantLock();
		//this.prevThread = prev;
    }

	/**
	 * Trading function using locks
	 */
	public void run() {
		Utility utility = new Utility();
		
			try {
				//System.out.println(utility.getTimestamp());
				String time = utility.getZeroTimestamp();
				
				LocalTime baseTime = LocalTime.parse(time);
				
				LocalTime start = baseTime.plusSeconds(schedule.getTime()).plusNanos(1_000_000);
				LocalTime finish = start.plusSeconds(1);
				
				DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss:SS");
				String newStartTime = start.format(format);
				String newFinishTime = finish.format(format);
				
				/*if(prevThread != null) {
					prevThread.join();
				}*/
			
				String decide = "";
				int numStocks = Integer.parseInt(schedule.getNumStocks());
				
				if(numStocks > 0) {
					decide = "purchase";
				} else {
					decide = "sale";
					numStocks = numStocks * (-1);
				}
				
				Thread.sleep(schedule.getTime() * 100);
				lock.lock();
				
				try {
					System.out.println("[" + newStartTime + "] Starting " + decide + " of " + numStocks + " stocks of " + schedule.getSchedTicker());
				} finally {
					lock.unlock();
					Thread.sleep(10);
				}
				
				lock.lock();
				try {
					System.out.println("[" + newFinishTime + "] Finishing " + decide + " of " + numStocks + " stocks of " + schedule.getSchedTicker());
				} finally {
					lock.unlock();
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}
}

