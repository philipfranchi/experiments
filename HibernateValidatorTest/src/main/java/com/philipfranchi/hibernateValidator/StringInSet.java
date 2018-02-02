package com.philipfranchi.hibernateValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Constraint(validatedBy = StringInSetValidator.class)
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE, TYPE, TYPE_USE })
@Retention(RetentionPolicy.RUNTIME)
public @interface StringInSet {
    String message() default "String is not in set";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}