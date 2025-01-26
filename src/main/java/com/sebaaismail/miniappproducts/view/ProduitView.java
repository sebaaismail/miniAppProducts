package com.sebaaismail.miniappproducts.view;

import com.sebaaismail.miniappproducts.model.Produit;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

/**
 * Classe représentant la vue pour gérer l'affichage des produits.
 */
public class ProduitView {

    private BorderPane view;
    private Button addButton;
    private TextField nomField;
    private TextField prixField;
    private TextField quantiteField;

    private TableView<Produit> produitTableView;

    /**
     * Constructeur de la vue des produits.
     * Initialise la vue en configurant les éléments d'interface.
     */
    public ProduitView() {
        setup();
    }

    /**
     * Méthode pour configurer l'interface utilisateur de la vue.
     */
    private void setup() {
        view = new BorderPane();
        view.setPadding(new Insets(20));

        VBox form = getForm();
        produitTableView = getProduitTableView(); // Utilise la variable d'instance
        produitTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        ScrollPane scrollPaneProduitsTable = new ScrollPane(produitTableView);
        scrollPaneProduitsTable.setFitToHeight(true);

        VBox tableParent = new VBox(scrollPaneProduitsTable);
        VBox.setVgrow(scrollPaneProduitsTable, Priority.ALWAYS); // Permet à la table de grandir

        // Crée un VBox pour contenir le formulaire et la table avec un espacement réactif
        VBox mainContainer = new VBox(20); // Espacement initial
        VBox.setVgrow(tableParent, Priority.ALWAYS); // Permet à la table de grandir

        // Lier l'espacement à une propriété qui reflète la hauteur du parent
        mainContainer.spacingProperty().bind(view.heightProperty().divide(10)); // Ajuster le diviseur pour l'espacement désiré

        mainContainer.getChildren().addAll(form, tableParent);
        view.setCenter(mainContainer);
    }

    /**
     * Méthode pour obtenir le formulaire d'ajout de produit.
     *
     * @return le VBox contenant le formulaire
     */
    public VBox getForm() {
        VBox form = new VBox(10);
        form.setPadding(new Insets(10));

        GridPane grid = new GridPane();
        grid.getStyleClass().add("products-form-grid-pane");
        grid.setHgap(15);
        grid.setVgap(20);
        grid.setPadding(new Insets(15));

        Label nomLabel = new Label("Nom du produit");

        nomField = new TextField();
        nomField.prefWidthProperty().bind(grid.widthProperty().divide(3));
        nomField.setMinWidth(200);
        //nomField.setPromptText("Entrez le nom du produit");

        Label prixLabel = new Label("Prix");

        prixField = new TextField();

        Label quantiteLabel = new Label("Quantité");
        quantiteField = new TextField();

        grid.add(nomLabel, 0, 0);
        grid.add(nomField, 1, 0);
        grid.add(prixLabel, 0, 1);
        grid.add(prixField, 1, 1);
        grid.add(quantiteLabel, 0, 2);
        grid.add(quantiteField, 1, 2);

        // Crée le bouton d'ajout
        addButton = new Button("Ajouter");
        addButton.setMaxWidth(Double.MAX_VALUE); // Définit une largeur préférée pour le bouton
        addButton.setPrefHeight(40);

        // Ajoute le bouton à la grille, s'étendant sur deux colonnes
        GridPane.setColumnSpan(addButton, 2); // S'étend sur deux colonnes
        grid.add(addButton, 0, 3); // Place le bouton dans la grille à la ligne 3
        GridPane.setMargin(addButton, new Insets(10, 20, 0, 20)); // Marge supérieure pour l'espacement

        form.getChildren().add(grid); // Ajoute la grille au formulaire

        VBox.setVgrow(grid, Priority.ALWAYS); // Permet à la grille de grandir

        return form;
    }

    /**
     * Méthode pour obtenir la table des produits.
     *
     * @return la TableView des produits
     */
    public TableView <Produit> getProduitTableView() {
        if (produitTableView == null) {
            produitTableView = new TableView<>();

            TableColumn<Produit, String> nomColumn = new TableColumn<>("Nom");
            nomColumn.setCellValueFactory(new PropertyValueFactory<>("nom"));
            nomColumn.setCellFactory(column -> new TableCell<Produit, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                        setStyle("");
                    } else {
                        setText(item);
                        getStyleClass().add("important-cell");
                    }
                }
            });

            nomColumn.setMinWidth(150);

            TableColumn<Produit, Double> prixColumn = new TableColumn<>("Prix");
            prixColumn.setCellValueFactory(new PropertyValueFactory<>("prix"));

            TableColumn<Produit, Integer> quantiteColumn = new TableColumn<>("Quantité");
            quantiteColumn.setCellValueFactory(new PropertyValueFactory<>("quantite"));

            produitTableView.getColumns().addAll(nomColumn, prixColumn, quantiteColumn);

            nomColumn.setPrefWidth(200);
            prixColumn.setPrefWidth(100);
            quantiteColumn.setPrefWidth(100);

            ObservableList<Produit> produitList = FXCollections.observableArrayList();
            produitTableView.setItems(produitList);
        }

        return produitTableView;
    }

    public Node getView() {
        return view;
    }

    public ButtonBase getAddProduitButton() {
        return addButton;
    }

    public String getProduitNom() {
        return nomField.getText();
    }

    public double getProduitPrix() {
        return Double.parseDouble(prixField.getText());
    }

    public int getProduitQuantite() {
        return Integer.parseInt(quantiteField.getText());
    }

    public void clearForm() {
        nomField.setText("");
        prixField.setText("");
        quantiteField.setText("");
    }

    /**
     * Valide les champs du formulaire.
     * Vérifie si les champs sont vides et si les prix et quantités sont négatifs.
     * Affiche un message d'erreur si la validation échoue.
     *
     * @return true si le formulaire est valide, sinon false.
     */
    public boolean validateForm() {
        String message = "";
        // Vérifier si le nom est vide
        if (nomField.getText().trim().isEmpty()) {
            message += "Le nom du produit ne peut pas être vide.";
        }

        // Vérifier si le prix est vide ou négatif
        String prixText = prixField.getText().trim();
        if (prixText.isEmpty()) {
            message += "\nLe prix ne peut pas être vide.";
        }

        try {
            double prix = Double.parseDouble(prixText);
            if (prix < 0) {
                message += "\nLe prix ne peut pas être négatif.";
            }
        } catch (NumberFormatException e) {
            message += "\nVeuillez entrer un prix valide.";
        }

        // Vérifier si la quantité est vide ou négative
        String quantiteText = quantiteField.getText().trim();
        if (quantiteText.isEmpty()) {
            message += "\nLa quantité ne peut pas être vide.";
        }
        try {
            int quantite = Integer.parseInt(quantiteText);
            if (quantite < 0) {
                message += "\nLa quantité ne peut pas être négative.";
            }
        } catch (NumberFormatException e) {
            message += "\nVeuillez entrer une quantité valide.";
        }

        if(message.isEmpty()) {
            return true;
        } else {
            showAlert("Erreur", message);
            return false;
        }
    }

    /**
     * Affiche une boîte de dialogue d'alerte avec un message donné.
     *
     * @param title Le titre de la boîte de dialogue.
     * @param message Le message à afficher.
     */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.getDialogPane().getStylesheets().add(getClass().getResource("/com/sebaaismail/miniappproducts/styles.css").toExternalForm());

        alert.showAndWait();
    }
}