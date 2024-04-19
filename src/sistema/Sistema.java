package sistema;

import java.util.Scanner;

import service.HandleMenu;

public class Sistema {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		HandleMenu hm = new HandleMenu();
		
		
		int opcao = 0;
		do {
			// \n
			System.out.println("1 - Criar \n2 - Editar \n3 - Deletar \n4 - Listar \n5 - Listar ID \n6 - Login \n7 - Trocar Senha \n9 - Sair \n");
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
				hm.login();
				break;
			}
			
			case 7: {
				hm.trocarSenhaUsuario();
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


