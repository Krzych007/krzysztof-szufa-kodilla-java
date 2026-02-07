package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {
    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")){
            System.out.println("Test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        int sum = calculator.add(6, 3);

        if (sum == 6+3){
            System.out.println("Test OK");
        } else {
            System.out.println("Error!");
        }

        int sub = calculator.subtract(9, 5);

        if (sub == 9-5){
            System.out.println("Test OK");
        } else {
            System.out.println("Error!");
        }
    }
}
