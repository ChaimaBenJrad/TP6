import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            
            // Initialiser les flux de lecture et d'�criture
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Envoyer les donn�es au serveur
            out.println("Ahmed Ben Ali");
            out.println(30);

            // Recevoir l'identifiant renvoy� par le serveur
            int id = Integer.parseInt(in.readLine());
            System.out.println("Identifiant de la personne ajout�e : " + id);

            // Fermer les flux et la connexion avec le serveur
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
