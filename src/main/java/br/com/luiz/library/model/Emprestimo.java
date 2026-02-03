package br.com.luiz.library.model;

import java.time.LocalDate;

public class Emprestimo {
    private long idEmprestimo;
    private Usuario usuario;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucaoPrevista;
    private LocalDate dataDevolucaoReal;
    private double multa;
    private StatusEmprestimo status;
}
