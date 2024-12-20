module miniAppProduits {
    requires javafx.base;
    requires javafx.controls;
    requires javafx.graphics;

    requires java.sql;

    opens com.sebaaismail.miniappproducts to javafx.graphics;

    opens com.sebaaismail.miniappproducts.model to javafx.base;

    exports com.sebaaismail.miniappproducts;

}