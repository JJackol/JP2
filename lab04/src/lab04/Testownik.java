package lab04;

import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import org.json.simple.JSONArray;



import javax.swing.JButton;

public class Testownik {
	
	BazaPytan baza;
	Pytanie pytanie;
	LinkedList<Pytanie> locQ;
	int currentQ;
	String imie;

	private int goodAns = 0;
	private int allAns = 0;
	
	JLabel lblNazwa;
	JLabel lblTresc;
	private JFrame frame;
	JRadioButton radioButtonA;
	JRadioButton radioButtonB;
	JRadioButton radioButtonC;
	JRadioButton radioButtonD;

	JDialog koniecD;
	JDialog wybierzD;
	
	//JTextArea trescP;
	
	ButtonGroup group;
	JRadioButton rdbtnA;
	JRadioButton rdbtnB;
	JRadioButton rdbtnC;
	JRadioButton rdbtnD;
	private JRadioButton rdbtnNewRadioButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				String imie = "testowe imie";
				String plikBazy = "test.json";
				if (args.length==2) {
					imie = args[0];
					plikBazy = args[1];
				}
				
				try {

					Testownik window = new Testownik(imie, plikBazy);
					window.wybierzD.setVisible(true);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				} 
				
			}
		});
	}
	Random rand ;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	public Testownik() {
		
		baza = new BazaPytan("test.json",true);
		locQ = new LinkedList<Pytanie>(baza.getPytania());
		//pytanie 
		
		rand = new Random();

		initialize();
		test();
	}

	public Testownik(String imie, String plikBazy) {	
		baza = new BazaPytan(plikBazy,true);
		locQ = new LinkedList<Pytanie>(baza.getPytania());
		
		this.imie = imie;
		//pytanie 
		
		rand = new Random();

		initialize();
		test();
	}

	private void test() {
		//Random rand = new Random();
		
		int currQ = rand.nextInt() % locQ.size();
		pytanie = new Pytanie( locQ.get(currQ) );
		locQ.remove(currQ);
		
		displayQ(pytanie);
		
	}

	private void displayQ(Pytanie pytanie2) {
		lblNazwa.setText(pytanie2.nazwa);
		lblTresc.setText(pytanie2.tresc);
		rdbtnA.setText(pytanie2.A);
		rdbtnB.setText(pytanie2.B);
		rdbtnC.setText(pytanie2.C);
		rdbtnD.setText(pytanie2.D);
		
	}	
	private void clearQ( ) {
		lblNazwa.setText("");
		lblTresc.setText("");
		rdbtnA.setText("");
		rdbtnB.setText("");
		rdbtnC.setText("");
		rdbtnD.setText("");
		
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
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		koniecD = new JDialog(this.frame, "Koniec");
		//JLabel label = new JLabel("Please wait...");
		koniecD.setLocationByPlatform(true);
		koniecD.setTitle("Wynik");
		
		btnNewButton_1 = new JButton("New button");
		//koniecD.getContentPane().add(btnNewButton_1, BorderLayout.NORTH);
		//koniecD.getContentPane().add(label);
		//koniecD.pack();
		
		///////wybierzD		
		wybierzD = new JDialog(this.frame, "wybiezr baze");
		//JLabel label = new JLabel("wybiezr baze");
		
//		ArrayList<String> bazy = loadBazy();
//		String[] array = bazy.toArray(new String[bazy.size()]);
//		
//		JComboBox<String> comboBox = new JComboBox( array );
//		comboBox.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				String plik = (String) comboBox.getSelectedItem();
//				baza = new BazaPytan(plik, true);
//			}
//		});
//		wybierzD.getContentPane().add(comboBox);
//		
//		btnNewButton = new JButton("wybierz");
//		btnNewButton.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		
//		wybierzD.getContentPane().add(btnNewButton, BorderLayout.SOUTH);
//		wybierzD.setLocationByPlatform(true);
//		wybierzD.setTitle("wybiezr baze");
//		//wybierzD.add(label);
//		wybierzD.pack();
		
		//trescP = new JTextPane();
		//trescP = new JTextArea();
		//panel.add(trescP, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		lblNazwa = new JLabel("Nazwa");
		lblNazwa.setBounds(8, 12, 70, 15);
		panel_1.add(lblNazwa);
		
		lblTresc = new JLabel("tresc");
		lblTresc.setBounds(8, 39, 70, 15);
		panel_1.add(lblTresc);
		
		
		rdbtnA = new JRadioButton("A");
		rdbtnA.setBounds(8, 100, 149, 23);
		panel_1.add(rdbtnA);
		
		rdbtnB = new JRadioButton("B");
		rdbtnB.setBounds(8, 125, 149, 23);
		panel_1.add(rdbtnB);
		
		rdbtnC = new JRadioButton("C");
		rdbtnC.setBounds(8, 150, 149, 23);
		panel_1.add(rdbtnC);
		
		rdbtnD = new JRadioButton("D");
		rdbtnD.setBounds(8, 175, 149, 23);
		panel_1.add(rdbtnD);
		
		
		group = new ButtonGroup();
		group.add(rdbtnA);
		group.add(rdbtnB);
		group.add(rdbtnC);
		group.add(rdbtnD);
		
		Button buttonOK = new Button("Zatwierdz");
		buttonOK.setActionCommand("Zatwierdz");
		buttonOK.setLocation(275, 105);
		buttonOK.setSize(149, 80);
		panel_1.add(buttonOK);
		
		
		buttonOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				//if (!locQ.isEmpty()) {
					String select = "";
					if (rdbtnA.isSelected()) {
						select = "A";
					} else if (rdbtnB.isSelected()) {
						select = "B";
					} else if (rdbtnC.isSelected()) {
						select = "C";
					} else if (rdbtnD.isSelected()) {
						select = "D";
					}
					if (select.equals(pytanie.poprawna))
						goodAns++;
					allAns++;
				//}

				clearQ();
				if(!locQ.isEmpty()) {

					System.out.println("laduj kolejne");
					test();

					System.out.println("zaladowano kolejne");
				}
				else {
					System.out.println("koniec"+ goodAns +" "+ allAns);
					int proc = goodAns*100/allAns;
					StringBuilder wynikStr = new StringBuilder();
					wynikStr.append(proc);
					wynikStr.append(",");
					wynikStr.append(imie);
					try (BufferedWriter writer = new BufferedWriter(
                            new FileWriter("Wyniki.csv", true)  )
						) {
						writer.newLine();   //Add new line
					    writer.write(wynikStr.toString());
					    writer.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					//koniecD.

					StringBuilder msg = new StringBuilder("twoj wynik to ");
					msg.append(proc);
					msg.append("%\n");
					JLabel label = new JLabel(msg.toString());
					JButton closeBtn = new JButton("Zamknij");
					closeBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							System.exit(0);
						}


					});
					
					koniecD.add(closeBtn, BorderLayout.SOUTH);
					koniecD.setLocationByPlatform(true);
					koniecD.setTitle("Koniec");
					koniecD.getContentPane().add(label);
					koniecD.pack();
					koniecD.setVisible(true);
					
					//todo wyniki
				    ;  
					
					//System.exit(0);
					
				}
					
				
				
			}
			
		});
//		rdbtnNewRadioButton = new JRadioButton("New radio button");
//		rdbtnNewRadioButton.setBounds(8, 218, 149, 23);
//		panel_1.add(rdbtnNewRadioButton);
	}
}
