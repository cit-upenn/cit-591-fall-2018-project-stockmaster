import com.ibm.watson.developer_cloud.natural_language_understanding.v1.NaturalLanguageUnderstanding;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalysisResults;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.AnalyzeOptions;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.Features;
import com.ibm.watson.developer_cloud.natural_language_understanding.v1.model.SentimentOptions;
import com.ibm.watson.developer_cloud.service.security.IamOptions;

import javax.management.relation.Role;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SentimentAnalysis {
    public static void main(String[] args) {

        IamOptions options = new IamOptions.Builder()
                .apiKey("APIkey")
                .build();

        NaturalLanguageUnderstanding naturalLanguageUnderstanding = new NaturalLanguageUnderstanding("2018-03-16", options);
        naturalLanguageUnderstanding.setEndPoint("https://gateway.watsonplatform.net/natural-language-understanding/api");

        IEXTradingNews news = new IEXTradingNews();
        String text = "";
        try {
            text = news.getNewsSummary();
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }

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

        System.out.println(response);
    }
}
