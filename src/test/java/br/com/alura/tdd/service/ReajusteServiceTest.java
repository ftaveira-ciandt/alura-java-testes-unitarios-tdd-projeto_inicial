package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ReajusteServiceTest {

    private ReajusteService service;

    private Funcionario funcionario;

   @BeforeEach
    public void inicializar() {
       System.out.println("inicializa");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Jose", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @AfterEach
    public void finalizar(){
        System.out.println("finaliza");
    }

    @BeforeAll
    public static void depoisDeTodos() {
        System.out.println("ANTES de todos");
    }

    @AfterAll
    public static void antesDeTodos() {
        System.out.println("DEPOIS de todos");
    }

    @Test
    void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

    @Test
    void reajusteDeveriaSerDeZeroPorcentoQuandoDesempenhoForRuim() {
        service.concederReajuste(funcionario, Desempenho.RUIM);
        assertEquals(new BigDecimal("1000.00"), funcionario.getSalario());
    }

}