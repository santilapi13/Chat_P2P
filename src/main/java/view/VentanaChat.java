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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class VentanaChat extends JFrame implements IVista, KeyListener {

    private JPanel contentPane;
    private ActionListener actionListener;
    private JTextField textField;


     public static void main(String[] args) {
        VentanaChat frame = new VentanaChat();
        frame.setVisible(true);
    }

    public VentanaChat () {

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

        JButton btnNewButton = new JButton("Enviar");
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
        panel.add(btnNewButton, BorderLayout.EAST);

        JPanel panel_1 = new JPanel();
        contentPane.add(panel_1, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("Usuario / Ip");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));

        JLabel lblNewLabel_1 = new JLabel("<dynamic>");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        panel_1.setLayout(new GridLayout(2, 1, 0, 0));
        panel_1.add(lblNewLabel);
        panel_1.add(lblNewLabel_1);

        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JTextArea textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        this.setVisible(true);
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
    public void setActionListener(ActionListener actionListener) {

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

}



