package com.ti2cc;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		
		int escolha;
		do {
			escolha = mostrarMenu();
			switch (escolha) {
				case 1:
					mostrarFilmes(dao);
					break;
				case 2:
					inserirFilme(dao);
					break;
				case 3:
					Scanner in = new Scanner(System.in);
					System.out.println("Digite o c�digo do filme que deseja excluir:");
					excluirFilme(dao, in.nextInt());
					in.close();
					break;
				case 4:
					Scanner input = new Scanner(System.in);
					System.out.println("Digite o c�digo do filme que deseja atualizar:");
					atualizarFilme(dao, input.nextInt());
					input.close();
					break;
				default:
					System.out.println("Saindo...");
			}
		} while (escolha == 1 || escolha == 2 || escolha == 3 || escolha == 4);
		
		dao.close();
	}
		
	public static int mostrarMenu() {
		System.out.println("==== MENU ====");
		System.out.println("Escolha uma das op��es:");
		System.out.println("1) Listar filmes");
		System.out.println("2) Inserir filme");
		System.out.println("3) Excluir filme");
		System.out.println("4) Atualizar filme");
		System.out.println("5) Sair");
		System.out.println();
		
		Scanner in = new Scanner(System.in);
		int entrada = in.nextInt();
		in.close();
		return entrada;
	}
	
	public static void mostrarFilmes(DAO dao) {
		Filme[] filmes = dao.getFilmes();
		System.out.println("==== Mostrar filmes === ");		
		for(int i = 0; i < filmes.length; i++) {
			System.out.println(filmes[i].toString());
		}
	}
	
	public static boolean contemCodigo(int codigo, int[] codigos) {
		for (int c : codigos) {
			if (c == codigo) {
				return true;
			}
		}
		return false;
	}
	
	public static int gerarNovoCodigo(DAO dao) {
		int[] codigosIndisponiveis = dao.getCodigos();
		int codigo;
		
		do {
			codigo = (int) ((Math.random() * (10000 - 10)) + 10);
		} while (contemCodigo(codigo, codigosIndisponiveis));
		
		return codigo;
	}
	
	public static void inserirFilme(DAO dao) {
		Scanner in = new Scanner(System.in);
		
		int codigo = gerarNovoCodigo(dao);
	
		System.out.println("T�tulo do filme:");
		String titulo = in.nextLine();
		
		System.out.println("Categoria do filme:");
		String categoria = in.nextLine();
		
		System.out.println("Dura��o do filme (minutos):");
		int minutos = in.nextInt();
		
		System.out.println("Ano de lan�amento do filme:");
		int ano = in.nextInt();
		
		System.out.println("Ator principal do filme:");
		String ator_principal = in.nextLine();
		
		System.out.println("Avalia��o do filme:");
		int avaliacao = in.nextInt();
		
		in.close();
		
		Filme filme = new Filme(codigo, titulo, categoria, minutos, ano, ator_principal, avaliacao);
		if(dao.inserirFilme(filme) == true) {
			System.out.println("Inser��o com sucesso -> " + filme.toString());
		}

	}
	
	public static void excluirFilme(DAO dao, int codigo) {
		Filme[] filmes = dao.getFilmes();
		for (int i = 0; i < filmes.length; i++) {
			if (filmes[i].getCodigo() == codigo) {
				if (dao.excluirFilme(codigo) == true) {
					System.out.println("Filme exclu�do com sucesso -> " + filmes[i].toString());
				} else {
					System.out.println("Houve algo errado ao tentar excluir.");
				}
				return;
			}
		}
		System.out.println("Filme n�o encontrado a partir do c�digo inserido.");
	}
	
	public static void atualizarFilme(DAO dao, int codigo) {
		Filme[] filmes = dao.getFilmes();
		for (Filme filme : filmes) {
			if (filme.getCodigo() == codigo) {
				System.out.println("Selecione a propriedade que deseja atualizar:");
				System.out.println("1) Titulo");
				System.out.println("2) Categoria");
				System.out.println("3) Minutos");
				System.out.println("4) Ano");
				System.out.println("5) Ator principal");
				System.out.println("6) Avalia��o");
				System.out.println("7) Sair");
				
				Scanner in = new Scanner(System.in);
				String entrada = in.nextLine();
				
				switch (entrada) {
				case "1":
					System.out.println("Novo titulo:");
					filme.setTitulo(in.nextLine());
					break;
				case "2":
					System.out.println("Nova categoria:");
					filme.setCategoria(in.nextLine());
					break;
				case "3":
					System.out.println("Novo tempo de dura��o (minutos):");
					filme.setMinutos(in.nextInt());
					break;
				case "4":
					System.out.println("Novo ano de lan�amento:");
					filme.setAno(in.nextInt());
					break;
				case "5":
					System.out.println("Novo ator principal:");
					filme.setAtor_principal(in.nextLine());
					break;
				case "6":
					System.out.println("Nova avalia��o:");
					filme.setAvaliacao(in.nextInt());
					break;
				default:
					System.out.println("Atualiza��o cancelada.");
				}
				in.close();
				
				dao.atualizarFilme(filme);
				return;
			}
		}
		System.out.println("Filme n�o encontrado a partir do c�digo inserido.");
	}
}
