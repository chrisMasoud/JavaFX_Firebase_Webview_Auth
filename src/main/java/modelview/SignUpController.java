package modelview;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.UserRecord;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class SignUpController {
    
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private TextField textFieldPhone;
    @FXML
    private TextField textFieldPassword;
    
    public void signUp() {
        String email = textFieldEmail.getText();
        String name = textFieldName.getText();
        String phone = textFieldPhone.getText();
        String password = textFieldPassword.getText();
        UserRecord.CreateRequest request = new UserRecord.CreateRequest()
                .setEmail(email)
                .setEmailVerified(false)
                .setPassword(password)
                .setPhoneNumber(phone)
                .setDisplayName(name)
                .setDisabled(false);
        UserRecord userRecord;
        try {
            userRecord = App.fauth.createUser(request);
            System.out.println("Successfully created new user: " + userRecord.getUid());

        } catch (FirebaseAuthException ex) {
            System.out.println("Error Signing Up");
        }
        try {
            App.setRoot("login.fxml");
        } catch (IOException ex) {
            Logger.getLogger(SignUpController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
