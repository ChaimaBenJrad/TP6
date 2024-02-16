import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        try {
            // Connexion au serveur
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connecté au serveur.");

            // Flux d'entrée pour recevoir des objets du serveur
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            // Réception de l'objet voiture du serveur
            voiture car = (voiture) in.readObject();
            System.out.println("Voiture reçue : Modèle - " + car.model + ", Carburant - " + car.getCarburant());

            // Fermeture des flux et de la socket
            in.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
