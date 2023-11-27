package tech.projetobridge.jogocartas.cartas;

import tech.projetobridge.jogocartas.implementadores.efeitos.AplicadorDeEfeito;

public abstract class Carta implements AcaoCarta {
    protected AplicadorDeEfeito efeitoDacarta;

    public Carta(AplicadorDeEfeito aplicadorDeEfeito) {

        this.efeitoDacarta = aplicadorDeEfeito;
    }

    abstract void mostrarCarta();

    public void aplicadorDeEfeito() {
        efeitoDacarta.aplicarEfeito();
    }



}
