package main;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.json.JSONException;
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler.LegendPosition;
import org.knowm.xchart.style.colors.ChartColor;
import org.knowm.xchart.style.colors.XChartSeriesColors;
import org.knowm.xchart.style.lines.SeriesLines;
import org.knowm.xchart.style.markers.SeriesMarkers;

public class DataPlot{
	
    public XYChart getLongTermChart(String symbol, String timeRange) throws IOException, JSONException, ParseException {
    	StockData stockdata = new StockData();
        int[] xData1 = new int[stockdata.getStockPrice(symbol, timeRange).keySet().size()];
        int[] xData2 = new int[stockdata.getStockPrice(symbol, timeRange).keySet().size()];
        int[] xData3 = new int[stockdata.getStockPrice(symbol, timeRange).keySet().size()];
        double[] yData = new double[stockdata.getStockPrice(symbol, timeRange).keySet().size()];

        int size  = stockdata.getStockPrice(symbol, timeRange).keySet().size();        
        int i = 0;
        for ( String key : stockdata.getStockPrice(symbol, timeRange).keySet() ) {
     
        	String[] parts = key.split("-");
        	String part1 = parts[0]; 
        	String part2 = parts[1]; 
        	String part3 = parts[2];
        	
        	int d1 = Integer.parseInt(part1);
        	int d2 = Integer.parseInt(part2);
        	int d3 = Integer.parseInt(part3);
        	double price = stockdata.getStockPrice(symbol, timeRange).get(key);
        	
        	xData1[i]= d1;
        	xData2[i]= d2;
        	xData3[i]= d3;
        	yData[i]= price;
        	i++;
        }

        
//// Show it
        
        XYChart chart = new XYChartBuilder().width(800).height(600).title("Stock Price").xAxisTitle("Date").yAxisTitle("Price").build();
        chart.getStyler().setPlotBackgroundColor(ChartColor.getAWTColor(ChartColor.GREY));
        chart.getStyler().setPlotGridLinesColor(new Color(255, 255, 255));
        chart.getStyler().setChartBackgroundColor(Color.WHITE);
        chart.getStyler().setLegendBackgroundColor(Color.PINK);
        chart.getStyler().setChartFontColor(Color.MAGENTA);
        chart.getStyler().setChartTitleBoxBackgroundColor(new Color(0, 222, 0));
        chart.getStyler().setChartTitleBoxVisible(true);
        chart.getStyler().setChartTitleBoxBorderColor(Color.BLACK);
        chart.getStyler().setPlotGridLinesVisible(true);
     
//        chart.getStyler().setAxisTickPadding(20);
//     
//        chart.getStyler().setAxisTickMarkLength(150);
//     
//        chart.getStyler().setPlotMargin(200);
     
        chart.getStyler().setChartTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        chart.getStyler().setLegendFont(new Font(Font.SERIF, Font.PLAIN, 18));
        chart.getStyler().setLegendPosition(LegendPosition.InsideSE);
        chart.getStyler().setLegendSeriesLineLength(12);
        chart.getStyler().setAxisTitleFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
        chart.getStyler().setAxisTickLabelsFont(new Font(Font.SERIF, Font.PLAIN, 11));
        chart.getStyler().setDatePattern("dd-MM-yyyy");
        chart.getStyler().setDecimalPattern("#0.000");
        chart.getStyler().setLocale(Locale.GERMAN);
        chart.getStyler().setPlotMargin(20);
        
        List<Date> x = new ArrayList<Date>();
        List<Double> y = new ArrayList<Double>();
        DateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = null;
        for (int j = 0; j < size; j++) {
        	 
              date = sdf.parse(xData3[j]+ "."+ xData2[j] + "." + xData1[j]);
//            	date = sdf.parse(j+".10.2018");
              
            x.add(date);
            y.add(yData[j]);
//            y.add(Math.random() * j);
            
          }
        XYSeries series = chart.addSeries("Price", x, y);
        series.setLineColor(XChartSeriesColors.BLUE);
        series.setMarkerColor(Color.ORANGE);
        series.setMarker(SeriesMarkers.CIRCLE);
        series.setLineStyle(SeriesLines.SOLID);
        return chart;
    }
    
    
    //for daily prices  
    
    
    public XChartPanel<XYChart> drawTimeGraph(String symbol, String timeRange) throws IOException, JSONException {
    	
    	StockData stockdata = new StockData();
//        double[] xData1 = new double[stockdata.getStockPrice(symbol, timeRange).keySet().size()];
//        double[] xData2 = new double[stockdata.getStockPrice(symbol, timeRange).keySet().size()];
       
        double[] yData = new double[stockdata.getStockPrice(symbol, timeRange).keySet().size()];
        double[] xData = new double[stockdata.getStockPrice(symbol, timeRange).keySet().size()];
        int size  = stockdata.getStockPrice(symbol, timeRange).keySet().size();        
        int i = 0;
        for ( String key : stockdata.getStockPrice(symbol, timeRange).keySet() ) {
     
        	String[] parts = key.split(":");
        	String part1 = parts[0]; 
        	String part2 = parts[1]; 
    
        	
        	double d1 = Double.parseDouble(part1);
        	double d2 = Double.parseDouble(part2);

        	double price = stockdata.getStockPrice(symbol, timeRange).get(key);
        	
//        	xData1[i]= d1;
//        	xData2[i]= d2;
        	xData[i] = d1+d2/60;  	
        	yData[i]= price;
        	i++;
        }

        
//// Show it
        
        XYChart chart = new XYChartBuilder().width(800).height(600).title("Stock Price").xAxisTitle("Time").yAxisTitle("Price").build();
        chart.getStyler().setPlotBackgroundColor(ChartColor.getAWTColor(ChartColor.GREY));
        chart.getStyler().setPlotGridLinesColor(new Color(255, 255, 255));
        chart.getStyler().setChartBackgroundColor(Color.WHITE);
        chart.getStyler().setLegendBackgroundColor(Color.PINK);
        chart.getStyler().setChartFontColor(Color.MAGENTA);
        chart.getStyler().setChartTitleBoxBackgroundColor(new Color(0, 222, 0));
        chart.getStyler().setChartTitleBoxVisible(true);
        chart.getStyler().setChartTitleBoxBorderColor(Color.BLACK);
        chart.getStyler().setPlotGridLinesVisible(true);
     
//        chart.getStyler().setAxisTickPadding(20);
//     
//        chart.getStyler().setAxisTickMarkLength(150);
//     
//        chart.getStyler().setPlotMargin(200);
     
        chart.getStyler().setChartTitleFont(new Font(Font.MONOSPACED, Font.BOLD, 24));
        chart.getStyler().setLegendFont(new Font(Font.SERIF, Font.PLAIN, 18));
        chart.getStyler().setLegendPosition(LegendPosition.InsideSE);
        chart.getStyler().setLegendSeriesLineLength(12);
        chart.getStyler().setAxisTitleFont(new Font(Font.SANS_SERIF, Font.ITALIC, 18));
        chart.getStyler().setAxisTickLabelsFont(new Font(Font.SERIF, Font.PLAIN, 11));
        chart.getStyler().setDecimalPattern("#0.000");
        chart.getStyler().setLocale(Locale.GERMAN);
        chart.getStyler().setPlotMargin(20);
        
        Map<Double, Object> xMarkMap = new TreeMap<Double, Object>();
        
        for (double d : xData) {
            int m = (int)d;
            double s = d-m;
            double se = Math.round(s*60);
            int sec = (int)se;
            String label = Integer.toString(m)+":"+Integer.toString(sec);
            xMarkMap.put(d, label);
        }
        
        chart.setXAxisLabelOverrideMap(xMarkMap);
        
        List<Double> x = new ArrayList<Double>();
        List<Double> y = new ArrayList<Double>();
        for (int j = 0; j < (i-1); j++) {
        	 
            
            x.add(xData[j]);
            y.add(yData[j]);
            
          }
//        System.out.println(stockdata.getStockPrice(symbol, timeRange).keySet());
//        System.out.println(xData);
//        System.out.println(size);
//        System.out.println(x.size());
        XYSeries series = chart.addSeries("Price", x, y);
        chart.setXAxisLabelOverrideMap(xMarkMap);
        series.setLineColor(XChartSeriesColors.BLUE);
        series.setMarkerColor(Color.ORANGE);
        series.setMarker(SeriesMarkers.CIRCLE);
        series.setLineStyle(SeriesLines.SOLID);
        //return new SwingWrapper<XYChart>(chart).getXChartPanel();
        new SwingWrapper<XYChart>(chart).displayChart();
        return new SwingWrapper<XYChart>(chart).getXChartPanel();
    }
   
    
    
    
    
}