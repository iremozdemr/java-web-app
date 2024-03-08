package com.mycompany.app;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import spark.ModelAndView;
import spark.template.mustache.MustacheTemplateEngine;

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

    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        get("/", (req, res) -> {
            Map<String, Object> map = new HashMap<>();
            map.put("isSuccess", "not evaluated yet!");
            return new ModelAndView(map, "index.html");
        }, new MustacheTemplateEngine());

        post("/evaluate", "application/json", (req, res) -> {
            ArrayList<Integer> term1Notes = new ArrayList<>();
            ArrayList<Integer> term2Notes = new ArrayList<>();
            ArrayList<String> term1Lectures = new ArrayList<>();
            ArrayList<String> term2Lectures = new ArrayList<>();
            int age = 0;
            String fullName = "";
        
            try {
                String[] term1NotesStr = req.queryParams("term1Notes").split(",");
                String[] term2NotesStr = req.queryParams("term2Notes").split(",");
                String[] term1LecturesStr = req.queryParams("term1Lectures").split(",");
                String[] term2LecturesStr = req.queryParams("term2Lectures").split(",");
        
                for (String note : term1NotesStr) {
                    term1Notes.add(Integer.parseInt(note.trim()));
                }
                for (String note : term2NotesStr) {
                    term2Notes.add(Integer.parseInt(note.trim()));
                }
                for (String lecture : term1LecturesStr) {
                    term1Lectures.add(lecture.trim());
                }
                for (String lecture : term2LecturesStr) {
                    term2Lectures.add(lecture.trim());
                }
        
                age = Integer.parseInt(req.queryParams("age").trim());
                fullName = req.queryParams("fullName").trim();
            } catch (NumberFormatException e) {
                res.status(400);
                return new ModelAndView(null, "index.html");
            }
        
            boolean isSuccess = isSuccessful(term1Notes, term2Notes, term1Lectures, term2Lectures, age, fullName);
        
            Map<String, Object> map = new HashMap<>();
            map.put("isSuccess", isSuccess);
            return new ModelAndView(map, "compute.mustache");
        }, new MustacheTemplateEngine());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; 
    }
}