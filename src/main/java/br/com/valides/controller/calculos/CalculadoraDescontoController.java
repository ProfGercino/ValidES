package br.com.valides.controller.calculos;

import br.com.valides.model.calculos.CalculadoraDesconto;
import br.com.valides.service.calculos.CalculadoraDescontoService;
import br.com.valides.util.ScreenManager;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * ************************************************************
 * Projeto.....: ValidES
 * Módulo......: Cálculos
 * Caso de Estudo: Calculadora de Desconto
 *
 * Controller responsável pela interação entre a interface
 * gráfica e a camada de serviço.
 *
 * @author
 *************************************************************
 */
public class CalculadoraDescontoController {

    /*==========================================================
     * COMPONENTES DA INTERFACE
     *==========================================================*/

    @FXML
    private TextField txtValorCompra;

    @FXML
    private TextField txtPercentualDesconto;

    @FXML
    private TextArea txtResultado;

    /*==========================================================
     * ATRIBUTOS
     *==========================================================*/

    private final CalculadoraDescontoService service =
            new CalculadoraDescontoService();

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
     * Executa o cálculo do desconto.
     */
    @FXML
    private void executar() {

        try {

            CalculadoraDesconto calculadora =
                    new CalculadoraDesconto();

            calculadora.setValorCompra(
                    Double.parseDouble(
                            txtValorCompra.getText().replace(",", ".")));

            calculadora.setPercentualDesconto(
                    Double.parseDouble(
                            txtPercentualDesconto.getText().replace(",", ".")));

            String relatorio = service.executar(calculadora);

            txtResultado.setText(relatorio);

        } catch (NumberFormatException ex) {

            txtResultado.setText(
                    "Erro: Informe apenas valores numéricos.");

        } catch (IllegalArgumentException ex) {

            txtResultado.setText(
                    ex.getMessage());

        } catch (Exception ex) {

            txtResultado.setText(
                    "Erro inesperado:\n" + ex.getMessage());

        }

    }

    /**
     * Limpa todos os campos da tela.
     */
    @FXML
    private void limpar() {

        txtValorCompra.clear();
        txtPercentualDesconto.clear();
        txtResultado.clear();

        txtValorCompra.requestFocus();

    }

    /**
     * Fecha a tela atual.
     */
    @FXML
    private void fechar() {

        ScreenManager.closeCurrentScreen();

    }

}