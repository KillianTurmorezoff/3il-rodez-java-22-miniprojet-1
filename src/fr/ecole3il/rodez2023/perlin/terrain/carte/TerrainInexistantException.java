package fr.ecole3il.rodez2023.perlin.terrain.carte;

public class TerrainInexistantException extends RuntimeException {
    public TerrainInexistantException(String message) {
        super(message);
    }
}