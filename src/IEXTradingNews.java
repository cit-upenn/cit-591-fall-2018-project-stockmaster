import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

public class IEXTradingNews {
	

    public String getNewsSummary() throws IOException {
        String jsonText = "";

        try {
            URL iex = new URL("https://api.iextrading.com/1.0/stock/goog/news/last/50");
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


        Gson gson = new Gson();
        News[] newsArray = gson.fromJson(jsonText, News[].class);
        ArrayList<News> newsList = new ArrayList<News>(Arrays.asList(newsArray));

        String text = "";
        for (int i = 0; i < newsList.size(); i++) {
            if (newsList.get(i).getSummary().equals("No summary available.")) {
                continue;
            }
            else {
                text += newsList.get(i).getSummary();
            }
        }

        return text;

    }
}
