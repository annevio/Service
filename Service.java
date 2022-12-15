import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Service extends Thread {
   String nom;
   String fileName;
   private FileWriter fw;

        public Service(String nom, FileWriter fw){
            this.nom=nom;
            this.fw=fw;
        }

    public void traitement() {

            // creation variable aleatoire de type entier entre 250 et 2000
            Random rd = new Random();
            int nombre = rd.nextInt(250, 2000);

            synchronized (fw) {
                System.out.println("Bonjour, je suis le processus" + this.nom);
                System.out.println("Mon traitement prendra " + nombre + " milisecondes");
                try {
                    Thread.sleep(nombre);
                } catch (Exception e) {
                    System.out.println("erreur " + e);
                }
                System.out.println("Ici le processus " + this.nom + " s'arrête");

                System.out.println("ici le processsus " + this.nom + " j'ai finis de travailler");

                try {
                    fw.write("Fin d'exécution du processus " + nom + "\n");
                    fw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run () {
            traitement();
        }
    }