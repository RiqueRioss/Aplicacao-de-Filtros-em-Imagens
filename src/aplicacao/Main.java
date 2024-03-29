package aplicacao;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedImage imagem = ImageIO.read(new File("src/aplicacao/imagem.png"));

        ManipularImagem manipularImagem = new ManipularImagem();

        BufferedImage apenasVermelho = FiltrosPontuais.bandaR(imagem);
        BufferedImage apenasVerde = FiltrosPontuais.bandaG(imagem);
        BufferedImage apenasAzul = FiltrosPontuais.bandaB(imagem);
        BufferedImage negativo = FiltrosPontuais.bandaNegativo(imagem);
        BufferedImage cinzaR = FiltrosPontuais.bandaCinzaR(imagem);
        BufferedImage cinzaB = FiltrosPontuais.bandaCinzaB(imagem);
        BufferedImage cinzaG = FiltrosPontuais.bandaCinzaG(imagem);
        BufferedImage cinzaM = FiltrosPontuais.bandaCinzaM(imagem);
        BufferedImage binarizado = FiltrosPontuais.binarizar(imagem, 150);
        BufferedImage addbrilho = FiltrosPontuais.adicionarBrilho(imagem, 50);
        BufferedImage multbrilho = FiltrosPontuais.multiplicarBrilho(imagem, 1.5);
        BufferedImage auTonalidade = FiltrosPontuais.alteracaoTonalidade(imagem, "red", 150);

        manipularImagem.exibirImagem("Operações com RGB", imagem, apenasVermelho, apenasVerde,
                apenasAzul, negativo, cinzaR, cinzaB, cinzaG, cinzaM, binarizado, addbrilho,
                multbrilho, auTonalidade);

        BufferedImage mostraLuminosidadeY = FiltrosPontuais.mostraLuminosidade(imagem);
        BufferedImage mostraCrominanciaI = FiltrosPontuais.mostraCrominanciaI(imagem);
        BufferedImage mostraCrominanciaQ = FiltrosPontuais.mostraCrominanciaQ(imagem);
        BufferedImage brilhoAditivoY = FiltrosPontuais.brilhoAditivoY(imagem, 100);
        BufferedImage brilhoMultiplicativoY = FiltrosPontuais.brilhoMultiplicativoY(imagem, 3);
        BufferedImage negativoY = FiltrosPontuais.negativoY(imagem);

        manipularImagem.exibirImagem("Operações com YIQ",imagem, mostraLuminosidadeY,
                mostraCrominanciaI, mostraCrominanciaQ, brilhoAditivoY,
                brilhoMultiplicativoY, negativoY);

    }

}