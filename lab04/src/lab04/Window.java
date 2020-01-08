package lab04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.ComboBoxModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.List;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dialog;

import javax.swing.JToolBar;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import java.awt.TextField;
import javax.swing.JTextPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;


import javax.swing.event.ChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.ProcessBuilder.Redirect;
import java.util.ArrayList;
import java.util.Scanner;
import java.beans.PropertyChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Window {
	
	private BazaPytan baza;
	List list_1;
	private JFrame frame;
	JTextArea textAreaTresc;
	TextField textFieldA;
	TextField textFieldB;
	TextField textFieldC;
	TextField textFieldD;
	
	ButtonGroup group;
	JRadioButton rdbtnA;
	JRadioButton rdbtnB;
	JRadioButton rdbtnC;
	JRadioButton rdbtnD;
	int pyt_sel=0;
	private JTextField textField;
	private JButton btnZapiszbaze;
	private JComboBox comboBox;
	private String name;
	private JButton btnNowaBaza;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	ArrayList<String> loadBazy() {
		//String[] lista;
		ArrayList<String> listaBaz = new ArrayList<String>();
		try
		{
			File f = new File("Bazy.csv");
			Scanner s = new Scanner(f);
			String str;
	        while(s.hasNextLine()){
	            str = s.nextLine();
	            if (!str.isEmpty())
	            	listaBaz.add(str);
					//comboBox.add(Component(String name = new String(str););
	        }
	        s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaBaz;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		baza = new BazaPytan("test.json",true);
		
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		list_1 = new List();
		
		list_1.setMultipleSelections(false);
		this.populatePytania(list_1);
		list_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pyt_sel = list_1.getSelectedIndex();
				updateTresc(pyt_sel);
				
			}
		});
		
		frame.getContentPane().add(list_1, BorderLayout.WEST);
		//list_1.
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		Button button_1 = new Button("Zapisz pytanie");
		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String select = "A";
				if(rdbtnA.isSelected()) {
					select = "A";	}
				else if(rdbtnB.isSelected()) {
					select = "B";	}
				else if(rdbtnC.isSelected()) {
					select = "C";	}
				else if(rdbtnD.isSelected()) {
					select = "D";}
				
				Pytanie nowe = new Pytanie(textField.getText(),
						textAreaTresc.getText(),
						textFieldA.getText(),
						textFieldB.getText(),
						textFieldC.getText(),
						textFieldD.getText(),
						select
						);
				baza.zapiszPytanieCache(pyt_sel,nowe);
				updatePytania();
				
			}
			
		});
		
		
		ArrayList<String> bazy = loadBazy();
		String[] array = bazy.toArray(new String[bazy.size()]);
		
		comboBox = new JComboBox( array );
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String plik = (String) comboBox.getSelectedItem();
				baza = new BazaPytan(plik, true);
			}
		});
		toolBar.add(comboBox);
		
		btnZapiszbaze = new JButton("ZapiszBaze");
		btnZapiszbaze.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				baza.save();
			}
		});
		
		btnNowaBaza = new JButton("nowa baza");
		btnNowaBaza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<String> bazy = loadBazy();
				String[] array = bazy.toArray(new String[bazy.size()]);
				
				
				String nowaBaza = JOptionPane.showInputDialog("Please input mark for test 1: ");
				baza = new BazaPytan(nowaBaza);
				
				
				
			}
		});
		toolBar.add(btnNowaBaza);
		toolBar.add(btnZapiszbaze);
		toolBar.add(button_1);
		
		Button button = new Button("Nowe pytanie");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				baza.nowePytanie("pytanie"+baza.getPytania().size());
				updatePytania();
			}


		});
		
		toolBar.add(button);
		
		textAreaTresc = new JTextArea();
		frame.getContentPane().add(textAreaTresc, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{4, 6, 250, 0};
		gbl_panel.rowHeights = new int[]{0, 31, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		rdbtnA = new JRadioButton("A");
		rdbtnA.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
			}
		});
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		GridBagConstraints gbc_rdbtnA = new GridBagConstraints();
		gbc_rdbtnA.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnA.gridx = 0;
		gbc_rdbtnA.gridy = 1;
		panel.add(rdbtnA, gbc_rdbtnA);
		
		rdbtnB = new JRadioButton("B");
		GridBagConstraints gbc_rdbtnB = new GridBagConstraints();
		gbc_rdbtnB.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnB.gridx = 0;
		gbc_rdbtnB.gridy = 2;
		panel.add(rdbtnB, gbc_rdbtnB);
		
		rdbtnC = new JRadioButton("C");
		GridBagConstraints gbc_rdbtnC = new GridBagConstraints();
		gbc_rdbtnC.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnC.gridx = 0;
		gbc_rdbtnC.gridy = 3;
		panel.add(rdbtnC, gbc_rdbtnC);
		
		rdbtnD = new JRadioButton("D");
		GridBagConstraints gbc_rdbtnD = new GridBagConstraints();
		gbc_rdbtnD.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnD.gridx = 0;
		gbc_rdbtnD.gridy = 4;
		panel.add(rdbtnD, gbc_rdbtnD);
		
		group = new ButtonGroup();
		group.add(rdbtnA);
		group.add(rdbtnB);
		group.add(rdbtnC);
		group.add(rdbtnD);
		


			
		
		
		JLabel lblA = new JLabel("A");
		GridBagConstraints gbc_lblA = new GridBagConstraints();
		gbc_lblA.insets = new Insets(0, 0, 5, 5);
		gbc_lblA.gridx = 1;
		gbc_lblA.gridy = 1;
		panel.add(lblA, gbc_lblA);
		
		JLabel lblB = new JLabel("B");
		GridBagConstraints gbc_lblB = new GridBagConstraints();
		gbc_lblB.insets = new Insets(0, 0, 5, 5);
		gbc_lblB.gridx = 1;
		gbc_lblB.gridy = 2;
		panel.add(lblB, gbc_lblB);
		
		JLabel lblC = new JLabel("C");
		GridBagConstraints gbc_lblC = new GridBagConstraints();
		gbc_lblC.insets = new Insets(0, 0, 5, 5);
		gbc_lblC.gridx = 1;
		gbc_lblC.gridy = 3;
		panel.add(lblC, gbc_lblC);
		
		JLabel lblD = new JLabel("D");
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.insets = new Insets(0, 0, 5, 5);
		gbc_lblD.gridx = 1;
		gbc_lblD.gridy = 4;
		panel.add(lblD, gbc_lblD);
		
		textFieldA = new TextField();
		textFieldA.setColumns(30);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.anchor = GridBagConstraints.WEST;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 1;
		panel.add(textFieldA, gbc_textField_1);
		
		textFieldB = new TextField();
		textFieldB.setColumns(30);
		GridBagConstraints gbc_txtNazwa = new GridBagConstraints();
		gbc_txtNazwa.insets = new Insets(0, 0, 5, 0);
		gbc_txtNazwa.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtNazwa.gridx = 2;
		gbc_txtNazwa.gridy = 2;
		panel.add(textFieldB, gbc_txtNazwa);
		
		textFieldC = new TextField();
		textFieldC.setColumns(30);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		panel.add(textFieldC, gbc_textField_2);
		
		textFieldD = new TextField();
		textFieldD.setColumns(30);
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		panel.add(textFieldD, gbc_textField_3);
	}

	protected void updateTresc(int sel) {
		textField.setText(baza.getPytania().get(sel).nazwa);
		textAreaTresc.setText(baza.getPytania().get(sel).tresc);
		textFieldA.setText(baza.getPytania().get(sel).A);
		textFieldB.setText(baza.getPytania().get(sel).B);
		textFieldC.setText(baza.getPytania().get(sel).C);
		textFieldD.setText(baza.getPytania().get(sel).D);
		group.clearSelection();
		switch(baza.getPytania().get(sel).poprawna) {
		case "A":
			rdbtnA.setSelected( true);
			break;
		case "B":
			rdbtnB.setSelected( true);
			break;
		case "C":
			rdbtnC.setSelected( true);
			break;
		case "D":
			rdbtnD.setSelected( true);
			break;
		}
		
		
		
	}

	private void populatePytania(List list) {
		for (Pytanie p : baza.getPytania()) {
			list.add(p.nazwa);
			
		}
	}
	
	private void setSel(int s) {
		this.pyt_sel = s;
	}
	private void updatePytania() {
		list_1.clear();
		for (Pytanie p : baza.getPytania()) {
			list_1.add(p.nazwa);
		}
		
	}
	public String getRdbtnBText() {
		return rdbtnB.getText();
	}
	public void setRdbtnBText(String text) {
		rdbtnB.setText(text);
	}
	public String getRdbtnAText() {
		return rdbtnA.getText();
	}
	public void setRdbtnAText(String text_1) {
		rdbtnA.setText(text_1);
	}
	public String getRdbtnCText() {
		return rdbtnC.getText();
	}
	public void setRdbtnCText(String text_2) {
		rdbtnC.setText(text_2);
	}
	public String getRdbtnDText() {
		return rdbtnD.getText();
	}
	public void setRdbtnDText(String text_3) {
		rdbtnD.setText(text_3);
	}
}
