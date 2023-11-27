package tech.projetobridge.jogocartas.implementadores.efeitos;

import tech.projetobridge.jogocartas.implementadores.efeitos.AplicadorDeEfeito;

public class AplicadorDeEfeitoParalisar implements AplicadorDeEfeito {
    @Override
    public void aplicarEfeito() {
        System.out.println("Efeito aplicado, oponente paralizado");
    }
}
