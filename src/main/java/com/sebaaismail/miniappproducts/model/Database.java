package com.sebaaismail.miniappproducts.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Classe pour gérer la connexion à la base de données.
 */
public class Database {

    private static Database instance;

    private Database() {
    }

    /**
     * Méthode pour obtenir l'instance unique de la base de données.
     *
     * @return l'instance de la base de données
     */
    public static Database getInstance() {
        if (instance == null) {
            synchronized (Database.class) {
                if (instance == null) {
                    instance = new Database();
                }
            }
        }
        return instance;
    }

    /**
     * Méthode pour créer une nouvelle connexion.
     *
     * @return la connexion à la base de données
     */
    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/miniapptest_db?serverTimezone=UTC", "root", "admin");
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Erreur de connexion à la base de données : ");
            e.printStackTrace();
        }
        return con;
    }
}