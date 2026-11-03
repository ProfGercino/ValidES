/**
 * ************************************************************
 * Projeto.....: ValidES
 * Módulo......: Cálculos
 * Caso de Estudo: Calculadora de Desconto
 *
 * Classe de testes JUnit.
 *
 * @author
 *************************************************************
 */

package br.com.valides.test.calculos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import br.com.valides.model.calculos.CalculadoraDesconto;
import br.com.valides.service.calculos.CalculadoraDescontoService;

public class CalculadoraDescontoServiceTest {

    /**
     * Testa um desconto de 10%.
     */
    @Test
    public void deveCalcularDescontoDeDezPorCento() {

        // =====================================================
        // ARRANGE
        // =====================================================

        CalculadoraDesconto calculadora = new CalculadoraDesconto();

        calculadora.setValorCompra(100.00);
        calculadora.setPercentualDesconto(10.00);

        CalculadoraDescontoService service =
                new CalculadoraDescontoService();

        // =====================================================
        // ACT
        // =====================================================

        service.executar(calculadora);

        // =====================================================
        // ASSERT
        // =====================================================

        assertEquals(
                10.00,
                calculadora.getValorDesconto(),
                0.01);

        assertEquals(
                90.00,
                calculadora.getValorFinal(),
                0.01);

    }

    /**
     * Testa o limite máximo permitido: desconto de 100%.
     */
    @Test
    public void deveCalcularDescontoDeCemPorCento() {

        // =====================================================
        // ARRANGE
        // =====================================================

        CalculadoraDesconto calculadora = new CalculadoraDesconto();

        calculadora.setValorCompra(100.00);
        calculadora.setPercentualDesconto(100.00);

        CalculadoraDescontoService service =
                new CalculadoraDescontoService();

        // =====================================================
        // ACT
        // =====================================================

        service.executar(calculadora);

        // =====================================================
        // ASSERT
        // =====================================================

        assertEquals(
                100.00,
                calculadora.getValorDesconto(),
                0.01);

        assertEquals(
                0.00,
                calculadora.getValorFinal(),
                0.01);

    }

    /**
     * Testa um percentual logo acima do limite (100,01%).
     */
    @Test
    public void deveRejeitarDescontoLogoAcimaDeCemPorCento() {

        // =====================================================
        // ARRANGE
        // =====================================================

        CalculadoraDesconto calculadora = new CalculadoraDesconto();

        calculadora.setValorCompra(100.00);
        calculadora.setPercentualDesconto(100.01);

        CalculadoraDescontoService service =
                new CalculadoraDescontoService();

        // =====================================================
        // ACT
        // =====================================================

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> service.executar(calculadora));

        // =====================================================
        // ASSERT
        // =====================================================

        assertEquals(
                "O percentual de desconto não pode ser superior a 100%.",
                excecao.getMessage());

    }

    /**
     * Testa um percentual bem acima do limite (150%).
     */
    @Test
    public void deveRejeitarDescontoDeCentoECinquentaPorCento() {

        // =====================================================
        // ARRANGE
        // =====================================================

        CalculadoraDesconto calculadora = new CalculadoraDesconto();

        calculadora.setValorCompra(100.00);
        calculadora.setPercentualDesconto(150.00);

        CalculadoraDescontoService service =
                new CalculadoraDescontoService();

        // =====================================================
        // ACT
        // =====================================================

        IllegalArgumentException excecao = assertThrows(
                IllegalArgumentException.class,
                () -> service.executar(calculadora));

        // =====================================================
        // ASSERT
        // =====================================================

        assertEquals(
                "O percentual de desconto não pode ser superior a 100%.",
                excecao.getMessage());

    }

    /**
     * Testa um valor de compra não numérico (NaN).
     */
    @Test
    public void deveRejeitarValorDaCompraNaoNumerico() {

        // =====================================================
        // ARRANGE
        // =====================================================

        CalculadoraDesconto calculadora = new CalculadoraDesconto();

        calculadora.setValorCompra(Double.NaN);
        calculadora.setPercentualDesconto(10.00);

        CalculadoraDescontoService service =
                new CalculadoraDescontoService();

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        assertThrows(
                IllegalArgumentException.class,
                () -> service.executar(calculadora));

    }

    /**
     * Testa um percentual de desconto não numérico (NaN).
     */
    @Test
    public void deveRejeitarPercentualDeDescontoNaoNumerico() {

        // =====================================================
        // ARRANGE
        // =====================================================

        CalculadoraDesconto calculadora = new CalculadoraDesconto();

        calculadora.setValorCompra(100.00);
        calculadora.setPercentualDesconto(Double.NaN);

        CalculadoraDescontoService service =
                new CalculadoraDescontoService();

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        assertThrows(
                IllegalArgumentException.class,
                () -> service.executar(calculadora));

    }

}
