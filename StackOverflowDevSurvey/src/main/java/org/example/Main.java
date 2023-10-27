package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StatisticProcessor computation = new Computations();
        System.out.println("Age: " + computation.getAverageAge());
        System.out.println("Hours: " + computation.getAverageHoursWorked());
        System.out.println("Salary: " + computation.getAverageSalary());

        System.out.print("Percent using Java: ");
        System.out.printf("%.6f", computation.getPercentageUsingLanguage("Java"));
        System.out.println();

        System.out.print("Percent using Python: ");
        System.out.printf("%.6f", computation.getPercentageUsingLanguage("Python"));
        System.out.println();

        System.out.print("Percent using C#: ");
        System.out.printf("%.6f", computation.getPercentageUsingLanguage("C#"));
        System.out.println();

        System.out.print("Percent using C: ");
        System.out.printf("%.6f", computation.getPercentageUsingLanguage("C"));
        System.out.println();

        System.out.print("Percent using Swift: ");
        System.out.printf("%.6f", computation.getPercentageUsingLanguage("Swift"));
        System.out.println();

        System.out.print("Percent using Kotlin: ");
        System.out.printf("%.6f", computation.getPercentageUsingLanguage("Kotlin"));
        System.out.println();

        System.out.print("Percent using JavaScript: ");
        System.out.printf("%.6f", computation.getPercentageUsingLanguage("JavaScript"));
        System.out.println();

        System.out.print("Percent using HTML/CSS: ");
        System.out.printf("%.6f", computation.getPercentageUsingLanguage("HTML/CSS"));
        System.out.println();

    }
}