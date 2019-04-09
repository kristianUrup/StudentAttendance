/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller;

import BE.Person;
import BE.Student;
import BE.Teacher;
import BLL.Exceptions.BllException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import GUI.Controller.Teacher.*;
import GUI.Controller.Student.*;
import com.jfoenix.controls.JFXPasswordField;
import GUI.Model.SAModel;
import com.jfoenix.controls.JFXTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.scene.Node;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Kristian Urup laptop
 */
public class PersonalDataController implements Initializable {

    private final SAModel SAM;
    private int textLimit;
    private final Pattern CPRPATTERN;
    
    private JFXPasswordField txtCprNr;
    @FXML
    private JFXTextField txtCprInput;
    public PersonalDataController() {
        try {
            SAM = new SAModel();
            CPRPATTERN = Pattern.compile("\\d{6}-\\d{4}");
        } catch (BllException ex) {
            throw new UnsupportedOperationException();
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtCprInput.setDisable(true);
        
    }

    /**
     * Checks if the CprPattern is correct
     * Checks whether its a student or a teacher, then opens a new screen
     * 
     * @param event
     * @throws IOException 
     */
    @FXML
    private void handleCheckIn(ActionEvent event) throws IOException {

        if (CPRPATTERN.matcher(txtCprInput.getText()).matches()) {
            try {
                for (Person person : SAM.getAllPersons()) {
                    if (person.getCpr().equals(txtCprInput.getText())) {
                        if (person instanceof Student) {
                            openStudentScreen(event, (Student) person);
                            return;
                        } else if (person instanceof Teacher) {
                            openTeacherScreen(event, (Teacher) person);
                            return;
                        }
                    }
                }
                incorrectCprNumber();
            } catch (BllException ex) {
                Logger.getLogger(PersonalDataController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            incorrectCprPattern();
        }

    }

    /**
     * Deletes the last digit that was inserted in the Cpr textfield
     * 
     * @param event 
     */
    @FXML
    private void handleDeleteBtn(ActionEvent event) {
        if (!txtCprInput.getText().isEmpty()) {
        String currentCprInput = "";
        for (int i = 0; i < txtCprInput.getText().length()-1; i++) {
            currentCprInput = currentCprInput + txtCprInput.getText().charAt(i);
        }
        txtCprInput.setText(currentCprInput);
        textLimit--;
        }
    }

    /**
     * Inserts the value 1 if 1 is pressed
     * @param event 
     */
    @FXML
    private void btnOne(ActionEvent event) {
        cprInputField(1);
    }

    /**
     * Inserts the value 2 if 2 is pressed
     * @param event 
     */
    @FXML
    private void btnTwo(ActionEvent event) {
        cprInputField(2);
    }

    /**
     * Inserts the value 3 if 3 is pressed
     * @param event 
     */
    @FXML
    private void btnThree(ActionEvent event) {
        cprInputField(3);
    }

    /**
     * Inserts the value 5 if 5 is pressed
     * @param event 
     */
    @FXML
    private void btnFive(ActionEvent event) {
        cprInputField(5);
    }

    /**
     * Inserts the value 4 if 4 is pressed
     * @param event 
     */
    @FXML
    private void btnFour(ActionEvent event) {
        cprInputField(4);
    }

    /**
     * Inserts the value 6 if 6 is pressed
     * @param event 
     */
    @FXML
    private void btnSix(ActionEvent event) {
        cprInputField(6);
    }

    /**
     * Inserts the value 7 if 7 is pressed
     * @param event 
     */
    @FXML
    private void btnSeven(ActionEvent event) {
        cprInputField(7);
    }

    /**
     * Inserts the value 0 if 0 is pressed
     * @param event 
     */
    @FXML
    private void btnZero(ActionEvent event) {
        cprInputField(0);
    }

    /**
     * Inserts the value 9 if 9 is pressed
     * @param event 
     */
    @FXML
    private void btnNine(ActionEvent event) {
        cprInputField(9);
    }

    /**
     * Inserts the value 8 if 8 is pressed
     * @param event 
     */
    @FXML
    private void btnEight(ActionEvent event) {
        cprInputField(8);
    }

    /**
     * Makes the limit so you cant type a cpr nr over 10 numbers and
     * divides the cpr number, so birthdate and personal 4 digits
     * are separated with a "-"
     * 
     * @param number 
     */
    private void cprInputField(int number) {
        if (textLimit >= 11) {

        } else {
            if (textLimit == 6) {
                String text = txtCprInput.getText();
                txtCprInput.setText(text + "-");
                textLimit++;
            }
            String text = txtCprInput.getText();
            txtCprInput.setText(text + Integer.toString(number));
            textLimit++;
        }
    }
            
    /**
     * Opens a new screen for the student
     * 
     * @param event
     * @param student 
     */
    private void openStudentScreen(ActionEvent event, Student student) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Student/StudentScreen.fxml"));
            Parent root = (Parent) loader.load();
            
            StudentScreenController sscontroller = loader.getController();
            updateStudentAbsence(student);
            sscontroller.setStudent(student);
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            Stage stage2 = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
            stage2.close();
        } catch (IOException ex) {
            Logger.getLogger(PersonalDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Opens a new screen for the teacher 
     * 
     * @param event
     * @param teacher 
     */
    private void openTeacherScreen(ActionEvent event, Teacher teacher) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Teacher/TeacherScreen.fxml"));
            Parent root = (Parent) loader.load();
            
            TeacherScreenController tscontroller = loader.getController();
            tscontroller.setTeacher(teacher);
            tscontroller.setComboBoxItems();
            
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            Stage stage2 = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
            stage2.close();
        } catch (IOException ex) {
            Logger.getLogger(PersonalDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Opens an alertbox if the numbers isn't the ddmmyy-xxxx format
     */
    private void incorrectCprPattern() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Invalid CPR-Number");
        alert.setHeaderText("Invalid CPR-Number format");
        alert.showAndWait();
    }

    /**
     * Shows an alertbox if the cpr number is incorrect
     */
    private void incorrectCprNumber() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Incorrect CPR-Number");
        alert.setHeaderText("The CPR-Number you have typed is incorrect");
        alert.showAndWait();
    }
    
    /**
     * Updates the student's attendance for the day, when logging in with student cpr.
     * 
     * @param student 
     */
    private void updateStudentAbsence(Student student) {
        try {
            LocalDate locatdate = LocalDate.now();
            String localdateString = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(locatdate);
            Date today = new SimpleDateFormat("dd/MM/yyyy").parse(localdateString);
            SAM.updateAbsence(student.getId(), today, true);
            double newAbsence = SAM.calculateAbsence(student.getId());
            String dayMostAbsent = SAM.updateMostDayAbsent(student);
            student.setDayMostAbsent(dayMostAbsent);
            student.setAbsence(newAbsence);
            SAM.updateStudentAbsence(student);
        } catch (ParseException | BllException ex) {
            Logger.getLogger(PersonalDataController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
