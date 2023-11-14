package com.example.computerstore.Exception;

public class AdminMatchException extends Exception {

    public AdminMatchException(ErrorCode errorCode) {
        super(errorCode.getDescription());
    }

    public static AdminMatchException forId(String adminId) {
        return new AdminMatchException(ErrorCode.ADMIN_NOT_FOUND);
    }
}
