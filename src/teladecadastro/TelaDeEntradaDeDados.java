package teladecadastro;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import teladecadastro.model.Produto;

public class TelaDeEntradaDeDados extends JPanel {
	
	private List<Produto> produtos = new ArrayList<>();
			
	public TelaDeEntradaDeDados() {		
		// GridLayout simula uma tabela com duas colunas
		this.setLayout(new GridLayout(0,2, 10, 10));
		JLabel  nomeDoProduto = new JLabel("Nome do Produto");
		nomeDoProduto.setHorizontalAlignment(JLabel.RIGHT);
		this.add(nomeDoProduto);
		
		JTextField nomeDoProdutoField = new JTextField();
		this.add(nomeDoProdutoField);
				
		JLabel  quantidade = new JLabel("Quantidade");
		quantidade.setHorizontalAlignment(JLabel.RIGHT);
		this.add(quantidade);
		
		JTextField quantidadeField = new JTextField();
		this.add(quantidadeField);
		
		JButton btnAdicionar = new JButton("Adicionar");
		this.add(btnAdicionar);
		btnAdicionar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//Pega o que foi digitado no campo do nome do Produto
				String nome = nomeDoProdutoField.getText();
				
				//Pega o que foi digitado em quantidade e converte para inteiro
				int quantidade = Integer.parseInt(quantidadeField.getText());
				
				//System.out.println(nome);
				//System.out.println(quantidade);
				
				Produto produto = new Produto(nome, quantidade);
				
				produtos.add(produto);
				
				System.out.println("Quantidade Cadastrada " + produtos.size());
				
				nomeDoProdutoField.setText("");
				quantidadeField.setText("");							
			}					
		});
				
		JButton btnmostrarTodos = new JButton("Mostrar Todos");
		this.add(btnmostrarTodos);
		btnmostrarTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < produtos.size(); i++) {					
					System.out.println(produtos.get(i));
				}
				
				Object[] titulos = {"Nome","Qunatidade"};
				Object[][] linhas = new Object[produtos.size()][2];
				for (int i = 0; i < produtos.size(); i++) {
					Object[] linha = new Object[] {produtos.get(i).getNome(), produtos.get(i).getQuantidade()};
				 	linhas[i] = linha;	
				 	}				
				JTable table = new JTable(linhas, titulos);
				JOptionPane.showMessageDialog(null, new JScrollPane(table));
			}		
		});		
	}
}
