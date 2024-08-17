package sakinana_CSCI201_PA2;

public class Schedule {

    /** 
     * Stock Trades Schedule 
     * Keep the track of tasks
    */
	int time;
	String schedTicker, numStocks;
    public Schedule(int time, String schedTicker, String numStocks) {
        this.time = time;
        this.schedTicker = schedTicker;
        this.numStocks = numStocks;
    }
    
    public int getTime(){
	     return this.time;
	 }
	 public void setTime(int time){
	     this.time = time;
	 }
	 public String getSchedTicker(){
	     return this.schedTicker;
	 }
	 public void setSchedTicker(String schedTicker){
	     this.schedTicker = schedTicker;
	 }
	 public String getNumStocks(){
	     return this.numStocks;
	 }
	 public void setNumStocks(String numStocks){
	     this.numStocks = numStocks;
	 }

    /**
     * Inner class to store task object
     */

    public static class Task {
        public Task( ) {

        }
    }
    
}

