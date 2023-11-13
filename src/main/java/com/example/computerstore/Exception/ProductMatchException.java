package com.example.computerstore.Exception;

public class ProductMatchException extends Exception {

    public static ProductMatchException forId(int productId) {
        return new ProductMatchException("ID " + productId + "에 해당하는 제품을 찾을 수 없습니다.");
    }

    public static ProductMatchException forName(String productName) {
        return new ProductMatchException("제품명 '" + productName + "'에 해당하는 제품을 찾을 수 없습니다.");
    }

    public static ProductMatchException stockShortage(int productId, int requestedQuantity, int availableStock) {
        String message = String.format("제품 ID %d의 요청된 수량(%d)이 현재 재고(%d)를 초과합니다.", productId, requestedQuantity, availableStock);
        return new ProductMatchException(message);
    }
    public ProductMatchException(String message) {
        super(message);
    }
}