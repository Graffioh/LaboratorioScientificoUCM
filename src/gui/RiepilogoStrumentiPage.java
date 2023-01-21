package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import dao.StrumentoImpl;
import extra.RowHeaderRenderer;
import model.Strumento;

import javax.swing.ListModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public class RiepilogoStrumentiPage extends JPanel {
	
	private JLabel listaStrumentiLabel;
	private JTable riepilogoStrumentiMensileTable, riepilogoStrumentiAnnualeTable;
	private JScrollPane riepilogoStrumentiMensileScrollPane, riepilogoStrumentiAnnualeScrollPane;
	
	private JButton riepilogoAnnualeBtn, riepilogoMensileBtn;
	
	private ArrayList<Strumento> strumentoArray;
	private StrumentoImpl strumentoDAO;
	
	private Controller controller;
	
	public RiepilogoStrumentiPage() {
		setBackground(new Color(171, 191, 244));
		setLayout(null);

		listaStrumentiLabel = new JLabel("RIEPILOGO STRUMENTI");
		listaStrumentiLabel.setForeground(new Color(0, 0, 0));
		listaStrumentiLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		listaStrumentiLabel.setBounds(339, 40, 333, 54);
		add(listaStrumentiLabel);
		
		riepilogoMensileBtn = new JButton("<html>RIEPILOGO<br />&nbsp;&nbsp;MENSILE</html>");
		riepilogoMensileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				riepilogoMensileBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				riepilogoMensileBtn.setBackground(new Color(171, 165, 255));
			}
		});
		riepilogoMensileBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoMensileBtn.setBackground(new Color(171, 165, 255));
		riepilogoMensileBtn.setOpaque(true);	
		riepilogoMensileBtn.setBounds(341, 94, 125, 63);
		riepilogoMensileBtn.setBorderPainted(true);
		riepilogoMensileBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoMensileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(riepilogoMensileBtn);
		
		riepilogoAnnualeBtn = new JButton("<html>RIEPILOGO<br />&nbsp;&nbsp;ANNUALE</html>");
		riepilogoAnnualeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				riepilogoAnnualeBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				riepilogoAnnualeBtn.setBackground(new Color(171, 165, 255));
			}
		});
		riepilogoAnnualeBtn.setBackground(new Color(171, 165, 255));
		riepilogoAnnualeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoAnnualeBtn.setBounds(500, 94, 125, 63);
		riepilogoAnnualeBtn.setOpaque(true);
		riepilogoAnnualeBtn.setBorderPainted(true);
		riepilogoAnnualeBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoAnnualeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(riepilogoAnnualeBtn);
		
		riepilogoStrumentiMensileTable = new JTable();
		riepilogoStrumentiMensileTable.setBackground(new Color(213, 223, 255));
		riepilogoStrumentiMensileTable.setBounds(50, 168, 895, 500);
		riepilogoStrumentiMensileTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		riepilogoStrumentiMensileTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		riepilogoStrumentiMensileTable.setDefaultEditor(Object.class, null);
		riepilogoStrumentiMensileTable.setRowSelectionAllowed(false);
		riepilogoStrumentiMensileTable.setFocusable(false);
		
		controller = new Controller();
		strumentoDAO = new StrumentoImpl();
		
		strumentoArray = new ArrayList<Strumento>();
		
		strumentoArray = strumentoDAO.populate();
		
		// RIEPILOGO MENSILE
		
		ListModel lm = new AbstractListModel() {
		      String[] headers = controller.fromArrayListToStringArray(strumentoArray);
		      
		      public int getSize() {
		          return headers.length;
		        }

		        public Object getElementAt(int index) {
		          return headers[index];
		        }
		};
		
		JList rowHeader = new JList(lm);
	    rowHeader.setFixedCellWidth(150);

	    rowHeader.setFixedCellHeight(riepilogoStrumentiMensileTable.getRowHeight()
	        + riepilogoStrumentiMensileTable.getRowMargin());
	    //                           + table.getIntercellSpacing().height);
	    rowHeader.setCellRenderer(new RowHeaderRenderer(riepilogoStrumentiMensileTable));
		
		riepilogoStrumentiMensileScrollPane = new JScrollPane(riepilogoStrumentiMensileTable);
		riepilogoStrumentiMensileScrollPane.setBounds(50, 168, 895, 500);
		riepilogoStrumentiMensileScrollPane.getViewport().setBackground(new Color(213, 223, 255));
		riepilogoStrumentiMensileScrollPane.setRowHeaderView(rowHeader);
		add(riepilogoStrumentiMensileScrollPane);
		
		DefaultTableModel tableModel = new DefaultTableModel();

		tableModel.addColumn("Gen");
		tableModel.addColumn("Feb");
		tableModel.addColumn("Mar");
		tableModel.addColumn("Apr");
		tableModel.addColumn("Mag");
		tableModel.addColumn("Giu");
		tableModel.addColumn("Lug");
		tableModel.addColumn("Ago");
		tableModel.addColumn("Sett");
		tableModel.addColumn("Ott");
		tableModel.addColumn("Nov");
		tableModel.addColumn("Dic");
		tableModel.addColumn("Utente");
		
		tableModel.addRow(new Object[] { "geolier", "geolier"});
			
		riepilogoStrumentiMensileTable.setModel(tableModel);
		
		// RIEPILOGO ANNUALE
		
		riepilogoStrumentiAnnualeTable = new JTable();
		riepilogoStrumentiAnnualeTable.setBackground(new Color(213, 223, 255));
		riepilogoStrumentiAnnualeTable.setBounds(50, 168, 895, 500);
		riepilogoStrumentiAnnualeTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		riepilogoStrumentiAnnualeTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		riepilogoStrumentiAnnualeTable.setDefaultEditor(Object.class, null);
		riepilogoStrumentiAnnualeTable.setRowSelectionAllowed(false);
		riepilogoStrumentiAnnualeTable.setFocusable(false);
		
		ListModel lm2 = new AbstractListModel() {
		      String[] headers = controller.fromArrayListToStringArray(strumentoArray);
		      
		      public int getSize() {
		          return headers.length;
		        }

		        public Object getElementAt(int index) {
		          return headers[index];
		        }
		};
		
		JList rowHeader2 = new JList(lm2);
	    rowHeader2.setFixedCellWidth(150);

	    rowHeader2.setFixedCellHeight(riepilogoStrumentiAnnualeTable.getRowHeight()
	        + riepilogoStrumentiAnnualeTable.getRowMargin());
	    //                           + table.getIntercellSpacing().height);
	    rowHeader2.setCellRenderer(new RowHeaderRenderer(riepilogoStrumentiAnnualeTable));
		
		riepilogoStrumentiAnnualeScrollPane = new JScrollPane(riepilogoStrumentiAnnualeTable);
		riepilogoStrumentiAnnualeScrollPane.setBounds(50, 168, 895, 500);
		riepilogoStrumentiAnnualeScrollPane.getViewport().setBackground(new Color(213, 223, 255));
		riepilogoStrumentiAnnualeScrollPane.setRowHeaderView(rowHeader2);
		add(riepilogoStrumentiAnnualeScrollPane);
		
		DefaultTableModel tableModel2 = new DefaultTableModel();

		tableModel2.addColumn("2023");
		tableModel2.addColumn("2024");
		tableModel2.addColumn("2025");
		tableModel2.addColumn("2026");
		tableModel2.addColumn("2027");
		tableModel2.addColumn("2028");
		tableModel2.addColumn("2029");
		tableModel2.addColumn("2030");
		tableModel2.addColumn("Utente");
		
		tableModel2.addRow(new Object[] { "enzo dong", "enzo dong"});
			
		riepilogoStrumentiAnnualeTable.setModel(tableModel2);
		
		riepilogoStrumentiMensileTable.setVisible(false);
		riepilogoStrumentiMensileScrollPane.setVisible(false);
		riepilogoStrumentiAnnualeTable.setVisible(false);
		riepilogoStrumentiAnnualeScrollPane.setVisible(false);
		
		riepilogoMensileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				riepilogoStrumentiMensileTable.setVisible(true);
				riepilogoStrumentiMensileScrollPane.setVisible(true);
				riepilogoStrumentiAnnualeTable.setVisible(false);
				riepilogoStrumentiAnnualeScrollPane.setVisible(false);
			}
		});
		
		riepilogoAnnualeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				riepilogoStrumentiMensileTable.setVisible(false);
				riepilogoStrumentiMensileScrollPane.setVisible(false);
				riepilogoStrumentiAnnualeTable.setVisible(true);
				riepilogoStrumentiAnnualeScrollPane.setVisible(true);
			}
		});
	}
}