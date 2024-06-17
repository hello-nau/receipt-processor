package com.yana.receipt_processor.entities.responses;

public class ReceiptResponse {
    String id;

    public ReceiptResponse(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
