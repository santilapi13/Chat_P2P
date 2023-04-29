package controller;

import model.Usuario;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorChat implements ActionListener  {

    private IVista vista;
    private static ControladorChat instance;
    Usuario usuario;

    public ControladorChat() {
        this.vista = new VentanaChat();
        this.vista.setActionListener(this);
    }

    public static ControladorChat getInstance() {
        if (instance == null) {
            instance = new ControladorChat();
        }
        return instance;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
