package tech.projetobridge.jogocartas.cartas;

import tech.projetobridge.jogocartas.implementadores.efeitos.AplicadorDeEfeito;

public class CartaMonstro extends Carta {
    public CartaMonstro(AplicadorDeEfeito efeito) {

        super(efeito);
    }

    @Override
    public void mostrarCarta() {
        System.out.println("Carta Monstro");

    }

    @Override
    public void sacar() {

        System.out.println("Sacou uma carta de Monstro, ");
    }

    @Override
    public void jogar() {

        System.out.println("Jogou carta de Monstro, ");
    }

}
