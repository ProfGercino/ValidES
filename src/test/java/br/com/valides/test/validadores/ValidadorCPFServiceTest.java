package br.com.valides.test.validadores;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import br.com.valides.model.validadores.ValidadorCPF;
import br.com.valides.service.validadores.ValidadorCPFService;

class ValidadorCPFServiceTest {

    private final ValidadorCPFService service = new ValidadorCPFService();

    @Test
    void deveAceitarCPFValido() {

        ValidadorCPF cpf = new ValidadorCPF();
        cpf.setCpfInformado("52998224725");
        service.executar(cpf);
        assertTrue(cpf.isValido());
    }

    @Test
    void deveRejeitarCPFComDigitosVerificadoresInvalidos() {

        ValidadorCPF cpf = new ValidadorCPF();
        cpf.setCpfInformado("52998224726");
        service.executar(cpf);
        assertFalse(cpf.isValido());
    }

    @Test
    void deveRejeitarCPFComQuantidadeIncorretaDeDigitos() {

        ValidadorCPF cpf = new ValidadorCPF();
        cpf.setCpfInformado("5299822472");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("529982247255");
        service.executar(cpf);
        assertFalse(cpf.isValido());
    }

    @Test
    void deveRejeitarCPFComLetras() {

        ValidadorCPF cpf = new ValidadorCPF();
        cpf.setCpfInformado("5299822472A");
        service.executar(cpf);
        assertFalse(cpf.isValido());
    }

    @Test
    void deveRejeitarCPFComCaracteresEspeciais() {

        ValidadorCPF cpf = new ValidadorCPF();
        cpf.setCpfInformado("529.982.247-2@");
        service.executar(cpf);
        assertFalse(cpf.isValido());
    }

    @Test
    void deveRejeitarCPFComTodosOsDigitosIguais() {

        ValidadorCPF cpf = new ValidadorCPF();
        cpf.setCpfInformado("00000000000");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("11111111111");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("22222222222");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("99999999999");
        service.executar(cpf);
        assertFalse(cpf.isValido());
    }

    @Test
    void deveAceitarCPFFormatado() {

        ValidadorCPF cpf = new ValidadorCPF();
        cpf.setCpfInformado("529.982.247-25");
        service.executar(cpf);
        assertTrue(cpf.isValido());
    }

}