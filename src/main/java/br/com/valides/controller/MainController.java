/*
==============================================================================
Projeto : ValidES
Arquivo : MainController.java
Objetivo: Responsável apenas por responder aos eventos do menu e atualizar a 
 barra de status, enquanto todo o gerenciamento de telas ficará centralizado
 no ScreenManager
==============================================================================
*/

package br.com.valides.controller;

import br.com.valides.util.ScreenManager;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class MainController {

    @FXML
    // Região "área de trabalho" onde as telas filhas aparecerão
    private AnchorPane desktopPane;

    @FXML
    private Label lblUsuario;

    @FXML
    private Label lblStatus;

    @FXML
    private void initialize() {
    	
        ScreenManager.setDesktopPane(desktopPane);

        lblUsuario.setText("Administrador");
        lblStatus.setText("Sistema iniciado");
    }

    @FXML
    private void abrirTriangulo() {

    	    ScreenManager.open("Problema do Triângulo",
    	            "/br/com/valides/fxml/trigonometria/TrianguloView.fxml");

    	    lblStatus.setText("Tela Atual: Problema do Triângulo");
	}

    @FXML
    private void abrirConversaoData() {

        ScreenManager.open("Conversão de Datas",
            "/br/com/valides/fxml/conversoes/ConversaoDataView.fxml");
        
        lblStatus.setText("Tela Atual: Conversão de Datas");
    }
    
    @FXML
    private void abrirCalculadoraDesconto() {
    	
    	ScreenManager.open("Calcular Desconto",
    		"/br/com/valides/fxml/calculos/CalculadoraDescontoView.fxml");
    	
    	lblStatus.setText("Tela Atual: Calculando Descontos");    
    }
    
    @FXML
    private void abrirValidadorCPF() {
    	
    	ScreenManager.open("Validador de CPF",
    		"/br/com/valides/fxml/validadores/ValidadorCPFView.fxml");
    	
    	lblStatus.setText("Tela Atual: Validador de CPF");    
    }
    
    @FXML
    private void abrirClassificacaoTriagulos() {

        lblStatus.setText("Classificação de Triângulos");
    }
    
    @FXML
    private void abrirSenos() {

        lblStatus.setText("Lei dos Senos");
    }
    
 
    @FXML
    private void abrirCossenos() {

        lblStatus.setText("Lei dos Cossenos");
    }

    @FXML
    private void encerrarSistema() {
        Platform.exit();
    }
}
