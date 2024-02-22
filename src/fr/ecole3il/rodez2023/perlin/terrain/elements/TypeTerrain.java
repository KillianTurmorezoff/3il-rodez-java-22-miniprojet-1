package fr.ecole3il.rodez2023.perlin.terrain.elements;

import java.awt.image.BufferedImage;
import fr.ecole3il.rodez2023.perlin.Utils;

/**
 * Cette énumération représente les différents types de terrain possibles.
 */
public enum TypeTerrain {

    /**
     * Collines
     */
    COLLINES("Collines", "hills.png"),

    /**
     * Désert
     */
    DESERT("Désert", "desert.png"),

    /**
     * Forêt de conifères
     */
    FORET_CONIFÈRES("Forêt de conifères", "coniferous_forest.png"),

    /**
     * Forêt de feuillus
     */
    FORET_FEUILLUS("Forêt de feuillus", "deciduous_forest.png"),

    /**
     * Marais
     */
    MARAIS("Marais", "marsh.png"),

    /**
     * Montagne
     */
    MONTAGNE("Montagne", "mountain.png"),

    /**
     * Océan
     */
    OCEAN("Océan", "ocean.png"),

    /**
     * Plaine
     */
    PLAINE("Plaine", "plain.png"),

    /**
     * Toundra
     */
    TOUNDRA("Toundra", "tundra.png");

    private final String nom;
    private final String fichierImage;

    private TypeTerrain(String nom, String fichierImage) {
        this.nom = nom;
        this.fichierImage = fichierImage;
    }

    /**
     * Renvoie l'image associée au type de terrain.
     *
     * @return L'image du type de terrain.
     */
    public BufferedImage getImage() {
        return Utils.chargerTuile(fichierImage);
    }

    @Override
    public String toString() {
        return nom;
    }
}
