
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Recipe> recipeList = new ArrayList<>();

        UserInput input = new UserInput(scanner);
        System.out.println("File to read:");
        String fileName = input.getFileName();

        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");

        while (true) {
            System.out.println("Enter command:");

            String command = input.getCommand();
            Scanner readFile;

            try {
                readFile = new Scanner(new File(fileName));

                recipeList = input.readFile(readFile);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(RecipeSearch.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("list")) {
                list(recipeList);

            }

            if (command.equals("find name")) {
                System.out.println("Searched word:");
                String word = input.getNameToSearch();
                searchFile(recipeList, word);
            }

            if (command.equals("find cooking time")) {
                System.out.println("Max cooking time:");
                int time = input.getTimeToSearch();
                searchFileWithTime(recipeList, time);
            }

            if (command.equals("find ingredient")) {
                System.out.println("Ingredient: ");
                String ingredient = input.getIngredientToSearch();
                searchFileWithIngredient(recipeList, ingredient);
            }

        }

    }

    public static void list(ArrayList<Recipe> recipeList) {
        System.out.println("Recipes:");
        for (Recipe recipe : recipeList) {
            System.out.println(recipe.getName() + ", cooking time: " + recipe.getTime());
        }
    }

    public static void searchFile(ArrayList<Recipe> recipeList, String word) {
        System.out.println("Recipes:");
        for (Recipe recipe : recipeList) {
            if (recipe.getName().contains(word)) {
                System.out.println(recipe.getName() + ", cooking time: " + recipe.getTime());
            }
        }
    }

    public static void searchFileWithTime(ArrayList<Recipe> recipeList, int time) {
        System.out.println("Recipes:");
        for (Recipe recipe : recipeList) {
            if (recipe.getTime() <= time) {
                System.out.println(recipe.getName() + ", cooking time: " + recipe.getTime());
            }
        }
    }

    public static void searchFileWithIngredient(ArrayList<Recipe> recipeList, String ingredient) {
        System.out.println("Recipes:");
        for (Recipe recipe : recipeList) {
            if (recipe.getIngredients().contains(ingredient)) {
                System.out.println(recipe.getName() + ", cooking time: " + recipe.getTime());
            }
        }
    }

}
