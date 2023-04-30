package view;

import model.Usuario;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class VentanaChat extends JFrame implements IVista, KeyListener {

    private JPanel contentPane;
    private ActionListener actionListener;
    private JTextField textField;

    private JButton btnEnviar;

    private JTextArea textArea;

    public VentanaChat () throws UnknownHostException {

        setTitle("Chat con " + Usuario.getInstance().getSesionActual().getRemoto().getUsername());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 419, 344);
        this.contentPane = new JPanel();
        this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(this.contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        panel.setLayout(new BorderLayout(0, 0));

        textField = new JTextField();
        panel.add(textField);
        textField.setColumns(10);
        textField.addKeyListener(this);

        btnEnviar = new JButton("ENVIAR");
        btnEnviar.setFont(new Font("Tahoma", Font.BOLD, 11));
        panel.add(btnEnviar, BorderLayout.EAST);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel(Usuario.getInstance().getSesionActual().getRemoto().getUsername() + " " + Usuario.getInstance().getSocket().getInetAddress().toString());
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

        panel_1.setLayout(new GridLayout(2, 1, 0, 0));
        panel_1.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        textArea.setEditable(false);

        this.setVisible(true);
    }

    @Override
    public void setActionListener(ActionListener actionListener) {
         this.btnEnviar.addActionListener(actionListener);
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

    }



    @Override
    public void cerrarse() {

    }

    @Override
    public String getDireccionIP() {
        return null;
    }

    @Override
    public String getPuertoIP() {
        return null;
    }

    @Override
    public String getText() {
        return this.textField.getText();
    }

    @Override
    public void agregarMensaje(String mensaje) {
        this.textArea.setEditable(true);
        this.textArea.append(mensaje + "\n");
        this.textArea.setEditable(false);
    }

    @Override
    public void agregarUsuario(String usuario) {

    }

    @Override
    public void deseleccionar() {

    }

    public void vaciarTextField() {
    	this.textField.setText("");
    }

    public void minimizarVentana() {}

    public void abrirVentana() {}
}



