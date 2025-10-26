
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Cat
 */
public class UserInput {

    private Scanner scanner;
    private String recipes;
    private ArrayList<Recipe> recipeList;
    private ArrayList<String> ingredients;

    public UserInput(Scanner scanner) {
        this.scanner = scanner;
        this.recipes = "";
        this.recipeList = new ArrayList<Recipe>();
        this.ingredients = new ArrayList<>();
    }

    public String getFileName() {
        String input = this.scanner.nextLine();
        return input;
    }
    
    public String getCommand() {
        String input = this.scanner.nextLine();
        return input;
    }
    
    public String getNameToSearch() {
        String input = this.scanner.nextLine();
        return input;
    }

    public ArrayList<Recipe> readFile(Scanner scanner) {
        while (scanner.hasNextLine()) {

            recipes += " " + scanner.nextLine();

        }
        String recipeName = "";
        int time=0;

        String[] recipesSeperate = recipes.split("  ");

        for (String recipe : recipesSeperate) {
            String[] singleRecipeSplit = recipe.split(" ");
            
            for (int i = 0; i < singleRecipeSplit.length; i++) {

                try {
                    time = Integer.valueOf(singleRecipeSplit[i]);

                    for (int x=0;x<singleRecipeSplit.length;x++) {
                        if (!singleRecipeSplit[x].equals(singleRecipeSplit[i])) {
                            recipeName += singleRecipeSplit[x] + " ";
                            
                        }
                        if (singleRecipeSplit[x].equals(singleRecipeSplit[i])) {
                            break;
                        }
                    }
                    for (int y=i+1;y<singleRecipeSplit.length;y++) {
                        this.ingredients.add(singleRecipeSplit[y]);
                    }
                    
                    Recipe r = new Recipe(recipeName.trim(),time,this.ingredients);
                    this.recipeList.add(r);
                    
                    recipeName = "";
                    time=0;
                    this.ingredients.clear();
                    
                } catch (Exception e) {

                }
            }
        }
        return this.recipeList;
    }
}
