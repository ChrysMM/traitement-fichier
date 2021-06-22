package fr.diginamic;

import javax.persistence.*;

/**
     * Classe Additif avec son identifiant et son libelle
     * @param id qui est l'identifiant de la classe
     * @param libelle qui est le libelle de la classe
     */

    @Entity
    public class Additif {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column
        private String libelle;



        @ManyToOne
        @JoinColumn(name = "idProduit")
        private Produit produit;

        /**
         * Constructeur par défaut
         */
        public Additif() {
        }

        /**
         * Constructeur avec parametres
         * @param id
         * @param libelle
         */
        public Additif(int id, String libelle) {
            this.id = id;
            this.libelle = libelle;
        }


        public int getId() {
            return id;
        }

        /**
         * modifie l'identifaint de la classe
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
         * @return le produit associé à la classe Additif
         */
        public Produit getProduit() {
            return produit;
        }

        /**
         * modifie le produit associé à la classe Additif
         * @param produit
         */
        public void setProduit(Produit produit) {
            this.produit = produit;
        }
    }

