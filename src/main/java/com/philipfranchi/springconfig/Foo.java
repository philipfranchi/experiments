package com.philipfranchi.springconfig;

public class Foo {

    private final SubContentModule subContentModule;

    public Foo(SubContentModule subContentModule) {
        this.subContentModule = subContentModule;
    }

    public void speak() {
        System.out.println("Hello from " + subContentModule.getName());
    }
}
