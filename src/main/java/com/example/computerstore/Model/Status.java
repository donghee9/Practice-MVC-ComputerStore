package com.example.computerstore.Model;

public enum Status {
    PENDING,        // 주문 대기 중
    CONFIRMED,      // 주문 확인됨
    SHIPPED,        // 배송 중
    DELIVERED,      // 배송 완료
    CANCELED        // 주문 취소
}