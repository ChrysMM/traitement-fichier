import fr.diginamic.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class IntegrationOpenFoodFacts {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("foodfact");
        EntityManager manager = factory.createEntityManager();



        EntityTransaction transaction = manager.getTransaction();
        transaction.begin();

        //1. integration des données du fichier en BDD

        Path paths = Paths.get("./open-food-facts.csv");

        try {
            List<String> lignes = Files.readAllLines(paths, StandardCharsets.UTF_8);
            lignes.remove(0);
            // Pour supprimer la première ligne
            Iterator<String> it = lignes.iterator();
            while(it.hasNext()) {
                String ligne = it.next();
                //chaque ligne de l'iteration
                String [] morceaux = ligne.split("\\|",-1 );
                // découper en morceaux
                String categorieProduit = morceaux[0];
                String marqueProduit = morceaux[1];
                String nomProduit = morceaux[2]; //
                String scoreNutritionnelProduit = morceaux[3]; //
                String ingredientsProduit = morceaux [4]; //
                String valeursNutritionnellesProduit = morceaux [5] + morceaux [6];
                //données nutrionnelles
                String allergenesProduit = morceaux[28];
                String additifsProduit = morceaux [29];



                // 2. Insertion des entités en base de données

                //la marque mais à revoir pour les doublons
                Marque marque = new Marque(0,marqueProduit);
                manager.persist(marque);
                if(marque.getLibelle().equalsIgnoreCase(marqueProduit)){
                    marqueProduit = marque.getLibelle();
                }



                Categorie categorie = new Categorie(0, categorieProduit);
                manager.persist(categorie);

                Ingredient ingredients = new Ingredient();
                Allergene allergenes = new Allergene();
                Additif additifs = new Additif();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



        transaction.commit();
        manager.close();

    }

    }

