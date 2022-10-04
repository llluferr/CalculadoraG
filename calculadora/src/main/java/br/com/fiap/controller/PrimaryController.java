package br.com.fiap.controller;

import java.io.IOException;

import br.com.fiap.dao.LogDao;
import br.com.fiap.model.Log;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class PrimaryController {

    @FXML private TextField display;

    private double numero1;
    private String operacao;

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

    public void raiz(){
        double valorDoDisplay = Double.valueOf(display.getText());
        double raiz = Math.sqrt(valorDoDisplay);
        display.setText(String.valueOf(raiz));
    }

    public void quadrado(){
        double valorDoDisplay = Double.valueOf(display.getText());
        double quadrado = Math.pow(valorDoDisplay, 2);
        display.setText(String.valueOf(quadrado));
    }

    public void operacao(ActionEvent event){
        Button botao = (Button) event.getSource();
        this.numero1 = Double.valueOf(display.getText());
        this.operacao = botao.getText();
        clear();
    }

    public void calcular(){
        double numero2 = Double.valueOf(display.getText());
        double resultado = 0;
        if(operacao.equals("+")) resultado = numero1 + numero2;
        if(operacao.equals("-")) resultado = numero1 - numero2;
        if(operacao.equals("X")) resultado = numero1 * numero2;
        if(operacao.equals("/")) resultado = numero1 / numero2;
        
        display.setText(String.valueOf(resultado));
        try{
            new LogDao().inserir(new Log(numero1, numero2, operacao, resultado));
        }catch(SQLException e){
            var alerta = new Alert(AlertType.ERROR);
            alerta.setContentText("Nao foi possivel salvar a operacao no BD.");
            alerta.show();
        }

    }

}
