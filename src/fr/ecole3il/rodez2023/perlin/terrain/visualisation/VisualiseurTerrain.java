package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

/**
 * Cette classe permet de visualiser le type de terrain à une position donnée sur une carte.
 */
public class VisualiseurTerrain {

    /**
     * La carte à visualiser.
     */
    private final Carte carte;

    /**
     * L'objet qui détermine le type de terrain en fonction de ses caractéristiques.
     */
    private final DetermineurTerrain determineurTerrain;

    /**
     * Constructeur de la classe VisualiseurTerrain.
     *
     * @param carte La carte à visualiser.
     * @param determineurTerrain L'objet qui détermine le type de terrain.
     */
    public VisualiseurTerrain(Carte carte, DetermineurTerrain determineurTerrain) {
        this.carte = carte;
        this.determineurTerrain = determineurTerrain;
    }

    /**
     * Renvoie le type de terrain à la position (i, j) sur la carte.
     *
     * @param i La coordonnée x de la position.
     * @param j La coordonnée y de la position.
     * @return Le type de terrain à la position (i, j), ou "Type de terrain indéterminé" si le type ne peut pas être déterminé.
     */
    public String getTypeTerrain(int i, int j) {
        // Récupérer les caractéristiques du terrain à la position (i, j)
        double altitude = carte.getTerrain(i, j).getAltitude();
        double hydrometrie = carte.getTerrain(i, j).getHydrometrie();
        double temperature = carte.getTerrain(i, j).getTemperature();

        // Déterminer le type de terrain en utilisant l'objet determineurTerrain
        TypeTerrain typeTerrain = determineurTerrain.determinerTerrain(altitude, hydrometrie, temperature);

        // Si le type de terrain n'a pas pu être déterminé, renvoyer un message d'erreur
        if (typeTerrain == null) {
            return "Type de terrain indéterminé";
        }

        // Renvoyer le nom du type de terrain déterminé
        return typeTerrain.toString();
    }
}
