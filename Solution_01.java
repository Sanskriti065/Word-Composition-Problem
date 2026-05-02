import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Solution_01 {
    public static void main(String[] args) throws FileNotFoundException {

        // For storing longest and second longest words
        String longest = "";
        String secondLongest = "";

        // Start time measurement
        long S_time = System.currentTimeMillis();

        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader("Input_01.txt"));

            String line_number;

            // Single loop (fixed)
            while ((line_number = br.readLine()) != null) {

                line_number = line_number.trim();

                // Optional: print line
                // System.out.println(line_number);

                if (line_number.length() > longest.length()) {
                    secondLongest = longest;
                    longest = line_number;
                } else if (line_number.length() > secondLongest.length() && !line_number.equals(longest)) {
                    secondLongest = line_number;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Output results
        System.out.println("Longest word: " + longest);
        System.out.println("Second longest word: " + secondLongest);

        // End time measurement
        long E_time = System.currentTimeMillis();

        // Time taken
        long T_time = E_time - S_time;
        System.out.println("Time taken: " + T_time + " ms");
    }
}