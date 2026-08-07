package br.com.valides.controller.trigonometria;

import br.com.valides.model.trigonometria.Triangulo;
import br.com.valides.service.trigonometria.TrianguloService;
import br.com.valides.util.ScreenManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TrianguloController {

    /*======================================================
     * COMPONENTES FXML
     *======================================================*/

    @FXML
    private TextField txtLadoA;

    @FXML
    private TextField txtLadoB;

    @FXML
    private TextField txtLadoC;

    @FXML
    private TextArea txtResultado;

    /*======================================================
     * SERVIÇOS
     *======================================================*/

    private final TrianguloService service = new TrianguloService();

    /*======================================================
     * INICIALIZAÇÃO
     *======================================================*/

    @FXML
    public void initialize() {

        txtResultado.setEditable(false);

        txtLadoA.requestFocus();
    }

    /*======================================================
     * EVENTOS DA INTERFACE
     *======================================================*/

    @FXML
    private void executar() {

        try {

            double ladoA = Double.parseDouble(txtLadoA.getText());

            double ladoB = Double.parseDouble(txtLadoB.getText());

            double ladoC = Double.parseDouble(txtLadoC.getText());

            Triangulo triangulo =
                    new Triangulo(ladoA, ladoB, ladoC);

            txtResultado.setText(
                    service.analisar(triangulo));

        } catch (NumberFormatException ex) {

            txtResultado.setText(
                    "ERRO:\n\nInforme apenas valores numéricos.");
        }
    }

    @FXML
    private void limpar() {

        limparCampos();
    }

    @FXML
    private void fechar() {

        ScreenManager.closeCurrentScreen();
    }

    /*======================================================
     * MÉTODOS AUXILIARES
     *======================================================*/

    private void limparCampos() {

        txtLadoA.clear();
        txtLadoB.clear();
        txtLadoC.clear();

        txtResultado.clear();

        txtLadoA.requestFocus();
    }

}