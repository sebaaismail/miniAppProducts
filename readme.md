
# README - Mini Application de Gestion de Produits

## a. Description de l’application

Cette mini application JavaFX permet aux utilisateurs de gérer une liste de produits.  Elle offre une interface utilisateur simple et intuitive,  où les utilisateurs peuvent ajouter de nouveaux produits via un formulaire et visualiser les produits ajoutés dans une table.  Les données des produits sont stockées dans une base de données MySQL,  garantissant une persistance des données.

### Fonctionnalités principales :

-   Formulaire pour ajouter un produit (nom, prix, quantité).
-   Table pour afficher les produits ajoutés.
-   Validation des entrées pour éviter les erreurs (champs vides, prix et quantités négatifs).
-   Intégration avec une base de données MySQL pour stocker les informations des produits.
-   Utilisation du pattern MVC pour séparer la logique de l'interface utilisateur et la gestion des données.
-   Fichier CSS séparé pour le style de l'application.
-   Utilisation de la police Poppins pour une meilleure présentation.

## b. Instructions pour configurer MySQL et créer la table Produits

1.  **Installer MySQL**  : Si vous n'avez pas encore installé MySQL, téléchargez et installez-le depuis  [le site officiel de MySQL](https://dev.mysql.com/downloads/mysql/).

2.  **Créer une base de données**  :

   -   Connectez-vous à MySQL en utilisant un client comme MySQL Workbench ou via la ligne de commande.
   -   Exécutez les commandes suivantes pour créer la base de données et la table :



>     CREATE DATABASE IF NOT EXISTS miniapptest_db;  
>     USE miniapptest_db;  
>       
>     DROP TABLE IF EXISTS produits;  
>       
>     CREATE TABLE produits (  
>       id BIGINT NOT NULL AUTO_INCREMENT,  
>       nom VARCHAR(255) NOT NULL,  
>       prix FLOAT NOT NULL DEFAULT 0,  
>       quantite INT NOT NULL DEFAULT 0,  
>       PRIMARY KEY (id)  
>     );


vous pouvez egalement commencer par qulques data en la base de données:

> `  
INSERT INTO produits (nom, prix, quantite) VALUES  
('Product A', 19.99, 100),  
('Product B', 29.99, 50),  
('Product C', 15.49, 200),  
('Product D', 45.00, 30),  
('Product E', 9.99, 150),  
('Product F', 25.00, 75);`

## c. Instructions pour exécuter l’application avec Maven

1.  **Cloner le projet**  : Clonez le dépôt contenant le code source de l'application sur votre machine locale en utilisant la commande suivante :


```bash
git clone <URL_DU_DEPOT_GIT>
```
Naviguer vers le répertoire du projet :

    cd chemin/vers/le/projet/miniAppProduits

Compiler le projet : Exécutez la commande suivante pour compiler le projet et télécharger les dépendances :

     mvn clean install 
ou bien ouvrie le avec l'editeur intelijidea par:
open File or Project

Exécuter l'application : Utilisez la commande suivante pour exécuter l'application :

    mvn javafx:run 
ou bien par intelijidea via la commande Run sur le fichier Launcher

## Détails techniques

### Structure du projet

-   **Modèle (Model)** :  
    Gère les données et la logique métier. La classe `ProduitModel` interagit avec la base de données pour récupérer et ajouter des produits.

-   **Vue (View)** :  
    Gère l'interface utilisateur. La classe `ProduitView` contient le formulaire et la table pour afficher les produits.

-   **Contrôleur (Controller)** :  
    Relie le modèle et la vue, en gérant les événements de l'utilisateur. La classe `ProduitController` orchestre les interactions.

### Fichier `pom.xml`

Le fichier `pom.xml` est configuré pour inclure toutes les dépendances nécessaires, notamment JavaFX et le connecteur MySQL. Voici un extrait de la configuration :

xml

Copier le code

    <dependencies>
        <dependency>
            <groupId>org.openjfx</groupId>
            <artifactId>javafx-controls</artifactId>
            <version>17.0.1</version>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.22</version>
        </dependency>
        <!-- Autres dépendances -->
    </dependencies>


## Plugin Maven Assembly

Le plugin **Maven Assembly** est un outil puissant utilisé pour créer des archives, telles que des fichiers JAR, contenant toutes les dépendances nécessaires à l'exécution d'une application Java. Ce plugin facilite le déploiement d'applications en regroupant le code de l'application et ses dépendances dans un seul fichier JAR exécutable.

### Configuration du Plugin

Dans le fichier `pom.xml`, le plugin est configuré comme suit :

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-assembly-plugin</artifactId>
    <version>3.6.0</version>
    <configuration>
        <descriptorRefs>
            <descriptorRef>jar-with-dependencies</descriptorRef>
        </descriptorRefs>
        <archive>
            <manifest>
                <mainClass>com.sebaaismail.miniappproducts.Launcher</mainClass>
            </manifest>
        </archive>
    </configuration>
    <executions>
        <execution>
            <id>make-assembly</id>
            <phase>package</phase>
            <goals>
                <goal>single</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```
Pour créer le fichier JAR exécutable avec toutes les dépendances, il suffit d'exécuter la commande suivante dans le terminal :

    mvn clean package

Après l'exécution de cette commande, vous pouvez trouver le fichier JAR généré sous le nom `miniAppProducts-1.0-SNAPSHOT-jar-with-dependencies.jar` dans le dossier `target` de votre répertoire de projet. Ce fichier est prêt à être déployé et exécuté.

### Fichier CSS

Le style de l'application est centralisé dans un fichier `styles.css`, permettant une gestion simplifiée des styles. Les définitions incluent :

-   **Boutons**
-   **Champs de texte**
-   **Tableau**

### Police personnalisée

La police **Poppins** est utilisée pour personnaliser l'apparence de l'application. Cela offre une interface utilisateur plus esthétique et agréable.


**Capture d'ecran pour l'interface:**
![enter image description here](https://i.ibb.co/xfWCrqz/Capture.png)