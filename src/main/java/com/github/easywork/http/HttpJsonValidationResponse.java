package com.github.easywork.http;

import com.github.easywork.domain.error.ValidationError;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * Created by lgs on 16-5-31.
 */
@Data
public class HttpJsonValidationResponse{

    protected List<ValidationError> errors = Lists.newLinkedList();

    public HttpJsonValidationResponse addValidationError(String field, Object rejectedValue, String message) {
        ValidationError validationError = new ValidationError(field, rejectedValue, message);
        errors.add(validationError);
        return this;
    }

    public HttpJsonValidationResponse addValidationError(String message) {
        ValidationError validationError = new ValidationError();
        errors.add(validationError);
        return this;
    }


}
