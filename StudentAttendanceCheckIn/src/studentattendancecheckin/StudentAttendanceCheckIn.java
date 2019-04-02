/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentattendancecheckin;

import BLL.DateManager;
import BLL.Exceptions.BllException;
import DAL.DateDAO;
import DAL.Exceptions.DalException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kristian Urup laptop
 */
public class StudentAttendanceCheckIn extends Application
{

    @Override
    public void start(Stage stage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/View/PersonalData.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException
    {
        launch(args);
    }

}
