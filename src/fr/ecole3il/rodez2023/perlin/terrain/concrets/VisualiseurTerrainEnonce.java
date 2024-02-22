package fr.ecole3il.rodez2023.perlin.terrain.concrets;

import fr.ecole3il.rodez2023.perlin.terrain.carte.Carte;
import fr.ecole3il.rodez2023.perlin.terrain.elements.TypeTerrain;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.AltitudeAffichee;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.HydrometrieAffichee;
import fr.ecole3il.rodez2023.perlin.terrain.visualisation.TemperatureAffichee;

public class VisualiseurTerrainEnonce {

    private final Carte carte;

    public VisualiseurTerrainEnonce(Carte carte) {
        this.carte = carte;
    }

    public AltitudeAffichee getAltitudeAffichee(int x, int y) {
        double altitude = carte.getTerrain(x, y).getAltitude();
        if (altitude < 0)
            return AltitudeAffichee.FOND_MARIN;
        else if (altitude <= 0.25)
            return AltitudeAffichee.BASSE;
        else if (altitude <= 0.7)
            return AltitudeAffichee.MOYENNE;
        else
            return AltitudeAffichee.ELEVEE;
    }

    public HydrometrieAffichee getHydrometrieAffichee(int x, int y) {
        double hydrometrie = carte.getTerrain(x, y).getHydrometrie();
        if (hydrometrie <= 0.25)
            return HydrometrieAffichee.SEC;
        else if (hydrometrie <= 0.7)
            return HydrometrieAffichee.MOYEN;
        else
            return HydrometrieAffichee.HUMIDE;
    }

    public TemperatureAffichee getTemperatureAffichee(int x, int y) {
        double temperature = carte.getTerrain(x, y).getTemperature();
        if (temperature <= 0.25)
            return TemperatureAffichee.FROID;
        else if (temperature <= 0.7)
            return TemperatureAffichee.TEMPERE;
        else
            return TemperatureAffichee.CHAUD;
    }

    public TypeTerrain getTypeTerrain(int x, int y) {
        // Implémentation des règles pour déterminer le type de terrain en fonction de l'altitude, de l'hydrométrie et de la température
        double altitude = carte.getTerrain(x, y).getAltitude();
        double hydrometrie = carte.getTerrain(x, y).getHydrometrie();
        double temperature = carte.getTerrain(x, y).getTemperature();

        if (altitude < 0 && hydrometrie <= 0.25 && temperature <= 0.25)
            return TypeTerrain.OCEAN;
        else if (hydrometrie <= 0.25 && altitude <= 0.25 && (temperature <= 0.25 || temperature > 0.7))
            return TypeTerrain.PLAINE;
        else if (hydrometrie <= 0.25 && altitude <= 0.25 && temperature > 0.25 && temperature <= 0.7)
            return TypeTerrain.FORET_FEUILLUS;
        else if (hydrometrie <= 0.25 && altitude <= 0.25 && temperature > 0.7)
            return TypeTerrain.TOUNDRA;
        else if (hydrometrie <= 0.25 && altitude <= 0.25 && (temperature > 0.25 && temperature <= 0.7))
            return TypeTerrain.FORET_CONIFÈRES;
        else if (hydrometrie <= 0.25 && altitude <= 0.7 && temperature <= 0.25)
            return TypeTerrain.DESERT;
        else if (hydrometrie <= 0.25 && altitude <= 0.7 && (temperature > 0.25 && temperature <= 0.7))
            return TypeTerrain.COLLINES;
        else if (hydrometrie <= 0.25 && altitude <= 0.7 && temperature > 0.7)
            return TypeTerrain.DESERT;
        else if ((hydrometrie > 0.25 && hydrometrie <= 0.7) && altitude <= 0.25 && temperature <= 0.7)
            return TypeTerrain.MARAIS;
        else if ((hydrometrie > 0.25 && hydrometrie <= 0.7) && altitude <= 0.25 && temperature > 0.25 && temperature <= 0.7)
            return TypeTerrain.MARAIS;
        else if ((hydrometrie > 0.25 && hydrometrie <= 0.7) && altitude > 0.7 && temperature <= 0.7)
            return TypeTerrain.MONTAGNE;
        else if ((hydrometrie > 0.25 && hydrometrie <= 0.7) && altitude > 0.7 && (temperature > 0.25 && temperature <= 0.7))
            return TypeTerrain.MONTAGNE;
        else
            return TypeTerrain.PLAINE;
    }
}
