package br.com.dhecastro.java8.lambda.validator;

@FunctionalInterface
interface Validador<T> {
	boolean valida(T t);
}
