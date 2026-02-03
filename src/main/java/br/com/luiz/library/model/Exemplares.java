package br.com.luiz.library.model;

import java.time.LocalDate;

public class Exemplares {
    private long idExemplar;
    private Livro livro;
    private String codigoBarras;
    private EstadosConservacao estadoConservacao;
    private LocalDate dataAquisicao;
    private boolean disponivel;
    private String observacoes;
}
