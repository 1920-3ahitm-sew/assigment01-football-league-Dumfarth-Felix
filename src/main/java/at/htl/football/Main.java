package at.htl.football;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
        League league = new League();
    static final String FILENAME = "bundesliga-1819.csv";

    public static void main(String[] args) {
        readFile();
    }

    private static void readFile() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(FILENAME))) {
            String line;
            while((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
