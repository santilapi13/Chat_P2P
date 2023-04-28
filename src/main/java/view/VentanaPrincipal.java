package view;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements IVista, KeyListener {

	private JPanel contentPane;
	private ActionListener actionListener;
	private JTextField textFieldUsername;
	private JTextField textFieldIP;
	private JTextField textFieldPuerto;
	private JButton btnIniciarChat;
	private JButton btnSolicitarChat;

	public static void main(String[] args)	// TODO: Sacar este main de aca
	{
		VentanaPrincipal window = new VentanaPrincipal();
	}
	
	
	public VentanaPrincipal() {
		setTitle("Chat App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 481, 419);
		this.contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		
		JLabel lblNewLabel = new JLabel("CHAT APP");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_1 = new JLabel("Usuario / IP");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblNewLabel_2 = new JLabel("Nombre de Usuario");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textFieldUsername = new JTextField();
		textFieldUsername.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Escucha Habilitada");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel lblNewLabel_4 = new JLabel("Solicitudes Entrantes");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("");
		rdbtnNewRadioButton.setSelected(false);
		
		JLabel lblNewLabel_5 = new JLabel("Direccion IP");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		JLabel lblNewLabel_6 = new JLabel("Puerto IP");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		btnIniciarChat = new JButton("Iniciar Chat");
		btnIniciarChat.setEnabled(false);
		
		this.btnSolicitarChat = new JButton("Solicitar Chat");
		this.btnSolicitarChat.setEnabled(false);
		
		textFieldIP = new JTextField();
		textFieldIP.setColumns(10);
		textFieldIP.addKeyListener(this);
		
		textFieldPuerto = new JTextField();
		textFieldPuerto.setColumns(10);
		textFieldPuerto.addKeyListener(this);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(38)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_4)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(rdbtnNewRadioButton)
								.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))
							.addGap(76))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblNewLabel_5)
								.addComponent(lblNewLabel_6)
								.addComponent(textFieldPuerto, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)
								.addComponent(textFieldIP)
								.addComponent(btnSolicitarChat, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(30))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(154)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(181, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(178)
					.addComponent(lblNewLabel_1)
					.addContainerGap(211, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(58)
					.addComponent(btnIniciarChat)
					.addContainerGap(311, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(textFieldIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
							.addComponent(lblNewLabel_6)
							.addGap(9)
							.addComponent(textFieldPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(17)
							.addComponent(btnSolicitarChat)
							.addGap(8)))
					.addGap(18)
					.addComponent(btnIniciarChat)
					.addGap(17))
		);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		contentPane.setLayout(gl_contentPane);
		this.setVisible(true);
	}

	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnSolicitarChat.addActionListener(actionListener);
		this.actionListener = actionListener;
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		this.btnSolicitarChat.setEnabled(validarSolicitarChat());
	}

	private boolean validarSolicitarChat() {
		boolean resp = false;

		resp = this.textFieldPuerto.getText() != null && !this.textFieldPuerto.getText().isEmpty() && this.textFieldIP.getText() != null && !this.textFieldIP.getText().isEmpty();

		return resp;
	}
}


