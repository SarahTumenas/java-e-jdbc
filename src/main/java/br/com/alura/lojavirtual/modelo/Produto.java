package br.com.alura.lojavirtual.modelo;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format("Oproduto criado foi: %d, %s, %s",this.id, this.nome, this.descricao);
    }
}
