package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.*;
import model.Personale;
import controller.*;

public class LoginPage extends JFrame {

	private JPanel loginPagePanel;
	private JButton loginBtn;
	private JTextField matricolaTextField, codiceTextField;
	private JLabel matricolaLabel, codiceLabel;
	
	private static String matricola;
	private static int codice;
	
	private MainGUI mainPage;
	
	private Controller controller;
	
	
	public LoginPage() {
		setBackground(new Color(171, 191, 244));
		// LoginPage frame
		setResizable(false);
		setTitle("LaboratorioScientificoUCM (login)");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 69, 450, 300);
		setLocationRelativeTo(null); // To center the frame based on monitor

		// Panel
		loginPagePanel = new JPanel();
		loginPagePanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(loginPagePanel);
		loginPagePanel.setLayout(null); // Absolute layout

		// Text field
		matricolaTextField = new JTextField();
		matricolaTextField.setBounds(54, 36, 316, 43);
		matricolaTextField.setColumns(10);
		loginPagePanel.add(matricolaTextField);


		codiceTextField = new JTextField();
		codiceTextField.setBounds(54, 121, 316, 43);
		codiceTextField.setColumns(10);
		loginPagePanel.add(codiceTextField);

		controller = new Controller();
		// Button
		loginBtn = new JButton("Login");
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					matricola = matricolaTextField.getText();
					codice = Integer.parseInt(codiceTextField.getText());

					controller.goToMainPageBasedOnLoginData(matricolaTextField.getText(), Integer.parseInt(codiceTextField.getText()), LoginPage.this, mainPage);
				} catch (NumberFormatException nfe) {
					nfe.printStackTrace();
					JOptionPane.showMessageDialog(null, "Login non riuscito, riprovare");
				}
			}
		});
		loginBtn.setBounds(99, 189, 227, 43);
		loginPagePanel.add(loginBtn);

		// Label
		matricolaLabel = new JLabel("Matricola");
		matricolaLabel.setBounds(186, 11, 81, 14);
		loginPagePanel.add(matricolaLabel);

		codiceLabel = new JLabel("Codice");
		codiceLabel.setBounds(193, 96, 46, 14);
		loginPagePanel.add(codiceLabel);
	}

	public static String getMatricolaTextField(){
		return matricola;
	}

	public static int getCodiceTextField(){
		return codice;
	}

}
