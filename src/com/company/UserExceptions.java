package com.company;

import java.util.Scanner;

public class UserExceptions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number from 1 to 9");
        int a = scanner.nextInt();
        try {
            validateNumber(a);
        } catch (FromOneToNineException e) {
            e.printStackTrace();
        }
        try {
            validateNumberEven(a);
        } catch (FromOneToNineException e) {
            e.printStackTrace();
        }
    }

    static void validateNumber(int a) throws FromOneToNineException {
        if (a<1 || a>9) throw new FromOneToNineException("From 1 to 9");
    }

    static void validateNumberEven(int a) throws FromOneToNineException {
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        if (a%2==0) throw new FromOneToNineException("Even");
    }
}

class FromOneToNineException extends Exception{
    public FromOneToNineException(String message) {
        super(message);
    }
}


