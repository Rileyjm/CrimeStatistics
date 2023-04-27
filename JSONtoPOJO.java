import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class JSONtoPOJO {
   public static void main(String[] args) {
      String apiURL =  "https://phl.carto.com/api/v2/sql?q=" +
                        URLEncoder.encode("SELECT * FROM incidents_part1_part2 WHERE dispatch_date = '2011-09-27'");

      String jsonString = "";
      try {
         URL url = new URL(apiURL);
         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
         connection.setRequestMethod("GET");
         BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
         String inputLine;
         StringBuilder response = new StringBuilder();
         while ((inputLine = bufferedReader.readLine()) != null) {
            response.append(inputLine);
         }
         bufferedReader.close();
         jsonString = response.toString();
      } catch (Exception e) {
         System.out.println(e);
      }
      Gson gson = new Gson();
      PoliceActivity activity = gson.fromJson(jsonString, PoliceActivity.class);

   }
}
