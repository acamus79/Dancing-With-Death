package com.aec.dwd.exception;

/**
 * @author Adrian E. Camus
 */
public class ParamBadRequest extends RuntimeException{

    /**
     * Up string msg
     * @param message
     */
    public ParamBadRequest(String message){
        super(message);
    }
}
