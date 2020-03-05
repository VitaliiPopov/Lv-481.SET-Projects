package com.company;

import java.util.Scanner;

public class Fruit implements Comparable<Fruit>
{
    private String name;
    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Fruit() {}
    public Fruit(String name, String color){
        this.name = name;
        this.color = color;
    }

    public void Input(){
        Scanner in = new Scanner(System.in);
        System.out.println("Choose fruit: ");
        setName(in.nextLine());
        System.out.println("Choose color of fruit: ");
        setColor(in.nextLine());
    }

    @Override
    public String toString()
    {
        return String.format("Fruit - " + name + " has " + color + " color.");
    }

    @Override
    public int compareTo(Fruit otherFruit)
    {
        return name.compareTo(otherFruit.name);
    }

    public void Output()
    {
        System.out.println(this.toString());
    }
}
