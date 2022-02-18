package com.jason.argos;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //사과 녹색 10개, 빨간색 5개
        List<Apple> inventory = new ArrayList<>();

        for(int i = 0 ; i < 10; i++){
            Apple apple = new Apple(Color.GREEN, i);
            inventory.add(apple);
        }

        for(int i = 0 ; i < 5; i++){
            Apple apple = new Apple(Color.RED, i);
            inventory.add(apple);
        }

        List<Apple> greenApples = filterGreenApples(inventory);

        for(Apple greenApple : greenApples){
            System.out.println(greenApple.getColor());
        }

        greenApples = filterApplesByColor(inventory, Color.GREEN);
        for(Apple greenApple : greenApples){
            System.out.println(greenApple.getColor());
        }

        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        for(Apple redApple : redApples){
            System.out.println(redApple.getColor());
        }

        List<Apple> heavyApples = filterApples(inventory, Color.RED, 5, false);
        for(Apple heavy : heavyApples){
            System.out.println(heavy.getColor() + " " + heavy.getWeight());
        }

        greenApples = filterApples(inventory, new AppleGreenColorPredicate());
        for(Apple greenApple : greenApples){
            System.out.println(greenApple.getColor());
        }

        heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
        for(Apple heavy : heavyApples){
            System.out.println(heavy.getColor() + " " + heavy.getWeight());
        }

        List<Apple> redAndLight = filterApples(inventory, new AppleRedAndLightPredicate());
        for(Apple apple : redAndLight){
            System.out.println(apple.getColor() + " " + apple.getWeight());
        }

        redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });
        for(Apple redApple : redApples){
            System.out.println(redApple.getColor());
        }

        greenApples = filterApples(inventory, (Apple apple) -> Color.GREEN.equals(apple.getColor()));
        for(Apple greenApple : greenApples){
            System.out.println(greenApple.getColor());
        }




    }

    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory){
            if(Color.GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }



}
