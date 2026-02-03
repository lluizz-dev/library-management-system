package br.com.luiz.library.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Livro {
    private long idLivro;
    private String isbn;
    private String titulo;
    private String subtitulo;
    private int anoPublicacao;
    private int edicao;
    private int numeroPaginas;
    private BigDecimal preco;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

}
