package com.unir.robmarciano.controller;

public class Cifra implements AcaoPersonalizada{
	
	@Override
	public String executarAcao(String texto) {
		int chave_padrao = 3;

		StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);

            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                char cifrado = (char) ((c - base + chave_padrao) % 26 + base);
                resultado.append(cifrado);
            } else {
                resultado.append(c); 
            }
        }

        return resultado.toString();
		
	}


}
