package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Computations implements StatisticProcessor{
    long totalSalary = 0;
    int salaryCounter = 0;
    private List<String> initReader(int index){
        List<String> values = new ArrayList<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("survey_results_public_subset.tsv"));
            String line;
            String value;
            while((line = reader.readLine()) != null){
                String [] parts = line.split("\t");
                value = parts[index];
                values.add(value);
            }

        }
        catch(IOException e){
            System.err.printf("Unable to read the data file: %s\n", e);
            System.exit(1);
        }
        return values;
    }
    @Override
    public long getAverageSalary() {
        List<String> readSalaries = initReader(6);
        List<String> readYears = initReader(5);
        long totalSalary = 0;
        int salaryCounter = 0;
        for (int i = 0; i < readSalaries.size(); i++) {
            if (!readSalaries.get(i).equals("NA") && !readSalaries.get(i).contains("E")
                    && readYears.get(i).equals("Yearly")){
                long salary = Long.parseLong(readSalaries.get(i));
                totalSalary = totalSalary + salary;
                salaryCounter++;
            }
        }
        return totalSalary / salaryCounter;
    }
    @Override
    public long getAverageHoursWorked() {
        List<String> readHours = initReader(58);
        long totalHours = 0;
        int hoursCounter = 0;
        for (int i = 0; i < readHours.size(); i++){
            if (!readHours.get(i).equals("NA") && !readHours.get(i).contains(".")){
                long hours = Long.parseLong(readHours.get(i));
                totalHours = totalHours + hours;
                hoursCounter++;
            }
        }
        return totalHours / hoursCounter;
    }

    @Override
    public long getAverageAge() {
        List<String> readAges = initReader(3);
        long totalAge = 0;
        int ageCounter = 0;
        for (int i = 0; i < readAges.size(); i++){
            if (!readAges.get(i).equals("NA") && !readAges.get(i).contains(".")) {
                long age = Long.parseLong(readAges.get(i));
                totalAge = totalAge + age;
                ageCounter++;
            }
        }
        return totalAge / ageCounter;
    }

    @Override
    public float getPercentageUsingLanguage(String language) {
        List<String> readLanguages = initReader(22);
        float languageCounter = 0;
        float totalAnswerCounter = 0;
        String line;
        for (int i = 0; i < readLanguages.size(); i++){
            if (!readLanguages.get(i).equals("NA")) {
                totalAnswerCounter++;
                line = readLanguages.get(i);
                String [] parts = line.split(";");
                for (String part : parts) {
                    if (part.equals(language)){
                        languageCounter++;
                    }
                }
                }
            }
        float ans = languageCounter / totalAnswerCounter;
        return (languageCounter / totalAnswerCounter) ;
    }
}
