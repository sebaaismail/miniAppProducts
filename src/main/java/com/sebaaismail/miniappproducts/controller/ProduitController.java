package com.sebaaismail.miniappproducts.controller;

import com.sebaaismail.miniappproducts.model.Produit;
import com.sebaaismail.miniappproducts.model.ProduitModel;
import com.sebaaismail.miniappproducts.view.ProduitView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.util.List;

/**
 * Contrôleur pour gérer l'interaction entre le modèle et la vue des produits.
 */
public class ProduitController {
    private ProduitModel produitModel;
    private ProduitView produitView;

    /**
     * Constructeur du contrôleur qui initialise le modèle et la vue.
     *
     * @param produitModel le modèle de produit
     * @param produitView  la vue de produit
     */
    public ProduitController(ProduitModel produitModel, ProduitView produitView) {
        this.produitModel = produitModel;
        this.produitView = produitView;
        loadProduits();
        setupAddProduitButton();
    }

    /**
     * Méthode pour charger les produits depuis le modèle et les afficher dans la vue.
     */
    private void loadProduits() {
        List<Produit> produitList = produitModel.getAllProduits();
        System.out.println("nb produits : " + produitList.size());
        ObservableList<Produit> produits = FXCollections.observableArrayList(produitList);
        TableView<Produit> produitTableView = produitView.getProduitTableView();
        produitTableView.setItems(produits);
    }

    /**
     * Méthode pour configurer le bouton d'ajout de produit.
     */
    private void setupAddProduitButton() {
        produitView.getAddProduitButton().setOnAction(event -> {
            if(produitView.validateForm()) {
                String nom = produitView.getProduitNom();
                double prix = produitView.getProduitPrix();
                int quantite = produitView.getProduitQuantite();
                Produit newProduit = new Produit(nom, prix, quantite);
                produitModel.addProduit(newProduit);
                loadProduits();
                produitView.clearForm();
            }
        });
    }
}
