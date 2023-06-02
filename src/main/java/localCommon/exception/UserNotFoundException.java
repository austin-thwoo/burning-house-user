package localCommon.exception;


import globalCommon.error.exception.BusinessException;
import globalCommon.error.model.ErrorCode;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BusinessException {
    public  UserNotFoundException(String value, HttpStatus badRequest) {
        super(value, ErrorCode.USER_NOT_FOUND,badRequest);
    }
}
