package tech.projetobridge.jogocartas.cartas;

import tech.projetobridge.jogocartas.implementadores.efeitos.AplicadorDeEfeito;

public class CartaMagica extends Carta {
    public CartaMagica(AplicadorDeEfeito aplicadorDeEfeito) {
        super(aplicadorDeEfeito);
    }

    @Override
    void mostrarCarta() {
        System.out.println("Carta Mágica");

    }

    @Override
    public void sacar() {
        System.out.println("Sacou uma carta Mágica");

    }

    @Override
    public void jogar() {
        System.out.println("Jogou uma carta de Mágica");

    }
}
