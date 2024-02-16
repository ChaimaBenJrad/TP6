package TP;

import java.io.*;
import java.net.*;
import java.util.Scanner;
class SocketClient {
public static void main(String argv[]) {
int port = 0;
String host = "";
Scanner keyb = new Scanner(System.in);
// Demande � l'utilisateur de saisir le nom du serveur
System.out.print("Nom du serveur : ");
host = keyb.next();
System.out.print("Port du serveur : ");
try {
port = keyb.nextInt();
} catch (NumberFormatException e) {
System.err.println("Le second param�tre n'est pas un entier.");
System.exit(-1);
}
// Communication entre le client et le serveur
try {
// R�solution de l'adresse IP du serveur � partir de son nom d'h�te
InetAddress adr = InetAddress.getByName(host);
// Cr�ation d'une socket et connexion au serveur
Socket socket = new Socket(adr, port);
// Cr�ation des flux de sortie et d'entr�e pour communiquer avec le serveur
ObjectOutputStream output =
new ObjectOutputStream(socket.getOutputStream());
ObjectInputStream input =
new ObjectInputStream(socket.getInputStream());
// Envoi d'une cha�ne de caract�res au serveur
output.writeObject(new String("ma premi�re socket"));
// Lecture de la r�ponse du serveur
String chaine = (String) input.readObject();
System.out.println(" recu du serveur : " + chaine);
} catch (Exception e) {
System.err.println("Erreur : " + e);
}
}
}
