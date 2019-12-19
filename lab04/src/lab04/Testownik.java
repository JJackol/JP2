package lab04;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JTextPane;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import org.json.simple.JSONArray;

public class Testownik {
	
	BazaPytan baza;
	Pytanie pytanie;
	ArrayList<Pytanie> locQ;
	int currentQ;

	private JFrame frame;
	JRadioButton radioButtonA;
	JRadioButton radioButtonB;
	JRadioButton radioButtonC;
	JRadioButton radioButtonD;
	
	JTextPane trescP;
	
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
				try {
					Testownik window = new Testownik();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Testownik() {
		
		baza = new BazaPytan("test.json",true);
		locQ = new ArrayList<Pytanie>(baza.getPytania());
		//pytanie 

		initialize();
		test();
	}

	private void test() {
		Random rand = new Random();
		
		int currQ = rand.nextInt() % locQ.size();
		pytanie = locQ.get(currQ);
		locQ.remove(currQ);
		
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		trescP = new JTextPane();
		panel.add(trescP, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		
		
		
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

				String select = "A";
				if(rdbtnA.isSelected()) {
					select = "A";	}
				else if(rdbtnB.isSelected()) {
					select = "B";	}
				else if(rdbtnC.isSelected()) {
					select = "C";	}
				else if(rdbtnD.isSelected()) {
					select = "D";}
				
				
				
			}
			
		});
//		rdbtnNewRadioButton = new JRadioButton("New radio button");
//		rdbtnNewRadioButton.setBounds(8, 218, 149, 23);
//		panel_1.add(rdbtnNewRadioButton);
	}
}
