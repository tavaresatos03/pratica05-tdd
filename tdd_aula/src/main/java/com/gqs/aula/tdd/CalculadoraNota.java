package com.gqs.aula.tdd;

public class CalculadoraNota {

    public static final double NOTA_MINIMA_APROVACAO = 70;
    public static final double NOTA_MAXIMA_A1_A2 = 30;
    public static final double NOTA_MAXIMA_A3 = 40;
    public static final double FREQUENCIA_MINIMA = 75;
    public static final double SOMA_MINIMA_PARA_AI = 40;

    public double calcularNotaFinal(double a1, double a2, double a3) {
        validarNota(a1, NOTA_MAXIMA_A1_A2, "A1");
        validarNota(a2, NOTA_MAXIMA_A1_A2, "A2");
        validarNota(a3, NOTA_MAXIMA_A3, "A3");
        return a1 + a2 + a3;
    }

    public boolean estaAprovadoPorNota(double notaFinal) {
        return notaFinal >= NOTA_MINIMA_APROVACAO;
    }

    public String situacao(double notaFinal, double frequencia) {
        if (estaAprovadoPorNota(notaFinal) && frequencia >= FREQUENCIA_MINIMA) {
            return "APROVADO";
        }
        return "REPROVADO";
    }

    private void validarNota(double nota, double notaMaxima, String nomeAvaliacao) {
        if (nota < 0 || nota > notaMaxima) {
            throw new IllegalArgumentException(
                    nomeAvaliacao + " deve estar entre 0 e " + notaMaxima);
        }
    }

    public boolean podeFazerAI(double a1, double a2, double a3, double frequencia) {
        boolean reprovadoPorNota = !estaAprovadoPorNota(a1 + a2 + a3);
        boolean frequenciaSuficiente = frequencia >= FREQUENCIA_MINIMA;
        boolean atingeMinimo = (a1 + a3 >= SOMA_MINIMA_PARA_AI) || (a2 + a3 >= SOMA_MINIMA_PARA_AI);
        return reprovadoPorNota && frequenciaSuficiente && atingeMinimo;
    }

    public double aplicarAI(double a1, double a2, double a3, double notaAI) {
        return 0;
    }
}
