package com.example.javafx;

import com.example.javafx.entities.Rent;
import com.example.javafx.enums.RepoType;
import com.example.javafx.factory.RepositoryFactory;
import com.example.javafx.impls.RentRepository;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class RentListController implements Initializable {
    public TableView<Rent> tbRents;
    public TableColumn<Rent, Integer> tdId;
    public TableColumn<Rent, String> tdBook;
    public TableColumn<Rent, Date> tdRentDate;
    public TableColumn<Rent, Date> tdExpDate;
    public TableColumn<Rent, String> tdStatus;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tdId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tdBook.setCellValueFactory(new PropertyValueFactory<>("bookName"));
        tdRentDate.setCellValueFactory(new PropertyValueFactory<>("rentDate"));
        tdExpDate.setCellValueFactory(new PropertyValueFactory<>("expDate"));
        tdStatus.setCellValueFactory(new PropertyValueFactory<>("statusLabel"));
        RentRepository rp = (RentRepository) RepositoryFactory.createRepository(RepoType.RENT);
        tbRents.getItems().addAll(rp.all());
    }

    public void backHome() throws IOException {
        Parent back = FXMLLoader.load(getClass().getResource("home.fxml"));
        Main.rootStage.setTitle("Book Rent");
        Main.rootStage.setScene(new Scene(back,600,400));
    }
}
