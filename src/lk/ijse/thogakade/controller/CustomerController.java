package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import lk.ijse.thogakade.bo.BoFactory;
import lk.ijse.thogakade.bo.custom.impl.CustomerBoImpl;
import lk.ijse.thogakade.dto.CustomerDTO;

public class CustomerController {

    @FXML
    private Label lblId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtSalary;

    @FXML
    private JFXButton btnSave;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private TableView<?> table;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colSalary;

    @FXML
    private TableColumn<?, ?> colOperator;

    CustomerBoImpl customerBo = BoFactory.getInstance().getBo(BoFactory.BoType.CUSTOMER);

    @FXML
    void save(ActionEvent event) throws Exception {
        boolean b = customerBo.addCustomer(new CustomerDTO(1,txtName.getText(),txtAddress.getText(),txtSalary.getText()));
        if (b){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText(null);
            alert.setContentText("Customer Added...");
            alert.showAndWait();
        }else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Customer Added Failed...");
            alert.showAndWait();
        }

    }
}
