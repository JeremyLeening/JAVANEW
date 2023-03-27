import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVFileReader {
   private String filePath;
   private String delimiter;

   public CSVFileReader(String filePath, String delimiter) {
      this.filePath = filePath;
      this.delimiter = delimiter;
   }

   public void read() {
      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
         String line;
         while ((line = br.readLine()) != null) {
            String[] data = line.split(delimiter);
            // Process the data here...
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
