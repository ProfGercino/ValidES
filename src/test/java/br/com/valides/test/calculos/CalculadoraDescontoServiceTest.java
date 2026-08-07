package br.com.valides.test.calculos;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.valides.model.calculos.CalculadoraDesconto;
import br.com.valides.service.calculos.CalculadoraDescontoService;

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
                90.00,
                calculadora.getValorFinal(),
                0.01);

    }

}