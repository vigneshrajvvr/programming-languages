package com.vvr.java8.lambdas;

import java.util.function.Predicate;

public class TestPredicate {
    public static void main(String[] args) {
        Evaluate<Integer> lambda = i -> i < 0;

        System.out.println("Evaluate : " + lambda.isNegative(-1));
        System.out.println("Evaluate : " + lambda.isNegative(+1));

        // Predicate<T> Functional Interface
        // boolean test(T t);
        Predicate<Integer> predicate = i -> i < 0;

        System.out.println("Evaluate : " + predicate.test(-1));
        System.out.println("Evaluate : " + predicate.test(+1));

        int x = 4;
        System.out.println("Is " + x + " even? " + check(x, n -> n % 2 == 0));
        x = 7;
        System.out.println("Is " + x + " even? " + check(x, n -> n % 2 == 0));

        String name="Mr. Joe Bloggs";
        System.out.println("Does " + name + " start with Mr. ? " + check(name, s -> s.startsWith("Mr.")));
        name="Ms. Ann Bloggs";
        System.out.println("Does " + name + " start with Mr. ? " + check(name, s -> s.startsWith("Mr.")));
    }

    public static <T> boolean check(T t, Predicate<T> lambda) {
        return lambda.test(t);
    }
}

// Custom Functional Interface
@FunctionalInterface
interface Evaluate<T> {
    boolean isNegative(T t);
}