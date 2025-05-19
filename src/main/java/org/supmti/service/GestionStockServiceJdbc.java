package org.supmti.service;

import org.supmti.control.ConnexionBD;
import org.supmti.model.Produit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestionStockServiceJdbc {

    public void ajouterProduit(Produit produit) {
        String sql = "INSERT INTO produits (nom, quantite, prix) VALUES (?, ?, ?)";
        try (Connection conn = ConnexionBD.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produit.getNom());
            stmt.setInt(2, produit.getQuantite());
            stmt.setDouble(3, produit.getPrix());

            stmt.executeUpdate();
            System.out.println("Produit ajouté à la base de données.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Ajouter aussi : supprimerProduitParId, afficherTousProduits, etc.
}

