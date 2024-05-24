/**
 * This is the package for the final project in CS3443 at UTSA.
 */
package edu.utsa.cs3443.recipefinalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import edu.utsa.cs3443.recipefinalproject.model.Recipe;


import java.util.ArrayList;

/**
 * This class represents the search activity of the application.
 * @author Jose Guerrero - ybb104
 */
public class SearchActivity extends AppCompatActivity {
    private Button findRecipesButton;
    private EditText searchBar;
    private RecipeController recipeController;

    /**
     * Called when the activity is starting.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchBar = (EditText) findViewById(R.id.searchBar);
        findRecipesButton = (Button) findViewById(R.id.findRecipesButton);
        recipeController = new RecipeController(getAssets());

        findRecipesButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Called when a view has been clicked.
             * @param v The view that was clicked.
             */
            @Override
            public void onClick(View v) {
                String ingredients = searchBar.getText().toString();
                Log.d("SearchActivity", "Ingredients: " + ingredients);
                ArrayList<Recipe> recipes = recipeController.findRecipes(ingredients);
                Log.d("SearchActivity", "Found " + recipes.size() + " recipes");
                openResultsActivity(recipes);
            }
        });
    }

    /**
     * Opens the ResultsActivity for the specified recipes.
     * @param recipes The recipes to be displayed.
     */
    public void openResultsActivity(ArrayList<Recipe> recipes) {
        Log.d("SearchActivity", "Starting ResultsActivity");
        Intent intent = new Intent(this, ResultsActivity.class);
        intent.putExtra("recipes", recipes);
        startActivity(intent);
    }
}
