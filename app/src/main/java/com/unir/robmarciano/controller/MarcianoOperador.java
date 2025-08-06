package com.unir.robmarciano.controller;

public class MarcianoOperador extends Marciano {

    @Override
    public String responda(String entrada) {
        String[] partes = entrada.trim().toLowerCase().split(" ");
        String comando = partes[0];

        if (comando.equals("some") || comando.equals("subtraia") || comando.equals("multiplique") || comando.equals("divida")) {
            try {
                if (partes.length < 3) {
                    return "Operação matemática incompleta. Forneça dois números.";
                }

                double num1 = Double.parseDouble(partes[1]);
                double num2 = Double.parseDouble(partes[2]);
                double resultado;

                switch (comando) {
                    case "some":
                        resultado = num1 + num2;
                        break;
                    case "subtraia":
                        resultado = num1 - num2;
                        break;
                    case "multiplique":
                        resultado = num1 * num2;
                        break;
                    case "divida":
                        if (num2 == 0) {
                            return "Não é possível dividir por zero.";
                        }
                        resultado = num1 / num2;
                        break;
                    default:
                        return "Operação desconhecida.";
                }

                return "Essa eu sei: " + resultado;

            } catch (NumberFormatException e) {
                return "Operandos inválidos. Por favor, use números.";
            }
        } else {
            return super.responda(entrada);
        }
    }
}
