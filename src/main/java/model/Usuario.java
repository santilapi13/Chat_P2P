package model;

import controller.ControladorChat;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Usuario extends Thread {
    private Informacion informacion;
    private Socket socket;
    private ServerSocket socketServer;
    private InputStreamReader entradaSocket;
    private PrintWriter salida;
    private BufferedReader entrada;
    private boolean isEscuchando;
    private ArrayList<Sesion> sesionesAnteriores;
    private Sesion sesionActual;

     //PATRON SINGLETON
    private static Usuario instance;
    private Usuario() throws UnknownHostException {
        this.informacion = new Informacion(InetAddress.getLocalHost().getHostAddress(), 1234, "");
        this.isEscuchando = false;
        this.sesionesAnteriores = new ArrayList<>();
        this.sesionActual = null;
    }
    public static Usuario getInstance() throws UnknownHostException {
        if (instance == null)
            instance = new Usuario();
        return instance;
    }

     //GETTERS Y SETTERS
    public Informacion getInformacion() {
        return informacion;
    }
    public String getIP() {
        return this.informacion.getIP();
    }
    public int getPuerto() {
        return this.informacion.getPuerto();
    }
    public String getUsername() {
        return this.informacion.getUsername();
    }
    public void setPuerto(int puerto) {
        this.informacion.setPuerto(puerto);
    }
    public void setUsername(String username) {
        this.informacion.setUsername(username);
    }
    public Socket getSocket() {
        return this.socket;
    }
    public Sesion getSesionActual() {
        return sesionActual;
    }

    /**
     * Se pone en modo escucha esperando una solicitud de chat.
     */
    @Override
    public void run() {
        try {
            this.activarModoEscucha();
        } catch (IOException e) {
            System.out.println("Error al activar el modo escucha.");
        }
    }

    private void iniciarESSockets() throws IOException {
        // TODO: Ver como obtener el username del remoto
        this.sesionActual = new Sesion(this.informacion, new Informacion(this.socket.getInetAddress().toString(), this.socket.getPort(), ""));
        this.entradaSocket = new InputStreamReader(socket.getInputStream());
        this.entrada = new BufferedReader(entradaSocket);
        this.salida = new PrintWriter(socket.getOutputStream(), true);
        ControladorChat.getInstance();
    }

    private void activarModoEscucha() throws IOException {
        this.socketServer = new ServerSocket(this.getPuerto());
        isEscuchando = true;
        this.socket = socketServer.accept();
        this.iniciarESSockets();
    }

    public void solicitarChat(Informacion informacionReceptor) throws IOException {
        this.socket = new Socket(informacionReceptor.getIP(),informacionReceptor.getPuerto());
        iniciarESSockets();
    }

    public void enviarMensaje(String mensaje) throws IOException {
        this.sesionActual.addMensaje(mensaje, true);
        this.salida.println(mensaje);
    }

    public String recibirMensaje() throws IOException {
        String mensaje = this.entrada.readLine();
        this.sesionActual.addMensaje(mensaje, false);
        return mensaje;
    }

    public void desconectar() throws IOException {
        this.sesionesAnteriores.add(this.sesionActual);
        sesionActual = null;
        this.socket.close();
        if (isEscuchando) {
            this.socketServer.close();
            isEscuchando = false;
        }
    }

}
