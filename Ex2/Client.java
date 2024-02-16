import java.io.*;
import java.net.*;
public class Client {
    public static void main(String[] args) {
        try {
            // Connexion au serveur
            Socket socket = new Socket("localhost", 12345);
            System.out.println("Connect� au serveur.");

            // Flux d'entr�e pour recevoir des objets du serveur
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            
            // R�ception de l'objet voiture du serveur
            voiture car = (voiture) in.readObject();
            System.out.println("Voiture re�ue : Mod�le - " + car.model + ", Carburant - " + car.getCarburant());

            // Fermeture des flux et de la socket
            in.close();
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
