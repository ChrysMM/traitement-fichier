package fr.diginamic;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe Marque avec son identifiant et libelle
 * @param idMarque qui est l'identifiant de la classe
 * @param libelle qui est le libelle de la classe
 */

@Entity
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMarque;

    @Column()
    private String libelle;

    //Relation Marque-Produit = OneToMany avec une marque pour plusiuers produits
    @OneToMany(mappedBy = "marque")
    private Set<Produit> produits;

    /**
     * Constructeur par defaut
     */
    public Marque() {
    }

    /**
     * Constructeur avec parametres
     * @param idMarque
     * @param libelle
     */
    public Marque(int idMarque, String libelle) {
        this.idMarque = idMarque;
        this.libelle = libelle;

        Set<Produit> produits = new HashSet<Produit>();
    }


    public int getIdMarque() {
        return idMarque;
    }

    /**
     * modifie l'identifiant de la classe
     * @param id
     */
    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
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
     * @return la liste des produits
     */
    public Set<Produit> getProduits() {
        return produits;
    }

    /**
     * modifie la liste des produits
     * @param produits
     */
    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }
}
