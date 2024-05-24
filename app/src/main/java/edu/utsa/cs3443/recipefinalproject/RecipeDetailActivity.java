/**
 * This is the package for the final project in CS3443 at UTSA.
 */
package edu.utsa.cs3443.recipefinalproject;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.recipefinalproject.model.Ingredient;
import edu.utsa.cs3443.recipefinalproject.model.Recipe;

import java.util.Random;

/**
 * This class represents the detail activity of a recipe.
 * @author Jose Guerrero - ybb104
 */
public class RecipeDetailActivity extends AppCompatActivity {

    // Add your drawable resource IDs here
    private int[] imageResources = {
            R.drawable.ingpic1,
            R.drawable.ingpic2,
            R.drawable.ingpic3,
            R.drawable.ingpic4, R.drawable.ingpic5, R.drawable.ingpic6
    };

    /**
     * Called when the activity is starting.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_detail);

        // Get the Recipe object from the Intent
        Recipe recipe = (Recipe) getIntent().getSerializableExtra("recipe");

        // Get references to the TextViews
        TextView recipeTitleTextView = findViewById(R.id.recipeTitleTextView);
        TextView recipeIngredientsTextView = findViewById(R.id.recipeIngredientsTextView);
        TextView recipeInstructionsTextView = findViewById(R.id.recipeInstructionsTextView);

        // Set the text for the TextViews
        recipeTitleTextView.setText(recipe.getRecipeName());

        StringBuilder ingredientsText = new StringBuilder();
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredientsText.append(ingredient.getName()).append(": ").append(ingredient.getQuantity()).append("\n");
        }
        recipeIngredientsTextView.setText(ingredientsText.toString());

        recipeInstructionsTextView.setText(recipe.getInstructions());

        // Get a reference to the ImageView
        ImageView imageView = findViewById(R.id.yourImageViewId);

        // Generate a random number between 0 and the length of your image resources array
        int randomImageIndex = new Random().nextInt(imageResources.length);

        // Set the ImageView's image to a random image from your drawable resources
        imageView.setImageResource(imageResources[randomImageIndex]);
    }
}
