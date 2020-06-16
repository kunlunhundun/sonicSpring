package com.tiandihui.cmd.common.exception;

import com.tiandihui.cmd.common.api.IErrorCode;

public class Asserts {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }


}
