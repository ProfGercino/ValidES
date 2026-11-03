/**
 * ************************************************************
 * Projeto.....: ValidES
 * Módulo......: Trigonometria
 * Caso de Estudo: Problema do Triângulo
 *
 * Classe de testes JUnit.
 *
 * @author
 *************************************************************
 */

package br.com.valides.test.trigonometria;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import br.com.valides.model.trigonometria.Triangulo;
import br.com.valides.service.trigonometria.TrianguloService;

public class TrianguloServiceTest {

    /**
     * Testa um triângulo com os três lados iguais.
     */
    @Test
    public void deveClassificarTrianguloEquilatero() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(3.0);
        triangulo.setLadoB(3.0);
        triangulo.setLadoC(3.0);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Classificação........: EQUILÁTERO"));

    }

    /**
     * Testa um triângulo equilátero com lados decimais.
     */
    @Test
    public void deveClassificarTrianguloEquilateroComLadosDecimais() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(1.5);
        triangulo.setLadoB(1.5);
        triangulo.setLadoC(1.5);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Classificação........: EQUILÁTERO"));

    }

    /**
     * Testa um triângulo isósceles com os lados A e B iguais.
     */
    @Test
    public void deveClassificarTrianguloIsoscelesComLadosAeBIguais() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(3.0);
        triangulo.setLadoB(3.0);
        triangulo.setLadoC(5.0);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Classificação........: ISÓSCELES"));

    }

    /**
     * Testa um triângulo isósceles com os lados A e C iguais.
     */
    @Test
    public void deveClassificarTrianguloIsoscelesComLadosAeCIguais() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(3.0);
        triangulo.setLadoB(5.0);
        triangulo.setLadoC(3.0);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Classificação........: ISÓSCELES"));

    }

    /**
     * Testa um triângulo isósceles com os lados B e C iguais.
     */
    @Test
    public void deveClassificarTrianguloIsoscelesComLadosBeCIguais() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(5.0);
        triangulo.setLadoB(3.0);
        triangulo.setLadoC(3.0);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Classificação........: ISÓSCELES"));

    }

    /**
     * Testa um triângulo com os três lados diferentes.
     */
    @Test
    public void deveClassificarTrianguloEscaleno() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(3.0);
        triangulo.setLadoB(4.0);
        triangulo.setLadoC(5.0);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Classificação........: ESCALENO"));

    }

    /**
     * Testa um lado igual a zero em cada posição.
     */
    @Test
    public void deveRejeitarLadoIgualAZero() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        TrianguloService service = new TrianguloService();

        String relatorio;

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        triangulo.setLadoA(0.0);
        triangulo.setLadoB(1.0);
        triangulo.setLadoC(1.0);
        relatorio = service.analisar(triangulo);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Todos os lados devem ser maiores que zero."));

        triangulo.setLadoA(1.0);
        triangulo.setLadoB(0.0);
        triangulo.setLadoC(1.0);
        relatorio = service.analisar(triangulo);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Todos os lados devem ser maiores que zero."));

        triangulo.setLadoA(1.0);
        triangulo.setLadoB(1.0);
        triangulo.setLadoC(0.0);
        relatorio = service.analisar(triangulo);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Todos os lados devem ser maiores que zero."));

    }

    /**
     * Testa um lado com valor negativo.
     */
    @Test
    public void deveRejeitarLadoNegativo() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(-3.0);
        triangulo.setLadoB(4.0);
        triangulo.setLadoC(5.0);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Todos os lados devem ser maiores que zero."));

    }

    /**
     * Testa a fronteira da desigualdade triangular: um lado igual
     * à soma dos outros dois, em cada posição.
     */
    @Test
    public void deveRejeitarTrianguloDegenerado() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        TrianguloService service = new TrianguloService();

        String relatorio;

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        triangulo.setLadoA(1.0);
        triangulo.setLadoB(2.0);
        triangulo.setLadoC(3.0);
        relatorio = service.analisar(triangulo);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Os valores informados não formam um triângulo."));

        triangulo.setLadoA(3.0);
        triangulo.setLadoB(1.0);
        triangulo.setLadoC(2.0);
        relatorio = service.analisar(triangulo);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Os valores informados não formam um triângulo."));

        triangulo.setLadoA(2.0);
        triangulo.setLadoB(3.0);
        triangulo.setLadoC(1.0);
        relatorio = service.analisar(triangulo);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Os valores informados não formam um triângulo."));

    }

    /**
     * Testa um lado maior que a soma dos outros dois, em cada posição.
     */
    @Test
    public void deveRejeitarLadoMaiorQueASomaDosOutros() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        TrianguloService service = new TrianguloService();

        String relatorio;

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        triangulo.setLadoA(1.0);
        triangulo.setLadoB(2.0);
        triangulo.setLadoC(10.0);
        relatorio = service.analisar(triangulo);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Os valores informados não formam um triângulo."));

        triangulo.setLadoA(10.0);
        triangulo.setLadoB(1.0);
        triangulo.setLadoC(2.0);
        relatorio = service.analisar(triangulo);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Os valores informados não formam um triângulo."));

        triangulo.setLadoA(2.0);
        triangulo.setLadoB(10.0);
        triangulo.setLadoC(1.0);
        relatorio = service.analisar(triangulo);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Os valores informados não formam um triângulo."));

    }

    /**
     * Testa um triângulo degenerado com lados decimais
     * (0,1 + 0,2 = 0,3).
     */
    @Test
    public void deveRejeitarTrianguloDegeneradoComLadosDecimais() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(0.1);
        triangulo.setLadoB(0.2);
        triangulo.setLadoC(0.3);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Os valores informados não formam um triângulo."));

    }

    /**
     * Testa um lado não numérico (NaN).
     */
    @Test
    public void deveRejeitarLadoNaoNumerico() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(Double.NaN);
        triangulo.setLadoB(1.0);
        triangulo.setLadoC(1.0);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: ERRO"));

    }

    /**
     * Testa um lado infinito.
     */
    @Test
    public void deveRejeitarLadoInfinito() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(Double.POSITIVE_INFINITY);
        triangulo.setLadoB(1.0);
        triangulo.setLadoC(1.0);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: ERRO"));

    }

    /**
     * Testa se os lados são exibidos no padrão brasileiro,
     * independente do idioma configurado na máquina.
     */
    @Test
    public void deveExibirLadosNoPadraoBrasileiro() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(3.0);
        triangulo.setLadoB(4.5);
        triangulo.setLadoC(5.25);

        TrianguloService service = new TrianguloService();

        Locale localeOriginal = Locale.getDefault();

        Locale.setDefault(Locale.US);

        // =====================================================
        // ACT
        // =====================================================

        String relatorio;

        try {

            relatorio = service.analisar(triangulo);

        } finally {

            Locale.setDefault(localeOriginal);

        }

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Lado A...............: 3,00"));
        assertTrue(relatorio.contains("Lado B...............: 4,50"));
        assertTrue(relatorio.contains("Lado C...............: 5,25"));

    }

    /**
     * Testa se a classificação não aparece quando o triângulo é inválido.
     */
    @Test
    public void naoDeveExibirClassificacaoQuandoTrianguloInvalido() {

        // =====================================================
        // ARRANGE
        // =====================================================

        Triangulo triangulo = new Triangulo();

        triangulo.setLadoA(1.0);
        triangulo.setLadoB(2.0);
        triangulo.setLadoC(3.0);

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(triangulo);

        // =====================================================
        // ASSERT
        // =====================================================

        assertFalse(relatorio.contains("Classificação"));

    }

    /**
     * Testa o comportamento quando o triângulo não é informado.
     */
    @Test
    public void deveRetornarErroQuandoTrianguloNulo() {

        // =====================================================
        // ARRANGE
        // =====================================================

        TrianguloService service = new TrianguloService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(null);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: ERRO"));

    }

}
