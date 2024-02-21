package fr.ecole3il.rodez2023.perlin.terrain.visualisation;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;

public class VisualiseurTerrain {
    private final Carte carte;
    private final DetermineurTerrain determineurTerrain;

    public VisualiseurTerrain(Carte carte, DetermineurTerrain determineurTerrain) {
        this.carte = carte;
        this.determineurTerrain = determineurTerrain;
    }

    // Méthodes pour obtenir les caractéristiques visuelles...

    public String getTypeTerrain(int i, int j) {
        double altitude = carte.getTerrain(i, j).getAltitude();
        double hydrometrie = carte.getTerrain(i, j).getHydrometrie();
        double temperature = carte.getTerrain(i, j).getTemperature();

        TypeTerrain typeTerrain = determineurTerrain.determinerTerrain(altitude, hydrometrie, temperature);

        // Si le détermineur retourne null, nous pouvons gérer ce cas selon vos besoins
        // Par exemple, nous pouvons retourner une chaîne vide ou un message d'erreur
        if (typeTerrain == null) {
            return "Type de terrain indéterminé";
        }

        // Retourner le nom du type de terrain
        return typeTerrain.toString();
    }
}
