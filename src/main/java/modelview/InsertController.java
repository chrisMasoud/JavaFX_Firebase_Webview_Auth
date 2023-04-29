package modelview;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.WriteResult;
import com.mycompany.mvvmexample.App;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class InsertController {
    
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldMajor;
    @FXML
    private TextField textFieldAge;
    
    public void insert() {
        DocumentReference docRef = App.fstore.collection("References").document(UUID.randomUUID().toString());
        Map<String, Object> data = new HashMap<>();
        data.put("Name", textFieldName.getText());
        data.put("Major", textFieldMajor.getText());
        data.put("Age", Integer.valueOf(textFieldAge.getText()));
        ApiFuture<WriteResult> result = docRef.set(data);
        try {
            App.setRoot("AccessFBView.fxml");
        } catch (IOException ex) {
            Logger.getLogger(InsertController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
