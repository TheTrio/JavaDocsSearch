package TheTrio;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    JFXTextField textField;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       textField.setOnKeyPressed(e->{
           if(e.getCode()== KeyCode.ENTER && !e.isControlDown()) {
               ThreadClass t = new ThreadClass("https://docs.oracle.com/javase/8/docs/api/allclasses-frame.html", textField.getText());
               t.start();
           }
       });
    }
}
