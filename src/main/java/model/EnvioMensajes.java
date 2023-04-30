package model;

import java.io.IOException;

public interface EnvioMensajes {

    void enviarMensaje(String mensaje) throws IOException;
    String recibirMensaje() throws IOException;
}
