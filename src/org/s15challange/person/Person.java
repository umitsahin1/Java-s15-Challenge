package org.s15challange.person;

public abstract class Person {
    private String name;

    //Constructors
    public Person(String name) {
        this.name = name;
    }

    //Getters
    public String getName() {
        return name;
    }

    //Methods
    public abstract void whoYouAre();
}
