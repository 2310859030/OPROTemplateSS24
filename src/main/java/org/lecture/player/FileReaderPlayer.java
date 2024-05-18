package org.lecture.player;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * class for loading a player from a CSV file
 */
public class FileReaderPlayer {

    /**
     * loads a player from a CSV file.
     * the CSV file should have a header line, followed by a line with the player's name and max health points separated by a semicolon.
     * @param filePath path to the CSV file
     * @return s a player object with the loaded data, or a default Player object with an empty name and 0 health points if an error occurs.
     */
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



