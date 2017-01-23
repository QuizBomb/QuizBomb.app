package gr.quizbomb.controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import gr.quizbomb.model.Score;
import gr.quizbomb.model.helper.ScoreClassStatistics;
import gr.quizbomb.service.ScoreService;

@Controller
public class StatisticsController {
	
	@Autowired
	private ScoreService scoreService;
	
	@RequestMapping(value = "/statistics", method = RequestMethod.GET)
	public String getStatisticsPage() {
		
		return "statistics";
	}
	
	@RequestMapping(value = "/statistics/class", method = RequestMethod.GET)
	public ModelAndView getClassStatistics(HttpServletResponse res) throws IOException {
		
		List<Score> scores = scoreService.getScoresFromThisYear();
		
		List<ScoreClassStatistics> list = new ArrayList<ScoreClassStatistics>();
		
		ScoreClassStatistics a = new ScoreClassStatistics("Α' Γυμνασίου" );
		
		ScoreClassStatistics b = new ScoreClassStatistics("Β' Γυμνασίου");
		
		ScoreClassStatistics c = new ScoreClassStatistics("Γ' Γυμνασίου");
		
		for (Score score: scores){
			
			if (score.getStudentQuiz().getsClass().getValue().equals("A")){
				
				a.setScore(a.getScore() + score.getSuccessRate());
				a.setCount(a.getCount() + 1);
			} else if (score.getStudentQuiz().getsClass().getValue().equals("B")){
				
				b.setScore(b.getScore() + score.getSuccessRate());
				b.setCount(b.getCount() + 1);
			} else if (score.getStudentQuiz().getsClass().getValue().equals("C")){
				
				c.setScore(c.getScore() + score.getSuccessRate());
				c.setCount(c.getCount() + 1);
			}	
			
		}
		
		a.setScore(a.getScore() / a.getCount());
		b.setScore(b.getScore() / b.getCount());
		c.setScore(c.getScore() / c.getCount());
			
		list.add(a);
		list.add(b);
		list.add(c);
		
		final CategoryDataset dataset = createDataset(list);
        final JFreeChart chart = createChart(dataset);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new Dimension(1000, 500));
        
        res.setContentType("image/png");
        res.getOutputStream().write(ChartUtilities.encodeAsPNG(chart.createBufferedImage(1000, 500)));
		
		return null;
	}
	
	 /**
     * Returns a sample dataset.
     * 
     * @return The dataset.
     */
    private CategoryDataset createDataset(List<ScoreClassStatistics> scores) {
        
        // row keys...
        final String series1 = "Τάξεις";

        // column keys...
        final String category1 = scores.get(0).getName() + "(" +scores.get(0).getCount()+ " μαθητές)";
        final String category2 = scores.get(1).getName() + "(" +scores.get(1).getCount()+ " μαθητές)";
        final String category3 = scores.get(2).getName() + "(" +scores.get(2).getCount()+ " μαθητές)";
      
        // create the dataset...
        final DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.addValue(scores.get(0).getScore(), series1, category1);
        dataset.addValue(scores.get(1).getScore(), series1, category2);
        dataset.addValue(scores.get(2).getScore(), series1, category3);
        
        return dataset;
        
    }
    
    /**
     * Creates a sample chart.
     * 
     * @param dataset  the dataset.
     * 
     * @return The chart.
     */
    private JFreeChart createChart(final CategoryDataset dataset) {
        
        // create the chart...
        final JFreeChart chart = ChartFactory.createBarChart(
            "",         // chart title
            "",               // domain axis label
            "Μέσος Όρος",                  // range axis label
            dataset,                  // data
            PlotOrientation.VERTICAL, // orientation
            true,                     // include legend
            true,                     // tooltips?
            false                     // URLs?
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...

        // set the background color for the chart...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        final CategoryPlot plot = chart.getCategoryPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        // set the range axis to display integers only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());

        // disable bar outlines...
        final BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setDrawBarOutline(false);
        
        // set up gradient paints for series...
        final GradientPaint gp0 = new GradientPaint(
            0.0f, 0.0f, Color.blue, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp1 = new GradientPaint(
            0.0f, 0.0f, Color.green, 
            0.0f, 0.0f, Color.lightGray
        );
        final GradientPaint gp2 = new GradientPaint(
            0.0f, 0.0f, Color.red, 
            0.0f, 0.0f, Color.lightGray
        );
        renderer.setSeriesPaint(0, gp0);
        renderer.setSeriesPaint(1, gp1);
        renderer.setSeriesPaint(2, gp2);

        final CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(
            CategoryLabelPositions.createUpRotationLabelPositions(Math.PI / 6.0)
        );
        // OPTIONAL CUSTOMISATION COMPLETED.
        
        return chart;
        
    }
    
}
