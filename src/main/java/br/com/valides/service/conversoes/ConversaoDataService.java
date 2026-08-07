package br.com.valides.service.conversoes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import br.com.valides.model.conversoes.ConversaoData;
import br.com.valides.service.BaseService;

/**
 * Serviço responsável pelas regras de negócio do módulo
 * Conversão de Datas.
 *
 * Projeto: ValidES
 */
public class ConversaoDataService extends BaseService {

    /*======================================================
     * MÉTODOS PÚBLICOS
     *======================================================*/

    /**
     * Analisa a data informada.
     *
     * @param conversaoData Data informada pelo usuário.
     * @return Relatório da análise.
     */
	
    public String analisar(ConversaoData conversaoData) {

        boolean sucesso;
        String mensagem;
        String dataExtenso = "";

        if (!dataInformada(conversaoData)) {

            sucesso = false;
            mensagem = "Informe uma data.";

        } else if (!formatoValido(conversaoData)) {

            sucesso = false;
            mensagem = "Formato inválido. Utilize dd/MM/yyyy.";

        } else {

            LocalDate data = converterParaData(conversaoData);

            if (data == null) {

                sucesso = false;
                mensagem = "Data inválida.";

            } else {

                sucesso = true;
                mensagem = "Conversão realizada com sucesso.";

                dataExtenso = converterParaExtenso(data);
            }

        }

        return montarRelatorio(
                conversaoData,
                sucesso,
                mensagem,
                dataExtenso);
    }

    /*======================================================
     * VALIDAÇÕES
     *======================================================*/

    /**
     * Verifica se a data foi informada.
     */
    private boolean dataInformada(ConversaoData conversaoData) {

        return conversaoData.getData() != null
                && !conversaoData.getData().trim().isEmpty();
    }

    /**
     * Verifica se o formato é válido.
     */
    private boolean formatoValido(ConversaoData conversaoData) {

        return conversaoData.getData()
                .matches("\\d{2}/\\d{2}/\\d{4}");
    }

    /*======================================================
     * REGRAS DE NEGÓCIO
     *======================================================*/

    /**
     * Converte a String para LocalDate.
     */
    private LocalDate converterParaData(
            ConversaoData conversaoData) {

        try {

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            return LocalDate.parse(
                    conversaoData.getData(),
                    formatter);

        } catch (DateTimeParseException ex) {

            return null;
        }

    }

    /**
     * Converte a data para o formato por extenso.
     */
    private String converterParaExtenso(LocalDate data) {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern(
                        "d 'de' MMMM 'de' yyyy",
                        Locale.of("pt", "BR"));

        return data.format(formatter);
    }

    /*======================================================
     * GERAÇÃO DO RELATÓRIO
     *======================================================*/

    /**
     * Monta o relatório do processamento.
     */
    private String montarRelatorio(
            ConversaoData conversaoData,
            boolean sucesso,
            String mensagem,
            String dataExtenso) {

        StringBuilder sb = iniciarRelatorio(
                "CONVERSÃO DE DATAS",
                sucesso,
                mensagem);

        sb.append("\n");

        sb.append(String.format(
                "Data Informada.......: %s%n",
                conversaoData.getData()));

        if (sucesso) {

            sb.append(String.format(
                    "Data Convertida......: %s%n",
                    dataExtenso));

        }

        return sb.toString();

    }

}