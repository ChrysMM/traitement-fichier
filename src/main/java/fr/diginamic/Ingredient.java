package fr.diginamic;

/**
 * Classe Ingredient avec un identifiant et un libelle
 * @param id qui représente l'identifaint de la classe
 * @param libelle qui représente le libelle de la classe
 */

import javax.persistence.*;

@Entity
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String libelle;


    //Relation Ingredient - Produit = ManyToOne avec un ou +ieurs ingredients appartenant à un même produit
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    /**
     * Constructeur par defaut
     */
    public Ingredient() {
    }


    public Ingredient(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }



    public int getId() {
        return id;
    }

    /**
     * modifie l'identifiant de la classe
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return le libellé de la classe
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     * modifie le libelle de la classe
     * @param libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     * @return le produit associé à la classe Ingredient
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * modifie le produit associé à la classe Ingredient
     * @param produit
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}
