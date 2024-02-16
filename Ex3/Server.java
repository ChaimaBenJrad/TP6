import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Serveur en attente de connexion...");
            
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connecté : " + clientSocket);
                
                // Création d'un nouveau thread pour gérer la connexion client
                ClientHandler clientHandler = new ClientHandler(clientSocket);
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;
    private static int nextId = 1;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Initialiser les flux de lecture et d'écriture
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Lire les données envoyées par le client
            String name = in.readLine();
            int age = Integer.parseInt(in.readLine());

            // Générer un identifiant et le renvoyer au client
            out.println(nextId);
            nextId++;

            // Afficher les informations côté serveur
            System.out.println("Nouvelle personne ajoutée : " + name + " - Age : " + age);

            // Fermer les flux et la connexion avec le client
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
