package br.com.valides.controller.validadores;

import br.com.valides.model.validadores.ValidadorCPF;
import br.com.valides.service.validadores.ValidadorCPFService;
import br.com.valides.util.ScreenManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * ************************************************************
 * Projeto.....: ValidES
 * Módulo......: Validadores
 * Caso de Estudo: Validador de CPF
 *
 * Controller responsável pela comunicação entre a interface
 * gráfica e a camada de serviço.
 *
 * @author
 *************************************************************
 */

public class ValidadorCPFController {

    /*==========================================================
     * COMPONENTES DA INTERFACE
     *==========================================================*/

    @FXML
    private TextField txtCPF;

    @FXML
    private TextArea txtResultado;

    /*==========================================================
     * ATRIBUTOS
     *==========================================================*/

    private final ValidadorCPFService service =
            new ValidadorCPFService();

    /*==========================================================
     * INICIALIZAÇÃO
     *==========================================================*/

    @FXML
    private void initialize() {

        txtResultado.setEditable(false);

    }

    /*==========================================================
     * EVENTOS DOS BOTÕES
     *==========================================================*/

    /**
     * Executa a validação do CPF.
     */
    
    @FXML
    private void executar() {

        try {

            ValidadorCPF cpf = new ValidadorCPF();

            cpf.setCpfInformado(txtCPF.getText());

            String relatorio = service.executar(cpf);

            txtResultado.setText(relatorio);

        } catch (IllegalArgumentException ex) {

            txtResultado.setText(ex.getMessage());

        } catch (Exception ex) {

            txtResultado.setText(
                    "Erro inesperado:\n" + ex.getMessage());

            ex.printStackTrace();

        }

    }

    /**
     * Limpa todos os campos da tela.
     */
    
    @FXML
    private void limpar() {

        txtCPF.clear();

        txtResultado.clear();

        txtCPF.requestFocus();

    }

    /**
     * Fecha a tela atual.
     */
    
    @FXML
    private void fechar() {

        ScreenManager.closeCurrentScreen();

    }

}