package TP;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketServeur {
public static void main(String argv[]) {
int port = 0;
Scanner keyb = new Scanner(System.in);
// Demande � l'utilisateur de saisir le port d'�coute du serveur
System.out.print("Port d'�coute : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le param�tre n'est pas un entier.");
System.err.println("Usage : java ServeurUDP port-serveur");
System.exit(-1);
}
try {
// Cr�ation d'une socket serveur �coutant sur le port sp�cifi�
ServerSocket serverSocket = new ServerSocket(port);
// Attente de la connexion d'un client

Socket socket = serverSocket.accept();

// Cr�ation des flux de sortie et d'entr�e pour communiquer avec le client
ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());
// Lecture de la cha�ne de caract�res envoy�e par le client
String chaine = (String) input.readObject();
System.out.println(" recu : " + chaine);
// Affiche l'adresse IP et le port du client
System.out.println(" ca vient de : " + socket.getInetAddress() +
":" + socket.getPort());
// Envoi d'une confirmation au client
output.writeObject(new String("bien recu"));
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
}
}
