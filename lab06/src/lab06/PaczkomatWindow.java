package lab06;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PaczkomatWindow {
	Paczkomat p;
	private JFrame frame;
	private JTextField textFieldImie;
	private JTextField textFieldTelefon;
	private JTextField textMsg;
	private JTextField textField_1;
	private JTextField txtDo;
	private JTextField txtDo_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaczkomatWindow window = new PaczkomatWindow();
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
	public PaczkomatWindow() {
		p = new Paczkomat();
		initialize();

		frame.setVisible(true);
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImie = new JLabel("Imie");
		lblImie.setBounds(12, 26, 70, 15);
		frame.getContentPane().add(lblImie);
		
		textFieldImie = new JTextField();
		textFieldImie.setBounds(98, 24, 114, 19);
		frame.getContentPane().add(textFieldImie);
		textFieldImie.setColumns(10);
		
		textFieldTelefon = new JTextField();
		textFieldTelefon.setBounds(98, 50, 114, 19);
		frame.getContentPane().add(textFieldTelefon);
		textFieldTelefon.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setBounds(12, 53, 70, 15);
		frame.getContentPane().add(lblTelefon);
		
		JButton btnWylij = new JButton("Wyślij");
		btnWylij.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int port = p.getId(Integer.parseInt(textField_1.getText()));
				p.send("localhost", port , new Paczka(
						textFieldImie.getText(),
						textFieldTelefon.getText(),
						txtDo.getText(), 
						txtDo_1.getText(),
						textMsg.getText(), 
						0, 0));
			}
		});
		btnWylij.setBounds(98, 178, 117, 25);
		frame.getContentPane().add(btnWylij);
		
		JLabel lblTresc = new JLabel("Tresc");
		lblTresc.setBounds(12, 80, 70, 15);
		frame.getContentPane().add(lblTresc);
		
		textMsg = new JTextField();
		textMsg.setBounds(98, 78, 114, 19);
		frame.getContentPane().add(textMsg);
		textMsg.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(406, 181, 28, 20);
		frame.getContentPane().add(spinner);
		
		JLabel lblIdPaczkomatu = new JLabel("ID paczkomatu");
		lblIdPaczkomatu.setBounds(293, 183, 114, 15);
		frame.getContentPane().add(lblIdPaczkomatu);
		
		JButton btnZarejestrujPaczkomat = new JButton("Zarejestruj paczkomat");
		btnZarejestrujPaczkomat.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				if(!p.isRegistered)
					p.register((int) spinner.getValue());
			}
		});
		btnZarejestrujPaczkomat.setBounds(293, 209, 141, 49);
		frame.getContentPane().add(btnZarejestrujPaczkomat);
		
		JLabel lblIdCelu = new JLabel("Id celu");
		lblIdCelu.setBounds(12, 107, 70, 15);
		frame.getContentPane().add(lblIdCelu);
		
		textField_1 = new JTextField();
		textField_1.setText("0");
		textField_1.setBounds(98, 105, 114, 19);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		txtDo = new JTextField();
		txtDo.setText("do");
		txtDo.setBounds(230, 24, 114, 19);
		frame.getContentPane().add(txtDo);
		txtDo.setColumns(10);
		
		txtDo_1 = new JTextField();
		txtDo_1.setText("do");
		txtDo_1.setBounds(230, 50, 114, 19);
		frame.getContentPane().add(txtDo_1);
		txtDo_1.setColumns(10);
		
		JLabel lblOd = new JLabel("OD:");
		lblOd.setBounds(134, 0, 70, 15);
		frame.getContentPane().add(lblOd);
		
		JLabel lblDo = new JLabel("DO:");
		lblDo.setBounds(252, 0, 70, 15);
		frame.getContentPane().add(lblDo);
	}
}
