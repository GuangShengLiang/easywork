package com.github.easywork.json;

import com.github.easywork.domain.error.ValidationError;
import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class JsonValidationResponse extends JsonResponse {

    protected List<ValidationError> errors = Lists.newLinkedList();

    public JsonValidationResponse addValidationError(String field, Object rejectedValue, String message) {
        ValidationError validationError = new ValidationError(field, rejectedValue, message);
        errors.add(validationError);
        return this;
    }

    public JsonValidationResponse addValidationError(String message) {
        ValidationError validationError = new ValidationError();
        errors.add(validationError);
        return this;
    }


}
