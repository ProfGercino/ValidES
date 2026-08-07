package br.com.valides.service.trigonometria;

import br.com.valides.model.trigonometria.Triangulo;
import br.com.valides.service.BaseService;

/**
 * Serviço responsável pelas regras de negócio do módulo
 * Problema do Triângulo.
 *
 * Projeto: ValidES
 */
public class TrianguloService extends BaseService {

    /*======================================================
     * MÉTODOS PÚBLICOS
     *======================================================*/

    /**
     * Analisa o triângulo informado.
     *
     * @param triangulo objeto contendo os lados.
     * @return relatório da análise.
     */
	public String analisar(Triangulo triangulo) {

	    boolean sucesso;
	    String mensagem;
	    String classificacao = "";

	    if (!ladosValidos(triangulo)) {

	        sucesso = false;
	        mensagem = "Todos os lados devem ser maiores que zero.";

	    } else if (!formaTriangulo(triangulo)) {

	        sucesso = false;
	        mensagem = "Os valores informados não formam um triângulo.";

	    } else {

	        sucesso = true;
	        mensagem = "Triângulo válido.";
	        classificacao = classificar(triangulo);

	    }

	    return montarRelatorio(
	            triangulo,
	            sucesso,
	            mensagem,
	            classificacao);
	}
	
    /*======================================================
     * VALIDAÇÕES
     *======================================================*/

    /**
     * Verifica se todos os lados são positivos.
     */
    private boolean ladosValidos(Triangulo triangulo) {

        return triangulo.getLadoA() > 0
            && triangulo.getLadoB() > 0
            && triangulo.getLadoC() > 0;
    }

    /*======================================================
     * REGRAS DE NEGÓCIO
     *======================================================*/

    /**
     * Verifica a desigualdade triangular.
     */
    private boolean formaTriangulo(Triangulo triangulo) {

        double a = triangulo.getLadoA();
        double b = triangulo.getLadoB();
        double c = triangulo.getLadoC();

        return (a < b + c)
            && (b < a + c)
            && (c < a + b);
    }

    /**
     * Classifica o triângulo.
     */
    private String classificar(Triangulo triangulo) {

        double a = triangulo.getLadoA();
        double b = triangulo.getLadoB();
        double c = triangulo.getLadoC();

        if (a == b && b == c) {
            return "EQUILÁTERO";
        }

        if (a == b || a == c || b == c) {
            return "ISÓSCELES";
        }

        return "ESCALENO";
    }

    /*======================================================
     * GERAÇÃO DO RELATÓRIO
     *======================================================*/

    /**
     * Monta o relatório apresentado ao usuário.
     */
    private String montarRelatorio(
            Triangulo triangulo,
            boolean sucesso,
            String mensagem,
            String classificacao) {

        StringBuilder sb = iniciarRelatorio(
                "PROBLEMA DO TRIÂNGULO",
                sucesso,
                mensagem);

        sb.append("\n");

        sb.append(String.format(
                "Lado A...............: %.2f%n",
                triangulo.getLadoA()));

        sb.append(String.format(
                "Lado B...............: %.2f%n",
                triangulo.getLadoB()));

        sb.append(String.format(
                "Lado C...............: %.2f%n",
                triangulo.getLadoC()));

        if (sucesso) {

            sb.append("\n");

            sb.append(String.format(
                    "Classificação........: %s%n",
                    classificacao));

        }

        return sb.toString();
    }
}