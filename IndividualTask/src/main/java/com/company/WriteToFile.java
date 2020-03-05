package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteToFile {
    private static File file = new File("output.txt");

    public static void WriteToFile(ArrayList<Fruit> fruits) {
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter myWrite = new FileWriter("output.txt");
            for (Fruit f : fruits) {
                myWrite.write(f.toString());
                myWrite.write("\n");
            }
            myWrite.close();
            System.out.println("*****Successfully wrote to the file.*******");
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
