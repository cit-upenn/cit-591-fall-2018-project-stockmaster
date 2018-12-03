
public class StockDataMonthly {
    String date;
    double open;
    double high;
    double low;
    double close;
    int volume;
    int unadjustedVolume;
    double change;
    double changePercent;
    double vwap;
    String label;
    double changeOverTime;
    

	/**
	 * @param date
	 * @param open
	 * @param high
	 * @param low
	 * @param close
	 * @param volume
	 * @param unadjustedVolume
	 * @param change
	 * @param changePercent
	 * @param vwap
	 * @param label
	 * @param changeOverTime
	 */
	public StockDataMonthly(String date, double open, double high, double low, double close, int volume,
			int unadjustedVolume, double change, double changePercent, double vwap, String label,
			double changeOverTime) {
		this.date = date;
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.unadjustedVolume = unadjustedVolume;
		this.change = change;
		this.changePercent = changePercent;
		this.vwap = vwap;
		this.label = label;
		this.changeOverTime = changeOverTime;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}

	/**
	 * @return the open
	 */
	public double getOpen() {
		return open;
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
	 * @return the close
	 */
	public double getClose() {
		return close;
	}

	/**
	 * @return the volume
	 */
	public int getVolume() {
		return volume;
	}

	/**
	 * @return the unadjustedVolume
	 */
	public int getUnadjustedVolume() {
		return unadjustedVolume;
	}

	/**
	 * @return the change
	 */
	public double getChange() {
		return change;
	}

	/**
	 * @return the changePercent
	 */
	public double getChangePercent() {
		return changePercent;
	}

	/**
	 * @return the vwap
	 */
	public double getVwap() {
		return vwap;
	}

	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}

	/**
	 * @return the changeOverTime
	 */
	public double getChangeOverTime() {
		return changeOverTime;
	}
    
    
	
	

}
