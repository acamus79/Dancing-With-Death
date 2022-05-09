package com.aec.dwd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Adrian E. Camus
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ParamNotFound extends RuntimeException {

    /**
     * Up string msg
     * @param error
     */
    public ParamNotFound(String error) {
        super(error);
    }
}