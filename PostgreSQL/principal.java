package com.ti2cc;

import java.util.Scanner;

public class Principal {
	
	public static void mostrar() {
		System.out.println("assustado");
	}
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		dao.conectar();
		Scanner console = new Scanner(System.in);
		int x = 0;
		do {
			
			System.out.println("digite o que quer fazer");
			System.out.println("1-listar");
			System.out.println("2-inserir");
			System.out.println("3-excluir");
			System.out.println("4-atualizar");
			System.out.println("5-sair");
			
			x = console.nextInt();
			
			switch( x ) {
			case 1:
				System.out.println("==== Mostrar usuários === ");
				Usuario[] usuarios = dao.getUsuarios();
				for(int i = 0; i < usuarios.length; i++) {
					System.out.println(usuarios[i].toString());
				}
				break;
			case 2:
				System.out.println("digite o codigo a ser inserido");
				int c = console.nextInt();
				System.out.println("digite o nome a ser inserido");
				String n = console.nextLine();
				System.out.println("digite a nova senha a ser inserida");
				String p = console.nextLine();
				System.out.println("digite o sexo a ser inserido");
				char s = console.next().charAt(0); 
				Usuario usuario = new Usuario(c, p, p, s);
				if(dao.inserirUsuario(usuario) == true) {
					System.out.println("Inserção com sucesso -> " + usuario.toString());
				}
				break;
			case 3:
				System.out.println("digite o codigo a ser excluido");
				int codigo = console.nextInt();
				dao.excluirUsuario(codigo);
				System.out.println("usuario "+ codigo + " excluido");
				break;
			case 4:
				
			}
		}while(x != 5);
		
		/**
		//Inserir um elemento na tabela
		Usuario usuario = new Usuario(11, "pablo", "pablo",'M');
		if(dao.inserirUsuario(usuario) == true) {
			System.out.println("Inserção com sucesso -> " + usuario.toString());
		}
		
		//Mostrar usuÃ¡rios do sexo masculino		
		System.out.println("==== Mostrar usuários do sexo masculino === ");
		Usuario[] usuarios = dao.getUsuariosMasculinos();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}

		//Atualizar usuÃ¡rio
		usuario.setSenha("nova senha");
		dao.atualizarUsuario(usuario);

		//Mostrar usuÃ¡rios do sexo masculino
		System.out.println("==== Mostrar usuários === ");
		usuarios = dao.getUsuarios();
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		
		//Excluir usuÃ¡rio
		dao.excluirUsuario(usuario.getCodigo());
		
		//Mostrar usuÃ¡rios
		usuarios = dao.getUsuarios();
		System.out.println("==== Mostrar usuários === ");		
		for(int i = 0; i < usuarios.length; i++) {
			System.out.println(usuarios[i].toString());
		}
		**/
		dao.close();
	}
}
