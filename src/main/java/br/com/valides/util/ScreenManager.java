/*
==============================================================================
Projeto : ValidES
Arquivo : ScreenManager.java
Objetivo: Responsável por: abrir telas, fechar telas, impedir duas telas 
  abertas, centralizar todas as operações do MDI.
==============================================================================
*/

package br.com.valides.util;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;

public final class ScreenManager {

    private static AnchorPane desktopPane;

    private static Node currentScreen;

    private ScreenManager() {
    }

    public static void setDesktopPane(AnchorPane pane) {

        desktopPane = pane;

    }

    public static void open(String titulo, String fxml) {

        if (desktopPane == null) {

            throw new IllegalStateException(
                    "DesktopPane não inicializado.");

        }

        try {
        	
            FXMLLoader loader = new FXMLLoader(
                    ScreenManager.class.getResource(fxml));

            Node tela = loader.load();

            desktopPane.getChildren().clear();

            desktopPane.getChildren().add(tela);
                  
            AnchorPane.setTopAnchor(tela, 0.0);
            AnchorPane.setBottomAnchor(tela, 0.0);
            AnchorPane.setLeftAnchor(tela, 0.0);
            AnchorPane.setRightAnchor(tela, 0.0);

            currentScreen = tela;

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    public static void closeCurrentScreen() {

        if (desktopPane != null) {

            desktopPane.getChildren().clear();

            currentScreen = null;

        }

    }

    public static boolean hasScreenOpen() {

        return currentScreen != null;

    }

}