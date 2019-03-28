/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller.Student;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Frederik Jensen
 */
public class AttendenceCheckController implements Initializable
{

    @FXML
    private JFXTextField txtDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        LocalDate localDate = LocalDate.now();
        txtDate.setText(DateTimeFormatter.ofPattern("dd/MM/yyyy").format(localDate));
    }    
    
}
