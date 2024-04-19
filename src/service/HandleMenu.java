package service;

import java.util.List;
import java.util.Scanner;

import models.Usuario;
import utils.GerenciadorDeUsuarios;

public class HandleMenu {
	
	Scanner sc = new Scanner (System.in);
	
	// Gerenciador
	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();
	
	// Construtor vazio
	public HandleMenu() {
		// Toda vez que a classe menu, for instanciada, o nosso arquivo sera verificado
		gs.verificarECriar("usuarios.txt");
	}
	
	public void criar() {
		System.out.print("Digite o nome: ");
		String nome = sc.next();
		System.out.print("Digite a senha: ");
		String senha = sc.next();
		
		int id = getNextId();
		
		Usuario u = new Usuario(id, nome, senha);
		gs.adicionarUsurario(u);
		
		
	}
	
	public void editar() {
		System.out.print("Digite o ID do usuario: ");
		int id = sc.nextInt();
		
		System.out.print("Digite o novo nome: ");
		String nome = sc.next();
		
		System.out.print("Digite a nova senha: ");
		String senha = sc.next();
		
		gs.editarUsuario(id, nome, senha);
	}
	
	public void listarId() {
		System.out.print("Digite o ID do usurio para ser listado: ");
		int id = sc.nextInt();
		gs.listarUsuariosId();
	}

	public void deletar() {
		System.out.print("Digite o ID do usurio a ser deletado:");
		int id = sc.nextInt();
		gs.deletarUsuario(id);
		
	}
	
	public void listar() {
		gs.listarUsuarios();
	}
	
	public void trocarSenhaUsuario() {
		System.out.println("Digite o ID do usuário: ");
		int id = sc.nextInt();
		System.out.println("Digite a senha antiga: ");
		String senhaAntiga = sc.next();
		System.out.println("Digite a nova senha: ");
		String novaSenha = sc.next();
 
		// Chama o método trocarSenha do GerenciadorDeUsuarios
		gs.trocarSenha(id, senhaAntiga, novaSenha);
	}
	
	public void login() {
		Scanner input1 = new Scanner(System.in);
		
	    System.out.print("Insira o seu Nome: ");
	    String usuario = input1.next();


	    System.out.print("Insira a senha: ");
	    String senha = input1.next();

	      gs.login(usuario, senha); 

	}
	
	
	private int getNextId() {
		List<Usuario> usuarios = gs.lerUsuarios();
		int maxId = 0;
		
		// for => forEach
		for (Usuario usuario : usuarios) {
			int id = usuario .getId();
			
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
