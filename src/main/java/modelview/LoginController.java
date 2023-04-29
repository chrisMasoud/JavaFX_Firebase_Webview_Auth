
package modelview;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LoginController {
    
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldPassword;
    
    public void login(ActionEvent event) {
        String email = textFieldEmail.getText();
        String password = textFieldPassword.getText();
        
        if (email.isEmpty() || password.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Please enter both email and password!");
            alert.showAndWait();
            return;
        }

        try {
            UserRecord user = FirebaseAuth.getInstance().getUserByEmail(email);
                        if (user != null) {
                            try {
                                App.setRoot("AccessFBView.fxml");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Invalid email or password!");
                            alert.showAndWait();
                        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void close() {
        System.exit(0);
    }
    
    public void goToSignUp() {
         try {
             App.setRoot("signUp.fxml");
         } catch (IOException ex) {
             Logger.getLogger(AccessFBView.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
}
