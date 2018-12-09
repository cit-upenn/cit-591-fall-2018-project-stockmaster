package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

/**
 * 
 * @author Shiqing (Jill) Liu
 *
 */
public class NewsAnalysis {

	/**
	 * A string representing the ticker symbol of the company
	 */
	private String stock = "";

	/**
	 * 
	 * @param stock
	 */
	public NewsAnalysis(String stock) {
		this.stock = stock;
	}

	/**
	 * Feed news summary texts into IBM Watson API and run sentiment analysis on texts
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
		String text = "";
		text = this.getNewsSummary();

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

		double score = response.getSentiment().getDocument().getScore();

		return score;
	}
	
	/**
	 * Parse JSON response and retrieve the news summary texts
	 * @return a string that contains all summaries for the most recent 50 pieces of news
	 * @throws IOException
	 * @throws JSONException
	 */
	public String getNewsSummary() throws IOException, JSONException {
		String jsonText = "";
		URL iex = new URL("https://api.iextrading.com/1.0/stock/" + stock + "/news/last/50");
		URLConnection iexAPI = iex.openConnection();
		BufferedReader in = new BufferedReader(
				new InputStreamReader(
						iexAPI.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null) {
			jsonText += inputLine;
		}
		in.close();
		
		String text = "";
		
		return parseJSON(text, jsonText);
	}
	
	/**
	 * Parse API response 
	 * @param text An empty string 
	 * @param jsonText API response
	 * @return A string that contains the news summary for the most recent news
	 * @throws JSONException
	 */
	public String parseJSON(String text, String jsonText) throws JSONException {
		JSONArray ja = new JSONArray(jsonText);
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