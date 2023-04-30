package model;

import controller.ControladorChat;
import controller.ControladorPrincipal;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Usuario implements Runnable, GestorSesiones, EnvioMensajes, GestorConexion {
    private Informacion informacion;
    private Socket socket;
    private ServerSocket socketServer;
    private InputStreamReader entradaSocket;
    private PrintWriter salida;
    private BufferedReader entrada;
    private boolean escuchando;
    private ArrayList<Sesion> sesionesAnteriores;
    private Sesion sesionActual;

    private int solicitando = 0;

     //PATRON SINGLETON
    private static Usuario instance;
    private Usuario() throws UnknownHostException {
        this.informacion = new Informacion(InetAddress.getLocalHost().getHostAddress(), 1234, "");
        this.escuchando = false;
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
    @Override
    public void setSesionActual(Sesion sesionActual) {
        this.sesionActual = sesionActual;
    }
    @Override
    public void addNuevaSesion(Sesion sesion) {
        this.sesionesAnteriores.add(sesion);
    }

    public boolean isEscuchando() {
        return escuchando;
    }

    /**
     * Se pone en modo escucha esperando una solicitud de chat.
     */
    @Override
    public void run() {
        try {
            this.activarModoEscucha();
        } catch (IOException e) {
        }
    }

    private void iniciarESSockets() throws IOException {
        this.entradaSocket = new InputStreamReader(socket.getInputStream());
        this.entrada = new BufferedReader(entradaSocket);
        this.salida = new PrintWriter(socket.getOutputStream(), true);
        this.salida.println(this.informacion.getUsername());
        String usernameRemoto = this.entrada.readLine();
        this.sesionActual = new Sesion(this.informacion, new Informacion(this.socket.getInetAddress().toString(), this.socket.getPort(), usernameRemoto));

        if (this.solicitando == 1) {
            ControladorChat.getInstance().nuevaVentana();
        }
        else{
            ControladorPrincipal.getInstance().agregarUsuario(usernameRemoto);
        }
    }

    private void activarModoEscucha() throws IOException {
        System.out.println("Modo escucha activado.");
        this.socketServer = new ServerSocket(this.getPuerto());
        escuchando = true;
        this.socket = socketServer.accept();
        this.socketServer.close();
        escuchando = false;
        this.socketServer = null;
        this.iniciarESSockets();
    }

    public void desactivarModoEscucha() throws IOException {
        this.socketServer.close();
        this.socketServer = null;
        this.socket = null;
        escuchando = false;
        System.out.println("Modo escucha desactivado.");
    }

    public void solicitarChat(Informacion informacionReceptor) throws IOException {
        this.socket = new Socket(informacionReceptor.getIP(),informacionReceptor.getPuerto());
        this.solicitando = 1;
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
        this.addNuevaSesion(this.sesionActual);
        sesionActual = null;
        this.socket.close();
        this.socket = null;
        this.salida = null;
        this.entrada = null;
        this.entradaSocket = null;
        this.solicitando = 0;
    }

}
