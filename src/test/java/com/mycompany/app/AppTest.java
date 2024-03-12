package com.mycompany.app;

import java.util.ArrayList;

import junit.framework.TestCase;

public class AppTest extends TestCase {
    public void testValidParameters() {
        ArrayList<Integer> term1Notes = new ArrayList<>();
        term1Notes.add(90);
        term1Notes.add(85);
        
        ArrayList<Integer> term2Notes = new ArrayList<>();
        term2Notes.add(88);
        term2Notes.add(87);

        ArrayList<String> term1Lectures = new ArrayList<>();
        term1Lectures.add("Math");
        term1Lectures.add("Science");

        ArrayList<String> term2Lectures = new ArrayList<>();
        term2Lectures.add("History");
        term2Lectures.add("English");

        int age = 20;
        String fullName = "John Doe";

        assertTrue(App.isSuccessful(term1Notes, term2Notes, term1Lectures, term2Lectures, age, fullName));
    }

    public void testNullFullName() {
        ArrayList<Integer> term1Notes = new ArrayList<>();
        ArrayList<Integer> term2Notes = new ArrayList<>();
        ArrayList<String> term1Lectures = new ArrayList<>();
        ArrayList<String> term2Lectures = new ArrayList<>();
        int age = 20;
        String fullName = null;

        assertFalse(App.isSuccessful(term1Notes, term2Notes, term1Lectures, term2Lectures, age, fullName));
    }

    public void testEmptyFullName() {
        ArrayList<Integer> term1Notes = new ArrayList<>();
        ArrayList<Integer> term2Notes = new ArrayList<>();
        ArrayList<String> term1Lectures = new ArrayList<>();
        ArrayList<String> term2Lectures = new ArrayList<>();
        int age = 20;
        String fullName = "";

        assertFalse(App.isSuccessful(term1Notes, term2Notes, term1Lectures, term2Lectures, age, fullName));
    }

	public void testInvalidAge() {
		ArrayList<Integer> term1Notes = new ArrayList<>();
		term1Notes.add(90);
		term1Notes.add(85);
		
		ArrayList<Integer> term2Notes = new ArrayList<>();
		term2Notes.add(88);
		term2Notes.add(87);

		ArrayList<String> term1Lectures = new ArrayList<>();
		term1Lectures.add("Math");
		term1Lectures.add("Science");

		ArrayList<String> term2Lectures = new ArrayList<>();
		term2Lectures.add("History");
		term2Lectures.add("English");

		int age = 16; // Invalid age
		String fullName = "John Doe";

		assertFalse(App.isSuccessful(term1Notes, term2Notes, term1Lectures, term2Lectures, age, fullName));
	}

    public void testInvalidNotes() {
        ArrayList<Integer> term1Notes = new ArrayList<>();
        term1Notes.add(90);
        term1Notes.add(-5); // Invalid note
        ArrayList<Integer> term2Notes = new ArrayList<>();
        term2Notes.add(88);
        term2Notes.add(87);
        ArrayList<String> term1Lectures = new ArrayList<>();
        term1Lectures.add("Math");
        term1Lectures.add("Science");
        ArrayList<String> term2Lectures = new ArrayList<>();
        term2Lectures.add("History");
        term2Lectures.add("English");
        String fullName = "John Doe";
        int age = 20;
    
        assertFalse(App.isSuccessful(term1Notes, term2Notes, term1Lectures, term2Lectures, age, fullName));
    }
}