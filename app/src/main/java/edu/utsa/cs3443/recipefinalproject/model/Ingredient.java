/**
 * This is the package for the final project in CS3443 at UTSA.
 */
package edu.utsa.cs3443.recipefinalproject.model;

import java.io.Serializable;

/**
 * This class represents an Ingredient which is serializable.
 * @author Jose Guerrero - ybb104
 */
public class Ingredient implements Serializable {
    private String name;
    private String quantity;

    /**
     * Constructs an Ingredient with the specified name and quantity.
     * @param name The name of the ingredient.
     * @param quantity The quantity of the ingredient.
     */
    public Ingredient(String name, String quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * Returns the name of the ingredient.
     * @return A string representing the name of the ingredient.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the quantity of the ingredient.
     * @return A string representing the quantity of the ingredient.
     */
    public String getQuantity() {
        return quantity;
    }
}
