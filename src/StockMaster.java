import java.io.IOException;

public class StockMaster {

    public static void main(String[] args) {
        IEXTradingNews news = new IEXTradingNews();

        try {
            String newsSummary = news.getNewsSummary();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
