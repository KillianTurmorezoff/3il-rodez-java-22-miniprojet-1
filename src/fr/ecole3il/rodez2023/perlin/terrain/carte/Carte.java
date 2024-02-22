package fr.ecole3il.rodez2023.perlin.terrain.carte;

import java.util.Scanner;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

/**
 * Cette classe représente une carte de terrain.
 * Elle contient le nom de la carte, sa largeur, sa hauteur et un tableau de terrains.
 */
public class Carte {

    // Attributs

    /**
     * Le nom de la carte.
     */
    private String nom;

    /**
     * La largeur de la carte en nombre de cases.
     */
    private int largeur;

    /**
     * La hauteur de la carte en nombre de cases.
     */
    private int hauteur;

    /**
     * Un tableau de terrains représentant la carte.
     */
    private Terrain[][] terrains;

    // Constructeurs

    /**
     * Constructeur d'une carte à partir d'un générateur de carte.
     *
     * @param nom        Le nom de la carte.
     * @param largeur    La largeur de la carte.
     * @param hauteur    La hauteur de la carte.
     * @param generateurCarte Le générateur de carte à utiliser pour générer les terrains.
     */
    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte) {
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.terrains = generateurCarte.genererCarte(largeur, hauteur);
    }

    /**
     * Constructeur d'une carte à partir d'une chaîne de caractères contenant les données de la carte.
     *
     * @param donneesCarte La chaîne de caractères contenant les données de la carte.
     */
    public Carte(String donneesCarte) {
        try (Scanner scanner = new Scanner(donneesCarte)) {
            // Lecture du nom de la carte
            this.nom = scanner.nextLine();

            // Lecture de la largeur et de la hauteur de la carte
            this.largeur = Integer.parseInt(scanner.nextLine());
            this.hauteur = Integer.parseInt(scanner.nextLine());

            // Initialisation du tableau de terrains
            this.terrains = new Terrain[largeur][hauteur];

            // Lecture des données de terrain
            for (int i = 0; i < largeur; i++) {
                for (int j = 0; j < hauteur; j++) {
                    double altitude = scanner.nextDouble() * 2 - 1;
                    double hydrometrie = scanner.nextDouble();
                    double temperature = scanner.nextDouble();
                    this.terrains[i][j] = new Terrain(altitude, hydrometrie, temperature);
                }
            }
        } catch (Exception e) {
            // En cas d'erreur lors de la lecture ou du formatage des données
            e.printStackTrace();
        }
    }

    // Accesseurs

    /**
     * @return Le nom de la carte.
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return La largeur de la carte.
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     * @return La hauteur de la carte.
     */
    public int getHauteur() {
        return hauteur;
    }

    /**
     * @param x La coordonnée x du terrain à récupérer.
     * @param y La coordonnée y du terrain à récupérer.
     * @return Le terrain à la position (x, y).
     * @throws TerrainInexistantException Si la position (x, y) est en dehors des limites de la carte.
     */
    public Terrain getTerrain(int x, int y) throws TerrainInexistantException {
        if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
            throw new TerrainInexistantException("La case demandée est en dehors des limites de la carte.");
        }
        return terrains[x][y];
    }
}
