package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Usuario {
    private Direccion direccion;
    private String username;
    private Socket socketEmisor;
    private ServerSocket socketReceptor;

    public Usuario(String username) throws UnknownHostException {
        this.direccion = new Direccion(InetAddress.getLocalHost().getHostAddress());
        this.username = username;
    }

    public Direccion getDireccion() {
        return direccion;
    }
    public void setPuerto(String puerto) {
        this.direccion.setPuerto(puerto);
    }
    public String getUsername() {
        return username;
    }
    public void setUsername() {
        this.username = username;
    }

    public void activarModoEscucha() {

    }

    public void solicitarChat(Direccion direccionReceptor) throws UnknownHostException, IOException {
        this.socketEmisor = new Socket(direccionReceptor.getIP(),Integer.parseInt(direccionReceptor.getPuerto()));
    }

}
