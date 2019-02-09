/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller.Student;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Kristian Urup laptop
 */
public class StudentScreenController implements Initializable
{

    @FXML
    private BorderPane borderPane;
    @FXML
    private Label lblName;
    @FXML
    private Label lblKlasse;
    @FXML
    private JFXButton lblLogOff;
    @FXML
    private JFXButton btnShowAttendance;
    @FXML
    private JFXTextField txtDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    
}
