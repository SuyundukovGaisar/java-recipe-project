/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.ArrayList;

public class UserInterface {
    private Scanner scanner;
    private ArrayList<Recipe> completeArray;
    private FilterRecipes filter;
    
    public UserInterface(Scanner scanner){
        this.scanner = scanner; 
        completeArray = new ArrayList<>();
        filter = new FilterRecipes();
    }
    public void start(){
        System.out.println("File to read:");
        String file = scanner.nextLine();
        
        filter.readFile(file);
            
        System.out.println("Commands:\n" + "list - lists the recipes\n" + 
                "stop - stops the program\n" + "find name - searches recipes by name\n" + 
                "find cooking time - searches recipes by cooking time\n" + 
                "find ingredient - searches recipes by ingredient");
        System.out.println("");
        while(true){
            System.out.println("Enter command:");
            String command = scanner.nextLine();

            if (command.equals("list")) {
                System.out.println("Recipes:");
                filter.printRecipes();
            }else if (command.equals("stop")) {
                return;
            }else if(command.equals("find name")){
                System.out.println("Searched word:");
                String inputName = scanner.nextLine();
                completeArray.clear();
                completeArray = filter.findName(inputName);
                System.out.println("");
                System.out.println("Recipes:");
                for (Recipe recipe : completeArray) {
                    System.out.println(recipe);
                }
                System.out.println("");
            }else if(command.equals("find cooking time")){
                System.out.println("Max time:");
                int maxTime = Integer.valueOf(scanner.nextLine());
                completeArray.clear();
                completeArray = filter.findTime(maxTime);
                System.out.println("");
                System.out.println("Recipes:");
                for (Recipe recipe : completeArray) {
                    System.out.println(recipe);
                }
                System.out.println("");
            }else if(command.equals("find ingredient")){
                System.out.println("Ingredient:");
                String inputIngredien = scanner.nextLine();
                completeArray.clear();
                completeArray = filter.findIngredient(inputIngredien);
                System.out.println("");
                System.out.println("Recipes:");
                for (Recipe recipe : completeArray) {
                    System.out.println(recipe);
                }
                System.out.println("");
            }
        }
    }
}
