package fr.ecole3il.rodez2023.perlin.math;

import java.util.Random;

/**
 * La classe `BruitAleatoire` étend la classe `Bruit2D` et génère du bruit aléatoire en deux dimensions.
 * Elle utilise la classe `Random` de Java pour générer des valeurs aléatoires.
 */
public class BruitAleatoire extends Bruit2D {

    /**
     * Constructeur de la classe `BruitAleatoire`.
     *
     * @param graine La graine à utiliser pour le générateur de nombres aléatoires.
     * @param resolution La résolution du bruit.
     */
    public BruitAleatoire(long graine, double resolution) {
    	super(graine, resolution);
	}

	/**
     * Calcule le bruit 2D en un point donné.
     *
     * @param x La coordonnée x du point.
     * @param y La coordonnée y du point.
     * @return Le bruit 2D en (x, y).
     */
	@Override
	public double bruit2D(double x, double y) {
		Random rnd = new Random();
    	return rnd.nextDouble();
	}
    
}
