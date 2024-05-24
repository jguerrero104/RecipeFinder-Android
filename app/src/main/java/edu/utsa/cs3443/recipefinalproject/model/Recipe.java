/**
 * This is the package for the final project in CS3443 at UTSA.
 */
package edu.utsa.cs3443.recipefinalproject.model;

import java.io.Serializable;
import java.util.List;

/**
 * This class represents a Recipe which is serializable.
 * @author Jose Guerrero - ybb104
 */
public class Recipe implements Serializable {
    private int recipeID;
    private String recipeName;
    private List<Ingredient> ingredients;
    private int preparationTime;
    private int cookingTime;
    private String instructions;

    /**
     * Returns the ID of the recipe.
     * @return An integer representing the ID of the recipe.
     */
    public int getRecipeID() {
        return recipeID;
    }

    /**
     * Sets the ID of the recipe.
     * @param recipeID The ID of the recipe.
     */
    public void setRecipeID(int recipeID) {
        this.recipeID = recipeID;
    }

    /**
     * Returns the name of the recipe.
     * @return A string representing the name of the recipe.
     */
    public String getRecipeName() {
        return recipeName;
    }

    /**
     * Sets the name of the recipe.
     * @param recipeName The name of the recipe.
     */
    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    /**
     * Returns the list of ingredients in the recipe.
     * @return A list of ingredients in the recipe.
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Sets the list of ingredients in the recipe.
     * @param ingredients The list of ingredients in the recipe.
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * Returns the preparation time of the recipe.
     * @return An integer representing the preparation time of the recipe.
     */
    public int getPreparationTime() {
        return preparationTime;
    }

    /**
     * Sets the preparation time of the recipe.
     * @param preparationTime The preparation time of the recipe.
     */
    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }

    /**
     * Returns the cooking time of the recipe.
     * @return An integer representing the cooking time of the recipe.
     */
    public int getCookingTime() {
        return cookingTime;
    }

    /**
     * Sets the cooking time of the recipe.
     * @param cookingTime The cooking time of the recipe.
     */
    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    /**
     * Returns the instructions of the recipe.
     * @return A string representing the instructions of the recipe.
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * Sets the instructions of the recipe.
     * @param instructions The instructions of the recipe.
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    /**
     * Returns a string representation of the recipe.
     * @return A string representing the recipe.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recipe Name: ").append(this.recipeName).append("\n");
        sb.append("Preparation Time: ").append(this.preparationTime).append(" minutes\n");
        sb.append("Cooking Time: ").append(this.cookingTime).append(" minutes\n");
        sb.append("Ingredients: \n");
        for (Ingredient ingredient : this.ingredients) {
            sb.append("- ").append(ingredient.getName()).append(": ").append(ingredient.getQuantity()).append("\n");
        }
        return sb.toString();
    }
}
