package com.aec.dwd.exception;

/**
 * @author Adrian E. Camus <https://acamus79.github.io/>
 */
public class ParamBadRequest extends RuntimeException{

    public ParamBadRequest(String message){
        super(message);
    }
}
