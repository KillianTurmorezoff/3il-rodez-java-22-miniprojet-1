package fr.ecole3il.rodez2023.perlin.terrain.generation;

import fr.ecole3il.rodez2023.perlin.math.BruitPerlin2D;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;

/**
 * Cette classe représente un générateur de carte utilisant la méthode Perlin
 * pour générer un tableau de terrains en fonction d'une graine.
 * Elle utilise trois "couches" de générateur de bruit de Perlin pour les éléments du terrain.
 * Les graines sont définies comme demandé.
 * La résolution est laissée à 1.
 * 
 * @author killian turmorezoff
 */
public class GenerateurPerlin extends GenerateurCarte {

    /**
     * Constructeur du générateur de carte Perlin.
     *
     * @param graine La graine utilisée pour la génération de la carte.
     */
    public GenerateurPerlin(long graine) {
        super(graine);
    }

    /**
     * Méthode pour générer un terrain spécifique à une position donnée en utilisant la méthode Perlin.
     *
     * @param i        La position verticale dans la carte.
     * @param j        La position horizontale dans la carte.
     * @param largeur  La largeur totale de la carte.
     * @param hauteur  La hauteur totale de la carte.
     * @return Le terrain généré pour la position spécifiée.
     */
    @Override
    protected Terrain genererTerrain(int i, int j, int largeur, int hauteur) {
        double normI = (double) i / largeur;
        double normJ = (double) j / hauteur;

        // Générateur de bruit pour l'hydrométrie
        BruitPerlin2D bruitHydrometrie = new BruitPerlin2D(getGraine(), 1.0);
        double hydrometrie = bruitHydrometrie.bruit2D(normI, normJ);

        // Générateur de bruit pour la température
        BruitPerlin2D bruitTemperature = new BruitPerlin2D(getGraine(), 1.0); // Utilise une graine différente
        double temperature = bruitTemperature.bruit2D(normI, normJ);

        // Générateur de bruit pour l'altitude
        BruitPerlin2D bruitAltitude = new BruitPerlin2D(getGraine(), 1.0); // Utilise une autre graine différente
        double altitude = bruitAltitude.bruit2D(normI, normJ);
        
        // Normalisation des valeurs entre 0 et 1
        hydrometrie = (hydrometrie + 1) / 2;
        temperature = (temperature + 1) / 2;
        altitude = (altitude + 1) / 2;

        // Création du terrain en fonction des valeurs générées
        return new Terrain(hydrometrie, temperature, altitude);
    }
}
