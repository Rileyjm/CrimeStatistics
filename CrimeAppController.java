import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import java.time.LocalDate;
import javafx.event.ActionEvent;


public class CrimeAppController{

   @FXML
    private DatePicker date;

   @FXML
    private Button Enter;

   @FXML
    private TextArea Results;
    
    
   @FXML
   private void onSearch(ActionEvent event){
      LocalDate date = this.date.getValue();
      System.out.println(date);
      
      this.Results.setText(date.toString());
      
   }

}
