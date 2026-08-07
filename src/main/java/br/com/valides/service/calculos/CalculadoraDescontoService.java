package br.com.valides.service.calculos;

import br.com.valides.model.calculos.CalculadoraDesconto;
import br.com.valides.service.BaseService;

/**
 * ************************************************************
 * Projeto.....: ValidES
 * Módulo......: Cálculos
 * Caso de Estudo: Calculadora de Desconto
 *
 * Service responsável pelas regras de negócio da Calculadora
 * de Desconto.
 *
 * @author
 *************************************************************
 */
public class CalculadoraDescontoService extends BaseService {

    /*==========================================================
     * MÉTODOS PÚBLICOS
     *==========================================================*/

    /**
     * Executa o cálculo do desconto.
     *
     * @param calculadora Objeto contendo os dados da operação.
     * @return Relatório textual.
     */
    public String executar(CalculadoraDesconto calculadora) {

        validar(calculadora);

        calcular(calculadora);

        return gerarRelatorio(calculadora);

    }

    /*==========================================================
     * VALIDAÇÕES
     *==========================================================*/

    /**
     * Valida os dados informados pelo usuário.
     *
     * @param calculadora Dados da operação.
     */
    private void validar(CalculadoraDesconto calculadora) {

        if (calculadora == null) {

            throw new IllegalArgumentException(
                    "Objeto CalculadoraDesconto não pode ser nulo.");

        }

        if (calculadora.getValorCompra() <= 0) {

            throw new IllegalArgumentException(
                    "O valor da compra deve ser maior que zero.");

        }

        if (calculadora.getPercentualDesconto() < 0) {

            throw new IllegalArgumentException(
                    "O percentual de desconto não pode ser negativo.");

        }

        if (calculadora.getPercentualDesconto() > 100) {

            throw new IllegalArgumentException(
                    "O percentual de desconto não pode ser superior a 100%.");

        }

    }

    /*==========================================================
     * REGRAS DE NEGÓCIO
     *==========================================================*/

    /**
     * Realiza os cálculos.
     *
     * @param calculadora Dados da operação.
     */
    private void calcular(CalculadoraDesconto calculadora) {

        double valorDesconto =
                calculadora.getValorCompra()
                * calculadora.getPercentualDesconto()
                / 100.0;

        double valorFinal =
                calculadora.getValorCompra()
                - valorDesconto;

        calculadora.setValorDesconto(valorDesconto);
        calculadora.setValorFinal(valorFinal);

    }

    /*==========================================================
     * GERAÇÃO DO RELATÓRIO
     *==========================================================*/

    /**
     * Gera o relatório apresentado ao usuário.
     *
     * @param calculadora Dados da operação.
     * @return Relatório formatado.
     */
    private String gerarRelatorio(CalculadoraDesconto calculadora) {

        StringBuilder sb = new StringBuilder();

        sb.append("========================================\n");
        sb.append("      CALCULADORA DE DESCONTO\n");
        sb.append("========================================\n\n");

        sb.append(String.format(
                LOCALE_BR,
                "Valor da compra.....: R$ %,.2f%n",
                calculadora.getValorCompra()));

        sb.append(String.format(
                LOCALE_BR,
                "Desconto............: %,.2f%%%n",
                calculadora.getPercentualDesconto()));

        sb.append(String.format(
                LOCALE_BR,
                "Valor do desconto...: R$ %,.2f%n",
                calculadora.getValorDesconto()));

        sb.append(String.format(
                LOCALE_BR,
                "Valor final.........: R$ %,.2f%n",
                calculadora.getValorFinal()));

        return sb.toString();

    }

}