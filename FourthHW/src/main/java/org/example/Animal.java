package org.example;

class Animal {
    private String name;
    private int age;

    private String sound;

    public Animal(String name, int age, String sound) {
        this.name = name;
        this.age = age;
        this.sound = sound;
    }
    public void eat() {
        System.out.println(name + " is eating.");
    }

    public void sleep() {
        System.out.println(name + " is sleeping.");
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
    public void makeSound(){
        System.out.println(name + " makes sound " + sound);
    }
}

class Tiger extends Animal {
    public Tiger(String name, int age, String sound) {
        super(name, age, sound);
    }

    public void hunt() {
        System.out.println(getName() + " the tiger is hunting.");
    }
}