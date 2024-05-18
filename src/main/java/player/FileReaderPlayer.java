package player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderPlayer {

    public static Player loadFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            line = br.readLine();
            if (line != null) {
                String[] data = line.split(";");
                String name = data[0];
                int maxHealthPoints = Integer.parseInt(data[1]);

                return new Player(name, maxHealthPoints);
            }
        } catch (FileNotFoundException e) {
            System.err.println ("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println ("Error reading file: " + e.getMessage());
        }
        return new Player ("", 0);
    }
}



