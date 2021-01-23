package lk.ijse.thogakade.controller;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainFormController {

    @FXML
    private AnchorPane paneCustomer;

    @FXML
    private ImageView imgCustomer;

    @FXML
    private AnchorPane paneItem;

    @FXML
    private ImageView imgItem;

    @FXML
    private AnchorPane paneOrder;

    @FXML
    private ImageView imgOrder;

    @FXML
    private AnchorPane paneClose;

    @FXML
    private ImageView imgClose;

    @FXML
    void close(MouseEvent event) {
        Stage stage= (Stage) paneClose.getScene().getWindow();
        stage.close();

    }

    @FXML
    void customer(MouseEvent event) {

    }

    @FXML
    void item(MouseEvent event) {

    }

    @FXML
    void order(MouseEvent event) {

    }

}
