/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author Jonas
 */
public class JavaDocViewer extends GridPane implements Initializable  {

    @FXML
    WebView webView;
    @FXML
    ComboBox comboBox;
    AutoCompleteComboBoxListener<ComboBox> autoCompleteComboBoxListener;

    ObservableList<String> javaClassesAndInterfaces = FXCollections.observableArrayList();

    Map<String, String> toLinkMap = new HashMap<>();

    public void addtoMap(Map toLinkMap, ObservableList<String> ol) throws FileNotFoundException, IOException {
        toLinkMap.put("", "http://www.google.com");
        ol.add("");
//        FileReader fileReader = new FileReader("javaLinksAgain.txt");
        InputStream inputStream = getClass().getResourceAsStream("javaLinksAgain.txt");
        InputStreamReader fileReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            int begin = line.lastIndexOf('/') + 1;
            int end = line.lastIndexOf('.');
            //System.out.println(line.substring(begin, end)+ "," + line);
            ol.add(line.substring(begin, end));
            toLinkMap.put(line.substring(begin, end), line);
        }
        fileReader.close();
    }

    public JavaDocViewer() throws IOException {
        FXMLLoader loader = new FXMLLoader(FinalProject.class.getResource("JavaDocViewer.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        loader.load();
    }

    public void goComboBoxGo(ActionEvent event) {
        webView.getEngine().load(toLinkMap.get(comboBox.getSelectionModel().getSelectedItem().toString()));

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb){
        try {
            addtoMap(toLinkMap, javaClassesAndInterfaces);
        } catch (IOException ex) {
            Logger.getLogger(JavaDocViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
        comboBox.getItems().addAll(javaClassesAndInterfaces);
        autoCompleteComboBoxListener = new AutoCompleteComboBoxListener<>(comboBox);
        webView.getEngine().load("http://www.google.com");
    }

}
