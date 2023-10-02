package org.example;

class Human {
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("My name is " + name + " and I am " + age + " years old.");
    }
}

class Builder extends Human {
    private String profession;

    public Builder(String name, int age, String profession) {
        super(name, age);
        this.profession = profession;
    }

    public void build() {
        System.out.println("I am a " + profession + " and I can build things.");
    }
}

class Sailor extends Human {
    private String shipName;

    public Sailor(String name, int age, String shipName) {
        super(name, age);
        this.shipName = shipName;
    }

    public void sail() {
        System.out.println("I am a sailor on the ship named " + shipName + ".");
    }
}

class Pilot extends Human {
    private String aircraftModel;

    public Pilot(String name, int age, String aircraftModel) {
        super(name, age);
        this.aircraftModel = aircraftModel;
    }

    public void fly() {
        System.out.println("I am a pilot flying " + aircraftModel + ".");
    }
}
