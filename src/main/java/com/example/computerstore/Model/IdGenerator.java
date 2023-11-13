package com.example.computerstore.Model;

import java.util.concurrent.atomic.AtomicInteger;

public class IdGenerator {
    private static final AtomicInteger customerId = new AtomicInteger(0);
    private static final AtomicInteger orderHistoryId = new AtomicInteger(0);
    private static final AtomicInteger categoryId = new AtomicInteger(0);

    private static final AtomicInteger productId = new AtomicInteger(0);

    public static int getNextCustomerId() {
        return customerId.incrementAndGet();
    }

    public static int getNextOrderHistoryId() {
        return orderHistoryId.incrementAndGet();
    }

    public static int getNextCategoryId() {
        return categoryId.incrementAndGet();
    }


    public static int getNextProductId() {
        return productId.incrementAndGet();
    }

    public static int getNextId(String entityType) {
        switch (entityType.toLowerCase()) {
            case "customer":
                return getNextCustomerId();
            case "orderHistory":
                return getNextOrderHistoryId();
            case "category":
                return getNextCategoryId();
            case "product":
                return getNextProductId();
            default:
                throw new IllegalArgumentException("Invalid entity type: " + entityType);
        }
    }
}
