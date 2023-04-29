package view;

import java.awt.event.ActionListener;

public interface IVista {

    void setActionListener(ActionListener actionListener);

    void cerrarse();

    String getDireccionIP();

    String getPuertoIP();

}
