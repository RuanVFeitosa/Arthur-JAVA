package models;

public class Produto {
	
	private long id;
	private String nome;
	private double preco;
	private int qtd;
	
	

	public Produto(long id2, String nome2, double preco2, int qtd2) {
		this.id = id2;
		this.nome = nome2;
		this.preco = preco2;
		this.qtd = qtd2;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQtd() {
		return qtd;
	}
	public void setQtd(int qtd) {
		this.qtd = qtd;
	}
	
	@Override
	public String toString() {
		return id + ";" + nome + ";" + preco + ";" + qtd ;
	}

}
