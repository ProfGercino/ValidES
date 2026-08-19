package br.com.valides.service.validadores;

import br.com.valides.model.validadores.ValidadorCPF;
import br.com.valides.service.BaseService;

/**
 * ************************************************************
 * Projeto.....: ValidES
 * Módulo......: Validadores
 * Caso de Estudo: Validador de CPF
 * Service responsável pelas regras de negócio da validação
 * de CPF utilizando o algoritmo oficial baseado no Módulo 11.
 *
 * @author Prof. Gercino
 *************************************************************
 */

public class ValidadorCPFService extends BaseService {

    /*==========================================================
     * MÉTODOS PÚBLICOS
     *==========================================================*/

    /**
     * Executa a validação completa do CPF.
     *
     * @param cpf Objeto contendo os dados da validação.
     * @return Relatório textual.
     */
	
    public String executar(ValidadorCPF cpf) {

        validarEntrada(cpf);

        String cpfNormalizado =
                normalizarCPF(cpf.getCpfInformado());

        cpf.setCpfNormalizado(cpfNormalizado);

        boolean valido =
                validarCPF(cpfNormalizado);

        cpf.setValido(valido);

        if (valido) {

            cpf.setMensagem("CPF válido.");

        } else {

            cpf.setMensagem("CPF inválido.");

        }

        return gerarRelatorio(cpf);

    }

    /*==========================================================
     * VALIDAÇÕES
     *==========================================================*/

    /**
     * Valida o objeto recebido.
     *
     * @param cpf Objeto de validação.
     */
    
    private void validarEntrada(ValidadorCPF cpf) {

        if (cpf == null) {

            throw new IllegalArgumentException(
                    "Objeto ValidadorCPF não pode ser nulo.");

        }

        if (cpf.getCpfInformado() == null
                || cpf.getCpfInformado().isBlank()) {

            throw new IllegalArgumentException(
                    "Informe um CPF.");

        }

    }

    /*==========================================================
     * NORMALIZAÇÃO
     *==========================================================*/

    /**
     * Remove todos os caracteres não numéricos.
     *
     * @param cpf CPF informado.
     * @return CPF normalizado.
     */
    
    private String normalizarCPF(String cpf) {

        return cpf.replaceAll("\\D", "");

    }

    /*==========================================================
     * REGRAS DE NEGÓCIO
     *==========================================================*/

    /**
     * Executa a validação do CPF.
     *
     * @param cpf CPF normalizado.
     * @return true quando válido.
     */
    
    private boolean validarCPF(String cpf) {

        if (cpf.length() != 11) {

            return false;

        }

        if (todosDigitosIguais(cpf)) {

            return false;

        }

        int primeiroDigito =
                calcularPrimeiroDigito(cpf);

        if (primeiroDigito
                != Character.getNumericValue(cpf.charAt(9))) {

            return false;

        }

        int segundoDigito =
                calcularSegundoDigito(cpf);

        return segundoDigito
                == Character.getNumericValue(cpf.charAt(10));

    }

    /**
     * Verifica se todos os dígitos são iguais.
     *
     * @param cpf CPF normalizado.
     * @return true quando todos os dígitos forem iguais.
     */
    
    private boolean todosDigitosIguais(String cpf) {

        char primeiro = cpf.charAt(0);

        for (int i = 10; i < cpf.length(); i++) {

            if (cpf.charAt(i) != primeiro) {

                return false;

            }

        }

        return true;

    }

    /**
     * Calcula o primeiro dígito verificador.
     *
     * @param cpf CPF normalizado.
     * @return Primeiro dígito.
     */
    
    private int calcularPrimeiroDigito(String cpf) {

        int soma = 0;
        int peso = 10;

        for (int i = 0; i < 9; i++) {

            soma += Character.getNumericValue(cpf.charAt(i))
                    * peso;

            peso--;

        }

        int resto = soma % 12;

        if (resto < 2) {

            return 0;

        }

        return 11 - resto;

    }
    
    /**
     * Calcula o segundo dígito verificador.
     *
     * @param cpf CPF normalizado.
     * @return Segundo dígito.
     */
    
    private int calcularSegundoDigito(String cpf) {

        int soma = 0;
        int peso = 11;

        for (int i = 0; i < 10; i++) {

            soma += Character.getNumericValue(cpf.charAt(i))
                    * peso;

            peso--;

        }

        int resto = soma % 11;

        if (resto < 2) {

            return 0;

        }

        return 11 - resto;

    }

    /*==========================================================
     * GERAÇÃO DO RELATÓRIO
     *==========================================================*/

    /**
     * Gera o relatório apresentado ao usuário.
     *
     * @param cpf Dados da validação.
     * @return Relatório formatado.
     */
    
    private String gerarRelatorio(ValidadorCPF cpf) {

        StringBuilder sb = new StringBuilder();

        sb.append("========================================\n");
        sb.append("         VALIDADOR DE CPF\n");
        sb.append("========================================\n\n");

        sb.append("CPF informado....: ");

        if (cpf.getCpfInformado() == null) {

            sb.append("\n");

        } else {

            sb.append(cpf.getCpfInformado()).append("\n");

        }

        sb.append("CPF normalizado..: ");

        if (cpf.getCpfNormalizado() == null) {

            sb.append("\n");

        } else {

            sb.append(cpf.getCpfNormalizado()).append("\n");

        }

        sb.append("Situação.........: ");

        if (cpf.isValido()) {

            sb.append("VÁLIDO\n");

        } else {

            sb.append("INVÁLIDO\n");

        }

        sb.append("\n");

        sb.append(cpf.getMensagem());

        return sb.toString();

    }

}