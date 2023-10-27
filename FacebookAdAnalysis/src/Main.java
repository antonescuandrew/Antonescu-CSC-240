import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Ad> ads = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("ads_subset.csv"));
            reader.readLine();
            String line;
            // We loop through the file reading a line until we reach the end, which will then return null
            while((line = reader.readLine()) != null) {
                String [] parts = line.split(",");

                int political = Integer.parseInt(parts[1]);
                int not_political = Integer.parseInt(parts[2]);
                boolean isPolitical = false;
                if (political >= not_political){
                    isPolitical = true;
                }
                String title = parts[3];
                double political_probability = Double.parseDouble(parts[11]);
                String targets = parts[14];
                String advertiser = parts[15];
                boolean isTargetedPolitical = false;
                if (isPolitical == true && !targets.equals("[]")){
                    isTargetedPolitical = true;
                }
                String paid_for_by = parts[20];
                if (isPolitical == true){
                    if (isTargetedPolitical == true){
                        TargetedPoliticalAd ad = new TargetedPoliticalAd(title,political_probability, paid_for_by, targets,advertiser);
                        ads.add(ad);
                    }
                else{
                    PoliticalAd ad = new PoliticalAd(title, political_probability, paid_for_by);
                    ads.add(ad);
                    }
                }

                // TODO: Split each line  (Tip: Look at the split method for the Java String class)

                // TODO: Process the fields

                // TODO: Determine the type of ad and add it to your List
            }

        }
        catch (IOException e) {
            System.err.printf("Unable to read the data file: %s\n", e);
            System.exit(1);
        }

        try {
            // This is to write each
            BufferedWriter writer = new BufferedWriter(new FileWriter("out.csv"));
            for (Ad ad : ads){
                writer.write(ad.format());
                writer.write("\n");
            }

            // TODO: Write your data using the List

            // We need to call close to ensure the buffer is flushed
            writer.close();
        }
        catch (IOException e) {
            System.err.printf("Unable to write the data file: %s\n", e);
            System.exit(2);
        }

    }
}
