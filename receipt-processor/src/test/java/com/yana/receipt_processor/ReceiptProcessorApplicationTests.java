package com.yana.receipt_processor;
import com.yana.receipt_processor.entities.Item;
import com.yana.receipt_processor.entities.Receipt;
import com.yana.receipt_processor.services.ReceiptService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ReceiptProcessorApplicationTests {

	@Test
     void testCalculatePoints() {
		ReceiptService receiptService = new ReceiptService();
			Receipt receipt = new Receipt(
					"Target",
					"2022-01-01",
					"13:01",
					Arrays.asList(
							new Item("Mountain Dew 12PK", "6.49"),
							new Item("Emils Cheese Pizza", "12.25"),
							new Item("Knorr Creamy Chicken", "1.26"),
							new Item("Doritos Nacho Cheese", "3.35"),
							new Item("Klarbrunn 12-PK 12 FL OZ", "12.00")
					),
					"35.35"
			);

			int points = receiptService.calculatePoints(receipt);
			assertEquals(28, points);
		}
	}

