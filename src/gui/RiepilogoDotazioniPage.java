package gui;

import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.Color;
import javax.swing.border.LineBorder;

import org.jfree.data.general.DefaultPieDataset;

import controller.Controller;
import dao.DotazioneAccessoriaImpl;
import model.DotazioneAccessoria;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RiepilogoDotazioniPage extends JPanel {
	
	private JLabel listaDotazioniLabel, selezionaDotazioneLabel;
	
	private JButton consumoMensileBtn, consumoAnnualeBtn;
	
	private PieChartDotazioni pcdMensile, pcdAnnuale;

	private ArrayList<DotazioneAccessoria> dotazioneArray;
	private String[] dotazioniStringArray;
	
	private DefaultPieDataset dataset1, dataset2;

	private DotazioneAccessoriaImpl dotazioneDAO;
	private Controller controller;
	
	public RiepilogoDotazioniPage() {
		setBackground(new Color(171, 191, 244));
		setLayout(null);
		
		/*listaDotazioni = new JTextArea();
		listaDotazioni.setBackground(new Color(213, 223, 255));
		listaDotazioni.setBounds(108, 292, 777, 378);
		add(listaDotazioni);*/

		listaDotazioniLabel = new JLabel("GRAFICO");
		listaDotazioniLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		listaDotazioniLabel.setBounds(425, 11, 136, 54);
		add(listaDotazioniLabel);
		
		consumoMensileBtn = new JButton("<html>CONSUMO<br />&nbsp;MENSILE</html>");
		consumoMensileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				consumoMensileBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				consumoMensileBtn.setBackground(new Color(171, 165, 255));
			}
		});
		consumoMensileBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		consumoMensileBtn.setBackground(new Color(171, 165, 255));
		consumoMensileBtn.setBounds(349, 63, 125, 63);
		consumoMensileBtn.setOpaque(true);
		consumoMensileBtn.setBorderPainted(true);
		consumoMensileBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(consumoMensileBtn);

		consumoAnnualeBtn = new JButton("<html>CONSUMO<br />&nbsp;ANNUALE</html>");
		consumoAnnualeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				consumoAnnualeBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				consumoAnnualeBtn.setBackground(new Color(171, 165, 255));
			}
		});
		consumoAnnualeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		consumoAnnualeBtn.setBackground(new Color(171, 165, 255));
		consumoAnnualeBtn.setBounds(498, 63, 125, 63);
		consumoAnnualeBtn.setOpaque(true);
		consumoAnnualeBtn.setBorderPainted(true);
		consumoAnnualeBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(consumoAnnualeBtn);
		
		selezionaDotazioneLabel = new JLabel("SELEZIONA DOTAZIONE");
		selezionaDotazioneLabel.setBounds(346, 137, 314, 50);
		selezionaDotazioneLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		add(selezionaDotazioneLabel);
		
		controller = new Controller();

		dotazioneDAO = new DotazioneAccessoriaImpl();
		dotazioneArray = dotazioneDAO.getDotazioniAccessorie();

		dotazioniStringArray = controller.fromArrayListToStringArray(dotazioneArray);
		
		final JComboBox<String> dotazioniComboBox = new JComboBox<String>(dotazioniStringArray);
		dotazioniComboBox.setBounds(362, 188, 250, 40);
		dotazioniComboBox.setBackground(new Color(213, 223, 255));
		dotazioniComboBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				dotazioniComboBox.setBackground(new Color(200, 215, 245));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dotazioniComboBox.setBackground(new Color(213, 223, 255));
			}
		});
		add(dotazioniComboBox);
		
		dataset1 = new DefaultPieDataset();

		dataset2 = new DefaultPieDataset();

		dataset1 = controller.setDatasetMonth(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
		dataset2 = controller.setDatasetYear(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
		
		pcdMensile = new PieChartDotazioni(dataset1);
		pcdMensile.setBounds(73, 245, 844, 432);
		add(pcdMensile);
		
		pcdAnnuale = new PieChartDotazioni(dataset2);
		pcdAnnuale.setBounds(73, 245, 844, 432);
		add(pcdAnnuale);
			
		pcdMensile.setVisible(false);
		pcdAnnuale.setVisible(false);

		addComponentListener(new ComponentAdapter () {
			@Override
			public void componentShown ( ComponentEvent e ) {

				dataset1 = controller.setDatasetMonth(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
				dataset2 = controller.setDatasetYear(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
				
				pcdMensile.updateChart(dataset1);
				pcdAnnuale.updateChart(dataset2);
				
			}
		});

		dotazioniComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){

				dataset1 = controller.setDatasetMonth(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
				dataset2 = controller.setDatasetYear(dotazioneArray, dotazioniComboBox.getSelectedItem().toString());
				
				pcdMensile.updateChart(dataset1);
				pcdAnnuale.updateChart(dataset2);

			}
		});
		
		consumoMensileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				pcdMensile.setVisible(true);
				pcdAnnuale.setVisible(false);
			}
		});
		
		consumoAnnualeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				pcdMensile.setVisible(false);
				pcdAnnuale.setVisible(true);
			}
		});
		
	}
}