package br.com.dhecastro.java8.defaultmethods;

import java.util.List;
import java.util.function.Consumer;

import br.com.dhecastro.java8.pojo.Usuario;

public class LacoForEach {

	public static void main(String[] args) {
		
		List<Usuario> usuarios = Usuario.listaUsuarios();
		
		Consumer<Usuario> mostraMensagem = u -> System.out.println("Imprimindo nome..: ");
		Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());
		
		//forEach é um método do tipo default da interface Iterable.
		//É um método com implementação dentro de uma interface. O.O hehe.
		
		//Já o método andThen é outro método default dentro da interface Consumer.
		//As interfaces funcionais devem ter apenas um método ABSTRATO, porém podem ter outros métodos,
		//desde que sejam default.
		usuarios.forEach(mostraMensagem.andThen(imprimeNome));

	}

}
