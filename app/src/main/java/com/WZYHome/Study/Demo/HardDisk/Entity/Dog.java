package com.WZYHome.Study.Demo.HardDisk.Entity;

/**
 * Created by Administrator on 2017/12/21.
 */

public class Dog {
    private String name;
    private String food;

    public Dog(String name, String food) {
        this.name = name;
        this.food = food;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}
