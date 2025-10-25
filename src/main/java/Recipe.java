/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
import java.util.ArrayList;

public class Recipe {
    private String name;
    private int timeCook;
    private ArrayList<String> ingredients;
    
    public Recipe(){
        ingredients = new ArrayList<>();
    }
    
    public String getName(){
        return this.name;
    }
    public int getTime(){
        return this.timeCook;
    }
    public ArrayList<String> getIngredients(){
        return this.ingredients;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setTimeCook(int timeCook){
        this.timeCook = timeCook;
    }
    public void add(String ingredient){
        ingredients.add(ingredient);
    }
    public String toString(){
        return this.name + ", cooking time: " + this.timeCook;
    }
}
