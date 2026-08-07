package br.com.valides.model.calculos;

/**
 * ************************************************************
 * Projeto.....: ValidES
 * Módulo......: Cálculos
 * Caso de Estudo: Calculadora de Desconto
 *
 * Classe responsável por armazenar os dados utilizados no
 * cálculo do desconto aplicado a uma compra.
 *
 * Esta classe não contém regras de negócio.
 *
 * @author
 *************************************************************
 */
public class CalculadoraDesconto {

    /*==========================================================
     * ATRIBUTOS
     *==========================================================*/

    /**
     * Valor original da compra.
     */
    private double valorCompra;

    /**
     * Percentual de desconto informado pelo usuário.
     */
    private double percentualDesconto;

    /**
     * Valor monetário do desconto calculado.
     */
    private double valorDesconto;

    /**
     * Valor final da compra após aplicação do desconto.
     */
    private double valorFinal;

    /*==========================================================
     * CONSTRUTORES
     *==========================================================*/

    /**
     * Construtor padrão.
     */
    public CalculadoraDesconto() {

    }

    /**
     * Construtor com parâmetros.
     *
     * @param valorCompra Valor da compra.
     * @param percentualDesconto Percentual de desconto.
     */
    public CalculadoraDesconto(double valorCompra,
                               double percentualDesconto) {

        this.valorCompra = valorCompra;
        this.percentualDesconto = percentualDesconto;

    }

    /*==========================================================
     * GETTERS E SETTERS
     *==========================================================*/

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double getPercentualDesconto() {
        return percentualDesconto;
    }

    public void setPercentualDesconto(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    public double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    /*==========================================================
     * MÉTODOS AUXILIARES
     *==========================================================*/

    @Override
    public String toString() {

        return "CalculadoraDesconto [valorCompra=" + valorCompra
                + ", percentualDesconto=" + percentualDesconto
                + ", valorDesconto=" + valorDesconto
                + ", valorFinal=" + valorFinal + "]";

    }

}