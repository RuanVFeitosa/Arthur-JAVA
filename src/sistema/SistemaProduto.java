package sistema;

import java.util.Scanner;

import service.MenuProduto;

public class SistemaProduto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		MenuProduto hm = new MenuProduto();
		
		
		int opcao = 0;
		do {
			// \n
			System.out.println("Bem-vindo ao Cadatro de Produtos \n |1 - Criar \n |2 - Editar \n |3 - Deletar \n |4 - Listar \n |5 - Listar ID \n |6 - Somar Preços \n |7 - Contar Quantidade de Produtos \n |9  - Sair \n ---------------------------------------");
			opcao = sc.nextInt();
			
			switch (opcao) {
			case 1: {
				hm.criar();
				break;
			}
			
			case 2: {
				hm.editar();
				break;
			}
			
			case 3: {
				hm.deletar();
				break;
			}
			
			case 4: {
				hm.listar();
				break;
			}
			
			case 5: {
				hm.listarId();
				break;
			}
			
			case 6: {
				hm.somarPreços();
				break;
			}
			
			case 7: {
				hm.contarQuantidadeProdutos();
				break;
			}
			
			case 9: {
				System.out.println("Finalizando o Sistema...");
				System.out.println("Tchau...");
				break;
			}
			
			default:
			System.out.println("Opção Invalida");
			break;
			}
			
			
		} while (opcao != 9); 
			sc.close();
		}
		
		

	}


