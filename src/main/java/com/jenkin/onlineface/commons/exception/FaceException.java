package com.jenkin.onlineface.commons.exception;

import com.jenkin.onlineface.commons.enums.exception.ExceptionEnum;
import lombok.Data;
import org.springframework.util.StringUtils;

import static com.jenkin.onlineface.commons.enums.exception.ExceptionEnum.ERROR_EXCEPTION;


/**
 * @author jenkin
 */
public class FaceException extends RuntimeException {
    private static final FaceException systemException = new FaceException(ERROR_EXCEPTION,ERROR_EXCEPTION.getDesc());
    private ExceptionEnum type;
    private String msg;

    /**
     * Constructs a new runtime exception with {@code null} as its
     * detail message.  The cause is not initialized, and may subsequently be
     * initialized by a call to {@link #initCause}.
     */
    public FaceException(ExceptionEnum type, String msg) {
        super(StringUtils.isEmpty(msg)?type.getDesc():msg);
        this.type = type;
        this.msg = StringUtils.isEmpty(msg)?type.getDesc():msg;
    }

    public static FaceException systemException(String msg ){
        return  new FaceException(ERROR_EXCEPTION,msg==null?ERROR_EXCEPTION.getDesc():msg);
    }

    public ExceptionEnum getType() {
        return type;
    }

    private void setType(ExceptionEnum type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    private void setMsg(String msg) {
        this.msg = msg;
    }
}
