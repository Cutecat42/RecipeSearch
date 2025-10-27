
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Cat
 */
public class Recipe {
    private String name;
    private int time;
    private ArrayList<String> ingredients;
    
    public Recipe(String name, int time, ArrayList<String> ingredients) {
        this.name = name;
        this.time = time;
        this.ingredients = new ArrayList<>(ingredients);
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getTime() {
        return this.time;
    }
    
    public ArrayList<String> getIngredients() {
        return this.ingredients;
    }
    
    @Override
    public String toString() {
        return "Recipe name: "+ this.name + ", Cooking time: " + this.time + ", Ingredients: " + this.ingredients.toString();
    }
}
