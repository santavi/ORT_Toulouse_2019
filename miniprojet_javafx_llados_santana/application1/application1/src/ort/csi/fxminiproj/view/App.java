package ort.csi.fxminiproj.view;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ort.csi.fxminiproj.model.DBModelConnector;

public class App extends Application {
    
    @Override
    public void start(Stage stage) throws IOException  {
       
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
       
    }    public static void main(String[] args) {
        launch(args);
    }
    
}
