import java.util.Scanner;

public class Main {
     public static void main(String[] args)
    {
    Stock eau = new Stock();
    eau.name = "Eau";
    eau.Max = 100;
    eau.Min = 20;
    eau.remplir();

    Stock grains = new Stock();
    grains.name = "Grains";
    grains.Max = 50;
    grains.Min = 10;
    grains.remplir();

    Stock gobelets = new Stock();
    gobelets.name = "Gobelets";
    gobelets.Max = 10;
    gobelets.Min = 0;
    gobelets.remplir();
    
    int credit = 0;
    int caisse = 0;

    int cafesServis = 0;

    Scanner scanner = new Scanner(System.in);
     while (true) {
            System.out.println("MACHINE À CAFÉ");
            System.out.println("Crédit : " + credit + "€");
            System.out.println("1 - Insérer 2€");
            System.out.println("2 - Acheter un café (2€)");
            System.out.println("3 - Voir les stocks");
            System.out.println("4 - Menu technicien");
            System.out.println("5 - Quitter");


            int choix = scanner.nextInt();
                        if (choix == 1) {
                credit += 2;
                System.out.println("2€ ajouté. Crédit actuel : " + credit + "€");
            } else if (choix == 2) {
            if (cafesServis >= 5) {
                System.out.println("ERREUR : Machine entartrée - Appelez le technicien");
            }
            else if (credit < 2) {
                System.out.println("Crédit insuffisant,ajoutez de la monnaie");
            }
            else if (!eau.estSuffisant(20)) {
                System.out.println("Plus d'eau");
            }
            else if (!grains.estSuffisant(10)) {
                System.out.println("Plus de grains");
            }
            else if (!gobelets.estSuffisant(1)) {
                System.out.println("Plus de gobelets");
            }
            else {
                eau.consommer(20);
                grains.consommer(10);
                gobelets.consommer(1);

                credit -= 2;
                caisse += 2;
                cafesServis++;

                System.out.println("Café servi");
            }
            } else if (choix == 3) {
            eau.afficher();
            grains.afficher();
            gobelets.afficher();
            System.out.println("Cafés servis : " + cafesServis);
            System.out.println("Caisse : " + caisse + "€");
            }
            else if (choix == 4) {

            System.out.println("MENU TECHNICIEN");
            System.out.println("1 - Recharger les stocks");
            System.out.println("2 - Détartrer la machine");
            System.out.println("3 - Récupérer l'argent");
            System.out.println("4 - Retour");

            int choixTech = scanner.nextInt();

            if (choixTech == 1) {
                eau.remplir();
                grains.remplir();
                gobelets.remplir();
                System.out.println("Stocks rechargés");
            }
            else if (choixTech == 2) {
                cafesServis = 0;
                System.out.println("Machine détartrée");
            }
            else if (choixTech == 3) {
                System.out.println("Montant récupéré : " + caisse + "€");
                caisse = 0;
            }
        }
            else if (choix == 5) {
                System.out.println("Bonne journée");
                break;

        }
        scanner.close();
    }
    }
}