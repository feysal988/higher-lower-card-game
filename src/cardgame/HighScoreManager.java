package cardgame;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class HighScoreManager {

    private static final String FILE_NAME = "highscore.txt";

    public static int loadHighScore() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                return 0;
            }
            Scanner scanner = new Scanner(file);
            int score = scanner.nextInt();
            scanner.close();
            return score;
        } catch (Exception e) {
            return 0;
        }
    }

    public static void saveHighScore(int score) {
        try {
            FileWriter writer = new FileWriter(FILE_NAME);
            writer.write(String.valueOf(score));
            writer.close();
        } catch (Exception e) {
        }
    }
}
