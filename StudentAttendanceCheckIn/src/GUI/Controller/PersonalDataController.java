/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Person;
import BE.Student;
import BE.Teacher;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import GUI.Controller.Teacher.*;
import GUI.Controller.Student.*;
import com.jfoenix.controls.JFXPasswordField;
import GUI.Model.SAModel;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.WindowEvent;

/**
 * FXML Controller class
 *
 * @author Kristian Urup laptop
 */
public class PersonalDataController implements Initializable {

    private final SAModel SAM;
    private int textLimit;
    private final Pattern CPRPATTERN;
    
    @FXML
    private JFXPasswordField txtCprNr;
    public PersonalDataController() {
        SAM = new SAModel();
        CPRPATTERN = Pattern.compile("\\d{6}-\\d{4}");
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtCprNr.setDisable(true);
        
    }

    @FXML
    private void handleCheckIn(ActionEvent event) throws IOException {

        if (CPRPATTERN.matcher(txtCprNr.getText()).matches()) {
            for (Person person : SAM.getAllPersons()) {
                if (person.getCpr().equals(txtCprNr.getText())) {
                    if (person instanceof Student) {
                        openStudentScreen(event, (Student) person);
                        return;
                    } else if (person instanceof Teacher) {
                        openTeacherScreen(event);
                        return;
                    }
                }
            }
            incorrectCprNumber();
        } else {
            incorrectCprPattern();
        }

    }

    @FXML
    private void handleDeleteBtn(ActionEvent event) {
        txtCprNr.clear();
        textLimit = 0;
    }

    @FXML
    private void btnOne(ActionEvent event) {
        cprInputField(1);
    }

    @FXML
    private void btnTwo(ActionEvent event) {
        cprInputField(2);
    }

    @FXML
    private void btnThree(ActionEvent event) {
        cprInputField(3);
    }

    @FXML
    private void btnFive(ActionEvent event) {
        cprInputField(5);
    }

    @FXML
    private void btnFour(ActionEvent event) {
        cprInputField(4);
    }

    @FXML
    private void btnSix(ActionEvent event) {
        cprInputField(6);
    }

    @FXML
    private void btnSeven(ActionEvent event) {
        cprInputField(7);
    }

    @FXML
    private void btnZero(ActionEvent event) {
        cprInputField(0);
    }

    @FXML
    private void btnNine(ActionEvent event) {
        cprInputField(9);
    }

    @FXML
    private void btnEight(ActionEvent event) {
        cprInputField(8);
    }

    private void cprInputField(int number) {
        if (textLimit >= 11) {

        } else {
            if (textLimit == 6) {
                String text = txtCprNr.getText();
                txtCprNr.setText(text + "-");
                textLimit++;
            }
            String text = txtCprNr.getText();
            txtCprNr.setText(text + Integer.toString(number));
            textLimit++;
        }
    }


    private void backSpace(KeyEvent kEvent)
    {
        if (kEvent.getCode() == KeyCode.BACK_SPACE)
        {
            textLimit--;
        }
    }
            
    private void openStudentScreen(ActionEvent event, Student student) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Student/StudentScreen.fxml"));
            Parent root = (Parent) loader.load();
            StudentScreenController sscontroller = loader.getController();
            sscontroller.setSTudent(student);
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            Stage stage2 = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
            stage2.close();
        } catch (IOException ex) {
            Logger.getLogger(PersonalDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void openTeacherScreen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Teacher/TeacherScreen.fxml"));
            Parent root = (Parent) loader.load();
            TeacherScreenController tscontroller = loader.getController();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            Stage stage2 = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
            stage2.close();
        } catch (IOException ex) {
            Logger.getLogger(PersonalDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void incorrectCprPattern() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid CPR-Number");
        alert.setHeaderText("Invalid CPR-Number format");
        alert.showAndWait();
    }

    private void incorrectCprNumber() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Incorrect CPR-Number");
        alert.setHeaderText("The CPR-Number you have typed is incorrect");
        alert.showAndWait();
    }
}
