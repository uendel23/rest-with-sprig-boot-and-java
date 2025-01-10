package br.com.del.rest_with_sprig_boot_and_java.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.nio.channels.UnresolvedAddressException;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UnsupportedMathOperationException extends RuntimeException{

    private static final long serialVersionUID =1L;


    public UnsupportedMathOperationException(String ex) {
        super(ex);
    }
}

