package com.example.studentmanagement.test;

public class Bird extends Animal implements AnimalInterface{

    @Override
    void sound() {
        System.out.println("bay bay");
    }

    @Override
    public void fly() {
        System.out.println("sai canh");
    }
}
