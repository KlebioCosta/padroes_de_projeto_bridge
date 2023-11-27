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


        EstadoDoJogo estadoAtual;

        for (EstadoDoJogo estado : EstadoDoJogo.values()) {
            estadoAtual = estado;

            switch (estadoAtual) {
                case INICIANDO_JOGO:
                    quebraLinha();
                    quebraLinha();
                    System.out.println("-=-=-=-=-=-* É HORA DO DUELO *-=-=-=-=-=-");

                    quebraLinha();
                    break;
                case DISTRIBUINDO_CARTAS:
                    System.out.println("CADA JOGADOR PEGA 5 CARTAS");
                    exibicaoCurta();
                    limparTela();
                    break;
                case SUA_VEZ_DE_JOGAR:
                    System.out.println("SUA JOGADA INICIOU");
                    quebraLinha();

                    cartaMonstro.jogar();
                    System.out.println(" 'CEIFADOR SEM NOME',\n" +
                            " Colocado em posiçao de DEF.");
                    exibicaoLonga();
                    cartaArmadilha.jogar();
                    System.out.println("'NEGAR DEFESA', Virada pra baixo.");
                    exibicaoLonga();
                    limparTela();
                    break;
                case VEZ_DO_OPONENTE:
                    System.out.println("VEZ DO SEU OPONENTE");
                    quebraLinha();
                    break;
                case PUXANDO_CARTA_P2:
                    System.out.println("ADIVERSÁRIO PUXA UMA NOVA CARTA");
                    exibicaoCurta();
                    break;
                case PENSANDO_NA_JOGADA_P2:
                    System.out.println("'o adversário fica olhando para sua carta virada para baixo'.");
                    exibicaoLonga();
                    cartaMonstro.jogar();System.out.println(" 'FEITICEIRO DO ABISMO'");
                    exibicaoCurta();
                    quebraLinha();
                    System.out.println("Adversário decide fazer um ATK.");
                    exibicaoLonga();
                    quebraLinha();
                    limparTela();
                        break;
                case BATALHA2:
                    System.out.println("ADVERSÁRIO COMEÇA  A BATALHAR");
                    quebraLinha();
                    System.out.println("'FEITICEIRO DO ABISMO' ATK SEU MONSTRO 'CEIFADOR SEM NOME'");
                    exibicaoCurta();
                    System.out.println("ATK do monstro inimigo é maior que sua DEF,");
                    exibicaoCurta();
                    System.out.println("Seu 'CEIFADOR SEM NOME' é destruido.");
                    exibicaoLonga();
                    quebraLinha();
                    System.out.println("Após ir para o cemitério o efeito do seu monstro é ativado, ");
                    exibicaoCurta();
                    cartaMonstro3.aplicadorDeEfeito();
                    quebraLinha();
                    System.out.println("Monstro inimigo 'FEITICEIRO DO ABISMO',\n" +
                            " não pode atacar por 1 rodada.");
                    quebraLinha();
                    exibicaoLonga();
                    limparTela();
                    break;
                case FINALIZANDO_RODADA:
                    System.out.println("RODADA FINALIZADA, SUA VEZ DE JOGAR");
                    quebraLinha();
                    exibicaoCurta();
                    limparTela();
                    break;

            }


        }
        for (EstadoDoJogo estado1 : EstadoDoJogo.values()) {
            estadoAtual = estado1;

            switch (estadoAtual) {
                case SUA_VEZ_DE_JOGAR:
                    System.out.println("SUA JOGADA INICIOU");
                    quebraLinha();
                    exibicaoCurta();

                    cartaMagica.sacar();
                    System.out.println("'FACA GUIADA PELO OLHO CEGO'");
                    cartaMagica.jogar();
                    exibicaoCurta();
                    System.out.println("Carta mágica ativada,");
                    cartaMagica4.aplicadorDeEfeito();
                    quebraLinha();
                    cartaMonstro.jogar();
                    System.out.println("'PESADELO VIVO'");
                    System.out.println("'Dizem que a melhor DEF é o ATK, então...'");
                    quebraLinha();
                    exibicaoCurta();
                    limparTela();
                    break;
                case BATALHA_P1:
                    System.out.println("VOCÊ COMEÇA A BATALHAR");
                    quebraLinha();
                    exibicaoCurta();
                    System.out.println("Você ATK o monstro inimigo 'FEITICEIRO DO ABISMO', ");
                    exibicaoCurta();
                    System.out.println("monstro inimigo destruido.");
                    System.out.println("Apos ser destruido o efeito do monstro inimigo é ativado");
                    cartaMonstro2.aplicadorDeEfeito();
                    quebraLinha();
                    exibicaoCurta();
                    System.out.println("Ao destruir um monstro o efeito do seu monstro é ativado");
                    exibicaoCurta();
                    quebraLinha();
                    cartaMonstro.aplicadorDeEfeito();
                    System.out.println("O adiverario perde pontos de vida diretamente");
                    exibicaoLonga();
                    limparTela();
                    break;
                case VEZ_DO_OPONENTE:
                    System.out.println("VEZ DO SEU OPONENTE");
                    quebraLinha();
                    exibicaoCurta();
                    cartaMonstro.sacar();
                    exibicaoCurta();
                    cartaArmadilha.jogar();
                    exibicaoCurta();
                    cartaMagica1.jogar();
                    cartaMonstro.jogar();
                    System.out.println("Monstro colocado em posição de DEF");
                    exibicaoLonga();
                    quebraLinha();
                    System.out.println("Sua carta Armadilha é ativada,\n" +
                            " 'NEGAR DEF', monstro adversário fica em posção de ATK");
                    quebraLinha();
                    exibicaoCurta();
                    System.out.println("Carta Armadilha do Adversário é ativada,\n" +
                            "'NEGAR EFEITO'.");
                    exibicaoCurta();
                    quebraLinha();
                    System.out.println("Monstro do Adversário volta para posição de DEF");
                    quebraLinha();
                    System.out.println("O Adversário termina sua jogada colocando\n" +
                            "uma carta virada para baixo");
                    quebraLinha();
                    limparTela();

                    break;
                case FINALIZANDO_RODADA:
                    System.out.println("RODADA FINALIZADA, SUA VEZ DE JOGAR");
                    quebraLinha();
                    exibicaoCurta();
                    limparTela();
                    break;

            }

        }
        for (EstadoDoJogo estado2 : EstadoDoJogo.values()) {
            estadoAtual = estado2;

            switch (estadoAtual) {
                case SUA_VEZ_DE_JOGAR:
                    System.out.println("SUA JOGADA INICIOU");
                    quebraLinha();
                    exibicaoCurta();
                    break;

                case PUXANDO_CARTA_P1:
                    cartaMonstro.sacar();
                    System.out.println("'OLHO GORDO o DEVORADOR DE MAGIA'");
                    break;

                case PENSANDO_NA_JOGADA_P1:
                    System.out.println("Está na hora de usar a Relíquia do Milênio");
                    quebraLinha();
                    exibicaoCurta();
                    System.out.println("'MILEENIÔOOOOHHH'");
                    quebraLinha();
                    System.out.println("Isso já estava predestinado a acontecer HUAHUHAUHAU");
                    exibicaoLonga();
                    break;

                case BATALHA_P1:
                    cartaMonstro.jogar();
                    System.out.println("OLHO GORDO o DEVORADOR DE MAGIA");
                    quebraLinha();
                    exibicaoCurta();
                    System.out.println("Após colocar seu monstro em campo,\n" +
                            " a carta Armadilha do adversario é ativada");
                    cartaArmadilha2.aplicadorDeEfeito();
                    quebraLinha();
                    exibicaoCurta();
                    System.out.println("Este jogo está chegando ao fim");
                    quebraLinha();
                    exibicaoCurta();
                    limparTela();
                    System.out.println("Após colocar meu monstro 'OLHO GORDO o DEVORADOR DE MAIGA' em campo,\n" +
                            " Eu posso oferecer quantas cartas Mágicas eu tiver em campo e na minha mão,\n" +
                            "Para cada carta que meu monstro devorar eu poderei puxar 2 novas cartas do meu Deck,\n " +
                            "Após eu puxar as novas cartas e ela forem Cartas Mágicas eu posso descidir se meu \n" +
                            "monstro irá devoralas ou não,  e para cada Carta que eu permitir que ele devore\n" +
                            "ele ganha 300 de ATK");
                    quebraLinha();quebraLinha();
                    exibicaoLonga();exibicaoLonga();
                    limparTela();
                    System.out.println("Meu monstro devorou 3 cartas entao posso puxar mais 6 Cartas,\n" +
                            "e aumentando 900 de ATK do meu 'DEVORADOR'");
                    quebraLinha();
                    exibicaoCurta();
                    cartaMagica.sacar();
                    System.out.println("'DRENO DOS CORRUPTOS'");
                    exibicaoCurta();
                    quebraLinha();
                    cartaMonstro.sacar();
                    System.out.println("'VAGANTE'");
                    exibicaoCurta();
                    quebraLinha();
                    cartaArmadilha.sacar();
                    System.out.println("'PREGO DE MESA'");
                    exibicaoCurta();
                    cartaMagica.sacar();
                    System.out.println("'GÁS VENENOSO'");
                    exibicaoCurta();
                    quebraLinha();
                    cartaMagica.sacar();
                    System.out.println("'COVIL DAS ARANHAS'");
                    exibicaoCurta();
                    quebraLinha();
                    cartaMagica.sacar();
                    System.out.println("NEBLINA ELETRICA");
                    quebraLinha();
                    limparTela();
                    System.out.println("Continuando sua jogada");
                    quebraLinha();
                    cartaMagica.jogar();
                    System.out.println("'COVIEL DAS ARANHAS'");
                    cartaMagica3.aplicadorDeEfeito();
                    quebraLinha();
                    exibicaoCurta();
                    System.out.println("As demais Cartas Magicas vão para\n" +
                            "o 'OLHO GORDO' ganhando mais 900 de ATK.");
                    quebraLinha();
                    exibicaoCurta();
                    System.out.println("Agora o grande final,\n" +
                            "se você naõ tiver cartas Mágicas em mãos eu posso ATK\n" +
                            "seus pontos de vida diretamente. ");
                    quebraLinha();
                    exibicaoCurta();
                    System.out.println("'OLHO GORDO' VAMOS ACABAR COM ESSE DUELO'");
                    quebraLinha();
                    System.out.println("ATK os pontos de vida diretamente");
                    exibicaoCurta();
                    limparTela();
                    break;
                case FINALIZANDO_JOGO:
                    System.out.println("OS PONTOS DE VIDA DO INIMIGO FORAM \n" +
                            "REDUZIDOS A ZERO");
                    quebraLinha();
                    System.out.println("O DUELO CHEGOU AO FIM");
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
