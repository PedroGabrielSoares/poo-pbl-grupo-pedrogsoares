package domain;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class GrupoTest {

    @Test
    public void deveDividirDespesaCorretamenteEntreMembros() {
        // Arrange
        Grupo republica = new Grupo("1", "República");
        Usuario pedro = new Usuario("Pedro");
        Usuario participante2 = new Usuario("Carlos");
        
        republica.adicionarMembro(pedro);
        republica.adicionarMembro(participante2);

        // Act - Pedro registrou um gasto comum de R$ 100,00
        Dinheiro contaEnergia = new Dinheiro(new BigDecimal("100.00"));
        republica.registrarDespesa(pedro, contaEnergia);

        // Assert - A divisão ideal deve resultar em 50.00 para cada um
        Dinheiro cota = republica.calcularCotaPorMembro();
        assertEquals(new BigDecimal("50.00"), cota.getValor());

        // Pedro adiantou 100, deve receber 50 de volta (+50.00)
        assertEquals(new BigDecimal("50.00"), republica.calcularSaldo(pedro));
        
        // Carlos consumiu mas não pagou nada ainda, deve 50 (-50.00)
        assertEquals(new BigDecimal("-50.00"), republica.calcularSaldo(participante2));
    }

    @Test
    public void naoDevePermitirDinheiroNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Dinheiro(new BigDecimal("-10.00"));
        });
    }
}

