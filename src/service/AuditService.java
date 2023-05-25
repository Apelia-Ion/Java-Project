package service;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditService {
    private static final String FILE_PATH = "audit.csv";

    public static void writeAudit(String action) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true)) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String timestamp = LocalDateTime.now().format(formatter);

            String[] data = { timestamp, action };
            fileWriter.append(String.join(",", data));
            fileWriter.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
