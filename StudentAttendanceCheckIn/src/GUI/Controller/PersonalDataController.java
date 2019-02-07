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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kristian Urup laptop
 */
public class PersonalDataController implements Initializable
{
    
    @FXML
    private TextField txtCprNr;
    
    int textLimit;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        
    }

    @FXML
    private void handleCheckIn(ActionEvent event) throws IOException
    {
        int cprNr = Integer.parseInt(txtCprNr.getText());
        if (cprNr == 1)
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
        txtCprNr.clear();
        textLimit = 0;
    }

    @FXML
    private void btnOne(ActionEvent event)
    {
        if(textLimit == 10)
        {
            
        } else {
            String text = txtCprNr.getText();
            txtCprNr.setText(text + "1");
            textLimit++;
        }
    }

    @FXML
    private void btnTwo(ActionEvent event)
    {
        if(textLimit == 10)
        {
            
        } else {
            String text = txtCprNr.getText();
            txtCprNr.setText(text + "2");
            textLimit++;
        }
    }

    @FXML
    private void btnThree(ActionEvent event)
    {
        if(textLimit == 10)
        {
            
        } else {
            String text = txtCprNr.getText();
            txtCprNr.setText(text + "3");
            textLimit++;
        }
    }

    @FXML
    private void btnFive(ActionEvent event)
    {
        if(textLimit == 10)
        {
            
        } else {
            String text = txtCprNr.getText();
            txtCprNr.setText(text + "5");
            textLimit++;
        }
    }

    @FXML
    private void btnFour(ActionEvent event)
    {
        if(textLimit == 10)
        {
            
        } else {
            String text = txtCprNr.getText();
            txtCprNr.setText(text + "4");
            textLimit++;
        }
    }

    @FXML
    private void btnSix(ActionEvent event)
    {
        if(textLimit == 10)
        {
            
        } else {
            String text = txtCprNr.getText();
            txtCprNr.setText(text + "6");
            textLimit++;
        }
    }

    @FXML
    private void btnSeven(ActionEvent event)
    {
        if(textLimit == 10)
        {
            
        } else {
            String text = txtCprNr.getText();
            txtCprNr.setText(text + "7");
            textLimit++;
        }
    }

    @FXML
    private void btnZero(ActionEvent event)
    {
        if(textLimit == 10)
        {
            
        } else {
            String text = txtCprNr.getText();
            txtCprNr.setText(text + "0");
            textLimit++;
        }
    }

    @FXML
    private void btnNine(ActionEvent event)
    {
        if(textLimit == 10)
        {
            
        } else {
            String text = txtCprNr.getText();
            txtCprNr.setText(text + "9");
            textLimit++;
        }
    }

    @FXML
    private void btnEight(ActionEvent event)
    {
        if(textLimit == 10)
        {
            
        } else {
            String text = txtCprNr.getText();
            txtCprNr.setText(text + "8");
            textLimit++;
        }
    }

    @FXML
    private void backSpace(KeyEvent kEvent)
    {
        if(kEvent.getCode() == KeyCode.BACK_SPACE)
        {
            textLimit --;
        }
    }
}
