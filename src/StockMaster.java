import java.io.IOException;

public class StockMaster {

    public static void main(String[] args) {
    	SentimentAnalysis sa = new SentimentAnalysis("aapl");
        IEXTradingPrices price = new IEXTradingPrices();

        try {
            price.getStockPrice("aapl", "3m");
            sa.runSentimentAnalysis();
           

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
