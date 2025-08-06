package com.unir.robmarciano.controller;

import java.util.regex.Pattern;

public class Marciano {

    public String responda(String entrada) {
        if (entrada == null || entrada.trim().isEmpty()) {
            return "Não me incomode";
        }

        boolean isPergunta = entrada.trim().endsWith("?");
        boolean isGrito = Pattern.compile("\\b[A-Z]{2,}\\b").matcher(entrada).find();
        boolean temEu = entrada.toLowerCase().contains("eu");

        if (isGrito && isPergunta) {
            return "Relaxa, eu sei o que estou fazendo!";
        } else if (isGrito) {
            return "Opa! Calma aí!";
        } else if (isPergunta) {
            return "Certamente";
        } else if (temEu) {
            return "A responsabilidade é sua";
        } else {
            return "Tudo bem, como quiser";
        }
    }
}
