package com.philipfranchi.hibernateValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringInSetValidator implements ConstraintValidator<StringInSet, String> {

    private Set<String> goodValueSet = new HashSet<>(Arrays.asList("a", "b", "c"));

    @Override
    public void initialize(StringInSet constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if(value == null || value.isEmpty() || !goodValueSet.contains(value)) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("String is not in set {a,b,c}")
                    .addPropertyNode("name")
                    .addConstraintViolation();
            return false;
        }
        return true;
    }
}
