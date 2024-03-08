package com.mycompany.app;

import java.util.ArrayList;

public class App{
    
    public static boolean isSuccessful(ArrayList<Integer> term1Notes,ArrayList<Integer> term2Notes,ArrayList<String> term1Lectures,ArrayList<String> term2Lectures,int age,String fullName){
        if(fullName == null || fullName.isEmpty()){
            System.out.println("invalid name");
            return false;
        }
        if(fullName.trim().isEmpty()){
            System.out.println("invalid name");
            return false;
        }
        for(char c: fullName.toCharArray()){
            if(Character.isDigit(c)){
                System.out.println("invalid name");
                return false;
            }
        }
        if(age < 18 || age>100){
            System.out.println("student's age is not suitable");
            return false;
        }
        if (term1Notes == null || term1Notes.isEmpty() || term2Notes == null || term2Notes.isEmpty()) {
            System.out.println("student is not successful");
            return false;
        }

        for (int note1 : term1Notes) {
            if(note1 > 100 || note1<0){
                System.out.println("term1 notes are invalid");
                return false;
            }
        }
        for (int note2 : term2Notes) {
            if(note2 > 100 || note2<0){
                System.out.println("term2 notes are invalid");
                return false;
            }
        }

        int total1 = 0;
        for (int note1 : term1Notes) {
            total1 += note1;
        }
        double average1 = (double) total1 / term1Notes.size();
        System.out.println("average of first term notes: " + average1);

        int total2 = 0;
        for (int note2 : term2Notes) {
            total2 += note2;
        }
        double average2 = (double) total2 / term2Notes.size();
        System.out.println("average of second term notes: " + average2);

        System.out.println("Students First Term Lectures:");
        System.out.println("+-------------------------+");
        System.out.println("| Lectures                |");
        System.out.println("+-------------------------+");
        for (String lecture : term1Lectures) {
            System.out.printf("| %-23s|%n", lecture);
        }
        System.out.println("+-------------------------+");
        System.out.println("\nStudents Second Term Lectures:");
        System.out.println("+-------------------------+");
        System.out.println("| Lectures                |");
        System.out.println("+-------------------------+");
        for (String lecture : term2Lectures) {
            System.out.printf("| %-23s|%n", lecture);
        }
        System.out.println("+-------------------------+");

        if(average1 >= 85){
            System.out.println("student succeeds first semester");
        }
        else{
            System.out.println("student was not successful in the first semester");
        }
        if(average2 >= 85){
            System.out.println("student succeeds second semester");
        }
        else{
            System.out.println("student was not successful in the second semester");
        }

        double average = (average1+average2)/2;
        if(average < 85){
            System.out.println("student is not successful");
            return false;
        }

        return true;
    }
}