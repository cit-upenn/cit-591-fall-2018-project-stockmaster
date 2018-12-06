package main;

import com.google.gson.Gson;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;
import com.ibm.watson.developer_cloud.service.security.IamOptions;
import javax.management.relation.Role;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewsAnalysis {

	private String symbol;

    /**
	 * @param symbol
	 */
	public NewsAnalysis(String symbol) {
		this.symbol = symbol;
	}
	
	
	/**
	 * 
	 * @return the analysis result pulled from the sentiment 
	 * @throws IOException
	 * @throws JSONException
	 */
	public double getSentiment() throws IOException, JSONException {

		IamOptions options = new IamOptions.Builder()
				.apiKey("tIC-2Mnm6ZOCrspaApqErvH5tkFFyeAoSn_2Hn7p1wRb")
				.build();

		NaturalLanguageUnderstanding naturalLanguageUnderstanding = new NaturalLanguageUnderstanding("2018-03-16", options);
		naturalLanguageUnderstanding.setEndPoint("https://gateway.watsonplatform.net/natural-language-understanding/api");

		//        IEXTradingNews news = new IEXTradingNews();
		String text = "";
		text = this.getNewsSummary();
		//System.out.println(text);

		//        List<String> targets = new ArrayList<String>();
		//        targets.add("award");

		SentimentOptions sentiment = new SentimentOptions.Builder()
				.document(true)
				.build();

		Features features = new Features.Builder()
				.sentiment(sentiment)
				.build();

		AnalyzeOptions parameters = new AnalyzeOptions.Builder()
				.text(text)
				.features(features)
				.build();

		AnalysisResults response = naturalLanguageUnderstanding
				.analyze(parameters)
				.execute();

		String label = response.getSentiment().getDocument().getLabel();
		double score = response.getSentiment().getDocument().getScore();

		System.out.println(label);
		System.out.println(score);
		return score;
	}
	
	public String getNewsSummary() throws IOException, JSONException {
		String jsonText = "";

		URL iex = new URL("https://api.iextrading.com/1.0/stock/" + symbol + "/news/last/50");
		URLConnection iexAPI = iex.openConnection();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						iexAPI.getInputStream()));
		String inputLine;

		while ((inputLine = in.readLine()) != null) {
			jsonText += inputLine;
		}

		in.close();

		JSONArray ja = new JSONArray(jsonText);

		String text = "";
		for (int i = 0; i < ja.length(); i++) {
			JSONObject object = ja.getJSONObject(i);
			String newsText = object.getString("summary");
			if (newsText.equals("No summary available.")) {
				continue;
			}
			else {
				text += newsText;
			}
		}
		return text;
	}
}
