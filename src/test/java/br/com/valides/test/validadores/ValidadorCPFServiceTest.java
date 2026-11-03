package br.com.valides.test.validadores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import br.com.valides.model.validadores.ValidadorCPF;
import br.com.valides.service.validadores.ValidadorCPFService;

class ValidadorCPFServiceTest {

    private final ValidadorCPFService service = new ValidadorCPFService();

    @Test
    void deveAceitarCPFValido() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ValidadorCPF cpf = new ValidadorCPF();

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        // Primeiro e último dígitos iguais
        cpf.setCpfInformado("52998224725");
        service.executar(cpf);
        assertTrue(cpf.isValido());

        cpf.setCpfInformado("86125433048");
        service.executar(cpf);
        assertTrue(cpf.isValido());

        // Primeiro e último dígitos diferentes
        cpf.setCpfInformado("11144477735");
        service.executar(cpf);
        assertTrue(cpf.isValido());

        cpf.setCpfInformado("12345678909");
        service.executar(cpf);
        assertTrue(cpf.isValido());
    }

    @Test
    void deveRejeitarCPFComDigitosVerificadoresInvalidos() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ValidadorCPF cpf = new ValidadorCPF();

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        // Segundo dígito verificador errado
        cpf.setCpfInformado("52998224726");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        // Primeiro dígito verificador errado
        cpf.setCpfInformado("11144477745");
        service.executar(cpf);
        assertFalse(cpf.isValido());
    }

    @Test
    void deveRejeitarCPFComQuantidadeIncorretaDeDigitos() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ValidadorCPF cpf = new ValidadorCPF();

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        cpf.setCpfInformado("5299822472");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("529982247255");
        service.executar(cpf);
        assertFalse(cpf.isValido());
    }

    @Test
    void deveRejeitarCPFComLetras() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ValidadorCPF cpf = new ValidadorCPF();
        cpf.setCpfInformado("52998224725A");

        // =====================================================
        // ACT
        // =====================================================

        service.executar(cpf);

        // =====================================================
        // ASSERT
        // =====================================================

        assertFalse(cpf.isValido());
    }

    @Test
    void deveRejeitarCPFComCaracteresEspeciais() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ValidadorCPF cpf = new ValidadorCPF();
        cpf.setCpfInformado("529.982.247-25@");

        // =====================================================
        // ACT
        // =====================================================

        service.executar(cpf);

        // =====================================================
        // ASSERT
        // =====================================================

        assertFalse(cpf.isValido());
    }

    @Test
    void deveRejeitarCPFComTodosOsDigitosIguais() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ValidadorCPF cpf = new ValidadorCPF();

        // =====================================================
        // ACT / ASSERT
        // =====================================================

        cpf.setCpfInformado("00000000000");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("11111111111");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("22222222222");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("33333333333");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("44444444444");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("55555555555");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("66666666666");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("77777777777");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("88888888888");
        service.executar(cpf);
        assertFalse(cpf.isValido());

        cpf.setCpfInformado("99999999999");
        service.executar(cpf);
        assertFalse(cpf.isValido());
    }

    @Test
    void deveAceitarCPFFormatado() {

        // =====================================================
        // ARRANGE
        // =====================================================

        ValidadorCPF cpf = new ValidadorCPF();
        cpf.setCpfInformado("529.982.247-25");

        // =====================================================
        // ACT
        // =====================================================

        service.executar(cpf);

        // =====================================================
        // ASSERT
        // =====================================================

        assertTrue(cpf.isValido());
        assertEquals("52998224725", cpf.getCpfNormalizado());
    }

}
