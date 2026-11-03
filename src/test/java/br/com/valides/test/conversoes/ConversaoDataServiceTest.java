/**
 * ************************************************************
 * Projeto.....: ValidES
 * Módulo......: Conversões
 * Caso de Estudo: Conversão de Datas
 *
 * Classe de testes JUnit.
 *
 * @author
 *************************************************************
 */

package br.com.valides.test.conversoes;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.valides.model.conversoes.ConversaoData;
import br.com.valides.service.conversoes.ConversaoDataService;

public class ConversaoDataServiceTest {

    /**
     * Testa a conversão de uma data comum.
     */
    @Test
    public void deveConverterDataComum() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("15/03/2024");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Data Convertida......: 15 de março de 2024"));

    }

    /**
     * Testa a conversão de uma data com dia e mês com zero à esquerda.
     */
    @Test
    public void deveConverterDataComZeroAEsquerda() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("01/01/2024");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Data Convertida......: 1 de janeiro de 2024"));

    }

    /**
     * Testa a conversão do último dia do ano.
     */
    @Test
    public void deveConverterUltimoDiaDoAno() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("31/12/1999");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Data Convertida......: 31 de dezembro de 1999"));

    }

    /**
     * Testa 29 de fevereiro em ano bissexto.
     */
    @Test
    public void deveConverterVinteENoveDeFevereiroEmAnoBissexto() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("29/02/2024");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Data Convertida......: 29 de fevereiro de 2024"));

    }

    /**
     * Testa 29 de fevereiro em ano bissexto secular (divisível por 400).
     */
    @Test
    public void deveConverterVinteENoveDeFevereiroEmAnoBissextoSecular() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("29/02/2000");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Data Convertida......: 29 de fevereiro de 2000"));

    }

    /**
     * Testa 29 de fevereiro em ano não bissexto.
     */
    @Test
    public void deveRejeitarVinteENoveDeFevereiroEmAnoNaoBissexto() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("29/02/2023");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Data inválida."));

    }

    /**
     * Testa 29 de fevereiro em ano secular não bissexto (1900).
     */
    @Test
    public void deveRejeitarVinteENoveDeFevereiroEmAnoSecularNaoBissexto() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("29/02/1900");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Data inválida."));

    }

    /**
     * Testa o dia 31 em um mês de 30 dias.
     */
    @Test
    public void deveRejeitarDiaTrintaEUmEmMesDeTrintaDias() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("31/04/2024");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Data inválida."));

    }

    /**
     * Testa o dia 30 em fevereiro.
     */
    @Test
    public void deveRejeitarDiaTrintaEmFevereiro() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("30/02/2024");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Data inválida."));

    }

    /**
     * Testa o dia 31 em fevereiro. A data convertida não deve
     * aparecer no relatório.
     */
    @Test
    public void deveRejeitarDiaTrintaEUmEmFevereiro() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("31/02/2023");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Data inválida."));
        assertFalse(relatorio.contains("Data Convertida"));

    }

    /**
     * Testa dias fora do intervalo de 1 a 31.
     */
    @Test
    public void deveRejeitarDiaForaDoIntervalo() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        ConversaoDataService service = new ConversaoDataService();

        String relatorio;

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        conversao.setData("32/01/2024");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Data inválida."));

        conversao.setData("00/01/2024");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Data inválida."));

    }

    /**
     * Testa meses fora do intervalo de 1 a 12.
     */
    @Test
    public void deveRejeitarMesForaDoIntervalo() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        ConversaoDataService service = new ConversaoDataService();

        String relatorio;

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        conversao.setData("01/13/2024");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Data inválida."));

        conversao.setData("01/00/2024");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Data inválida."));

    }

    /**
     * Testa entradas fora do formato dd/MM/yyyy.
     */
    @Test
    public void deveRejeitarFormatoInvalido() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        ConversaoDataService service = new ConversaoDataService();

        String relatorio;

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        conversao.setData("1/1/2024");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Mensagem.............: Formato inválido. Utilize dd/MM/yyyy."));

        conversao.setData("2024-03-15");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Mensagem.............: Formato inválido. Utilize dd/MM/yyyy."));

        conversao.setData("15-03-2024");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Mensagem.............: Formato inválido. Utilize dd/MM/yyyy."));

        conversao.setData("15/03/24");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Mensagem.............: Formato inválido. Utilize dd/MM/yyyy."));

        conversao.setData("15/03/20245");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Mensagem.............: Formato inválido. Utilize dd/MM/yyyy."));

        conversao.setData("ab/cd/efgh");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Mensagem.............: Formato inválido. Utilize dd/MM/yyyy."));

    }

    /**
     * Testa uma data válida com espaços no início e no fim.
     */
    @Test
    public void deveConverterDataComEspacosNasPontas() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        conversao.setData("  15/03/2024 ");

        ConversaoDataService service = new ConversaoDataService();

        // =====================================================
        // ACT
        // =====================================================

        String relatorio = service.analisar(conversao);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(relatorio.contains("Situação.............: SUCESSO"));
        assertTrue(relatorio.contains("Data Convertida......: 15 de março de 2024"));

    }

    /**
     * Testa a data vazia, em branco e nula.
     */
    @Test
    public void deveRejeitarDataNaoInformada() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoData conversao = new ConversaoData();

        ConversaoDataService service = new ConversaoDataService();

        String relatorio;

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        conversao.setData("");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Informe uma data."));

        conversao.setData("   ");
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Informe uma data."));

        conversao.setData(null);
        relatorio = service.analisar(conversao);
        assertTrue(relatorio.contains("Situação.............: ERRO"));
        assertTrue(relatorio.contains("Mensagem.............: Informe uma data."));

    }

    /**
     * Testa o comportamento quando a conversão não é informada.
     */
    @Test
    public void deveRetornarErroQuandoConversaoNula() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ConversaoDataService service = new ConversaoDataService();

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
