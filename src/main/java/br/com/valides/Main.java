/**
 * ValidES - Aplicativo Pedagógico para Engenharia de Software.
 * Desenvolvedor: Prof. Gercino
 * 
 */

package br.com.valides;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader(
                getClass().getResource(
                        "/br/com/valides/fxml/MainView.fxml"));

        Scene scene = new Scene(loader.load());

        scene.getStylesheets().add(
        	    getClass()
        	        .getResource("/br/com/valides/styles/application.css")
        	        .toExternalForm()
        );
        
        stage.setTitle("ValidES");
        stage.setScene(scene);

        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}