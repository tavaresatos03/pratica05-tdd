package com.gqs.aula.tdd;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraNotaTest {
    @Test
    void deveSomarAsTresNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(20, 20, 30);
        assertEquals(70, resultado);
    }

    @Test
    void deveSomarOutrasNotas() {
        CalculadoraNota calc = new CalculadoraNota();
        double resultado = calc.calcularNotaFinal(10, 15, 25);
        assertEquals(50, resultado);
    }

    @Test
    void deveAprovarComNota70() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.estaAprovadoPorNota(70));
    }

    @Test
    void deveReprovarComNota69() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.estaAprovadoPorNota(69));

    }

    @Test
    void deveRejeitarA1MaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularNotaFinal(35, 20, 30));
    }

    @Test
    void deveRejeitarA2MaiorQue30() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularNotaFinal(20, 35, 30));
    }

    @Test
    void deveRejeitarA3MaiorQue40() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularNotaFinal(20, 20, 45));
    }

    @Test
    void deveRejeitarA1Negativa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.calcularNotaFinal(-5, 20, 30));
    }

    @Test
    void devePermitirNotasMaximas() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(100, calc.calcularNotaFinal(30, 30, 40));
    }

    @Test
    void deveAprovarComNotaEFrequenciaSuficientes() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("APROVADO", calc.situacao(80, 90));
    }

    @Test
    void deveReprovarComNotaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO", calc.situacao(60, 90));
    }

    @Test
    void deveReprovarPorFrequenciaMesmoComNotaAlta() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("REPROVADO", calc.situacao(95, 74));
    }

    @Test
    void deveAprovarComFrequenciaExatamente75() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals("APROVADO", calc.situacao(70, 75));
    }

    @Test
    void devePoderFazerAIQuandoA2MaisA3Basta() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.podeFazerAI(10, 20, 30, 80));
    }

    @Test
    void devePoderFazerAIComA1MaisA3Exatamente40() {
        CalculadoraNota calc = new CalculadoraNota();
        assertTrue(calc.podeFazerAI(10, 5, 30, 80));
    }

    @Test
    void naoDevePoderFazerAISeJaAprovado() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(25, 25, 30, 80));
    }

    @Test
    void naoDevePoderFazerAIComFrequenciaBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(10, 20, 30, 70));
    }

    @Test
    void naoDevePoderFazerAISeNenhumaSomaChegaA40() {
        CalculadoraNota calc = new CalculadoraNota();
        assertFalse(calc.podeFazerAI(5, 5, 30, 80));
    }

    @Test
    void deveSubstituirA1QuandoEhAMenor() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(75, calc.aplicarAI(10, 20, 30, 25));
    }

    @Test
    void deveSubstituirA2QuandoEhAMenor() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(75, calc.aplicarAI(20, 10, 30, 25));
    }

    @Test
    void naoDeveSubstituirQuandoAIEhBaixa() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(75, calc.aplicarAI(20, 25, 30, 5));
    }

    @Test
    void naoDeveMudarQuandoAIEhIgualAMenor() {
        CalculadoraNota calc = new CalculadoraNota();
        assertEquals(60, calc.aplicarAI(10, 20, 30, 10));
    }

    @Test
    void deveRejeitarAIInvalida() {
        CalculadoraNota calc = new CalculadoraNota();
        assertThrows(IllegalArgumentException.class,
                () -> calc.aplicarAI(10, 20, 30, 35));
    }
}
