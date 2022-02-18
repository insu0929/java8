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

        //1. 첫 번째 시도: 녹색 사과 필터링
        List<Apple> greenApples = filterGreenApples(inventory);
        for(Apple greenApple : greenApples){
            System.out.println(greenApple.getColor());
        }

        //2. 두 번째 시도: 색을 파라미터화
        greenApples = filterApplesByColor(inventory, Color.GREEN);
        for(Apple greenApple : greenApples){
            System.out.println(greenApple.getColor());
        }

        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        for(Apple redApple : redApples){
            System.out.println(redApple.getColor());
        }

        //3. 세 번째 시도: 가능한 모든 속성으로 필터링
        List<Apple> heavyApples = filterApples(inventory, Color.RED, 5, false);
        for(Apple heavy : heavyApples){
            System.out.println(heavy.getColor() + " " + heavy.getWeight());
        }

        //4. 네 번째 시도: 추상적 조건으로 필터링
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

        //5. 다섯 번째 시도: 익명 클래스 사용
        redApples = filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return Color.RED.equals(apple.getColor());
            }
        });
        for(Apple redApple : redApples){
            System.out.println(redApple.getColor());
        }

        //6. 여섯 번째 시도: 람다 표현식 사용
        greenApples = filterApples(inventory, (Apple apple) -> Color.GREEN.equals(apple.getColor()));
        for(Apple greenApple : greenApples){
            System.out.println(greenApple.getColor());
        }

        List<Apple> lightApples = filter(inventory, (Apple apple) -> apple.getWeight() < 5);
        for(Apple light : lightApples){
            System.out.println(light.getColor() + " " +light.getWeight());
        }

        //7. 일곱 번째 시도: 리스트 형식으로 추상화
        List<Integer> nums = new ArrayList<>();
        for(int i = 0 ; i < 10; i++){
            nums.add(i);
        }
        List<Integer> odds = filter(nums, (Integer i) -> i % 2 != 0);
        for(int no : odds){
            System.out.println(no);
        }

    }

    //1. 첫 번째 시도: 녹색 사과 필터링
    public static List<Apple> filterGreenApples(List<Apple> inventory){
        List<Apple> result = new ArrayList<>();

        for(Apple apple : inventory){
            if(Color.GREEN.equals(apple.getColor())){
                result.add(apple);
            }
        }
        return result;
    }

    //2. 두 번째 시도: 색을 파라미터화
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(apple.getColor().equals(color)){
                result.add(apple);
            }
        }
        return result;
    }

    //3. 세 번째 시도: 가능한 모든 속성으로 필터링
    public static List<Apple> filterApples(List<Apple> inventory, Color color, int weight, boolean flag){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if((flag && apple.getColor().equals(color)) || (!flag && apple.getWeight() > weight)){
                result.add(apple);
            }
        }
        return result;
    }

    //4. 네 번째 시도: 추상적 조건으로 필터링
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p){
        List<Apple> result = new ArrayList<>();
        for(Apple apple : inventory){
            if(p.test(apple)){
                result.add(apple);
            }
        }
        return result;
    }

    //7. 일곱 번째 시도: 리스트 형식으로 추상화
    public static <T> List<T> filter(List<T> list, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T e : list){
            if(p.test(e))
                result.add(e);
        }
        return result;
    }

}
