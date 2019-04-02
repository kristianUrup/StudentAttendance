/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller.Teacher;

import BE.Student;
import BLL.Exceptions.BllException;
import GUI.Model.SAModel;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ScrollPane;

/**
 * FXML Controller class
 *
 * @author Frederik
 */
public class AbsenceSummaryController implements Initializable {

    private final SAModel SAM;
    final BarChart<String,Number> absenceChart;
    final CategoryAxis xAxis = new CategoryAxis();
    final NumberAxis yAxis = new NumberAxis();
    @FXML
    private ScrollPane scrollBarChart;

    public AbsenceSummaryController() {
        try {
            absenceChart = new BarChart<>(xAxis,yAxis);
            SAM = new SAModel();
        } catch (BllException ex) {
            throw new UnsupportedOperationException();
        }
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeAbsenceChart();
    }
    
    private void initializeAbsenceChart() {
        absenceChart.setTitle("Total Absence Summary");
        xAxis.setLabel("Student");
        yAxis.setLabel("Absence");
        XYChart.Series studentData = new XYChart.Series();
        for (Student student : SAM.getSortedAbsenceList()) {
            studentData.getData().add(new XYChart.Data(student.getName(), student.getAbsence()));
        }
        studentData.setName("Student absence in percentage");
        absenceChart.getData().add(studentData);
        absenceChart.setPrefWidth(400);
        scrollBarChart.setContent(absenceChart);
    }
}
