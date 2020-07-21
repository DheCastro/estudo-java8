package br.com.dhecastro.java8.lambda.comparator;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

import br.com.dhecastro.java8.pojo.Usuario;

/**
 * Estudo da evolução do comparator
 * @author dhecastro
 *
 */
public class Comparador {

	//Compare e ordenação de lista
	public static void main(String[] args) {

		List<Usuario> usuarios = Usuario.listaUsuarios();
		
		//Método antigo
		Comparator<Usuario> comparator = new Comparator<Usuario>() {
			public int compare(Usuario u1, Usuario u2) {
				return u1.getNome().compareTo(u2.getNome());
			}
		};
		Collections.sort(usuarios, comparator);
		
		//Lambda
		Comparator<Usuario> comparador = (u1,u2) -> u1.getNome().compareTo(u2.getNome());
		Collections.sort(usuarios, comparador);
		
		//Sintaxe reduzida do lambda
		Collections.sort(usuarios, (u1,u2) -> u1.getNome().compareTo(u2.getNome()));
		
		//Usando default method
		usuarios.sort((u1,u2) -> u1.getNome().compareTo(u2.getNome()));
		
		//Usando static method
		usuarios.sort(Comparator.comparing(u -> u.getNome()));
		
		//Usando static method com static import
		usuarios.sort(comparing(u -> u.getNome()));
		
		//Usando method reference
		usuarios.sort(comparing(Usuario::getNome));
		
		//Comparator já existente da classe String
		String.CASE_INSENSITIVE_ORDER.compare(usuarios.get(0).getNome(), usuarios.get(1).getNome());
		
		/*O comparing só funciona quando passado um lambda T (Usuário no caso), 
		que retorne um Comparable<U> (a String nome do usuário nesse caso - Comparable<String>).*/
		
		/*Indexação por ordem natural
		Exemplo com lista de objetos que já implementem Comparable, como Strings.*/
		
		List<String> palavras = Arrays.asList("Primeira", "Segunda", "Terceira");
		//Ascendente
		palavras.sort(Comparator.naturalOrder());
		//Reversa
		palavras.sort(Comparator.reverseOrder());
		
		//Ordenando por pontos
		//Usando static method
		usuarios.sort(Comparator.comparing(u -> u.getPontos()));
		
		//Usando static method com static import
		usuarios.sort(comparing(u -> u.getPontos()));
		
		//Usando method reference
		usuarios.sort(comparing(Usuario::getPontos));
		
		//O que acontece nos lambdas e reference acima?
		Function<Usuario, Integer> extraiPontos = u -> u.getPontos();
		Comparator<Usuario> comparatorPorPontos = Comparator.comparing(extraiPontos);
		usuarios.sort(comparatorPorPontos);
		
		//Evitando autoboxing de Integer para int
		ToIntFunction<Usuario> extraiPontosInt = u -> u.getPontos();
		Comparator<Usuario> comparatorPorPontosInt = Comparator.comparingInt(extraiPontosInt);
		usuarios.sort(comparatorPorPontosInt);
	}

}
