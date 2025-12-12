package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerTCP {
    public static void main(String[] args) {
        final int PUERTO = 12345; // Puerto donde escuchará el servidor TCP (Con AWS npi)

        try (ServerSocket serverSocket = new ServerSocket(PUERTO)) {
            System.out.println("Servidor esperando conexiones en el puerto " + PUERTO + "...");

            // Bucle infinito para aceptar múltiples clientes
            while (true) {
                Socket socketCliente = serverSocket.accept();
                System.out.println("Nuevo cliente conectado desde " + socketCliente.getInetAddress());

                // Crear un hilo para manejar a este cliente
                ManejadorCliente manejador = new ManejadorCliente(socketCliente);
                manejador.start();
            }

        } catch (IOException e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
    /**
     * Hilo que maneja la comunicación con un único cliente.
     */
    private static class ManejadorCliente extends Thread {
        private Socket socket;

        public ManejadorCliente(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try (
                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
            ) {
                String mensaje;
                // Leemos continuamente hasta que el cliente cierre la conexión (null)


            } catch (IOException e) {
                System.err.println("Error en la comunicación con el cliente: " + e.getMessage());
            } finally {
                try {
                    socket.close();
                    System.out.println("Cliente desconectado.");
                } catch (IOException e) {
                    System.err.println("Error al cerrar el socket del cliente: " + e.getMessage());
                }
            }
        }
    }
}
