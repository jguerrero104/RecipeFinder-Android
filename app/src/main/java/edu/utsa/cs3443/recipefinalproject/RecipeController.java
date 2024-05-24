/**
 * This is the package for the final project in CS3443 at UTSA.
 */
package edu.utsa.cs3443.recipefinalproject;

import android.content.res.AssetManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.util.List;

import edu.utsa.cs3443.recipefinalproject.model.Ingredient;
import edu.utsa.cs3443.recipefinalproject.model.Recipe;

/**
 * This class represents a RecipeController which manages the recipes.
 * @author Jose Guerrero - ybb104
 */
public class RecipeController {

    private ArrayList<Recipe> recipes;

    /**
     * Constructs a RecipeController with the specified assets.
     * @param assets The assets of the application.
     */
    public RecipeController(AssetManager assets) {
        this.recipes = new ArrayList<>();
        // Load the recipes from the CSV file
        try {
            InputStream is = assets.open("recipes.csv");
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader reader = new BufferedReader(isr);
            String line;
            boolean isFirstLine = true;
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    // Skip the header line
                    isFirstLine = false;
                    continue;
                }
                String[] fields = line.split(",");
                if (fields.length > 0) {
                    Recipe recipe = new Recipe();
                    try {
                        recipe.setRecipeID(Integer.parseInt(fields[0].trim()));
                        recipe.setPreparationTime(Integer.parseInt(fields[3].trim()));
                        recipe.setCookingTime(Integer.parseInt(fields[4].trim()));
                    } catch (NumberFormatException e) {
                        Log.e("RecipeController", "Error parsing number: " + e.getMessage());
                        continue;  // Skip this recipe
                    }
                    recipe.setRecipeName(fields[1]);
                    List<Ingredient> ingredients = new ArrayList<>();
                    for (String ingredient : fields[2].split(";")) {
                        // Each ingredient is in the format "name,quantity"
                        String[] parts = ingredient.trim().split(",", 2);
                        String name = parts[0];
                        String quantity = parts.length > 1 ? parts[1] : "";
                        ingredients.add(new Ingredient(name, quantity));
                    }
                    recipe.setIngredients(ingredients);
                    recipe.setInstructions(fields[5]);
                    this.recipes.add(recipe);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the list of recipes.
     * @return An ArrayList of recipes.
     */
    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * Adds a recipe to the list of recipes.
     * @param recipe The recipe to be added.
     */
    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }

    /**
     * Finds recipes that contain the specified ingredients.
     * @param ingredients The ingredients to be searched for.
     * @return An ArrayList of recipes that contain the specified ingredients.
     */
    public ArrayList<Recipe> findRecipes(String ingredients) {
        ArrayList<Recipe> matchingRecipes = new ArrayList<>();
        String[] searchedIngredients = ingredients.split(",");
        for (Recipe recipe : this.recipes) {
            Log.d("RecipeController", "Checking recipe: " + recipe.getRecipeName());
            for (String searchedIngredient : searchedIngredients) {
                for (Ingredient ingredient : recipe.getIngredients()) {
                    if (ingredient.getName().toLowerCase().contains(searchedIngredient.trim().toLowerCase())) {
                        Log.d("RecipeController", "Match found: " + recipe.getRecipeName());
                        matchingRecipes.add(recipe);
                        break;
                    }
                }
            }
        }
        return matchingRecipes;
    }
}
