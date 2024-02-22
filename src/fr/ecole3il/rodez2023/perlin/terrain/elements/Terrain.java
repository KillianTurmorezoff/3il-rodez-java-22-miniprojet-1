package fr.ecole3il.rodez2023.perlin.terrain.elements;

import fr.ecole3il.rodez2023.perlin.terrain.visualisation.DetermineurTerrain;

/**
 * Cette classe représente un terrain caractérisé par son hydrométrie, sa température et son altitude.
 */
public class Terrain {

    private double hydrometrie, temperature, altitude;

    /**
     * Constructeur de la classe Terrain.
     *
     * @param hydrometrie L'hydrométrie du terrain (entre 0 et 1).
     * @param temperature La température du terrain (entre 0 et 1).
     * @param altitude L'altitude du terrain (entre -1 et 1).
     * @throws MauvaiseValeurException Si les valeurs d'hydrométrie, de température ou d'altitude sont en dehors des intervalles autorisés.
     */
    public Terrain(double hydrometrie, double temperature, double altitude) throws MauvaiseValeurException {
        super();
        if (hydrometrie < 0 || hydrometrie > 1) {
            throw new MauvaiseValeurException("L'hydrométrie doit être comprise entre 0 et 1.");
        }
        if (temperature < 0 || temperature > 1) {
            throw new MauvaiseValeurException("La température doit être comprise entre 0 et 1.");
        }
        if (altitude < -1 || altitude > 1) {
            throw new MauvaiseValeurException("L'altitude doit être comprise entre -1 et 1.");
        }
        this.hydrometrie = hydrometrie;
        this.temperature = temperature;
        this.altitude = altitude;
    }

    /**
     * Renvoie l'hydrométrie du terrain.
     *
     * @return L'hydrométrie du terrain.
     */
    public double getHydrometrie() {
        return hydrometrie;
    }

    /**
     * Renvoie la température du terrain.
     *
     * @return La température du terrain.
     */
    public double getTemperature() {
        return temperature;
    }

    /**
     * Renvoie l'altitude du terrain.
     *
     * @return L'altitude du terrain.
     */
    public double getAltitude() {
        return altitude;
    }

    /**
     * Détermine le type de terrain en fonction de ses caractéristiques et d'un `DetermineurTerrain`.
     *
     * @param dt L'objet `DetermineurTerrain` utilisé pour définir les règles de classification.
     * @return Le type de terrain correspondant aux valeurs d'hydrométrie, de température et d'altitude.
     */
    public TypeTerrain getTypeTerrain(DetermineurTerrain dt) {
        return dt.determinerTerrain(altitude, hydrometrie, temperature);
    }
}
