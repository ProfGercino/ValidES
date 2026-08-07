package br.com.valides.model.validadores;

/**
 * ************************************************************
 * Projeto.....: ValidES
 * Módulo......: Validadores
 * Caso de Estudo: Validador de CPF
 *
 * Classe responsável por armazenar os dados utilizados na
 * validação de CPF alfanumérico.
 *
 * Esta classe não contém regras de negócio.
 *
 * @author
 *************************************************************
 */
public class ValidadorCPF {

    /*==========================================================
     * ATRIBUTOS
     *==========================================================*/

    /**
     * CPF informado pelo usuário.
     */
    private String cpfInformado;

    /**
     * CPF após o processo de normalização.
     */
    private String cpfNormalizado;

    /**
     * Indica se o CPF é válido.
     */
    private boolean valido;

    /**
     * Mensagem gerada pela validação.
     */
    private String mensagem;

    /*==========================================================
     * CONSTRUTORES
     *==========================================================*/

    /**
     * Construtor padrão.
     */
    public ValidadorCPF() {

    }

    /**
     * Construtor com parâmetro.
     *
     * @param cpfInformado CPF informado pelo usuário.
     */
    public ValidadorCPF(String cpfInformado) {

        this.cpfInformado = cpfInformado;

    }

    /*==========================================================
     * GETTERS E SETTERS
     *==========================================================*/

    public String getCpfInformado() {
        return cpfInformado;
    }

    public void setCpfInformado(String cpfInformado) {
        this.cpfInformado = cpfInformado;
    }

    public String getCpfNormalizado() {
        return cpfNormalizado;
    }

    public void setCpfNormalizado(String cpfNormalizado) {
        this.cpfNormalizado = cpfNormalizado;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    /*==========================================================
     * MÉTODOS AUXILIARES
     *==========================================================*/

    @Override
    public String toString() {

        return "ValidadorCPF [cpfInformado=" + cpfInformado
                + ", cpfNormalizado=" + cpfNormalizado
                + ", valido=" + valido
                + ", mensagem=" + mensagem + "]";

    }

}