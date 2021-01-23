package lk.ijse.thogakade.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class MainFormController {

    public AnchorPane pane;
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
    void customer(MouseEvent event) throws IOException {
        setUi("/lk/ijse/thogakade/view/Customer.fxml");
    }

    @FXML
    void item(MouseEvent event) {

    }

    @FXML
    void order(MouseEvent event) {

    }
    void setUi(String location) throws IOException {
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource(location))));
        stage.show();

        Stage stage1= (Stage) pane.getScene().getWindow();
        stage1.close();
    }

}
