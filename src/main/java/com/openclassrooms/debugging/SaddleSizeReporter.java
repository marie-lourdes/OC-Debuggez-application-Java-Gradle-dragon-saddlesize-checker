package com.openclassrooms.debugging;

public class SaddleSizeReporter {
    private int targetYear;
    private double beltSize;

    public SaddleSizeReporter(int targetYear, double beltSize) {
        this.targetYear = targetYear;
        this.beltSize = beltSize;
    }

    public void report() {
        System.out.println("En l'an " +
                targetYear +
                ", les dragons nes en l'an 1 auront une taille de selle de " +
                beltSize / 100 + " metres" +
                "(" + beltSize + " centimetres)"
        );
    }
}