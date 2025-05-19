package com.exemple.service;


import org.supmti.model.Produit;

import java.util.ArrayList;
import java.util.List;

public class GestionStockService {

    private List<Produit> produits;

    public GestionStockService() {
        this.produits = new ArrayList<>();
    }

    // Ajouter un produit
    public void ajouterProduit(Produit produit) {
        produits.add(produit);
        System.out.println("✅ Produit ajouté avec succès !");
    }

    // Supprimer un produit par nom (ou tu peux adapter par ID si tu préfères)
    public void supprimerProduit(String nom) {
        Produit produit = rechercherProduit(nom);
        if (produit != null) {
            produits.remove(produit);
            System.out.println("🗑️ Produit supprimé avec succès !");
        } else {
            System.out.println("⚠️ Produit introuvable.");
        }
    }

    // Mettre à jour un produit
    public void mettreAJourProduit(String nom, int nouvelleQuantite, double nouveauPrix) {
        Produit produit = rechercherProduit(nom);
        if (produit != null) {
            produit.setQuantite(nouvelleQuantite);
            produit.setPrix(nouveauPrix);
            System.out.println("✏️ Produit mis à jour avec succès !");
        } else {
            System.out.println("⚠️ Produit non trouvé.");
        }
    }

    // Afficher tous les produits
    public void afficherProduits() {
        if (produits.isEmpty()) {
            System.out.println("Aucun produit en stock.");
        } else {
            System.out.println("\n📦 Liste des produits en stock :");
            for (Produit p : produits) {
                System.out.println(p);
            }
        }
    }

    // Rechercher un produit par nom
    public Produit rechercherProduit(String nom) {
        for (Produit p : produits) {
            if (p.getNom().equalsIgnoreCase(nom)) {
                return p;
            }
        }
        return null;
    }

    // Rechercher un produit par ID
    public Produit rechercherProduitParId(int id) {
        for (Produit p : produits) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
}
