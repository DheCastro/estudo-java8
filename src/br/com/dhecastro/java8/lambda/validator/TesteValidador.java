package br.com.dhecastro.java8.lambda.validator;

public class TesteValidador {

	public static void main(String[] args) {
		Validador<String> validadorCEP = valor -> valor.matches("[0-9]{5}-[0-9]{3}");	
		System.out.println(validadorCEP.valida("60763-540"));
	}

}
