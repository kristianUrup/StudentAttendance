/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kristian Urup laptop
 */
public class PersonalDataController implements Initializable
{

    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button five;
    @FXML
    private Button four;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button zero;
    @FXML
    private Button nine;
    @FXML
    private Button eight;
    @FXML
    private TextField txtCprNr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        // TODO
    }    

    @FXML
    private void handleCheckIn(ActionEvent event) throws IOException
    {
        int cprNr = Integer.parseInt(txtCprNr.getText());
        if(cprNr == 1)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Student/StudentScreenController"));
            Parent root = (Parent) loader.load();
            
            GUI.Controller.Student.StudentScreenController sccontroller = loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
        }
    }

    @FXML
    private void handleDeleteBtn(ActionEvent event)
    {
    }
    
}
