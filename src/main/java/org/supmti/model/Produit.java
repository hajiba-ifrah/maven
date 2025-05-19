package org.supmti.model;


public class Produit {
    private static int compteurId = 1; // Pour générer automatiquement des ID
    private int id;
    private String nom;
    private int quantite;
    private double prix;

    // Constructeur
    public Produit(String nom, int quantite, double prix) {
        this.id = compteurId++;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Méthode toString pour affichage
    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}

