package com.jason.argos;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        //사과 녹색 10개, 빨간색 5개
        List<Apple> inventory = new ArrayList<>();

        for(int i = 0 ; i < 10; i++){
            Apple apple = new Apple(Color.GREEN);
            inventory.add(apple);
        }

        for(int i = 0 ; i < 5; i++){
            Apple apple = new Apple(Color.RED);
            inventory.add(apple);
        }

        List<Apple> greenApples = filterGreenApples(inventory);

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
}
