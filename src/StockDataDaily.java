public class StockDataDaily {
    String date;
    String minute;
    String label;
    double high;
    double low;
    double average;
    int volume;
    double notional;
    int numberOfTrades;
    double marketHigh;
    double marketLow;
    double marketAverage;
    int marketVolume;
    double marketNotional;
    int marketNumberOfTrades;
    double open;
    double close;
    double marketOpen;
    double marketClose;
    double changeOverTime;
    double marketChangeOverTime;
    
	/**
	 * @param date
	 * @param minute
	 * @param label
	 * @param high
	 * @param low
	 * @param average
	 * @param volume
	 * @param notional
	 * @param numberOfTrades
	 * @param marketHigh
	 * @param marketLow
	 * @param marketAverage
	 * @param marketVolume
	 * @param marketNotional
	 * @param marketNumberOfTrades
	 * @param open
	 * @param close
	 * @param marketOpen
	 * @param marketClose
	 * @param changeOverTime
	 * @param marketChangeOverTime
	 */
	public StockDataDaily(String date, String minute, String label, double high, double low, double average, int volume,
			double notional, int numberOfTrades, double marketHigh, double marketLow, double marketAverage,
			int marketVolume, double marketNotional, int marketNumberOfTrades, double open, double close,
			double marketOpen, double marketClose, double changeOverTime, double marketChangeOverTime) {
		this.date = date;
		this.minute = minute;
		this.label = label;
		this.high = high;
		this.low = low;
		this.average = average;
		this.volume = volume;
		this.notional = notional;
		this.numberOfTrades = numberOfTrades;
		this.marketHigh = marketHigh;
		this.marketLow = marketLow;
		this.marketAverage = marketAverage;
		this.marketVolume = marketVolume;
		this.marketNotional = marketNotional;
		this.marketNumberOfTrades = marketNumberOfTrades;
		this.open = open;
		this.close = close;
		this.marketOpen = marketOpen;
		this.marketClose = marketClose;
		this.changeOverTime = changeOverTime;
		this.marketChangeOverTime = marketChangeOverTime;
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	
	/**
	 * @return the minute
	 */
	public String getMinute() {
		return minute;
	}
	
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	
	/**
	 * @return the high
	 */
	public double getHigh() {
		return high;
	}
	
	/**
	 * @return the low
	 */
	public double getLow() {
		return low;
	}
	
	/**
	 * @return the average
	 */
	public double getAverage() {
		return average;
	}
	
	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}
	
	/**
	 * @return the notional
	 */
	public double getNotional() {
		return notional;
	}
	
	/**
	 * @return the numberOfTrades
	 */
	public int getNumberOfTrades() {
		return numberOfTrades;
	}
	
	/**
	 * @return the marketHigh
	 */
	public double getMarketHigh() {
		return marketHigh;
	}
	
	/**
	 * @return the marketLow
	 */
	public double getMarketLow() {
		return marketLow;
	}
	
	/**
	 * @return the marketAverage
	 */
	public double getMarketAverage() {
		return marketAverage;
	}
	
	/**
	 * @return the marketVolume
	 */
	public int getMarketVolume() {
		return marketVolume;
	}
	
	/**
	 * @return the marketNotional
	 */
	public double getMarketNotional() {
		return marketNotional;
	}
	
	/**
	 * @return the marketNumberOfTrades
	 */
	public int getMarketNumberOfTrades() {
		return marketNumberOfTrades;
	}
	
	/**
	 * @return the open
	 */
	public double getOpen() {
		return open;
	}
	
	/**
	 * @return the close
	 */
	public double getClose() {
		return close;
	}
	
	/**
	 * @return the marketOpen
	 */
	public double getMarketOpen() {
		return marketOpen;
	}
	
	/**
	 * @return the marketClose
	 */
	public double getMarketClose() {
		return marketClose;
	}
	
	/**
	 * @return the changeOverTime
	 */
	public double getChangeOverTime() {
		return changeOverTime;
	}
	
	/**
	 * @return the marketChangeOverTime
	 */
	public double getMarketChangeOverTime() {
		return marketChangeOverTime;
	}
}