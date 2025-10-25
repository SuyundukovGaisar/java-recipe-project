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
import java.util.ArrayList;
import java.util.Scanner;

public class FilterRecipes {
    private ArrayList<Recipe> recipes;
    private ArrayList<Recipe> completeArray;
    
    public FilterRecipes(){
        recipes = new ArrayList<>();
        completeArray = new ArrayList<>();
    }
    
    public void readFile(String file){
        try(Scanner fileScanner = new Scanner(Paths.get(file))){
            int countRow = 0;
            Recipe recipe = new Recipe();
            
            while (fileScanner.hasNextLine()) {
                String row = fileScanner.nextLine();
                
                if (row.isBlank()) {
                    countRow = 0;
                    recipes.add(recipe);
                    recipe = new Recipe();
                    continue;
                }
                
                if (countRow == 0) {
                    recipe.setName(row);
                }else if(countRow == 1){
                    recipe.setTimeCook(Integer.valueOf(row));
                }else{
                    recipe.add(row);
                }
                countRow++;
                
            }
            recipes.add(recipe);
        }catch(Exception ex){
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
    public ArrayList<Recipe> findName(String findName){
        completeArray.clear();
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(findName)) {
                completeArray.add(recipe);
            }
        }
        return completeArray;
    }
    public ArrayList<Recipe> findTime(int maxTime){
        completeArray.clear();
        for (Recipe recipe : recipes) {
            if (recipe.getTime() <= maxTime) {
                completeArray.add(recipe);
            }
        }
        return completeArray;
    }
    
    public ArrayList<Recipe> findIngredient(String ingredient){
        completeArray.clear();
        for (Recipe recipe : recipes) {
            if (recipe.getIngredients().contains(ingredient)) {
                completeArray.add(recipe);
            }
        }
        return completeArray;
    }
    
    public void printRecipes(){
        for (Recipe recipe : recipes) {
            System.out.println(recipe);
        }
    }
}
