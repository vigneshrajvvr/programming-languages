package com.vvr.java8.lambdas;

interface I {
    void m();
}

public class BasicLambda {
    public void main(String args[]) {
        // pre-Java 8
        I i = new I() {
            @Override
            public void m() {
                System.out.println("I::m()");
            }
        };

        i.m();
        // Java 8
        I lambdaI1 = () -> {
            System.out.println("Lambda expression 1");
        };

        I lambdaI2 = () -> System.out.println("Lambda expression 2");

        lambdaI1.m();
        lambdaI2.m();
    }
}
