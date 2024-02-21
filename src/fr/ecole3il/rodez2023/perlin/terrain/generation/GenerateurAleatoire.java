package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

import java.util.Random;

/**
 * Cette classe représente un générateur de carte qui initialise des valeurs aléatoires
 * pour les trois caractéristiques de terrain : hydrométrie, température et altitude.
 * La graine est utilisée pour initialiser le générateur de nombres aléatoires.
 * La résolution est laissée à 1.
 * 
 * @author killian turmorezoff
 */
public class GenerateurAleatoire extends GenerateurCarte {

    /**
     * Constructeur du générateur de carte aléatoire.
     *
     * @param graine La graine utilisée pour initialiser le générateur de nombres aléatoires.
     */
    public GenerateurAleatoire(long graine) {
        super(graine);
    }

    /**
     * Méthode pour générer un terrain spécifique à une position donnée avec des valeurs aléatoires.
     *
     * @param i        La position verticale dans la carte.
     * @param j        La position horizontale dans la carte.
     * @param largeur  La largeur totale de la carte.
     * @param hauteur  La hauteur totale de la carte.
     * @return Le terrain généré pour la position spécifiée.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        Random random = new Random(getGraine());

        // Génération aléatoire des valeurs pour l'hydrométrie, la température et l'altitude
        double hydrometrie = random.nextDouble();
        double temperature = random.nextDouble();
        double altitude = random.nextDouble();

        // Création du terrain avec les valeurs aléatoires
        return new Terrain(hydrometrie, temperature, altitude);
    }
}
