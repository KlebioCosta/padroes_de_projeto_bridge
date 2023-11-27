package tech.projetobridge.jogocartas.implementadores.efeitos;

import tech.projetobridge.jogocartas.implementadores.efeitos.AplicadorDeEfeito;

public class AplicadorDeEfeitoSangramento implements AplicadorDeEfeito {
    @Override
    public void aplicarEfeito() {

        System.out.println("Causando Sangramento ao oponente");
    }
}
