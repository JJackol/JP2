package lab04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Program {

	private JFrame frame;
	private JTextField txtImie;
	JComboBox comboBox;
	Window edycja = new Window();
	Testownik testownik = new Testownik();
	Tablica tablica = new Tablica();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Program window = new Program();
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
	public Program() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton btnEdytujPytania = new JButton("edytuj pytania");
		btnEdytujPytania.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {};
				Window.main(args);
			}
		});
		frame.getContentPane().add(btnEdytujPytania, BorderLayout.WEST);
		
		JButton btnRozpocznijTest = new JButton("rozpocznij test");
		btnRozpocznijTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String[] stri = {txtImie.getName(), (String)comboBox.getSelectedItem()};
				Testownik.main(stri);
				
			}
		});
		frame.getContentPane().add(btnRozpocznijTest, BorderLayout.CENTER);
		
		JButton btnPokazWyniki = new JButton("pokaz wyniki");
		btnPokazWyniki.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] args = {};
				Tablica.main(args);
			}
		});
		frame.getContentPane().add(btnPokazWyniki, BorderLayout.EAST);
		
		txtImie = new JTextField();
		txtImie.setText("imie");
		frame.getContentPane().add(txtImie, BorderLayout.NORTH);
		txtImie.setColumns(10);
		
		//comboBox = new JComboBox();
		
		
		ArrayList<String> bazy = loadBazy();
		String[] array = bazy.toArray(new String[bazy.size()]);
		
		comboBox = new JComboBox( array );
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//String plik = (String) comboBox.getSelectedItem();
				//baza = new BazaPytan(plik, true);
			}
		});
		frame.getContentPane().add(comboBox, BorderLayout.SOUTH);
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
	

}
