package com.vvr.java8.lambdas;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.sql.SQLOutput;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.*;

public class FIFromAPI {
    public static void main(String args[]) {
        FIFromAPI fiAPI = new FIFromAPI();
        fiAPI.predicate();
        fiAPI.supplier();
        fiAPI.consumer();
        fiAPI.function();
        fiAPI.unaryBinaryOperator();
    }

    public void predicate() {
        // Predicate<T>
        // boolean test(T t)
        Predicate<String> pStr = s -> s.contains("City");
        System.out.println(pStr.test("Vatican City"));
        // BiPredicate<T, U>
        // boolean test(T t, U u)
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("Vactican City", 8));
    }

    public void supplier() {
        // Supplier<T>
        // T get()
        Supplier<StringBuilder> supSB = () -> new StringBuilder();
        System.out.println("Supplier SB: " + supSB.get().append("SK"));

        Supplier<LocalTime> supTime = () -> LocalTime.now();
        System.out.println("Supplier time: " + supTime.get());

        Supplier<Double> sRandom = () -> Math.random();
        System.out.println(sRandom.get());
    }

    public void consumer() {
        // Consumer<T>
        // void accept(T t)
        Consumer<String> printC = s -> System.out.println(s);
        printC.accept("To be or not to be, that is the question");

        List<String> names = new ArrayList<>();
        names.add("John");
        names.add("Mary");
        names.forEach(printC);
        // BiConsumer<T, U>
        // void accept(T t, U u)
        var mapCapitalCities = new HashMap<String, String>();
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        biCon.accept("Dublin", "Ireland");
        biCon.accept("Washington D.C.", "USA");
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) -> System.out.println(key + " is the capital of: " + value);
        mapCapitalCities.forEach(mapPrint);
    }

    public void function() {
        // Function <T, R>
        // R apply(T t)
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("Moscow"));
        // BiFunction <T, U, R>
        // R apply(T t, U u)
        BiFunction<String, String, Integer> biFun = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFun.apply("William", "Shakespeare"));

        BiFunction<String, String, String> biFn2 = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("William", "Shakespeare"));
    }

    public void unaryBinaryOperator() {
        // UnaryOperator<T>
        // T apply(T t)
        UnaryOperator<String> unaryOp = name -> "My name is " + name;
        System.out.println("UnaryOperator:" + unaryOp.apply("Sean"));
        // BinaryOperator<T>
        // T apply(T t1, T t2)
        BinaryOperator<String> binaryOp = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply("William ", "Shakespeare"));
    }
}
