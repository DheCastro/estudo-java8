package br.com.dhecastro.java8.defaultmethods;

import java.util.List;
import java.util.function.Consumer;

import br.com.dhecastro.java8.pojo.Usuario;

public class LacoForEach {

	public static void main(String[] args) {
		
		List<Usuario> usuarios = Usuario.listaUsuarios();
		
		Consumer<Usuario> mostraMensagem = u -> System.out.println("Imprimindo nome..: ");
		Consumer<Usuario> imprimeNome = u -> System.out.println(u.getNome());
		
		//forEach � um m�todo do tipo default da interface Iterable.
		//� um m�todo com implementa��o dentro de uma interface. O.O hehe.
		
		//J� o m�todo andThen � outro m�todo default dentro da interface Consumer.
		//As interfaces funcionais devem ter apenas um m�todo ABSTRATO, por�m podem ter outros m�todos,
		//desde que sejam default.
		usuarios.forEach(mostraMensagem.andThen(imprimeNome));

	}

}
