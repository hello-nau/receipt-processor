package com.yana.receipt_processor.controllers;

import com.yana.receipt_processor.entities.Receipt;
import com.yana.receipt_processor.services.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    @Autowired
    ReceiptService receiptService;
    @PostMapping("/process")
    public ResponseEntity<?> processReceipt(@RequestBody Receipt receipt) {
        try {
            String id = receiptService.processReceipt(receipt);
            return ResponseEntity.ok(new ReceiptResponse(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The receipt is invalid");
        }
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<?> getPoints(@PathVariable String id) {
        int points = receiptService.getPoints(id);
        if (points == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("No receipt found for that id");
        }
        return ResponseEntity.ok(new PointResponse(points));
    }
}
