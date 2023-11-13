package com.example.computerstore.Exception;

public class CertifiedUserException extends Exception {


    public CertifiedUserException(String message) {
        super(message);
    }

    public static CertifiedUserException forUserId(String userId) {
        return new CertifiedUserException("사용자 " + userId + "에 대한 인증에 실패했습니다.");
    }
}
