/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.Controller.Teacher;

import BE.Dato;
import BE.Klasse;
import BE.Student;
import BE.Teacher;
import BLL.Exceptions.BllException;
import GUI.Model.SAModel;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.EventObject;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kristian Urup laptop
 */
public class TeacherScreenController implements Initializable {

    private Teacher teacherLoggedIn;
    private final SAModel SAM;
    @FXML
    private Label lblTeacherName;
    @FXML
    private JFXButton btnLogOff;
    @FXML
    private TableView<Student> tableStudents;
    @FXML
    private JFXButton btnAbsence;
    @FXML
    private JFXButton btnBack;
    @FXML
    private Label lblStudentName;
    @FXML
    private Label lblClass;
    @FXML
    private Label lblAbsence;
    @FXML
    private TableColumn<Student, String> clmStudentName;
    @FXML
    private BorderPane borderTeacherScreen;
    @FXML
    private AnchorPane anchorStudentInfo;
    @FXML
    private Label lblMostDayAbsence;
    @FXML
    private JFXComboBox<Klasse> comboClass;
    @FXML
    private RadioButton presentRadioBtn;
    @FXML
    private RadioButton absentRadioBtn;
    @FXML
    private Label lblAttendance;

    public TeacherScreenController() {
        try {
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
        clmStudentName.setCellValueFactory(new PropertyValueFactory<>("name"));
        btnBack.setVisible(false);
        absentRadioBtn.setVisible(false);
        presentRadioBtn.setVisible(false);
        lblAttendance.setVisible(false);
    }

    public void setTeacher(Teacher teacher) {
        teacherLoggedIn = teacher;
        lblTeacherName.setText(teacherLoggedIn.getName());
    }

    @FXML
    private void handlerLogOff(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/PersonalData.fxml"));
            Parent root = (Parent) loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root));
            stage.show();
            Stage stage2 = (Stage) ((Node) ((EventObject) event).getSource()).getScene().getWindow();
            stage2.close();
        } catch (IOException ex) {
            Logger.getLogger(TeacherScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlerStudentClicked(MouseEvent event) {
        try {
            Student selectedStudent = tableStudents.getSelectionModel().getSelectedItem();
            lblStudentName.setText(selectedStudent.getName());
            lblClass.setText(selectedStudent.getKlasse());
            lblAbsence.setText(Double.toString(selectedStudent.getAbsence()));
            lblMostDayAbsence.setText(selectedStudent.getDayMostAbsent());
            lblAttendance.setVisible(true);
            absentRadioBtn.setVisible(true);
            presentRadioBtn.setVisible(true);
            if (!SAM.isStudentAbsence(selectedStudent.getId())) {
                presentRadioBtn.setSelected(true);
                absentRadioBtn.setSelected(false);
            } else {
                absentRadioBtn.setSelected(true);
                presentRadioBtn.setSelected(false);
            }
        } catch (BllException ex) {
            Logger.getLogger(TeacherScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlerStudentAbsence(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/View/Teacher/AbsenceSummary.fxml"));
            Parent root = (Parent) loader.load();
            borderTeacherScreen.setCenter(root);
            borderTeacherScreen.setRight(null);
            borderTeacherScreen.setLeft(null);
            btnBack.setVisible(true);
            btnAbsence.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(TeacherScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlerBack(ActionEvent event) {
        borderTeacherScreen.setRight(anchorStudentInfo);
        borderTeacherScreen.setLeft(tableStudents);
        borderTeacherScreen.setCenter(null);
        btnBack.setVisible(false);
        btnAbsence.setVisible(true);
    }

    public void setComboBoxItems() {
        try {
            comboClass.setItems(SAM.getTeacherClasses(teacherLoggedIn.getId()));
            comboClass.getSelectionModel().selectFirst();
            setStudentsInList();
        } catch (BllException ex) {
            Logger.getLogger(TeacherScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setStudentsInList() {
        try {
            Klasse klasse = comboClass.getSelectionModel().getSelectedItem();
            tableStudents.setItems(SAM.getStudentsFromClass(klasse));
        } catch (BllException ex) {
            Logger.getLogger(TeacherScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void handlerSelectClass(ActionEvent event) {
        setStudentsInList();
    }

    @FXML
    private void handlerAbsent(ActionEvent event) {
        boolean present = presentRadioBtn.isSelected();
        Student selectedStudent = tableStudents.getSelectionModel().getSelectedItem();
        if (present) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Changing attendance for today");
            alert.setHeaderText("Are you sure you want to change the attendance?");
            alert.showAndWait();
            presentRadioBtn.setSelected(false);
            updateStudentAbsence(true, selectedStudent);
        }
    }

    @FXML
    private void handlerPresent(ActionEvent event) {
        boolean absent = absentRadioBtn.isSelected();
        Student selectedStudent = tableStudents.getSelectionModel().getSelectedItem();
        if (absent) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Changing attendance for today");
            alert.setHeaderText("Are you sure you want to change the attendance?");
            alert.showAndWait();
            absentRadioBtn.setSelected(false);
            updateStudentAbsence(false, selectedStudent);
        }
    }

    private void updateStudentAbsence(boolean isAbsent, Student student) {
        try {
            LocalDate locatdate = LocalDate.now();
            String localdateString = DateTimeFormatter.ofPattern("dd/MM/yyyy").format(locatdate);
            Date today = new SimpleDateFormat("dd/MM/yyyy").parse(localdateString);
            System.out.println(today);
            System.out.println(student.getId());
            SAM.updateAbsence(student.getId(), today, isAbsent);
            double absence = SAM.calculateAbsence(student.getId());
            String dayMostAbsent = SAM.updateMostDayAbsent(student);
            student.setDayMostAbsent(dayMostAbsent);
            student.setAbsence(absence);
            SAM.updateStudentAbsence(student);
        } catch (ParseException | BllException ex) {
            Logger.getLogger(TeacherScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
