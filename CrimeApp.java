import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CrimeApp extends Application
{

   public static void main(String[] args)
   {   
      launch(args);
   }
   
   @Override
   public void start(Stage stage) throws Exception
   {
      // Load the GUI from FXML built in Scene Builder
      Parent root = FXMLLoader.load(getClass().getResource("CrimeApp.fxml"));    
      Scene scene = new Scene(root);      
      stage.setTitle("Crime app");      
      stage.setScene(scene);
      stage.show();
      
      // All of the code that interacts with the API and the Scene 
      //   is found in DemoViewController.java
      
   }


}