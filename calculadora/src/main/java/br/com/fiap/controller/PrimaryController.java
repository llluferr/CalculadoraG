package br.com.fiap.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField display;

    public void digitarNumero(ActionEvent event) {
        Button botao = (Button) event.getSource(); 
        String valorDoDisplay = display.getText();
        if (valorDoDisplay.equals("0")) valorDoDisplay = "";
        display.setText(valorDoDisplay + botao.getText());
    }

    public void clear(){
        display.setText("0");
    }
    
    public void delete(){
        String valorDoDisplay = display.getText();
        valorDoDisplay = valorDoDisplay.substring(0, valorDoDisplay.length() - 1);
        display.setText(valorDoDisplay);
    }

}
