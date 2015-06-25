/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class SimpleBrowser extends GridPane implements Initializable {
    
    @FXML WebView webView;
    @FXML Button goButton;
    @FXML TextField webAddressBar;
        
    public SimpleBrowser() throws IOException{
        FXMLLoader loader = new FXMLLoader(FinalProject.class.getResource("simpleBrowser.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
    }
    
    public void goButtonClicked(ActionEvent event){
        String webAddress = webAddressBar.getText();
        // Add code here to validate the URL before attempting to load
        webView.getEngine().load(webAddress);
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        webView.getEngine().load("http://www.google.com");

    }    
    
}
