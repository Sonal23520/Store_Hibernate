package lk.ijse.thogakade.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.thogakade.bo.BoFactory;
import lk.ijse.thogakade.bo.custom.impl.CustomerBoImpl;
import lk.ijse.thogakade.dto.CustomerDTO;
import lk.ijse.thogakade.view.tm.CustomerTM;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

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
    private TableView<CustomerTM> table;

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
    ObservableList<CustomerTM> customerTMS = FXCollections.observableArrayList();
    @FXML
    void save(ActionEvent event) throws Exception {

        boolean b = customerBo.addCustomer(new CustomerDTO(1,txtName.getText(),txtAddress.getText(),txtSalary.getText()));
        if (b){
            alert("Customer Added...", Alert.AlertType.CONFIRMATION);
        }else {
            alert("Customer Added Failed...", Alert.AlertType.ERROR);
        }

        ArrayList<CustomerDTO> all = customerBo.getAll();
        CustomerDTO customerDTO1 = all.get(all.size() - 1);
        lblId.setText(String.valueOf(customerDTO1.getId()+1));
        loadTable();
        txtName.clear();
        txtAddress.clear();
        txtSalary.clear();

    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            ArrayList<CustomerDTO> all = customerBo.getAll();
            if (all.size()>0) {
            CustomerDTO customerDTO1 = all.get(all.size() - 1);
            lblId.setText(String.valueOf(customerDTO1.getId() + 1));
        }

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        colOperator.setCellValueFactory(new PropertyValueFactory<>("jfxButton"));

        loadTable();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    ///////////////////////////////////////////////////////////////////
    void alert(String msg, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    void loadTable() throws Exception {
        customerTMS.clear();
        table.refresh();
        ArrayList<CustomerDTO> all = customerBo.getAll();
        for (CustomerDTO customerDTO : all) {

            JFXButton jfxButton = new JFXButton("Delete");
            jfxButton.setStyle("-fx-background-color: #e74c3c; ");

            customerTMS.add(new CustomerTM(customerDTO.getId(),customerDTO.getName(),customerDTO.getAddress()
            ,customerDTO.getSalary(),jfxButton));

            jfxButton.setOnAction((e)->{
                try {
                    customerBo.deleteCustomer(String.valueOf(customerDTO.getId()));
                    loadTable();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            });
        }
        table.setItems(customerTMS);
    }

    public void search(ActionEvent actionEvent) throws Exception {
//
//        for (CustomerTM customerTM:customerTMS) {
//            if (customerTM.getId()!=Integer.parseInt(txtSearch.getText().trim())){
//                System.out.println("okk");
//            }
//        }
        CustomerDTO customerDTO = customerBo.searchCustomer(txtSearch.getText().trim());
        lblId.setText(String.valueOf(customerDTO.getId()));
        txtName.setText(customerDTO.getName());
        txtAddress.setText(customerDTO.getAddress());
        txtSalary.setText(customerDTO.getSalary());
        txtSearch.clear();


    }
}
