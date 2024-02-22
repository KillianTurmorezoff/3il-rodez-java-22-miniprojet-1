package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

/**
 * Cette classe implémente l'interface `DetermineurTerrain` et définit des règles pour déterminer le type de terrain en fonction de l'altitude, de l'hydrométrie et de la température.
 */
public class DetermineurTerrainEnonce implements DetermineurTerrain {

    /**
     * Détermine le type de terrain en fonction des valeurs d'altitude, d'hydrométrie et de température.
     *
     * @param altitude L'altitude du terrain (entre -1 et 1).
     * @param hydrometrie L'hydrométrie du terrain (entre 0 et 1).
     * @param temperature La température du terrain (entre 0 et 1).
     * @return Le type de terrain correspondant aux valeurs données.
     */
    @Override
    public TypeTerrain determinerTerrain(double altitude, double hydrometrie, double temperature) {

        // Règles de décision pour déterminer le type de terrain

        if (altitude < 0) {
            // Océan si l'altitude est négative
            return TypeTerrain.OCEAN;
        } else if (hydrometrie <= 0.25) {
            // Faible hydrométrie
            if (altitude <= 0.7) {
                // Basse altitude
                if (temperature <= 0.25) {
                    // Basse température
                    return TypeTerrain.PLAINE;
                } else if (temperature <= 0.7) {
                    // Température moyenne
                    return TypeTerrain.FORET_FEUILLUS;
                } else {
                    // Haute température
                    return TypeTerrain.TOUNDRA;
                }
            } else {
                // Altitude moyenne
                if (temperature <= 0.25) {
                    // Basse température
                    return TypeTerrain.PLAINE;
                } else if (temperature <= 0.7) {
                    // Température moyenne
                    return TypeTerrain.FORET_CONIFÈRES;
                } else {
                    // Haute température
                    return TypeTerrain.MONTAGNE;
                }
            }
        } else {
            // Forte hydrométrie
            if (altitude <= 0.7) {
                // Basse altitude
                if (temperature <= 0.25) {
                    // Basse température
                    return TypeTerrain.DESERT;
                } else if (temperature <= 0.7) {
                    // Température moyenne
                    return TypeTerrain.COLLINES;
                } else {
                    // Haute température
                    return TypeTerrain.MONTAGNE;
                }
            } else {
                // Altitude moyenne
                if (temperature <= 0.25) {
                    // Basse température
                    return TypeTerrain.MARAIS;
                } else if (temperature <= 0.7) {
                    // Température moyenne
                    return TypeTerrain.FORET_CONIFÈRES;
                } else {
                    // Haute température
                    return TypeTerrain.MONTAGNE;
                }
            }
        }
    }
}
