package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Usuario;

public class GerenciadorDeUsuarios {

	private static final String NOME_ARQUIVO = "usuarios.txt";

	// Verificar a Existencia do nosso banco e criar caso não exista
	public void verificarECriar(String nomeArquivo) {
		File arquivo = new File(nomeArquivo);

		// Verificar se o arquivo existe
		if (arquivo.exists()) {
			System.out.println("Banco funcionando");
		} else {
			try {
				arquivo.createNewFile();
				System.out.println("Arquivo criado com sucesso");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Ocorreu um erro ao criar o arquivo" + e.getMessage());
			}
		}
	}

	public void adicionarUsurario(Usuario usuario) {
		// Writer => Escrever

		// BuffWritter , FileWritter
		// BuffWritter propociona uma eficiente escrita
		// FileWriter escreve dentro do arquivo
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
			bw.write(usuario.toString()); // 1;Arthur;12345
			bw.newLine(); // Nova linha no arquivo txt
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao escrever no arquivo" + e.getMessage());
		}
	}

	public List<Usuario> lerUsuarios() {
		List<Usuario> usuarios = new ArrayList<Usuario>();
		// Buffed, File, Reader
		try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
			String linha; // linha => 1;nome;senha

			// Percorrer todas as linhas enquanto seja diferente de vazio
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(";"); // dividir em tres partes
				// Adicionar usuarios a lista
				usuarios.add(new Usuario(Integer.parseInt(partes[0]), partes[1], partes[2]));
			}
		} catch (IOException e) {
			System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
		}
		return usuarios;
	}

	public void deletarUsuario(int id) {
		List<Usuario> usuarios = lerUsuarios();

		if (usuarios.removeIf(usuario -> usuario.getId() == id)) {
			// Reescrevendo arquivo com novos usuarios e alterações
			reescreverArquivo(usuarios);
			System.out.println("Usuario deletado com sucesso");
		} else {
			System.out.println("Usuario não encontrado");
		}
	}

	public void reescreverArquivo(List<Usuario> usuarios) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
			for (Usuario usuario : usuarios) {
				bw.write(usuario.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void listarUsuarios() {
		List <Usuario> usuarios = lerUsuarios();
		
		// Nenhum usuario
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuario cadastrado");
		} else {
			System.out.println("Lista de Usuarios");
			for (Usuario usuario : usuarios) {
				System.out.println("ID: " + usuario.getId() + ", Nome: " + "" + usuario.getNome() + ", Senha: " + usuario.getSenha());
			}
		}
	}

	public void editarUsuario(int id, String novoNome, String novaSenha) {
		List <Usuario> usuarios = lerUsuarios();
		boolean encontrado = false;
		
		for (Usuario usuario : usuarios) {
			if (usuario.getId() == id) {
				usuario.setNome(novoNome);
				usuario.setSenha(novaSenha);
				encontrado = true;
				break;
			}
		}
		
		if(encontrado) {
			reescreverArquivo(usuarios);
			System.out.println("Usuario editado com sucesso");
		} else {
			System.out.print("Usuario não encontrado");
		}
	}

	public void listarUsuariosId() {
		List <Usuario> usuarios = lerUsuarios();
		
		// Nenhum usuario
		if (usuarios.isEmpty()) {
			System.out.println("Nenhum usuario cadastrado");
		} else {
			System.out.println("Lista de Usuarios");
			for (Usuario usuario : usuarios) {
				System.out.println("ID: " + usuario.getId() + ", Nome: " + "" + usuario.getNome() + ", Senha: " + usuario.getSenha());
			}
		}
	}

	public void login(String usuario, String senha) {
		List<Usuario> usuarios = lerUsuarios();
		
		if (usuario.equals(usuario)) {
		if(senha.equals(senha)) {
		    System.out.println("Login efetuado com sucesso");		
		    	} 
		    } else {
	    		System.out.println("Login ou senha não encontrados");
	}
		
	}
}