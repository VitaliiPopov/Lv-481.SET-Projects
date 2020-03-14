package com.company;

import java.util.Objects;
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
        return "Fruit - " + name + " has " + color + " color.";
    }

    @Override
    public int compareTo(Fruit otherFruit)
    {
        return name.compareTo(otherFruit.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return name.equals(fruit.name) &&
                color.equals(fruit.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }

    public void Output()
    {
        System.out.println(this.toString());
    }
}
