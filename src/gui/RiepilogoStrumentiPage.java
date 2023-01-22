package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.Font;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;
import dao.PrenotazioneImpl;
import dao.StrumentoImpl;
import extra.RowHeaderRenderer;
import model.Strumento;

import javax.swing.ListModel;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;



public class RiepilogoStrumentiPage extends JPanel {
	
	private JLabel listaStrumentiLabel;
	private JTable riepilogoStrumentiMensileTable, riepilogoStrumentiAnnualeTable, riepilogoUtenteAnnualeTable, riepilogoUtenteMensileTable;
	private JScrollPane riepilogoStrumentiMensileScrollPane, riepilogoStrumentiAnnualeScrollPane, riepilogoUtenteMensileScrollPane, riepilogoUtenteAnnualeScrollPane;
	
	private JButton riepilogoAnnualeBtn, riepilogoMensileBtn, riepilogoUtenteAnnualeBtn, riepilogoUtenteMensileBtn;
	
	private ArrayList<Strumento> strumentoArray;
	private StrumentoImpl strumentoDAO;
	private PrenotazioneImpl prenotazioneDAO;
	
	private Controller controller;
	
	public RiepilogoStrumentiPage() {
		setBackground(new Color(171, 191, 244));
		setLayout(null);

		listaStrumentiLabel = new JLabel("RIEPILOGO STRUMENTI");
		listaStrumentiLabel.setForeground(new Color(0, 0, 0));
		listaStrumentiLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		listaStrumentiLabel.setBounds(339, 40, 333, 54);
		add(listaStrumentiLabel);
		
		riepilogoMensileBtn = new JButton("<html><center>RIEPILOGO <br/> MENSILE <br/> USO</center></html>");
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
		riepilogoMensileBtn.setBounds(154, 94, 125, 63);
		riepilogoMensileBtn.setBorderPainted(true);
		riepilogoMensileBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoMensileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(riepilogoMensileBtn);
		
		riepilogoAnnualeBtn = new JButton("<html><center>RIEPILOGO <br/> ANNUALE <br/> USO</center></html>");
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
		riepilogoAnnualeBtn.setBounds(324, 94, 125, 63);
		riepilogoAnnualeBtn.setOpaque(true);
		riepilogoAnnualeBtn.setBorderPainted(true);
		riepilogoAnnualeBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoAnnualeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(riepilogoAnnualeBtn);
		
		riepilogoUtenteMensileBtn = new JButton("<html><center>RIEPILOGO <br/> MENSILE <br/> UTENTE</center></html>");
		riepilogoUtenteMensileBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				riepilogoUtenteMensileBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				riepilogoUtenteMensileBtn.setBackground(new Color(171, 165, 255));
			}
		});
		riepilogoUtenteMensileBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoUtenteMensileBtn.setBackground(new Color(171, 165, 255));
		riepilogoUtenteMensileBtn.setOpaque(true);	
		riepilogoUtenteMensileBtn.setBounds(520, 94, 125, 63);
		riepilogoUtenteMensileBtn.setBorderPainted(true);
		riepilogoUtenteMensileBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoUtenteMensileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(riepilogoUtenteMensileBtn);
		
		riepilogoUtenteAnnualeBtn = new JButton("<html><center>RIEPILOGO <br/> ANNUALE <br/> UTENTE</center></html>");
		riepilogoUtenteAnnualeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				riepilogoUtenteAnnualeBtn.setBackground(new Color(157,149,255));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				riepilogoUtenteAnnualeBtn.setBackground(new Color(171, 165, 255));
			}
		});
		riepilogoUtenteAnnualeBtn.setBackground(new Color(171, 165, 255));
		riepilogoUtenteAnnualeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		riepilogoUtenteAnnualeBtn.setBounds(693, 94, 125, 63);
		riepilogoUtenteAnnualeBtn.setOpaque(true);
		riepilogoUtenteAnnualeBtn.setBorderPainted(true);
		riepilogoUtenteAnnualeBtn.setBorder(new LineBorder(new Color(0, 0, 0)));
		riepilogoUtenteAnnualeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		add(riepilogoUtenteAnnualeBtn);
		
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
		
		prenotazioneDAO = new PrenotazioneImpl();
		
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
	        + riepilogoStrumentiMensileTable.getRowMargin() - 1);
	    //                           + table.getIntercellSpacing().height);
	    rowHeader.setCellRenderer(new RowHeaderRenderer(riepilogoStrumentiMensileTable));
		
		riepilogoStrumentiMensileScrollPane = new JScrollPane(riepilogoStrumentiMensileTable);
		riepilogoStrumentiMensileScrollPane.setBounds(50, 168, 895, 500);
		riepilogoStrumentiMensileScrollPane.getViewport().setBackground(new Color(213, 223, 255));
		riepilogoStrumentiMensileScrollPane.setRowHeaderView(rowHeader);
		add(riepilogoStrumentiMensileScrollPane);

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
	        + riepilogoStrumentiAnnualeTable.getRowMargin() - 1);
	    //                           + table.getIntercellSpacing().height);
	    rowHeader2.setCellRenderer(new RowHeaderRenderer(riepilogoStrumentiAnnualeTable));
		
		riepilogoStrumentiAnnualeScrollPane = new JScrollPane(riepilogoStrumentiAnnualeTable);
		riepilogoStrumentiAnnualeScrollPane.setBounds(50, 168, 895, 500);
		riepilogoStrumentiAnnualeScrollPane.getViewport().setBackground(new Color(213, 223, 255));
		riepilogoStrumentiAnnualeScrollPane.setRowHeaderView(rowHeader2);
		add(riepilogoStrumentiAnnualeScrollPane);
		
		// RIEPILOGO MENSILE UTENTE
		riepilogoUtenteMensileTable = new JTable();
		riepilogoUtenteMensileTable.setBackground(new Color(213, 223, 255));
		riepilogoUtenteMensileTable.setBounds(50, 168, 895, 500);
		riepilogoUtenteMensileTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		riepilogoUtenteMensileTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		riepilogoUtenteMensileTable.setDefaultEditor(Object.class, null);
		riepilogoUtenteMensileTable.setRowSelectionAllowed(false);
		riepilogoUtenteMensileTable.setFocusable(false);
		
		ListModel lm3 = new AbstractListModel() {
		      String[] headers = controller.fromArrayListToStringArray(strumentoArray);
		      
		      public int getSize() {
		          return headers.length;
		        }

		        public Object getElementAt(int index) {
		          return headers[index];
		        }
		};
		
		JList rowHeader3 = new JList(lm3);
	    rowHeader3.setFixedCellWidth(150);

	    rowHeader3.setFixedCellHeight(riepilogoUtenteMensileTable.getRowHeight()
	        + riepilogoUtenteMensileTable.getRowMargin() - 1);
	    //                           + table.getIntercellSpacing().height);
	    rowHeader3.setCellRenderer(new RowHeaderRenderer(riepilogoUtenteMensileTable));
		
		riepilogoUtenteMensileScrollPane = new JScrollPane(riepilogoUtenteMensileTable);
		riepilogoUtenteMensileScrollPane.setBounds(50, 168, 895, 500);
		riepilogoUtenteMensileScrollPane.getViewport().setBackground(new Color(213, 223, 255));
		riepilogoUtenteMensileScrollPane.setRowHeaderView(rowHeader3);
		add(riepilogoUtenteMensileScrollPane);

		DefaultTableModel tableModel3 = new DefaultTableModel();

		tableModel3.addColumn("Gen");
		tableModel3.addColumn("Feb");
		tableModel3.addColumn("Mar");
		tableModel3.addColumn("Apr");
		tableModel3.addColumn("Mag");
		tableModel3.addColumn("Giu");
		tableModel3.addColumn("Lug");
		tableModel3.addColumn("Ago");
		tableModel3.addColumn("Sett");
		tableModel3.addColumn("Ott");
		tableModel3.addColumn("Nov");
		tableModel3.addColumn("Dic");

		for(int i = 0; i < strumentoArray.size(); i++) {
			String[] row1 = prenotazioneDAO.getRiepilogoUtenteBasedOnMonth(i + 1);
		
			tableModel3.addRow(row1);
		}
			
		riepilogoUtenteMensileTable.setModel(tableModel3);
		
		// RIEPILOGO ANNUALE UTENTE
		
		riepilogoUtenteAnnualeTable = new JTable();
		riepilogoUtenteAnnualeTable.setBackground(new Color(213, 223, 255));
		riepilogoUtenteAnnualeTable.setBounds(50, 168, 895, 500);
		riepilogoUtenteAnnualeTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
		riepilogoUtenteAnnualeTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 12));
		riepilogoUtenteAnnualeTable.setDefaultEditor(Object.class, null);
		riepilogoUtenteAnnualeTable.setRowSelectionAllowed(false);
		riepilogoUtenteAnnualeTable.setFocusable(false);
		
		ListModel lm4 = new AbstractListModel() {
		      String[] headers = controller.fromArrayListToStringArray(strumentoArray);
		      
		      public int getSize() {
		          return headers.length;
		        }

		        public Object getElementAt(int index) {
		          return headers[index];
		        }
		};
		
		JList rowHeader4 = new JList(lm4);
	    rowHeader4.setFixedCellWidth(150);

	    rowHeader4.setFixedCellHeight(riepilogoUtenteAnnualeTable.getRowHeight()
	        + riepilogoUtenteAnnualeTable.getRowMargin() - 1);
	    //                           + table.getIntercellSpacing().height);
	    rowHeader4.setCellRenderer(new RowHeaderRenderer(riepilogoUtenteAnnualeTable));
		
		riepilogoUtenteAnnualeScrollPane = new JScrollPane(riepilogoUtenteAnnualeTable);
		riepilogoUtenteAnnualeScrollPane.setBounds(50, 168, 895, 500);
		riepilogoUtenteAnnualeScrollPane.getViewport().setBackground(new Color(213, 223, 255));
		riepilogoUtenteAnnualeScrollPane.setRowHeaderView(rowHeader4);
		add(riepilogoUtenteAnnualeScrollPane);

		DefaultTableModel tableModel4 = new DefaultTableModel();

		tableModel4.addColumn("2023");
		tableModel4.addColumn("2024");
		tableModel4.addColumn("2025");
		tableModel4.addColumn("2026");
		tableModel4.addColumn("2027");
		tableModel4.addColumn("2028");
		tableModel4.addColumn("2029");
		tableModel4.addColumn("2030");

		for(int i = 0; i < strumentoArray.size(); i++) {
			String[] row1 = prenotazioneDAO.getRiepilogoUtenteBasedOnYear(i + 1);
		
			tableModel4.addRow(row1);
		}
			
		riepilogoUtenteAnnualeTable.setModel(tableModel4);
		
		riepilogoStrumentiMensileTable.setVisible(false);
		riepilogoStrumentiMensileScrollPane.setVisible(false);
		riepilogoStrumentiAnnualeTable.setVisible(false);
		riepilogoStrumentiAnnualeScrollPane.setVisible(false);
		riepilogoUtenteMensileTable.setVisible(false);
		riepilogoUtenteMensileScrollPane.setVisible(false);
		riepilogoUtenteAnnualeTable.setVisible(false);
		riepilogoUtenteAnnualeScrollPane.setVisible(false);
		
		addComponentListener(new ComponentAdapter () {
			@Override
			public void componentShown ( ComponentEvent e ) {
				controller.populateRiepilogoMensileStrumentiTable(strumentoArray, prenotazioneDAO, riepilogoStrumentiMensileTable);
				controller.populateRiepilogoAnnualeStrumentiTable(strumentoArray, prenotazioneDAO, riepilogoStrumentiAnnualeTable);
				
				// DA METTERE UTENTE TABLES
			}
		});
		
		
		riepilogoMensileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				riepilogoStrumentiMensileTable.setVisible(true);
				riepilogoStrumentiMensileScrollPane.setVisible(true);
				riepilogoStrumentiAnnualeTable.setVisible(false);
				riepilogoStrumentiAnnualeScrollPane.setVisible(false);
				riepilogoUtenteMensileTable.setVisible(false);
				riepilogoUtenteMensileScrollPane.setVisible(false);
				riepilogoUtenteAnnualeTable.setVisible(false);
				riepilogoUtenteAnnualeScrollPane.setVisible(false);
			}
		});
		
		riepilogoAnnualeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				riepilogoStrumentiMensileTable.setVisible(false);
				riepilogoStrumentiMensileScrollPane.setVisible(false);
				riepilogoStrumentiAnnualeTable.setVisible(true);
				riepilogoStrumentiAnnualeScrollPane.setVisible(true);
				riepilogoUtenteMensileTable.setVisible(false);
				riepilogoUtenteMensileScrollPane.setVisible(false);
				riepilogoUtenteAnnualeTable.setVisible(false);
				riepilogoUtenteAnnualeScrollPane.setVisible(false);
			}
		});
		
		riepilogoUtenteMensileBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				riepilogoStrumentiMensileTable.setVisible(false);
				riepilogoStrumentiMensileScrollPane.setVisible(false);
				riepilogoStrumentiAnnualeTable.setVisible(false);
				riepilogoStrumentiAnnualeScrollPane.setVisible(false);
				riepilogoUtenteMensileTable.setVisible(true);
				riepilogoUtenteMensileScrollPane.setVisible(true);
				riepilogoUtenteAnnualeTable.setVisible(false);
				riepilogoUtenteAnnualeScrollPane.setVisible(false);
			}
		});
		
		riepilogoUtenteAnnualeBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e){
				riepilogoStrumentiMensileTable.setVisible(false);
				riepilogoStrumentiMensileScrollPane.setVisible(false);
				riepilogoStrumentiAnnualeTable.setVisible(false);
				riepilogoStrumentiAnnualeScrollPane.setVisible(false);
				riepilogoUtenteMensileTable.setVisible(false);
				riepilogoUtenteMensileScrollPane.setVisible(false);
				riepilogoUtenteAnnualeTable.setVisible(true);
				riepilogoUtenteAnnualeScrollPane.setVisible(true);
			}
		});
	}
}