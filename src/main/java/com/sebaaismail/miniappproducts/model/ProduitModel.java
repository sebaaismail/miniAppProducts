package com.sebaaismail.miniappproducts.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe pour gérer les opérations liées aux produits dans la base de données.
 */
public class ProduitModel {

    /**
     * Méthode pour obtenir tous les produits de la base de données.
     *
     * @return la liste des produits
     */
    public List<Produit> getAllProduits() {
        List<Produit> produits = new ArrayList<>();
        String query = "SELECT * FROM produits";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                Produit produit = new Produit(resultSet.getString("nom"),
                        resultSet.getDouble("prix"),
                        resultSet.getInt("quantite"));
                produits.add(produit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    /**
     * Méthode pour ajouter un produit à la base de données.
     *
     * @param produit le produit à ajouter
     */
    public void addProduit(Produit produit) {
        String query = "INSERT INTO produits (nom, prix, quantite) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, produit.getNom());
            preparedStatement.setDouble(2, produit.getPrix());
            preparedStatement.setInt(3, produit.getQuantite());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}