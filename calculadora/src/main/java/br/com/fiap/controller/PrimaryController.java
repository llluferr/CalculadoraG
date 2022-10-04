package br.com.fiap.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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
    }

}
