package fr.diginamic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @param idProduit qui est l'identifiant du produit
 * @param nom qui est le nom du produit
 * @param categorie qui est la catégorie du produit
 * @param marque qui est la marque du produit
 * @param scoreNutritionnel qui est le score nutritionnel du produit
 * @param valeursNutritionnelles qui est la valeur nutritionnelle du produit
 * @param ingredients qui est la liste des ingrédients du produit
 * @param additifs qui est la liste des éléments additifs du produit
 * @param allergenes qui est est la liste des allergenes du produit
 */
@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduit;

    @Column
    private String nom;

    @Column
    private String scoreNutritionnel;

    @Column
    private String [] valeursNutritionnelles;



    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    //Relation Produit-Marque = ManyToOne avec plusieurs produits appartenant à la même marque
    @ManyToOne
    @JoinColumn(name = "idMarque")
    private Marque marque;

    //Relation Produit - Allergene = OneToMany un produit donné peut avoir uen ou plusiuers allergenes

    @OneToMany(mappedBy = "produit")
    private Set<Allergene> allergenes;

    //Relation Produit - Ingredient = OneToMay avec un même produit possedant un ou +ieurs ingredients

    @OneToMany(mappedBy = "produit")
    private Set<Ingredient> ingredients;

    // Relation Produit - Additif = OneToMany avec un produit disposant d'un ou +ieurs additifs

    @OneToMany(mappedBy = "produit")
    private Set<Additif> additifs;

    /**
     * Constructeur par defaut
     */
    public Produit() {
    }



    public Produit(int idProduit, String nom, String scoreNutritionnel, String[] valeursNutritionnelles) {
        this.idProduit = idProduit;
        this.nom = nom;
        this.scoreNutritionnel = scoreNutritionnel;
        this.valeursNutritionnelles = valeursNutritionnelles;

        //Set des produits par les bases relationnelles

        Set<Allergene> allergenes = new HashSet<Allergene>();
        Set<Ingredient> ingredients = new HashSet<Ingredient>();
        Set<Additif> additifs = new HashSet<Additif>();
    }
    /**
     * Getters et Setters des attributs de la classe
     */

    /**
     * @return l'identifiant du produit
     */
    public int getIdProduit() {
        return idProduit;
    }

    /**
     * modifie l'identifiant du produit
     * @param idProduit
     */
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    /**
     * @return le nom du produit
     */
    public String getNom() {
        return nom;
    }

    /**
     * modifie le nom du produit
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return le score nutritionnel du produit
     */
    public String getScoreNutritionnel() {
        return scoreNutritionnel;
    }

    /**
     * modifie le score nutritionnel du produit
     * @param scoreNutritionnel
     */
    public void setScoreNutritionnel(String scoreNutritionnel) {
        this.scoreNutritionnel = scoreNutritionnel;
    }

    /**
     * modifie la liste des valeurs nutritionnelles du produit
     * @param valeursNutritionnelles
     */
    public void setValeursNutritionnelles(String[] valeursNutritionnelles) {
        this.valeursNutritionnelles = valeursNutritionnelles;
    }

    /**
     * @return la liste des valeurs nutritionnelles du produit
     */
    public String[] getValeursNutritionnelles() {
        return valeursNutritionnelles;
    }

    /**
     * @return la categorie associée à la classe Produit
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     * modifie la catégorie associée à la classe Produit
     * @param categorie
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    /**
     * @return la marque associée à la classe Produit
     */
    public Marque getMarque() {
        return marque;
    }

    /**
     * modifie la marque associée à la classe Produit
     * @param marque
     */
    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    /**
     * @return le Set d'Allergenes associées à la classe Produit
     */
    public Set<Allergene> getAllergenes() {
        return allergenes;
    }

    /**
     * modifie le Set d'Allergenes associées à la classe Produit
     * @param allergenes
     */
    public void setAllergenes(Set<Allergene> allergenes) {
        this.allergenes = allergenes;
    }

    /**
     * @return le Set d'ingredients associés à la clase Produit
     */
    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * modifie le Set d'ingredients associés à la clase Produit
     * @param ingredients
     */
    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * @return le Set d'additifs associés à la clase Produit
     */
    public Set<Additif> getAdditifs() {
        return additifs;
    }
    /**
     * modifie le Set d'additifs associés à la clase Produit
     * @param additifs
     */
    public void setAdditifs(Set<Additif> additifs) {
        this.additifs = additifs;
    }
}

