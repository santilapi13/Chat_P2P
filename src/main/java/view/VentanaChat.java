package view;

import model.Usuario;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class VentanaChat extends JFrame implements IVista, KeyListener {

    private JPanel contentPane;
    private ActionListener actionListener;
    private JTextField textField;

    private JButton btnEnviar;

    private JTextArea textArea;

    public VentanaChat () throws UnknownHostException {

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

        JLabel lblNewLabel = new JLabel("Usuario " + " " + Usuario.getInstance().getSocket().getInetAddress().toString());
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

        panel_1.setLayout(new GridLayout(2, 1, 0, 0));
        panel_1.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
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
        this.textArea.append(mensaje + "\n");
    }

    public void vaciarTextField() {
    	this.textField.setText("");
    }

}



