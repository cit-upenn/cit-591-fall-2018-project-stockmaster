import java.io.IOException;

public class StockMaster {

    public static void main(String[] args) {
        IEXTradingNews news = new IEXTradingNews();
        IEXTradingPrices price = new IEXTradingPrices();

        try {
            String newsSummary = news.getNewsSummary();
            price.getStockPrice();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
