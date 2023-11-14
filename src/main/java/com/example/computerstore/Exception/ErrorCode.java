package com.example.computerstore.Exception;

public enum ErrorCode {
    USER_NOT_FOUND(100, "User not found"),
    INVALID_INPUT(101, "Invalid input provided"),
    DATABASE_ERROR(102, "Database error occurred"),
    PRODUCT_NAME_NOT_MATCH(103, "Product does not match"),
    PRODUCT_ID_NOT_MATCH(104, "Product ID does not match"),
    ADMIN_NOT_FOUND(105, "Admin not found"),
    INSUFFICIENT_STOCK_QUANTITY(106, "Insufficient stock quantity");

    private final int code;
    private final String description;

    ErrorCode(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}