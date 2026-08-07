package br.com.valides.controller.conversoes;

import br.com.valides.model.conversoes.ConversaoData;
import br.com.valides.service.conversoes.ConversaoDataService;
import br.com.valides.util.ScreenManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Controller do módulo Conversão de Datas.
 *
 * Projeto: ValidES
 */

public class ConversaoDataController {

    /*======================================================
     * COMPONENTES DA VIEW
     *======================================================*/

    @FXML
    private TextField txtData;

    @FXML
    private TextArea txtResultado;

    /*======================================================
     * ATRIBUTOS
     *======================================================*/

    private final ConversaoDataService service =
            new ConversaoDataService();

    /*======================================================
     * MÉTODOS PÚBLICOS
     *======================================================*/

    /**
     * Executa o processamento.
     */
    @FXML
    private void executar() {

        ConversaoData conversao = new ConversaoData();

        conversao.setData(txtData.getText());

        String resultado = service.analisar(conversao);

        txtResultado.setText(resultado);

    }

    /**
     * Limpa os campos da tela.
     */
    
    @FXML
    private void limpar() {

        txtData.clear();

        txtResultado.clear();

        txtData.requestFocus();

    }

    /**
     * Fecha a tela.
     */
    @FXML
    private void fechar() {

    	ScreenManager.closeCurrentScreen();

    }

}