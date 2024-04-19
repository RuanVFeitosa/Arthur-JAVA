package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import models.Produto;

public class GerenciamentoDeProdutos {

    private static final String NOME_ARQUIVO = "produtos.txt";

    public static void main(String[] args) {
        GerenciamentoDeProdutos gerente = new GerenciamentoDeProdutos();
        gerente.verificarECriar(NOME_ARQUIVO);
        // Aqui você pode chamar outros métodos para testar suas funcionalidades, por exemplo:
        // gerente.adicionarUsurario(new Produto(...));
        // List<Produto> produtos = gerente.lerUsuarios();
    }

    public void verificarECriar(String nomeArquivo) {
        File arquivo = new File(nomeArquivo);
        if (!arquivo.exists()) {
            try {
                arquivo.createNewFile();
                System.out.println("Arquivo criado com sucesso");
            } catch (IOException e) {
                System.out.println("Ocorreu um erro ao criar o arquivo: " + e.getMessage());
            }
        }
    }

    public void adicionarProdutos(Produto produto) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO, true))) {
            bw.write(produto.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }
    }

    public List<Produto> lerProdutos() {
        List<Produto> produtos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");
                // Supondo que Produto tem um construtor que aceita id, nome, preço, quantidade
                long id = Integer.parseInt(partes[0]);
                double preco = Double.parseDouble(partes[2]);
                int quantidade = Integer.parseInt(partes[3]);
                produtos.add(new Produto(id, partes[1], preco, quantidade));
            }
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
        return produtos;
    }

    // Implemente outros métodos como deletarUsuario, reescreverArquivo, etc., como já estruturado acima



		public void deletarProduto(int id) {
			List<Produto> produtos = lerProdutos();

			if (produtos.removeIf(produto -> produto.getId() == id)) {
				// Reescrevendo arquivo com novos usuarios e alterações
				reescreverArquivo(produtos);
				System.out.println("Produto deletado com sucesso");
			} else {
				System.out.println("Produto não encontrado");
			}
		}

		public void reescreverArquivo(List<Produto> produtos) {
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOME_ARQUIVO))) {
				for (Produto produto : produtos) {
					bw.write(produto.toString());
					bw.newLine();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		public void listarProdutos() {
			List <Produto> produtos = lerProdutos();
			
			// Nenhum usuario
			if (produtos.isEmpty()) {
				System.out.println("Nenhum produto cadastrado");
			} else {
				System.out.println("Lista de Produtos");
				for (Produto produto : produtos) {
					System.out.println("ID: " + produto.getId() + ", Nome: " + "" + produto.getNome() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQtd());
				}
			}
		}

		public void editarProduto(long id, String novoNome, long novoPreco, int novaQtd) {
			List <Produto> produtos = lerProdutos();
			boolean encontrado = false;
			
			for (Produto produto : produtos ) {
				if (produto.getId() == id) {
					produto.setNome(novoNome);
					produto.setPreco(novoPreco);
					produto.setQtd(novaQtd);
					encontrado = true;
					break;
				}
			}
			
			if(encontrado) {
				reescreverArquivo(produtos);
				System.out.println("Produto editado com sucesso");
			} else {
				System.out.print("Produto não encontrado");
			}
		}

		public void listarProdutosId() {
			List <Produto> produtos = lerProdutos();
			
			// Nenhum usuario
			if (produtos.isEmpty()) {
				System.out.println("Nenhum Produto cadastrado");
			} else {
				System.out.println("Lista de Produtos");
				for (Produto produto : produtos) {
					System.out.println("ID: " + produto.getId() + ", Nome: " + "" + produto.getNome() + ", Preço: " + produto.getPreco() + ", Quantidade: " + produto.getQtd());
				}
			}
		}
		
		public void somarPrecos() {
	        List<Produto> produtos = lerProdutos();
	        double total = 0;
	        for (Produto produto : produtos) {
	            total += produto.getPreco() * produto.getQtd();
	        }
	        System.out.printf("O valor total dos produtos em estoque é: R$ %.2f\n", total);
	    }

	    public void contarQuantidadeProdutos() {
	        List<Produto> produtos = lerProdutos();
	        int totalQuantidade = 0;
	        for (Produto produto : produtos) {
	            totalQuantidade += produto.getQtd();
	        }
	        System.out.println("A quantidade total de produtos em estoque é: " + totalQuantidade);
	    }
	}

