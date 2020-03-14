package com.company.Tools;

import com.company.Fruit;
import com.company.FruitList;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);
    private static FruitList fruitList = new FruitList();
    private static ArrayList<Fruit> fruit = new ArrayList<>();

    public void Start(){
        while (true){
            System.out.println("\n*****************************\n" +
                    "Select an item from the menu:\n" +
                    "1. Initialize by default.\n" +
                    "2. Output the collection.\n" +
                    "3. Add new fruit.\n" +
                    "4. Add new citrus.\n" +
                    "5. Output information about yellow fruit\n" +
                    "6. Sort the collection.\n" +
                    "7. Write the collection to a file.\n" +
                    "8. Serialize the collection to XML.\n" +
                    "9. Deserialize the collection from XML.\n" +
                    "0 - to exit the program\n" +
                    "***********************\n");
            try {
                switch (scanner.nextByte()){
                    case 0:
                        System.out.println("Are you sure?\n" + "1 - Yes\n");
                        if(scanner.nextInt() == 1){
                            return;
                        }else{
                            break;
                        }
                    case 1:
                        fruitList.InitializeList(fruit);
                        break;
                    case 2:
                        fruitList.ConsoleOutput(fruit);
                        break;
                    case 3:
                        fruitList.AddNewFruitToList(fruit);
                        break;
                    case 4:
                        fruitList.AddNewCitrusToList(fruit);
                        break;
                    case 5:
                        fruitList.OutputYellowFruits(fruit);
                        break;
                    case 6:
                        fruitList.SortFruitList(fruit);
                        break;
                    case 7:
                        fruitList.WriteListToFile(fruit);
                        break;
                    case 8:
                        FruitList.SerializeListToXML(fruit);
                        break;
                    case 9:
                        FruitList.DeserializeListFromXML(fruit);
                        break;
                    default:
                        System.out.println("Enter valid data");
                        break;
                }
            }catch (InputMismatchException e){
                System.out.println("Enter valid data");
            }
        }
    }
}