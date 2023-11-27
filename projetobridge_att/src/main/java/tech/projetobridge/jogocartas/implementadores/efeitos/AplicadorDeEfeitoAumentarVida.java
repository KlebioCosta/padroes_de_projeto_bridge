package tech.projetobridge.jogocartas.implementadores.efeitos;

public class AplicadorDeEfeitoAumentarVida implements AplicadorDeEfeito {

    @Override
    public void aplicarEfeito() {
        System.out.println("Vida aumentou");
    }
}
