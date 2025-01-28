package org.s15challange;

public abstract class Person {
    private String name;

    public abstract void whoYouAre();

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
