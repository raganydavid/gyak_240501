import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Zene {
    public void musoridoKiiras(String filename) {
        File file = new File(filename);
        try {
            Scanner scanner = new Scanner(file);
            int radio1Hours = 0, radio1Minutes = 0, radio1Seconds = 0;
            int radio2Hours = 0, radio2Minutes = 0, radio2Seconds = 0;
            int radio3Hours = 0, radio3Minutes = 0, radio3Seconds = 0;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");

                int hours = Integer.parseInt(parts[0]);
                int minutes = Integer.parseInt(parts[1]);
                int seconds = Integer.parseInt(parts[2]);

                switch (hours) {
                    case 1:
                        radio1Hours += hours;
                        radio1Minutes += minutes;
                        radio1Seconds += seconds;
                        break;
                    case 2:
                        radio2Hours += hours;
                        radio2Minutes += minutes;
                        radio2Seconds += seconds;
                        break;
                    case 3:
                        radio3Hours += hours;
                        radio3Minutes += minutes;
                        radio3Seconds += seconds;
                        break;
                    default:
                        break;
                }
            }
            scanner.close();

            
            int totalRadio1Seconds = radio1Hours * 3600 + radio1Minutes * 60 + radio1Seconds;
            int totalRadio2Seconds = radio2Hours * 3600 + radio2Minutes * 60 + radio2Seconds;
            int totalRadio3Seconds = radio3Hours * 3600 + radio3Minutes * 60 + radio3Seconds;

            
            System.out.println("Rádió 1 műsorideje: " + formatSeconds(totalRadio1Seconds));
            System.out.println("Rádió 2 műsorideje: " + formatSeconds(totalRadio2Seconds));
            System.out.println("Rádió 3 műsorideje: " + formatSeconds(totalRadio3Seconds));
        } catch (FileNotFoundException e) {
            System.out.println("Hiba: A fájl nem található.");
            e.printStackTrace();
        }
    }

    
    private String formatSeconds(int seconds) {
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int remainingSeconds = seconds % 60;
        return hours + " óra " + minutes + " perc " + remainingSeconds + " másodperc";
    }
}
 