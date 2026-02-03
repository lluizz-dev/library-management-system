package br.com.luiz.library.model;

import java.time.LocalDate;

public class EmprestimoExemplares {
    private Emprestimo emprestimo;
    private Exemplares exemplar;
    private LocalDate dataDevolucaoEfetiva;
    private EstadosConservacao estadoDevolucao;
    private double multaExemplar;
}
