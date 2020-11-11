package com.atshop.security.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class ValidateUtil {
    private static ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    public Object validate(Object obj){
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<Object>> validate = validator.validate(obj);
        List<String> msgs=new ArrayList<>();
        for (ConstraintViolation<Object> item :
                validate) {
            msgs.add(item.getMessage());
        }
        return msgs;
    }
}
