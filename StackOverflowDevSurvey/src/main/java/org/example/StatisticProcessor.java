package org.example;

public interface StatisticProcessor {
    long getAverageSalary();
    long getAverageHoursWorked();
    long getAverageAge();
    float getPercentageUsingLanguage(String language);
}
