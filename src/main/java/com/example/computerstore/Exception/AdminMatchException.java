package com.example.computerstore.Exception;

public class AdminMatchException extends Exception {

    public AdminMatchException(String message) {
        super(message);
    }

    public static AdminMatchException forId(String adminId) {
        String message = "관리자 ID '" + adminId + "' 인증에 실패했습니다. 관리자 ID를 확인하세요.";
        return new AdminMatchException(message);
    }
}