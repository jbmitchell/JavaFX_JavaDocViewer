/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jonas
 */
public class FinalProject extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
        
        //SimpleBrowser sb = new SimpleBrowser();
        
        JavaDocViewer jdv = new JavaDocViewer();        
                
        Scene scene = new Scene(jdv, 900, 600);
        
        primaryStage.setTitle("JavaDocViewer");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
