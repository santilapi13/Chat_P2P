package model;

import java.io.IOException;

public interface GestorConexion {
    void desactivarModoEscucha() throws IOException;
    void solicitarChat(Informacion informacionReceptor) throws IOException;
    void desconectar() throws IOException;
}
