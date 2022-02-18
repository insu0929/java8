/*
 * @(#)AppleRedAndHeavyPredicate.java $version 2022/02/18
 *
 */
package com.jason.argos;

/**
 * @author Insu Yang
 */
public class AppleRedAndLightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.RED.equals(apple.getColor()) && apple.getWeight() < 5;
    }
}
