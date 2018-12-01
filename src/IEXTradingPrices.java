import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class IEXTradingPrices {
    public static void main(String[] args) throws IOException {
        String jsonText = "";

        try {
            URL iex = new URL("https://api.iextrading.com/1.0/stock/aapl/chart/ytd");
            URLConnection iexAPI = iex.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            iexAPI.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                jsonText += inputLine;
            }

            in.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        System.out.println(jsonText);
        Gson gson = new Gson();
        StockData[] stockDataArray = gson.fromJson(jsonText, StockData[].class);

        for (int i = 0; i < stockDataArray.length; i++) {
            System.out.println(stockDataArray[i].getDate());
            System.out.println(stockDataArray[i].getOpen());
        }

        



    }
}
