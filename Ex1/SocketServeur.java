package TP;

import java.io.*;
import java.net.*;
import java.util.Scanner;
public class SocketServeur {
public static void main(String argv[]) {
int port = 0;
Scanner keyb = new Scanner(System.in);
// Demande à l'utilisateur de saisir le port d'écoute du serveur
System.out.print("Port d'écoute : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le paramètre n'est pas un entier.");
System.err.println("Usage : java ServeurUDP port-serveur");
System.exit(-1);
}
try {
// Création d'une socket serveur écoutant sur le port spécifié
ServerSocket serverSocket = new ServerSocket(port);
// Attente de la connexion d'un client

Socket socket = serverSocket.accept();

// Création des flux de sortie et d'entrée pour communiquer avec le client
ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());
// Lecture de la chaîne de caractères envoyée par le client
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
