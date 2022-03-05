/*
 * @(#)AppleHeavyWeightPredicate.java $version 2022/02/18
 *
 */
package com.jason.argos;

/**
 * @author Insu Yang
 */
public class AppleHeavyWeightPredicate implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 5;
    }
}
