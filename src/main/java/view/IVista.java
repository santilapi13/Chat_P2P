package view;

import java.awt.event.ActionListener;

public interface IVista {

    void setActionListener(ActionListener actionListener);

    void cerrarse();

    String getDireccionIP();

    String getPuertoIP();

    String getText();
    void agregarMensaje( String mensaje );

    void agregarUsuario( String usuario );

    void deseleccionar();

}
