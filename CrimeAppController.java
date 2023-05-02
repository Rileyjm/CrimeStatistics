import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import com.google.gson.Gson;
   import java.io.BufferedReader;
   import java.io.InputStreamReader;
   import java.net.HttpURLConnection;
   import java.net.URL;
   import java.net.URLEncoder;


public class CrimeAppController{

   @FXML
    private DatePicker date;

   @FXML
    private Button Enter;

   @FXML
    private TextArea Results;
    
    //added new fx:id field to the .fxml file
    @FXML
    private TextField crime;
    
    
   @FXML
   private void onSearch(ActionEvent event)throws Exception{
   
      
      String date = this.date.getValue().toString();
      String crime = this.crime.toString();
      PoliceActivity activity = getActivityByDateAndCrime(date, crime); //Passes date and crime values into getActivityByDateAndCrime method.
      
      //Example of getting entries from the activity field.
      System.out.println(activity);
      
      // LocalDate date = this.date.getValue();
//       System.out.println(date);
//       
//       String apiURL =  "https://phl.carto.com/api/v2/sql?q=" + 
//                         URLEncoder.encode("SELECT * FROM incidents_part1_part2 WHERE dispatch_date = '" +date.toString()+"'");
//       System.out.println(apiURL);
//    
//       String jsonString = "";
//       
//       URL url = new URL(apiURL);
//       HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//       connection.setRequestMethod("GET");
//       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//       
//      //  String inputLine;
//    //    StringBuilder response = new StringBuilder();
//    //    while ((inputLine = bufferedReader.readLine()) != null) {
//    //       response.append(inputLine);
//    //    }
//    //    bufferedReader.close();
//    //    jsonString = response.toString();
//    //    System.out.println(jsonString);
//            
//       Gson gson = new Gson();
//       SearchResults a = gson.fromJson(bufferedReader, SearchResults.class);
//    
//    
//       
//       this.Results.setText(a.toString());
      
   }
   
   private PoliceActivity getActivityByDateAndCrime(String date, String crime)
   {
      
      
      //Slight adjustment to the API address to include everything from the crime AND date
      String apiURL =  "https://phl.carto.com/api/v2/sql?q=" + 
                        URLEncoder.encode("SELECT * FROM incidents_part1_part2 WHERE  text_general_code = " + "'" + crime + "'" + " AND dispatch_date = "+ "'" + date + "'");

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
      
      System.out.println(jsonString); //Testing
      Gson gson = new Gson();
      PoliceActivity activity = gson.fromJson(jsonString, PoliceActivity.class);
      return activity;
   
   }

}
