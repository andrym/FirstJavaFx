package fr.matthieu;
/*
Put header here


 */

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    private float res;
    private Map<String, String> convertsymbol = Map.of("Dollar", "$", "Euro", "€", "Pound", "£", "Yen", "¥");
    private Map<String, Double> convertValues = Map.of("Dollar", 1.18, "Euro", 1.00, "Pound", 0.86, "Yen", 129.81);
    private ObservableList<String> currencyList = FXCollections.observableArrayList("Dollar", "Euro", "Pound", "Yen");
    @FXML
    private TextField tfToConvert;
    @FXML
    private Label lblConvertResult;
    @FXML
    private ComboBox cbxCurrencyToConvert;
    @FXML
    private ComboBox cbxConvertedCurrency;
    @FXML
    private Label lblCurrencySymbol;

    @FXML
    public void onConvertAction() {
        res = Float.parseFloat(tfToConvert.getText());
        res *= convertValues.get(cbxCurrencyToConvert.getValue());
        res /= convertValues.get(cbxConvertedCurrency.getValue());
        // System.out.println("value1: " + cbxCurrencyToConvert.getValue());
        // System.out.println("value2: " + cbxConvertedCurrency.getValue());
        // System.out.println("value4: " + convertValues.get(cbxCurrencyToConvert.getValue()));
        // System.out.println("value3: " + convertValues.get(cbxConvertedCurrency.getValue()));
        lblConvertResult.setText(String.valueOf(res));
        
    }

    @FXML
    public void onCurrencyChange() {
        lblCurrencySymbol.setText(convertsymbol.get(cbxConvertedCurrency.getValue()));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lblConvertResult.setText("0");
        lblCurrencySymbol.setText(convertsymbol.get("Dollar"));
        cbxConvertedCurrency.setValue("Dollar");
        cbxConvertedCurrency.setItems(currencyList);
        cbxCurrencyToConvert.setValue("Euro");
        cbxCurrencyToConvert.setItems(currencyList);

    }
}
