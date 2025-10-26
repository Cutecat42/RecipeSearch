
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

        while (true) {
            System.out.println("Enter command:");

            String command = input.getCommand();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("list")) {
                try {
                    Scanner readFile = new Scanner(new File(fileName));
                    recipeList = input.readFile(readFile);
                    List(recipeList);

                } catch (FileNotFoundException ex) {
                    Logger.getLogger(RecipeSearch.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }

    public static void List(ArrayList<Recipe> recipeList) {
        System.out.println("Recipes:");
        for (Recipe recipe : recipeList) {
            System.out.println(recipe.getName() + ", cooking time: " + recipe.getTime());
        }
    }

}
