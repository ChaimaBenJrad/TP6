import java.io.*;
import java.net.*;

public class Serveur {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Serveur en attente de connexion...");

            // Accepter la connexion du client
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connecté.");

            // Flux de sortie pour envoyer des objets au client
            ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
            
            // Création d'un objet voiture et envoi au client
            voiture car = new voiture("Essence", "Toyota");
            car.setCarburant(50); // Exemple : Fixer la quantité de carburant
            out.writeObject(car);
            
            // Fermeture des flux et des sockets
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
