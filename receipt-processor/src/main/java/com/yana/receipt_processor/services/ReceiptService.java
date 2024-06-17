package com.yana.receipt_processor.services;

import com.yana.receipt_processor.entities.Item;
import com.yana.receipt_processor.entities.Receipt;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class ReceiptService {
    private Map<String, Integer> idPoints = new HashMap<>();
    public String processReceipt(Receipt receipt) {
        String id = UUID.randomUUID().toString();
        int points = calculatePoints(receipt);
        idPoints.put(id, points);
        receipt.setId(id);
        return id;
    }
    public int calculatePoints(Receipt receipt) {
        int points = 0;
        points += receipt.getRetailer().replaceAll("[^a-zA-Z0-9]", "").length();
        double total = Double.parseDouble(receipt.getTotal());
        if (total % 1 == 0) points += 50;
        if (total % 0.25 == 0) points += 25;
        points += (receipt.getItems().size() / 2) * 5;

        for (Item item : receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                double itemPrice = Double.parseDouble(item.getPrice());
                points += Math.ceil(itemPrice * 0.2);
            }
        }

        String[] dateParts = receipt.getPurchaseDate().split("-");
        int day = Integer.parseInt(dateParts[2]);
        if (day % 2 != 0) points += 6;

        String[] timeParts = receipt.getPurchaseTime().split(":");
        int hour = Integer.parseInt(timeParts[0]);
        if (hour >= 14 && hour < 16) points += 10;

        return points;
    }
    public int getPoints(String id) {
        return idPoints.containsKey(id) ? idPoints.get(id) : 0;
    }
}
