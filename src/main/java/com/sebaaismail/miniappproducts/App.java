package com.sebaaismail.miniappproducts;

import com.sebaaismail.miniappproducts.controller.ProduitController;
import com.sebaaismail.miniappproducts.model.ProduitModel;
import com.sebaaismail.miniappproducts.view.ProduitView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Classe principale de l'application.
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ProduitModel produitModel = new ProduitModel();
        ProduitView produitView = new ProduitView();
        ProduitController produitController = new ProduitController(produitModel, produitView);

        BorderPane root = new BorderPane();
        root.setCenter(produitView.getView());

        Scene scene = new Scene(root, 800, 600);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        stage.setTitle("Products Management Mini-app v1.0");
        stage.setScene(scene);
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/sebaaismail/miniappproducts/icon.png")));

        stage.setMinWidth(500);
        stage.setMinHeight(500);

        stage.show();
    }

    /**
     * Point d'entrée de l'application.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        launch(args);
    }
}