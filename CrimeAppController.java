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
    
    @FXML
    private TextField crime;
    
    
   @FXML
   private void onSearch(ActionEvent event)throws Exception{
      
      String crime = this.crime.getText().toString();
      System.out.println(crime);
      
      LocalDate date = this.date.getValue();
      System.out.println(date);
      
      String apiURL =  "https://phl.carto.com/api/v2/sql?q=" + 
                        URLEncoder.encode("SELECT * FROM incidents_part1_part2 WHERE  text_general_code = " + "'" + crime + "'" + " AND dispatch_date = "+ "'" + date + "'");
      System.out.println(apiURL);
   
      String jsonString = "";
      
      URL url = new URL(apiURL);
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      
     //  String inputLine;
   //    StringBuilder response = new StringBuilder();
   //    while ((inputLine = bufferedReader.readLine()) != null) {
   //       response.append(inputLine);
   //    }
   //    bufferedReader.close();
   //    jsonString = response.toString();
   //    System.out.println(jsonString);
           
      Gson gson = new Gson();
      SearchResults a = gson.fromJson(bufferedReader, SearchResults.class);
   
   
      
      this.Results.setText(a.toString());
      
   }

}
