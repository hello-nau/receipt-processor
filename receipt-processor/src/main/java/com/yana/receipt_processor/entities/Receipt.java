package com.yana.receipt_processor.entities;
import lombok.Data;

import java.util.List;

@Data
public class Receipt {
    private String retailer;
    private String purchaseDate;
    private String purchaseTime;
    private List<Item> itemList;
    private String totalPaid;
    private String id;

    public Receipt(String retailer, String purchaseDate, String purchaseTime, List<Item> itemList, String totalPaid) {
        this.retailer = retailer;
        this.purchaseDate = purchaseDate;
        this.purchaseTime = purchaseTime;
        this.itemList = itemList;
        this.totalPaid = totalPaid;
    }

    public String getRetailer() {
        return retailer;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public String getTotalPaid() {
        return totalPaid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
