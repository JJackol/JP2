package lab04;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.image.ComponentColorModel;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableModel;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JList;

public class Tablica extends JFrame {

	private JPanel contentPane;
	//private ArrayList<Wynik> listaWynikow;
	private JTable table;
	//JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tablica frame = new Tablica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tablica() {
        super("JTable Sorting Example");
        
        
        List<Wynik> listWyniki = createListWyniki();
        TableModel tableModel = new Wyniki(listWyniki);
        table = new JTable(tableModel);
 
        // insert code for sorting here...
 
        add(new JScrollPane(table), BorderLayout.CENTER);
 
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        table.setAutoCreateRowSorter(true);
        /////////////////////////////////////
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 450, 300);
//		contentPane = new JPanel();
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		contentPane.setLayout(new BorderLayout(0, 0));
//		setContentPane(contentPane);
//		
//		JScrollPane scrollPane = new JScrollPane();
//		contentPane.add(scrollPane, BorderLayout.CENTER);
//		
//		list = new JList(;
		//scrollPane.setViewportView(list);
		
		//for(Wynik w: listaWynikow)
		
		
		//list.
	}
	
   
 
    public List<Wynik> createListWyniki() {
    	
        List<Wynik> listW = new ArrayList<>();
        
        try
		{
			File f = new File("Wyniki.csv");
			Scanner s = new Scanner(f);
			String str;
	        while(s.hasNextLine()){
	            str = s.nextLine();
	            if (!str.isEmpty())
	            	listW.add(new Wynik(str));
	        }
	        s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

//        listEmployees.add(new Wynik(100, "Jacek"));
//        listEmployees.add(new Wynik(10, "P"));
//        listEmployees.add(new Wynik(1, "Arek"));
//        listEmployees.add(new Wynik(99, "Jacek"));
        //for
 
        // code to add dummy data here...
 
        return listW;
    }
 
}
