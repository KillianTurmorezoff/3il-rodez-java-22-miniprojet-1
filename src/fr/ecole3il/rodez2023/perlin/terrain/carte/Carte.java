package fr.ecole3il.rodez2023.perlin.terrain.carte;

import java.util.Scanner;
import fr.ecole3il.rodez2023.perlin.terrain.elements.Terrain;
import fr.ecole3il.rodez2023.perlin.terrain.generation.GenerateurCarte;

public class Carte {
    private String nom;
    private int largeur;
    private int hauteur;
    private Terrain[][] terrains;

    public Carte(String nom, int largeur, int hauteur, GenerateurCarte generateurCarte) {
        this.nom = nom;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.terrains = generateurCarte.genererCarte(largeur, hauteur);
    }
    
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
                    double altitude = scanner.nextDouble();
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

    public String getNom() {
        return nom;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getHauteur() {
        return hauteur;
    }

    public Terrain getTerrain(int x, int y) throws TerrainInexistantException {
        if (x < 0 || x >= largeur || y < 0 || y >= hauteur) {
            throw new TerrainInexistantException("La case demandée est en dehors des limites de la carte.");
        }
        return terrains[x][y];
    }
}
