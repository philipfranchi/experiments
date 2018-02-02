package com.philipfranchi.hibernateValidator;

import javax.validation.Valid;
import java.util.Set;

public class Foo {

    @Valid
    private Set<@StringInSet String> names;

    public Foo(Set<String> names) {
        this.names = names;
    }
}