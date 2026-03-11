package com.kodilla.exception.test;

public class ExceptionHandling {

    public void secondChallengeHandling() {
        SecondChallenge secondChallenge = new SecondChallenge();

        try {
            String result = secondChallenge.probablyIWillThrowException(1.5, 1.4);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("Error" + e);
        } finally {
            System.out.println("Koniec");
        }
    }
}
