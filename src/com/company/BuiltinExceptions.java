package com.company;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BuiltinExceptions {
    public static void main(String[] args) {
        //processArithmeticException();
        //processInputMismatchException();
        //processIOException();
        //processArray();
        //processClass();
        //processField();
        processNullPointer();

    }
    //Деление на ноль
    static void processArithmeticException(){
        //Деление на ноль
        int a = 1, b;
        try {
            b = a / 0;
        } catch (ArithmeticException e) {
            System.err.println("Деление на ноль");
        }
    }

    //Ввод только целых чисел
    static void processInputMismatchException(){
        int a =0;
        while (a == 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a: ");
            try {
                a = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error, enter an integer number");
            }
        }
    }

    //Обработка исключения чтения из файла
    static void processIOException(){
        try {
            InputStream input = new FileInputStream("src\\data\\words.txt");
        } catch (FileNotFoundException e) {
           // e.printStackTrace();
            System.err.println("Fine not found");
        }
        System.out.println("File opened...");
    }

    //Выход за предел массива
    static void processArray(){
        int[] a = {1,2,3};
        try {
            int b = a[3];
        }catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Выход за пределы массива");
        }
    }

    //Проверка существования класса
    static void processClass()  {
        Class<?> clazz = null;
        try {
           clazz =  Class.forName("java.util.Random");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } System.out.println(clazz);
    }

    static void processField(){
        Person person = new Person();
        //Class<?> clazz = Person.class
        Class<?> clazz = person.getClass();
        try {
            Field field = clazz.getDeclaredField("name");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }

    static void processNullPointer(){
        Person person = null;
        try {
            person.getName();
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}
