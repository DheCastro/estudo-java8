package br.com.dhecastro.java8.pojo;

import java.util.Arrays;
import java.util.List;

public class Usuario {

	private String nome;
	private int pontos;
	private boolean moderador;
	
	public Usuario(String nome, int pontos) {
		this.pontos = pontos;
		this.nome = nome;
		this.moderador = false;
	}

	public static List<Usuario> listaUsuarios() {
		//Populando a lista de testes
		Usuario user1 = new Usuario("Dhellano de Castro", 200);
		Usuario user2 = new Usuario("Dayane Mendes", 180);
		Usuario user3 = new Usuario("Aike Ferreira", 160);
		Usuario user4 = new Usuario("Preto Zeze", 140);
		Usuario user5 = new Usuario("Dhayana Oliveira", 110);
		Usuario user6 = new Usuario("Maria Santos", 100);
		Usuario user7 = new Usuario("Adonai Barbosa", 80);
		Usuario user8 = new Usuario("Luciano Felipe", 70);
		Usuario user9 = new Usuario("Rayane Barreto", 60);
		Usuario user0 = new Usuario("Daniel Lima", 50);
		List<Usuario> usuarios = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user0);
		
		return usuarios;
	}
	
	public String getNome() {
		return nome;
	}

	public int getPontos() {
		return pontos;
	}

	public boolean isModerador() {
		return moderador;
	}

	public void tornaModerador(boolean moderador) {
		this.moderador = moderador;
	}
	
	
}
