package br.com.alura.lojavirtual.modelo;

public class Produto {

    private Integer id;
    private String nome;
    private String descricao;

    public Produto(String nome, String descricao) {
        this.nome = nome;
        this.descricao = descricao;
    }

    public Produto(Integer id, String nome, String descricao) {
        this.id = id;
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
        return String.format("Oproduto é: %d, %s, %s",this.id, this.nome, this.descricao);
    }

    public Integer getId() {
        return id;
    }

    public void setCategoriaId(Integer id) {
        this.id = id;
    }

    public int getCategoriaId() {
        return id;
    }
}
