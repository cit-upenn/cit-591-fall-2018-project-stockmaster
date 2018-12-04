package main;

public class StockDataYearly {
    String date;
    double open;
    double high;
    double low;
    double close;
    int volume;
    double unadjustedClose;
    int unadjustedVolume;
    double change;
    double changePercent;
    double vwap;
    String label;
    double changeOverTime;

    public StockDataYearly(String date, double open, double high, double low, double close, int volume, double unadjustedClose, int unadjustedVolume, double change, double changePercent, double vwap, String label, double changeOverTime) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
        this.unadjustedClose = unadjustedClose;
        this.unadjustedVolume = unadjustedVolume;
        this.change = change;
        this.changePercent = changePercent;
        this.vwap = vwap;
        this.label = label;
        this.changeOverTime = changeOverTime;
    }

    public String getDate() {
        return date;
    }

    public double getOpen() {
        return open;
    }

    public double getHigh() {
        return high;
    }

    public double getLow() {
        return low;
    }

    public double getClose() {
        return close;
    }

    public int getVolume() {
        return volume;
    }

    public double getUnadjustedClose() {
        return unadjustedClose;
    }

    public int getUnadjustedVolume() {
        return unadjustedVolume;
    }

    public double getChange() {
        return change;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public double getVwap() {
        return vwap;
    }

    public String getLabel() {
        return label;
    }

    public double getChangeOverTime() {
        return changeOverTime;
    }
}
