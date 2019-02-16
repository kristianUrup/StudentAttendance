/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller.Student;

import BE.Student;
import GUI.Controller.Teacher.TeacherScreenController;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.EventObject;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kristian Urup laptop
 */
public class StudentScreenController implements Initializable
{

    String currentWindow = "MainScreen";
    Student studentLoggedIn;

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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        setCenterToAttendanceCheck();
    }

    public void setCenterToAttendanceCheck()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Student/AttendenceCheck.fxml"));
            Parent root = (Parent) loader.load();
            borderPane.setCenter(root);
        } catch (IOException ex)
        {
            Logger.getLogger(StudentScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlerShotAttendance(ActionEvent event)
    {
        switch (currentWindow)
        {
            case "MainScreen":
                ObservableList<PieChart.Data> absenceData = FXCollections.observableArrayList(
                        new PieChart.Data("Absence, " + Double.toString(studentLoggedIn.getAbsence()) + "%", studentLoggedIn.getAbsence()),
                        new PieChart.Data("Presence, " + Double.toString(100 - studentLoggedIn.getAbsence()) + "%", 100 - studentLoggedIn.getAbsence())
                );
                PieChart pieChart = new PieChart(absenceData);
                pieChart.setTitle("Total Absence");
                borderPane.setCenter(pieChart);
                btnShowAttendance.setText("Back to main screen");
                currentWindow = "PieChartScreen";
                break;
            
            case "PieChartScreen":
                setCenterToAttendanceCheck();
                currentWindow = "MainScreen";
                btnShowAttendance.setText("Show total attendance");
                break;
        }
    }

    public void setSTudent(Student student)
    {
        studentLoggedIn = student;
        lblName.setText(studentLoggedIn.getName());
        lblKlasse.setText(studentLoggedIn.getKlasse());
    }

    @FXML
    private void handlerLogOff(ActionEvent event)
    {
        try
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/PersonalData.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            Stage stage2 = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
            stage2.close();
        } catch (IOException ex)
        {
            Logger.getLogger(StudentScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
