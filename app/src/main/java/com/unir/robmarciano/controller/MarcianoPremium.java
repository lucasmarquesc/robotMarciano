package com.unir.robmarciano.controller;

public class MarcianoPremium extends MarcianoOperador {

    private AcaoPersonalizada acao;

    public MarcianoPremium(AcaoPersonalizada acao) {
        this.acao = acao;
    }

    @Override
    public String responda(String entrada) {
        if (entrada.toLowerCase().startsWith("agir ")) {
            String textoParaAcao = entrada.substring(5);
            return "É pra já! " + acao.executarAcao(textoParaAcao);
        } else {
            return super.responda(entrada);
        }
    }
}
