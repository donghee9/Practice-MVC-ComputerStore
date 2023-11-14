package com.example.computerstore.Exception;

public class CertifiedUserException extends Exception {

    public CertifiedUserException(ErrorCode errorCode) {
        super(errorCode.getDescription());
    }

    public static CertifiedUserException forUserId(String userId) {
        return new CertifiedUserException(ErrorCode.USER_NOT_FOUND);
    }
}
