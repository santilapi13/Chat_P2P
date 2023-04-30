package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
//import com.jgoodies.forms.layout.FormLayout;
//import com.jgoodies.forms.layout.ColumnSpec;
//import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame implements IVista, KeyListener {

	private JPanel contentPane;
	private ActionListener actionListener;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel_1;
	private JTextField textFieldNombre;
	private JLabel lblNewLabel_2;
	private JRadioButton rdbtnNewRadioButton;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_3;
	private JList list;
	private JButton btnIniciarChat;
	private JButton btnSolicitarChat;
	private JPanel panel_4;
	private JLabel lblNewLabel_4;
	private JTextField textFieldIP;
	private JTextField textFieldPuerto;


	
	
	public VentanaPrincipal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 474, 414);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(this.contentPane);
		
		lblNewLabel = new JLabel("CHAT APP");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(3, 2, 0, 0));
		
		lblNewLabel_1 = new JLabel("Nombre de Usuario");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		textFieldNombre = new JTextField();
		panel_1.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		textFieldNombre.addKeyListener(this);
		
		lblNewLabel_2 = new JLabel("Escucha Habilitada");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);
		
		rdbtnNewRadioButton = new JRadioButton("");
		panel_1.add(rdbtnNewRadioButton);
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel_3 = new JLabel("Solicitudes Entrantes");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel_3, BorderLayout.NORTH);
		
		list = new JList();
		panel_3.add(list, BorderLayout.CENTER);
		
		btnIniciarChat = new JButton("Iniciar Chat");
		btnIniciarChat.setEnabled(false);
		panel_3.add(btnIniciarChat, BorderLayout.SOUTH);
		
		panel_4 = new JPanel();
		panel_2.add(panel_4);
		
		lblNewLabel_4 = new JLabel("Direccion IP");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		btnSolicitarChat = new JButton("SOLICITAR CHAT");
		btnSolicitarChat.setEnabled(false);
		
		textFieldIP = new JTextField();
		textFieldIP.setColumns(10);
		textFieldIP.addKeyListener(this);
		
		textFieldPuerto = new JTextField();
		textFieldPuerto.setColumns(10);
		textFieldPuerto.addKeyListener(this);
		
		JLabel lblNewLabel_5 = new JLabel("Puerto IP");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(63)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSolicitarChat)
						.addComponent(textFieldIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4)
						.addComponent(textFieldPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(48)
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textFieldIP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(lblNewLabel_5)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(textFieldPuerto, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
					.addComponent(btnSolicitarChat)
					.addGap(32))
		);
		panel_4.setLayout(gl_panel_4);
	;
		this.setVisible(true);
	}
	
	@Override
	public void setActionListener(ActionListener actionListener) {
		this.btnSolicitarChat.addActionListener(actionListener);
		this.rdbtnNewRadioButton.addActionListener(actionListener);
		this.textFieldNombre.addActionListener(actionListener);

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

	public void cerrarse() {
		this.dispose();

	}

   	@Override
	public String getDireccionIP()
	{
		return this.textFieldIP.getText();
	}

	public String getPuertoIP()
	{
		return this.textFieldPuerto.getText();
	}

	public String getText() {
		return null;
	}

	@Override
	public void agregarMensaje(String mensaje) {

	}

	public String getUsername() {
		return this.textFieldNombre.getText();
	}

}