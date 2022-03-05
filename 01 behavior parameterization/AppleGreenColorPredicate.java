/*
 * @(#)AppleGreenColorPredicate.java $version 2022/02/18
 *
 */
package com.jason.argos;

/**
 * @author Insu Yang
 */
public class AppleGreenColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        return Color.GREEN.equals(apple.getColor());
    }
}
