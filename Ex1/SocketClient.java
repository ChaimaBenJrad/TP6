package TP;

import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
public static void main(String argv[]) {
int port = 0;
String host = "";
Scanner keyb = new Scanner(System.in);
// Demande à l'utilisateur de saisir le nom du serveur
System.out.print("Nom du serveur : ");
host = keyb.next();
System.out.print("Port du serveur : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le second paramètre n'est pas un entier.");
System.exit(-1);
}
// Communication entre le client et le serveur
try {
// Résolution de l'adresse IP du serveur à partir de son nom d'hôte
InetAddress adr = InetAddress.getByName(host);
// Création d'une socket et connexion au serveur
Socket socket = new Socket(adr, port);
// Création des flux de sortie et d'entrée pour communiquer avec le serveur
ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());
// Envoi d'une chaîne de caractères au serveur
output.writeObject(new String("ma première socket"));
// Lecture de la réponse du serveur
String chaine = (String) input.readObject();
System.out.println(" recu du serveur : " + chaine);
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
}
}
