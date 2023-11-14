package com.example.computerstore.Exception;

public class ProductMatchException extends Exception {

    public ProductMatchException(ErrorCode errorCode) {
        super(errorCode.getDescription());
    }

    public static ProductMatchException forId(int productId) {
        return new ProductMatchException(ErrorCode.PRODUCT_ID_NOT_MATCH);
    }

    public static ProductMatchException forName(String productName) {

        return new ProductMatchException(ErrorCode.PRODUCT_NAME_NOT_MATCH);
    }

    public static ProductMatchException stockShortage(int productId, int requestedQuantity, int availableStock) {
        return new ProductMatchException(ErrorCode.INSUFFICIENT_STOCK_QUANTITY);
    }
}
