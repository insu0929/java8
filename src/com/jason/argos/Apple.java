/*
 * @(#)Apple.java $version 2022/02/18
 *
 */
package com.jason.argos;

/**
 * @author Insu Yang
 */
public class Apple {
    private Color color;
    private int weight;

    Apple(Color color){
        this.color = color;
    }
    Apple(Color color, int weight){
        this.color = color;
        this.weight = weight;
    }

    public int getWeight(){ return weight; }
    public Color getColor() {
        return color;
    }
}
