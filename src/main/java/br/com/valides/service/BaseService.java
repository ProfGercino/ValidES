/*
fornecer o cabeçalho padrão dos relatórios;
padronizar o formato de saída;
servir como classe base para todos os Services.
*/
package br.com.valides.service;

import java.util.Locale;

/**
 * Classe base para todos os Services do projeto ValidES.
 *
 * Centraliza a construção do cabeçalho padrão dos relatórios.
 *
 * Projeto: ValidES
 */
public abstract class BaseService {

    /**
     * Cria o cabeçalho padrão dos relatórios.
     *
     * @param modulo   Nome do módulo.
     * @param sucesso  Indica se a execução foi realizada com sucesso.
     * @param mensagem Mensagem principal do processamento.
     *
     * @return StringBuilder contendo o início do relatório.
     */
	
	protected static final Locale LOCALE_BR = Locale.of("pt", "BR");
	
    protected StringBuilder iniciarRelatorio(
            String modulo,
            boolean sucesso,
            String mensagem) {

        StringBuilder sb = new StringBuilder();

        sb.append("============================================================\n");
        sb.append(String.format("MÓDULO...............: %s%n%n", modulo));

        sb.append(String.format(
                "Situação.............: %s%n",
                sucesso ? "SUCESSO" : "ERRO"));

        sb.append(String.format(
                "Mensagem.............: %s%n",
                mensagem));

        sb.append("------------------------------------------------------------\n");

        return sb;
    }

}


