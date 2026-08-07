package br.com.valides.model.conversoes;

/**
 * Modelo que representa uma data informada pelo usuário.
 *
 * Projeto: ValidES
 */
public class ConversaoData {

    /**
     * Data informada no formato dd/MM/yyyy.
     */
    private String data;

    /**
     * Construtor padrão.
     */
    public ConversaoData() {
    }

    /**
     * Construtor com parâmetro.
     *
     * @param data Data informada pelo usuário.
     */
    public ConversaoData(String data) {
        this.data = data;
    }

    /**
     * Retorna a data informada.
     *
     * @return data.
     */
    public String getData() {
        return data;
    }

    /**
     * Define a data informada.
     *
     * @param data Data no formato dd/MM/yyyy.
     */
    public void setData(String data) {
        this.data = data;
    }

}