package com.aec.dwd.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ParamNotFound extends RuntimeException {

    public ParamNotFound(String error) {
        super(error);
    }
}