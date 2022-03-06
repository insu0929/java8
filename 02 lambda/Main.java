package com.jason.argos;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Comparator<Integer> rev = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };

        Comparator<Integer> revLambda = (Integer o1, Integer o2) -> o2.compareTo(o1);

        //유효 람다 표현식

        IntPredicate evenNos = (int i) -> i % 2 == 0;
        evenNos.test(1000);

        int no = 1;

        final int no1 = 1;
        int no2 = 2; //effective final

        //익
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int no = 19;
                return o1.compareTo(no);
            }
        };


        //람다
        Comparator<Integer> com = (o1, o2) ->{
            return o1.compareTo(no);
        };

        //익명 클래스, nested class, 함수
        // 람다만 안됨
        SimpleThread thread1;
        // thread = gc.reiwrjw thread1 메모리 해제됨 (힙에 없음)

        SimpleThread thread2;
        SimpleThread thread3;


    }

    public class SimpleThread implements Runnable{
        @Override
        public void run() {
            int no = 1;

            IntConsumer com = (int i) -> {
                System.out.println(i + no);
            };

            no++;
        }
    }
}
