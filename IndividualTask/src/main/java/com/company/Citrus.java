package com.company;

import java.util.Scanner;

public class Citrus extends Fruit {
    private double vitaminC;

    public double getVitaminC() {
        return vitaminC;
    }

    public void setVitaminC(double vitaminC) {
        this.vitaminC = vitaminC;
    }

    public Citrus(){}

    public Citrus(String name, String color, double vitaminC){
        super(name, color);
        this.vitaminC = vitaminC;
    }

    @Override
    public void Input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Choose fruit: ");
        setName(in.nextLine());
        System.out.println("Choose color of fruit: ");
        setColor(in.nextLine());
        System.out.println("Choose how many grams contain citrus: ");
        setVitaminC(in.nextDouble());
    }
    @Override
    public String toString(){
        return String.format("Fruit - " + getName() + " has " + getColor() + " color and contain " + getVitaminC() + " grams of VitaminC.");
    }
    @Override
    public void Output()
    {
        System.out.println(this.toString());
    }
}
