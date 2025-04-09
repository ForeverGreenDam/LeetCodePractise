package com.greendam;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T2353_MID {
    public static void main(String[] args) {
        String[] foods = new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = new int[]{9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        foodRatings.highestRated("korean"); // 返回 "kimchi"
        // "kimchi" 是分数最高的韩式料理，评分为 9 。
      foodRatings.highestRated("japanese"); // 返回 "ramen"
        // "ramen" 是分数最高的日式料理，评分为 14 。
        foodRatings.changeRating("sushi", 16); // "sushi" 现在评分变更为 16 。
        foodRatings.highestRated("japanese"); // 返回 "sushi"
        // "sushi" 是分数最高的日式料理，评分为 16 。
        foodRatings.changeRating("ramen", 16); // "ramen" 现在评分变更为 16 。
        foodRatings.highestRated("japanese"); // 返回 "ramen"
        // "sushi" 和 "ramen" 的评分都是 16 。
        // 但是，"ramen" 的字典序比 "sushi" 更小。
    }
}
class FoodRatings {
   // private HashMap<String, Integer> foodRating = new HashMap<>();
    private HashMap<String,String> foodCuisine = new HashMap<>();
    private HashMap<String,HashMap<String,Integer>> cuisineFoodRating = new HashMap<>();
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
           // foodRating.put(foods[i],ratings[i]);
            foodCuisine.put(foods[i],cuisines[i]);
            if (cuisineFoodRating.containsKey(cuisines[i])){
                cuisineFoodRating.get(cuisines[i]).put(foods[i],ratings[i]);
            }else{
                HashMap<String,Integer> temp = new HashMap<>();
                temp.put(foods[i],ratings[i]);
                cuisineFoodRating.put(cuisines[i],temp);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine=foodCuisine.get(food);
        cuisineFoodRating.get(cuisine).put(food,newRating);
    }

    public String highestRated(String cuisine) {
        HashMap<String,Integer> foodRatingInCuisine=cuisineFoodRating.get(cuisine);
        Set<Map.Entry<String,Integer>> entries = foodRatingInCuisine.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator = entries.iterator();
        Map.Entry<String,Integer> max= iterator.next();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> tempEntry= iterator.next();
            if (tempEntry.getValue()>max.getValue()){
                max=tempEntry;
            }
            if (tempEntry.getValue()==max.getValue()){
                if (tempEntry.getKey().compareTo(max.getKey())<0){
                    max=tempEntry;
                }
            }
        }
        return max.getKey();
    }
}