package teladecadastro.model;

public class Produto {
	
	
	@Override
	public String toString() {
		return "Produto [nome=" + nome + ", quantidade=" + quantidade + "]";
	}
	private String nome;
	private int quantidade;
	
	public Produto(String nome, int quantidade) {
		this.nome = nome;
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}