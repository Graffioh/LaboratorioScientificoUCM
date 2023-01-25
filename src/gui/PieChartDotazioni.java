package gui;

import java.awt.Color;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartPanel;

public class PieChartDotazioni extends JPanel{
	
	private JFreeChart chart;
	
	private ChartPanel cp;
	
	public PieChartDotazioni(DefaultPieDataset dataset) {
		setLayout(null);
		setBackground(new Color(171, 191, 244));
		
		chart = ChartFactory.createPieChart("CONSUMO DOTAZIONE", dataset, true, true , false);
		chart.getPlot().setBackgroundPaint(new Color(171, 191, 244));
		chart.setBackgroundPaint(new Color(171, 165, 255));
		chart.getLegend().setBackgroundPaint(new Color(171, 165, 255));
		
		cp = new ChartPanel(chart);
		cp.setBounds(114,11,608,398);
		cp.setVisible(true);
		
		add(cp);
	}
	
	public void updateChart(DefaultPieDataset dataset) {
		chart = ChartFactory.createPieChart("CONSUMO DOTAZIONE", dataset, true, true , false);
		chart.getPlot().setBackgroundPaint(new Color(171, 191, 244));
		chart.setBackgroundPaint(new Color(171, 165, 255));
		chart.getLegend().setBackgroundPaint(new Color(171, 165, 255));
		
		cp.setChart(chart);
	}

}
