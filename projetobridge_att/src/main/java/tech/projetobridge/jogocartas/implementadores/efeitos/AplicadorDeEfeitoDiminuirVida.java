package tech.projetobridge.jogocartas.implementadores.efeitos;

import tech.projetobridge.jogocartas.implementadores.efeitos.AplicadorDeEfeito;

public class AplicadorDeEfeitoDiminuirVida implements AplicadorDeEfeito {

    @Override
    public void aplicarEfeito () {
        System.out.println("Vida do Oponente diminui");

    }


}
