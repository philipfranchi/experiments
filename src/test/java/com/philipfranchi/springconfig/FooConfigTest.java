package com.philipfranchi.springconfig;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Import(FooConfing.class)
public class FooConfigTest {

    @Autowired
    private Foo foo;

    @Test
    public void canPrintFoo() {
        foo.speak();
    }
}
