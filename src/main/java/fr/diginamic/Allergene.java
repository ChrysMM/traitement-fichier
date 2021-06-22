package fr.diginamic;

import javax.persistence.*;

/**
 * Classe Allergene un identifiant et un libelle
 * @param id qui est l'identifiant de la classe
 * @param libelle qui est le libelle de la classe
 */

@Entity
public class Allergene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String libelle;

    //Relation Allergene - Produit = ManyToOne avec plusiuers allergenes pour un produit donné
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    /**
     * Constructeur par defaut
     */
    public Allergene() {
    }


    public Allergene(int id, String libelle) {
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
     * @return le libelle de la classe
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
     * @return le produit associé à la classe Allergene
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     * modifie le produit associé à la classe Allergene
     * @param produit
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }
}