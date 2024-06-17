package com.yana.receipt_processor.entities.responses;

public class PointResponse {
    private int points;

    public PointResponse(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
