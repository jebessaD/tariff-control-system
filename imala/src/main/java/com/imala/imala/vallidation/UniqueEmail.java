package com.imala.imala.vallidation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy =UniqueEmailValidator.class)
@Documented
public @interface UniqueEmail {
    

    String message() default "not working";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
