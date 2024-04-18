package service;

import java.util.List;
import java.util.Scanner;

import models.Produto;
import utils.GerenciamentoDeProdutos;

public class MenuProduto {
	
	Scanner sc = new Scanner (System.in);
	
	// Gerenciador
	GerenciamentoDeProdutos gs = new GerenciamentoDeProdutos();
	
	// Construtor vazio
	public MenuProduto() {
		// Toda vez que a classe menu, for instanciada, o nosso arquivo sera verificado
		gs.verificarECriar("usuarios.txt");
	}
	
	public void criar() {
		System.out.print("Digite o nome: ");
		String nome = sc.next();
		
		System.out.print("Digite o preço: ");
		double preco = sc.nextDouble();
		
		System.out.print("Digite a quantidade: ");
		int qtd = sc.nextInt();
		
		long id = getNextId();
		
		Produto p = new Produto(id, nome, preco, qtd);
		gs.adicionarProdutos(p);
		
		
	}
	
	public void editar() {
		System.out.print("Digite o ID do usuario: ");
		int id = sc.nextInt();
		
		System.out.print("Digite o novo nome: ");
		String nome = sc.next();
		
		System.out.print("Digite o novo preço: ");
		long preco = sc.nextLong();
		
		System.out.print("Digite a nova quantidade: ");
		int qtd = sc.nextInt();
		
		gs.editarProduto(id, nome, preco, qtd);
	}
	
	public void listarId() {
		System.out.print("Digite o ID do usurio para ser listado: ");
		int id = sc.nextInt();
		gs.listarProdutosId();
	}

	public void deletar() {
		System.out.print("Digite o ID do usurio a ser deletado:");
		int id = sc.nextInt();
		gs.deletarProduto(id);
		
	}
	
	public void listar() {
		gs.listarProdutos();
	}
	
	public void login() {
		Scanner input1 = new Scanner(System.in);
		
	    System.out.print("Insira o seu Nome: ");
	    String usuario = input1.next();


	    System.out.print("Insira a senha: ");
	    String senha = input1.next();

	      gs.login(usuario, senha); 

	}
	
	
	private long getNextId() {
		List<Produto> produtos = gs.lerProdutos();
		long maxId = 0;
		
		// for => forEach
		for (Produto produto : produtos) {
			long id = produto .getId();
			
			//1 
			if (id > maxId) {
				// logica para descobrir ultimo id
				maxId = id;
			
			// 2000
				
			
			}
		}
		return maxId + 1;
	}

}
