/**
 * This is the package for the final project in CS3443 at UTSA.
 */
package edu.utsa.cs3443.recipefinalproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import edu.utsa.cs3443.recipefinalproject.model.Recipe;

import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.view.View;
import android.content.Intent;

/**
 * This class represents the results activity of the application.
 * @author Jose Guerrero - ybb104
 */
public class ResultsActivity extends AppCompatActivity {
    private ListView resultsListView;
    private ArrayList<Recipe> recipes;

    /**
     * Called when the activity is starting.
     * @param savedInstanceState If the activity is being re-initialized after previously being shut down then this Bundle contains the data it most recently supplied in onSaveInstanceState(Bundle).
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        resultsListView = (ListView) findViewById(R.id.resultsListView);

        // Get the recipes from the Intent
        ArrayList<Recipe> recipes = (ArrayList<Recipe>) getIntent().getSerializableExtra("recipes");
        Log.d("ResultsActivity", "Received " + recipes.size() + " recipes");

        // Create an ArrayAdapter for the ListView
        ArrayAdapter<Recipe> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipes);
        resultsListView.setAdapter(adapter);

        // Set an item click listener for the ListView
        resultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * Callback method to be invoked when an item in this AdapterView has been clicked.
             * @param parent The AdapterView where the click happened.
             * @param view The view within the AdapterView that was clicked (this will be a view provided by the adapter)
             * @param position The position of the view in the adapter.
             * @param id The row id of the item that was clicked.
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openRecipeDetailActivity(recipes.get(position));
            }
        });
    }

    /**
     * Opens the RecipeDetailActivity for the specified recipe.
     * @param recipe The recipe to be detailed.
     */
    public void openRecipeDetailActivity(Recipe recipe) {
        Intent intent = new Intent(this, RecipeDetailActivity.class);
        intent.putExtra("recipe", recipe);
        startActivity(intent);
    }
}
