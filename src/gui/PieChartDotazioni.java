package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.chart.ChartPanel;

public class PieChartDotazioni extends JPanel{
	
	private JLabel selezionaDotazioneLabel;
	
	public PieChartDotazioni(DefaultPieDataset dataset) {
		setLayout(null);
		setBackground(new Color(171, 191, 244));
		
		JFreeChart chart = ChartFactory.createPieChart("Consumo Dotazione", dataset, true, true , false);
		chart.getPlot().setBackgroundPaint(new Color(171, 191, 244));
		chart.setBackgroundPaint(new Color(171, 165, 255));
		chart.getLegend().setBackgroundPaint(new Color(171, 165, 255));
		
		JPanel panel = new ChartPanel(chart);
		panel.setBounds(114,11,608,398);
		panel.setVisible(true);
		
		add(panel);
	}	

}
