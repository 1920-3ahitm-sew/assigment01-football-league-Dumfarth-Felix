package at.htl.football;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    static League league = new League();
    static final String FILENAME = "bundesliga-1819.csv";

    public static void main(String[] args) {
        readFile();
        league.getTable();
    }

    private static void readFile() {
        int count = 0;
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(FILENAME))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split(";");
                if (count != 0) {
                    Match match = new Match(parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]));
                    league.addMatchResult(match);
                }
                count++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
