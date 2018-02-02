package com.philipfranchi.hibernateValidator;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class hibernateValidatorTest {

    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void shouldFailWithNameNotInSet() {
        Foo foo = new Foo(new HashSet<>(Arrays.asList("bad")));
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(foo);
        constraintViolations.iterator().forEachRemaining(c -> System.out.println(c.getMessage()));
        assertEquals(1, constraintViolations.size());
    }

    @Test
    public void shouldSucceedWithGoodSet() {
        Foo foo = new Foo(new HashSet<>(Arrays.asList("a")));
        Set<ConstraintViolation<Foo>> constraintViolations = validator.validate(foo);
        assertEquals(0, constraintViolations.size());
    }
}