package com.sebaaismail.miniappproducts.model;

/**
 * Classe représentant un produit.
 */
public class Produit {
    private int id;
    private String nom;
    private double prix;
    private int quantite;

    /**
     * Constructeur pour créer un produit avec nom, prix et quantité.
     *
     * @param nom      le nom du produit
     * @param prix     le prix du produit
     * @param quantite la quantité du produit
     */
    public Produit(String nom, double prix, int quantite) {
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    /**
     * Constructeur pour créer un produit avec id, nom, prix et quantité.
     *
     * @param id       l'identifiant du produit
     * @param nom      le nom du produit
     * @param prix     le prix du produit
     * @param quantite la quantité du produit
     */
    public Produit(int id, String nom, double prix, int quantite) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.quantite = quantite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    // Getters et setters omis pour la simplicité
}