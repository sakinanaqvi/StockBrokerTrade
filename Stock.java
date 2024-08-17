
public class Stock {
    /**
	 * Here: all the needed class members and their getters and setters
	 */
	String name, ticker, startDate, stockBusiness, description, exchange;
    public Stock(String name, String ticker, String startDate, String stockBusiness, String description, String exchange) {
    	this.name = name;
    	this.ticker = ticker;
    	this.startDate = startDate;
    	this.stockBusiness = stockBusiness;
    	this.description = description;
    	this.exchange = exchange;
    }
    public String getName(){
	     return this.name;
	 }
	 public void setName(String name){
	     this.name = name;
	 }
	 public String getTicker(){
	     return this.ticker;
	 }
	 public void setTicker(String ticker){
	     this.ticker = ticker;
	 }
	 public String getStartDate(){
	     return this.startDate;
	 }
	 public void setStartDate(String startDate){
	     this.startDate = startDate;
	 }
	 public String getStockBusiness(){
	     return this.stockBusiness;
	 }
	 public void setStockBusiness(String stockBusiness){
	     this.stockBusiness = stockBusiness;
	 }
	 public String getDescription(){
	     return this.description;
	 }
	 public void setDescription(String description){
	     this.description = description;
	 }
	 
	 public String getExchange(){
	     return this.exchange;
	 }
	 public void setExchange(String exchange){
	     this.exchange = exchange;
	 }



}


