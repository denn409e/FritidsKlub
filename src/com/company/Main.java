package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.ClassNotFoundException;

public class Main {

    private static int antalVare = 5;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        VareData[] shoppingList = new VareData[5];

        shoppingList = textTilArray();

        printArray(shoppingList);

        lavDataFile(shoppingList);

        File file = new File("varer.ser");

        shoppingList = dataFilTilArray(file);

        printArray(shoppingList);

    }

    public static VareData[] textTilArray() throws IOException {

        File bestilling = new File("src/com/company/bestilling.txt");
        Scanner input = new Scanner(bestilling);
        VareData[] shoppingList = new VareData[5];

        for (int i = 0; i < antalVare; i++) {
            shoppingList[i] = new VareData(input.nextInt(), input.next(), input.nextDouble() );
        }
        input.close();
        return shoppingList;
    }
    public static void printArray (VareData[] array){

        for (VareData data : array) {
            System.out.println(data.getAntal() +  " stk. " + data.getVareName() + " til en stykpris på " + data.getStykPris());
        }
    }
    public static void lavDataFile(VareData[] shoppingList) throws IOException {

        File varer = new  File("varer.ser");

        if (varer.createNewFile()){
            System.out.println("File created " + varer.getName());
        } else {
            System.out.println("File already exist");
        }
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(varer));
        for (VareData list : shoppingList) {
            output.writeObject(list);
        }
        output.close();


    }
    public static VareData[] dataFilTilArray(File data) throws IOException, ClassNotFoundException {

        ObjectInputStream input = new ObjectInputStream(new FileInputStream(data));
        List<VareData> list = new ArrayList<>();
        try {
            for (; ; ) {
                list.add((VareData) input.readObject());
            }
        } catch (EOFException exc) {

        }


        input.close();

        VareData[] vareData = new VareData[list.size()];
        for (int i = 0; i < list.size(); i++) {
            vareData[i] = list.get(i);
        }
        return vareData;
    }

}
