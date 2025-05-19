package org.supmti;


import org.supmti.model.Produit;
import org.supmti.service.GestionStockServiceJdbc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        com.exemple.service.GestionStockService service = new com.exemple.service.GestionStockService();
        Scanner scanner = new Scanner(System.in);
        GestionStockServiceJdbc produitDAO = new GestionStockServiceJdbc();
        int choix;

        do {
            System.out.println("\n=== MENU GESTION DE STOCK ===");
            System.out.println("1. Ajouter un produit");
            System.out.println("2. Supprimer un produit");
            System.out.println("3. Mettre à jour un produit");
            System.out.println("4. Afficher les produits");
            System.out.println("5. Rechercher un produit");
            System.out.println("0. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();
            scanner.nextLine(); // pour consommer la fin de ligne

            switch (choix) {
                case 1:
                    /*System.out.print("Nom du produit : ");
                    String nom = scanner.nextLine();
                    System.out.print("Quantité : ");
                    int quantite = scanner.nextInt();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine();
                    Produit produit = new Produit(nom, quantite, prix);
                    service.ajouterProduit(produit);
                    break;*/
                    System.out.print("Nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Quantité : ");
                    int quantite = scanner.nextInt();
                    System.out.print("Prix : ");
                    double prix = scanner.nextDouble();
                    Produit nouveauProduit = new Produit(nom, quantite, prix);
                    produitDAO.ajouterProduit(nouveauProduit);
                    System.out.println("Produit ajouté avec succès !");
                    break;

                case 2:
                    System.out.print("Nom du produit à supprimer : ");
                    String nomSup = scanner.nextLine();
                    service.supprimerProduit(nomSup);
                    break;

                case 3:
                    System.out.print("Nom du produit à mettre à jour : ");
                    String nomMaj = scanner.nextLine();
                    System.out.print("Nouvelle quantité : ");
                    int nouvelleQte = scanner.nextInt();
                    System.out.print("Nouveau prix : ");
                    double nouveauPrix = scanner.nextDouble();
                    scanner.nextLine();
                    service.mettreAJourProduit(nomMaj, nouvelleQte, nouveauPrix);
                    break;

                case 4:
                    service.afficherProduits();
                    break;

                case 5:
                    System.out.print("Nom du produit à rechercher : ");
                    String nomRecherche = scanner.nextLine();
                    Produit p = service.rechercherProduit(nomRecherche);
                    if (p != null) {
                        System.out.println("Produit trouvé : " + p);
                    } else {
                        System.out.println("Produit non trouvé.");
                    }
                    break;

                case 0:
                    System.out.println("Fermeture de l'application...");
                    break;

                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }

        } while (choix != 0);
    }
}
