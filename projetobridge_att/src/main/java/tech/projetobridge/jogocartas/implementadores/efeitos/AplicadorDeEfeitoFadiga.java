package tech.projetobridge.jogocartas.implementadores.efeitos;

import tech.projetobridge.jogocartas.implementadores.efeitos.AplicadorDeEfeito;

public class AplicadorDeEfeitoFadiga implements AplicadorDeEfeito {
    @Override
    public void aplicarEfeito() {
        System.out.println("Efeito aplicado, atk do inimigo foi reduzido");
    }
}
