package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.AltitudeAffichee;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.HydrometrieAffichee;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.TemperatureAffichee;

/**
 * Cette classe permet de visualiser les caractéristiques d'une carte de terrain en se basant sur des règles prédéfinies.
 */
public class VisualiseurTerrainEnonce {

    private final Carte carte;

    public VisualiseurTerrainEnonce(Carte carte) {
        this.carte = carte;
    }

    /**
     * Détermine l'affichage de l'altitude d'un terrain en fonction de sa valeur.
     *
     * @param x La coordonnée x du terrain.
     * @param y La coordonnée y du terrain.
     * @return L'affichage de l'altitude du terrain.
     */
    public AltitudeAffichee getAltitudeAffichee(int x, int y) {
        double altitude = carte.getTerrain(x, y).getAltitude();
        if (altitude < 0) {
            return AltitudeAffichee.FOND_MARIN;
        } else if (altitude <= 0.25) {
            return AltitudeAffichee.BASSE;
        } else if (altitude <= 0.7) {
            return AltitudeAffichee.MOYENNE;
        } else {
            return AltitudeAffichee.ELEVEE;
        }
    }

    /**
     * Détermine l'affichage de l'hydrométrie d'un terrain en fonction de sa valeur.
     *
     * @param x La coordonnée x du terrain.
     * @param y La coordonnée y du terrain.
     * @return L'affichage de l'hydrométrie du terrain.
     */
    public HydrometrieAffichee getHydrometrieAffichee(int x, int y) {
        double hydrometrie = carte.getTerrain(x, y).getHydrometrie();
        if (hydrometrie <= 0.25) {
            return HydrometrieAffichee.SEC;
        } else if (hydrometrie <= 0.7) {
            return HydrometrieAffichee.MOYEN;
        } else {
            return HydrometrieAffichee.HUMIDE;
        }
    }

    /**
     * Détermine l'affichage de la température d'un terrain en fonction de sa valeur.
     *
     * @param x La coordonnée x du terrain.
     * @param y La coordonnée y du terrain.
     * @return L'affichage de la température du terrain.
     */
    public TemperatureAffichee getTemperatureAffichee(int x, int y) {
        double temperature = carte.getTerrain(x, y).getTemperature();
        if (temperature <= 0.25) {
            return TemperatureAffichee.FROID;
        } else if (temperature <= 0.7) {
            return TemperatureAffichee.TEMPERE;
        } else {
            return TemperatureAffichee.CHAUD;
        }
    }

    /**
     * Détermine le type de terrain en fonction de son altitude, de son hydrométrie et de sa température.
     *
     * @param x La coordonnée x du terrain.
     * @param y La coordonnée y du terrain.
     * @return Le type de terrain.
     */
    public TypeTerrain getTypeTerrain(int x, int y) {
        // Implémentation des règles pour déterminer le type de terrain

        double altitude = carte.getTerrain(x, y).getAltitude();
        double hydrometrie = carte.getTerrain(x, y).getHydrometrie();
        double temperature = carte.getTerrain(x, y).getTemperature();

        // Ajout de commentaires explicatifs pour chaque règle de décision

        if (altitude < 0 && hydrometrie <= 0.25 && temperature <= 0.25) {
            // Altitude négative, faible hydrométrie et basse température : Océan
            return TypeTerrain.OCEAN;
        } else if (hydrometrie <= 0.25 && altitude <= 0.25 && (temperature <= 0.25 || temperature > 0.7)) {
            // Faible hydrométrie, basse altitude et température basse ou élevée : Plaine
            return TypeTerrain.PLAINE;
        } else if (hydrometrie <= 0.25 && altitude <= 0.25 && temperature > 0.25 && temperature <= 0.7) {
            // Faible hydrométrie, basse altitude et température tempérée : Forêt feuillue
            return TypeTerrain.FORET_FEUILLUS;
        } else if (hydrometrie <= 0.25 && altitude <= 0.25 && temperature > 0.7) {
            // Faible hydrométrie, basse altitude et température haute : Toundra
            return TypeTerrain.TOUNDRA;
        } else if (hydrometrie <= 0.25 && altitude <= 0.7 && (temperature > 0.25 && temperature <= 0.7)) {
            // Faible hydrométrie, altitude moyenne et température tempérée : Forêt de conifères
            return TypeTerrain.FORET_CONIFÈRES;
        } else if (hydrometrie <= 0.25 && altitude <= 0.7 && temperature <= 0.25) {
            // Faible hydrométrie, altitude moyenne et basse température : Désert
            return TypeTerrain.DESERT;
        } else if (hydrometrie <= 0.25 && altitude <= 0.7 && (temperature > 0.25 && temperature <= 0.7)) {
            // Faible hydrométrie, altitude moyenne et température tempérée : Collines
            return TypeTerrain.COLLINES;
        } else if (hydrometrie <= 0.25 && altitude <= 0.7 && temperature > 0.7) {
            // Faible hydrométrie, altitude moyenne et température haute : Désert
            return TypeTerrain.DESERT;
        } else if ((hydrometrie > 0.25 && hydrometrie <= 0.7) && altitude <= 0.25 && temperature <= 0.7) {
            // Hydrométrie moyenne, basse altitude et température tempérée : Marais
            return TypeTerrain.MARAIS;
        } else if ((hydrometrie > 0.25 && hydrometrie <= 0.7) && altitude <= 0.25 && temperature > 0.25 && temperature <= 0.7) {
            // Hydrométrie moyenne, basse altitude et température tempérée : Marais
            return TypeTerrain.MARAIS;
        } else if ((hydrometrie > 0.25 && hydrometrie <= 0.7) && altitude > 0.7 && temperature <= 0.7) {
            // Hydrométrie moyenne, altitude élevée et température tempérée : Montagne
            return TypeTerrain.MONTAGNE;
        } else if ((hydrometrie > 0.25 && hydrometrie <= 0.7) && altitude > 0.7 && (temperature > 0.25 && temperature <= 0.7)) {
            // Hydrométrie moyenne, altitude élevée et température tempérée : Montagne
            return TypeTerrain.MONTAGNE;
        } else {
            // Cas par défaut : Plaine
            return TypeTerrain.PLAINE;
        }
    }
}
