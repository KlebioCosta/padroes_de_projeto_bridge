package tech.projetobridge.jogocartas.cartas;

import tech.projetobridge.jogocartas.implementadores.efeitos.AplicadorDeEfeito;

public class CartaArmadilha extends Carta{
    public CartaArmadilha(AplicadorDeEfeito aplicadorDeEfeito) {
        super(aplicadorDeEfeito);
    }

    @Override
    void mostrarCarta() {

        System.out.println("Carta Armadilha");
    }

    @Override
    public void sacar() {
        System.out.println("Sacou uma carta Armadilha, ");
    }

    @Override
    public void jogar() {
        System.out.println("Jogou carta Armadilha, ");
    }
}
