package com.philipfranchi.hibernateValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringValidator implements ConstraintValidator<StringInSet, String> {
    private Set<String> set = new HashSet<>(Arrays.asList("a", "b", "c"));
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
