package br.com.del.rest_with_sprig_boot_and_java.exceptions;

import java.io.Serializable;
import java.util.Date;

public class ExceptionResponse implements Serializable {

    private static final long serialVersionUID =1L;

    private Date timestamp;
    private String message;
    private String details;

    public ExceptionResponse( Date timestamp,String mensage, String details) {
        this.message = mensage;
        this.timestamp = timestamp;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
