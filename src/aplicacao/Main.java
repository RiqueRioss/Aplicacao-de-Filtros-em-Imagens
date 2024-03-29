package aplicacao;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedImage imagem = ImageIO.read(new File("src/imagem.png"));

        ManipularImagem manipularImagem = new ManipularImagem();

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        Color corAzul = new Color(0,0,255);
        Color corVerde = new Color(0,255,0);
        Color corVermelho = new Color(255,0,0);

        imagem.setRGB(0, 0, corAzul.getRGB());
        imagem.setRGB(largura/2, altura/2, corVerde.getRGB());
        imagem.setRGB(largura-1, altura-1, corVermelho.getRGB());

        BufferedImage negativo = FiltrosPontuais.bandaNegativo(imagem);
        BufferedImage cinzaR = FiltrosPontuais.bandaCinza_R(imagem);
        BufferedImage cinzaB = FiltrosPontuais.bandaCinza_B(imagem);
        BufferedImage cinzaG = FiltrosPontuais.bandaCinza_G(imagem);
        BufferedImage cinzaM = FiltrosPontuais.bandaCinza_M(imagem);
        BufferedImage binarizado = FiltrosPontuais.binarizar(imagem, 150);
        BufferedImage addbrilho = FiltrosPontuais.adicionarBrilho(imagem, 50);
        BufferedImage multbrilho = FiltrosPontuais.multiplicarBrilho(imagem, 150);
        BufferedImage auTonalidade = FiltrosPontuais.alteracaoTonalidade(imagem, "red", 150);

        manipularImagem.exibirImagem("Operações com RGB" ,imagem, negativo, cinzaR, cinzaB, cinzaG, cinzaM, binarizado,
                addbrilho, multbrilho, auTonalidade);

        BufferedImage mostraLuminosidadeY = FiltrosPontuais.mostraLuminosidade(imagem);
        BufferedImage mostraCrominanciaI = FiltrosPontuais.mostraCrominanciaI(imagem);
        BufferedImage mostraCrominanciaQ = FiltrosPontuais.mostraCrominanciaQ(imagem);
        BufferedImage brilhoAditivoY = FiltrosPontuais.brilhoAditivoY(imagem, 100);
        BufferedImage brilhoMultiplicativoY = FiltrosPontuais.brilhoMultiplicativoY(imagem, 3);
        BufferedImage negativoY = FiltrosPontuais.negativoY(imagem);

        manipularImagem.exibirImagem("Operações com YIQ",imagem, mostraLuminosidadeY, mostraCrominanciaI, mostraCrominanciaQ,
                brilhoAditivoY, brilhoMultiplicativoY, negativoY);

    }

}