package com.codingfist.burninghouseuser.common.error.exception;


import com.codingfist.burninghouseuser.common.error.model.ErrorCode;

public class DateWrongException extends BusinessException {
    public DateWrongException(String value) {
        super(value, ErrorCode.DATE_WRONG);
    }
}
