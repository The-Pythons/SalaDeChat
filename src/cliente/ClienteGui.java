package cliente;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;
import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;

import java.awt.Color;
import javax.swing.JScrollPane;

public class ClienteGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteGui frame = new ClienteGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClienteGui() throws UnknownHostException, IOException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String servidor="localhost";
		int puerto=10000;
		
		Socket so = new Socket(servidor,puerto);
		Msj m =new Msj(so);
		m.enviarMsj("ebis1");

		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					m.enviarMsj(textField.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(248, 222, 114, 25);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(37, 218, 184, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		modelo.addElement("Rojo Claro");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 57, 294, 134);
		contentPane.add(scrollPane);
		
		JList<String> list = new JList<String>(modelo);
		modelo.addElement("juan");
		
	
		
		//out.writeUTF("ebis19");
		System.out.println(m.recivirMsj());
		System.out.println(m.recivirMsj());
		
		Msjentrantes me = new  Msjentrantes(m,modelo);
		Msjsalientes ms = new Msjsalientes(m);
		me.start();
		
		scrollPane.setViewportView(list);
	}
}
