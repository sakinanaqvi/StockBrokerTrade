import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class PA2 {
	String name, ticker, startDate, stockBusiness, description, exchange;
 
	/**
      * Read Stock Json File inputed by user using GSON
      */
    private void readStockFile(String stockFile) {
    	List<Stock> stocks = new ArrayList<>();
    	try {
    		Gson gson = new Gson();
    		for(Stock stock : stocks) {
    			stock.getName();
    			stock.getDescription();
    			stock.getExchange();
    			stock.getStartDate();
    			stock.getStockBusiness();
    			stock.getTicker();
    		}
		
		} catch (JsonSyntaxException e) {
			System.err.println("Error: File could not be parsed");
			e.printStackTrace();
		} 
    }

    /**
     * Read Stock Trades CSV File inputed by user
     */
    private List<Schedule> readScheduleFile(String scheduleFile) {
    	int time;
    	String schedTicker, numStocks;
    	String line = "";
    	List<Schedule> schedules = new ArrayList<>();
    	try(BufferedReader br = new BufferedReader(new FileReader(scheduleFile))) {
    		while((line = br.readLine()) != null) {
    			line = line.replace("\"", "").replace("'", "");
    			String [] data = line.split(",");
    			
    			time = Integer.parseInt(data[0].trim());
    			schedTicker = data[1].trim();
    			numStocks = data[2].trim();
    		    			
    			Schedule sched = new Schedule(time, schedTicker, numStocks);
    			sched.setTime(time);
    			sched.setNumStocks(numStocks);
    			sched.setSchedTicker(schedTicker);
    			schedules.add(sched);
    			//System.out.println(line);
    		}
    		
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    	return schedules;
    }

    /**
     *Set up Semaphore for Stock Brokers
     */

    private static void initializeSemaphor() {
    	Semaphore sem = null;
    	try {
    		sem = sem;
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    }

    private static void executeTrades() throws InterruptedException {

    }

    public static void main(String[] args) throws InterruptedException {
    	Scanner scanner = new Scanner(System.in);
    	String stockFile, scheduleFile;
    	File stock, schedule;
    	PA2 pa = new PA2();
    	List<Schedule> s = new ArrayList<>();
    	
    	do {
    		System.out.println("What is the name of the file containing the company information?");
    		stockFile = scanner.nextLine();
			
			stock = new File("src/" + stockFile);
			
			if(!stock.exists()) {
				System.out.println("Not a valid file");
			}
    	} while(!stock.exists());
    	pa.readStockFile(stockFile);
    	do {
    		System.out.println("What is the name of the file containing the schedule information?");
    		scheduleFile = scanner.nextLine();
			
			schedule = new File("src/" + scheduleFile);
			
			if(!schedule.exists()) {
				System.out.println("Not a valid file");
			}
    	} while(!schedule.exists());
    	s = pa.readScheduleFile("src/" + scheduleFile);
    	
    	System.out.println("Starting execution of program...\n");
    
    	
    	Lock lock = new ReentrantLock();
    	ArrayList<Thread> threads = new ArrayList<>();
    	
    	for(Schedule sched : s) {
    		Runnable task = new Trade(sched, lock);
    		Thread thread = new Thread(task);
    		threads.add(thread);
    		thread.start();
    	}
    	for(Thread thread :  threads) {
    		try {
    			thread.join();
    		} catch(InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	System.out.println("All trades completed!");
    	
    }
    
}

