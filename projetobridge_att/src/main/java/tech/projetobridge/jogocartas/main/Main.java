package tech.projetobridge.jogocartas.main;


import tech.projetobridge.jogocartas.cartas.CartaArmadilha;
import tech.projetobridge.jogocartas.cartas.CartaMagica;
import tech.projetobridge.jogocartas.cartas.CartaMonstro;
import tech.projetobridge.jogocartas.implementadores.efeitos.*;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        AplicadorDeEfeito aplicarAumentarVida = new AplicadorDeEfeitoAumentarVida();
        AplicadorDeEfeito aplicarDiminuirVida = new AplicadorDeEfeitoDiminuirVida();
        AplicadorDeEfeito aplicarFadiga = new AplicadorDeEfeitoFadiga();
        AplicadorDeEfeito aplicarParalisia = new AplicadorDeEfeitoParalisar();
        AplicadorDeEfeito aplicarSangramento = new AplicadorDeEfeitoSangramento();


        //Diminuir Vida

        CartaMonstro cartaMonstro = new CartaMonstro(aplicarDiminuirVida);
        CartaMagica cartaMagica = new CartaMagica(aplicarDiminuirVida);
        CartaArmadilha cartaArmadilha = new CartaArmadilha(aplicarDiminuirVida);


        //Aumentar Vida
        CartaMonstro cartaMonstro1 = new CartaMonstro(aplicarAumentarVida);
        CartaMagica cartaMagica1 = new CartaMagica(aplicarAumentarVida);
        CartaArmadilha cartaArmadilha1 = new CartaArmadilha(aplicarAumentarVida);

        //Fadiga
        CartaMonstro cartaMonstro2 = new CartaMonstro(aplicarFadiga);
        CartaMagica cartaMagica2 = new CartaMagica(aplicarFadiga);
        CartaArmadilha cartaArmadilha2 = new CartaArmadilha(aplicarFadiga);

        //Paralisia
        CartaMonstro cartaMonstro3 = new CartaMonstro(aplicarParalisia);
        CartaMagica cartaMagica3 = new CartaMagica(aplicarParalisia);
        CartaArmadilha cartaArmadilha3 = new CartaArmadilha(aplicarParalisia);

        //Sangramento
        CartaMonstro cartaMonstro4 = new CartaMonstro(aplicarSangramento);
        CartaMagica cartaMagica4 = new CartaMagica(aplicarSangramento);
        CartaArmadilha cartaArmadilha4 = new CartaArmadilha(aplicarSangramento);


        EstadoDoJogo estadoAtual = EstadoDoJogo.INICIANDO_JOGO;

        for (EstadoDoJogo estado : EstadoDoJogo.values()) {
            estadoAtual = estado;

            switch (estadoAtual) {
                case INICIANDO_JOGO:
                    System.out.println("-=-=-=-=-=-* É HORA DO DUELO *-=-=-=-=-=-");

                    quebraLinha();
                    break;
                case DISTRIBUINDO_CARTAS:
                    System.out.println("CADA JOGADOR PEGA 5 CARTAS");
                    exibicaoCurta();
                    quebraLinha();
                    break;
                case SUA_VEZ_DE_JOGAR:
                    System.out.println("SUA JOGADA INICIOU");
                    quebraLinha();

                    cartaMonstro.jogar();
                    System.out.println("monstro colocado em posiçao de def");
                    cartaArmadilha.jogar();
                    System.out.println("Virada pra baixo");
                    exibicaoLonga();
                    limparTela();
                    break;
                case VEZ_DO_OPONENTE:
                    System.out.println("VEZ DO SEU OPONENTE");
                    quebraLinha();
                    break;
                case PUXANDO_CARTA:
                    System.out.println("ADIVERSÁRIO PUXA UMA NOVA CARTA");
                    break;
                case PENSANDO_NA_JOGADA:
                    System.out.println("ADIVERSÁRIO FICA OLHANDO PARA SUA CARTA VIRADA PRA BAIXO");
                    exibicaoLonga();
                    cartaMonstro.jogar();
                    quebraLinha();
                        break;
                case BATALHA:
                    System.out.println("ADIVERSÁRIO ATK SEU MONSTRO EM POSIÇÃO DE DEF");
                    exibicaoLonga();
                    quebraLinha();

                    System.out.println("atk do monstro inimigo é maior que sua def");
                    System.out.println("seu monstro é destruido ");
                    System.out.println("após ir para o cemiterio o efeito do seu monstro é ativado");
                    cartaMonstro3.aplicadorDeEfeito();
                    quebraLinha();
                    exibicaoLonga();
                    limparTela();
                    break;
                case FINALIZANDO_RODADA:
                    System.out.println("RODADA FINALIZADA, SUA VEZ DE JOGAR");
                    exibicaoLonga();
                    quebraLinha();
                    break;

            }


        }
        for (EstadoDoJogo estado1 : EstadoDoJogo.values()) {
            estadoAtual = estado1;

            switch (estadoAtual) {
                case SUA_VEZ_DE_JOGAR:
                    System.out.println("SUA JOGADA INICIOU");
                    exibicaoLonga();
                    quebraLinha();
                    cartaMagica.sacar();
                    System.out.println("Você joga uma carta Magica");
                    cartaMagica4.aplicadorDeEfeito();
                    cartaMonstro.jogar();
                    System.out.println("Você atk o monstro inimigo");
                    System.out.println("monstro inimigo destruido\n" +
                            "Ao destruir um monstro o efeito do seu monstro é ativado");
                    cartaMonstro.aplicadorDeEfeito();
                    System.out.println("O adiverario perde pontos de vida diretamente");
                    exibicaoLonga();
                    exibicaoCurta();
                    limparTela();
                    break;
                case VEZ_DO_OPONENTE:
                    System.out.println("VEZ DO SEU OPONENTE");
                    quebraLinha();
                    exibicaoLonga();
                    cartaMonstro.sacar();
                    cartaArmadilha.jogar();
                    cartaMonstro.jogar();
                    quebraLinha();
                    break;

            }

        }
    }


    private static void quebraLinha() {
        System.out.println("\n");
        sleep(2000);
    }
    private static void exibicaoLonga() {
        sleep(4500);
    }
    private static void exibicaoCurta() {
        sleep(2500);
    }

    private static void limparTela() {
        for (int i = 0; i < 50; i++) {
                System.out.println();
        }
    }
    private static void sleep(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
