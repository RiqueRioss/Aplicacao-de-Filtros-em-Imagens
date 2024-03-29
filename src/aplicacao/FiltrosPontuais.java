package aplicacao;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
public class FiltrosPontuais {

    private static int validaLimitesRGB(int valor, int acrescimo) {
        int soma = valor + acrescimo;
        if (soma + acrescimo > 255) soma = 255;
        else if (soma + acrescimo < 0) soma = 0;
        return soma;
    }

    private static int validaLimitesRGB(int valor, float acrescimo) {
        float multiplicacao = valor * acrescimo;
        if (multiplicacao * acrescimo > 255) multiplicacao = 255;
        else if (multiplicacao * acrescimo < 0) multiplicacao = 0;
        return (int) multiplicacao;
    }

    private static int validaLimitesRGB(double valor) {
        if (valor > 255) valor = 255;
        else if (valor < 0) valor = 0;
        return (int) valor;
    }

    public static BufferedImage bandaR (BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));
                int red = cor.getRed();
                Color novaCor = new Color(red, 0,0);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaG (BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));
                int green = cor.getGreen();
                Color novaCor = new Color(0, green,0);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaB (BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));
                int blue = cor.getBlue();
                Color novaCor = new Color(0, 0,blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaNegativo (BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                Color novaCor = new Color(255-red, 255-green, 255-blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaCinza_R (BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));
                int red = cor.getRed();
                Color novaCor = new Color(red, red, red);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaCinza_B (BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));
                int blue = cor.getBlue();
                Color novaCor = new Color(blue, blue, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaCinza_G (BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));
                int green = cor.getGreen();
                Color novaCor = new Color(green, green, green);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage bandaCinza_M (BufferedImage img){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red + green + blue) / 3;
                Color novaCor = new Color(media, media, media);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage binarizar (BufferedImage img, int limiar){
        if (limiar < 1 || limiar > 254)
            throw new IllegalArgumentException("Limiar inválido");

        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();
                int media = (red + green + blue) / 3;

                Color novaCor;
                if(limiar > media){
                    novaCor = new Color(255,255,255);
                }
                else {
                    novaCor = new Color(0,0,0);
                }
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static BufferedImage alteracaoTonalidade(BufferedImage imgEntrada, String banda, int valor){
        if(!banda.equalsIgnoreCase("red") && !banda.equalsIgnoreCase("green")
        && !banda.equalsIgnoreCase("blue")){
            throw new IllegalArgumentException("Banda inválida");
        }
        
        int width = imgEntrada.getWidth();
        int height = imgEntrada.getHeight();
        BufferedImage imgSaida = new BufferedImage(width,height,BufferedImage.TYPE_INT_BGR);
        
        for(int h=0; h<height; h++){
            for(int w=0; w<width; w++){
                Color cor = new Color(imgEntrada.getRGB(w,h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                if (banda.equalsIgnoreCase("red")){
                    red = validaLimitesRGB(red, valor);
                }
                else if (banda.equalsIgnoreCase("green")){
                    green = validaLimitesRGB(green, valor);
                }
                else if (banda.equalsIgnoreCase("blue")){
                    blue = validaLimitesRGB(blue, valor);
                }

                Color novaCor = new Color(red, green, blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }
        return imgSaida;
    }

    public static BufferedImage adicionarBrilho (BufferedImage img, int aditivo){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));

                int red = cor.getRed() + aditivo;
                red = validaLimitesRGB(red,0);

                int green = cor.getGreen() + aditivo;
                green = validaLimitesRGB(green,0);

                int blue = cor.getBlue() + aditivo;
                blue = validaLimitesRGB(blue,0);

                Color novaCor = new Color(red,green,blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());

            }
        }
        return imgSaida;
    }

    public static BufferedImage multiplicarBrilho (BufferedImage img, float multiplicativo){
        int width = img.getWidth();
        int height = img.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        for(int h=0; h < height; h++){
            for(int w=0; w < width; w++){
                Color cor = new Color(img.getRGB(w, h));

                int red = cor.getRed();
                red = validaLimitesRGB(red,multiplicativo);

                int green = cor.getGreen();
                green = validaLimitesRGB(green,multiplicativo);

                int blue = cor.getBlue();
                blue = validaLimitesRGB(blue,multiplicativo);

                Color novaCor = new Color(red,green,blue);
                imgSaida.setRGB(w, h, novaCor.getRGB());
            }
        }
        return imgSaida;
    }

    public static ArrayList obterYIQ (BufferedImage imagem){
        int width = imagem.getWidth();
        int height = imagem.getHeight();

        ArrayList<Double[]> yiq = new ArrayList<>();
        Double[] cores;

        for(int w=0; w<width; w++){
            for(int h=0; h<height; h++){
                Color cor = new Color(imagem.getRGB(w,h));
                int red = cor.getRed();
                int green = cor.getGreen();
                int blue = cor.getBlue();

                double y = 0.299*red + 0.587*green + 0.114*blue;
                double i = 0.596*red - 0.274*green - 0.322*blue;
                double q = 0.211*red - 0.523*green + 0.312*blue;

                yiq.add(new Double[]{y, i, q});
            }
        }
        return yiq;
    }
    public static double[] rgbparaYIQ(double red, double green, double blue){
        double y = (0.229*red) + (0.587*green) + (0.114*blue);
        double i = (0.596*red) - (0.274*green) - (0.322*blue);
        double q = (0.211*red) - (0.523*green) + (0.312*blue);
        return new double[]{y, i, q};
    }
    public static double[] yiqparaRGB(double y, double i, double q){
        double r = y + (0.956 * i) + (0.621 * q);
        double g = y - (0.272 * i) - (0.647 * q);
        double b = y - (1.106 * i) + (1.703 * q);
        return new double[]{r, g, b};
    }
    public static BufferedImage mostraLuminosidade(BufferedImage imagem){
        int width = imagem.getWidth();
        int height = imagem.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        int x = 0;
        for(int w=0; w<width; w++){
            for(int h=0; h<height; h++){
                Color cores = new Color(imagem.getRGB(w, h));
                double[] yiq = rgbparaYIQ(cores.getRed(), cores.getGreen(), cores.getBlue());

                int y = validaLimitesRGB(yiq[0]);

                Color cor = new Color(y, y, y);

                imgSaida.setRGB(w, h, cor.getRGB());
                x++;
            }
        }
        return imgSaida;
    }
    public static BufferedImage mostraCrominanciaI(BufferedImage imagem){
        int width = imagem.getWidth();
        int height = imagem.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        int x = 0;
        for(int w=0; w<width; w++){
            for(int h=0; h<height; h++){
                Color cores = new Color(imagem.getRGB(w, h));
                double[] yiq = rgbparaYIQ(cores.getRed(), cores.getGreen(), cores.getBlue());

                int i = validaLimitesRGB(yiq[1]);

                Color cor = new Color(i, i, i);

                imgSaida.setRGB(w, h, cor.getRGB());
                x++;
            }
        }
        return imgSaida;
    }
    public static BufferedImage mostraCrominanciaQ(BufferedImage imagem){
        int width = imagem.getWidth();
        int height = imagem.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        int x = 0;
        for(int w=0; w<width; w++){
            for(int h=0; h<height; h++){
                Color cores = new Color(imagem.getRGB(w, h));
                double[] yiq = rgbparaYIQ(cores.getRed(), cores.getGreen(), cores.getBlue());

                int q = validaLimitesRGB(yiq[2]);

                Color cor = new Color(q, q, q);

                imgSaida.setRGB(w, h, cor.getRGB());
                x++;
            }
        }
        return imgSaida;
    }
    public static BufferedImage brilhoAditivoY(BufferedImage imagem, int aditivo){
        int width = imagem.getWidth();
        int height = imagem.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        int x = 0;
        for(int w=0; w<width; w++){
            for(int h=0; h<height; h++){
                Color cores = new Color(imagem.getRGB(w, h));
                double[] yiq = rgbparaYIQ(cores.getRed() + aditivo, cores.getGreen(), cores.getBlue());
                yiq = yiqparaRGB(yiq[0], yiq[1], yiq[2]);

                int red = validaLimitesRGB(yiq[0]);
                int green = validaLimitesRGB(yiq[1]);
                int blue = validaLimitesRGB(yiq[2]);

                Color corFinal = new Color(red, green, blue);

                imgSaida.setRGB(w, h, corFinal.getRGB());
                x++;
            }
        }
        return imgSaida;
    }
    public static BufferedImage brilhoMultiplicativoY(BufferedImage imagem, int multiplicativo){
        int width = imagem.getWidth();
        int height = imagem.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        int x = 0;
        for(int w=0; w<width; w++){
            for(int h=0; h<height; h++){
                Color cores = new Color(imagem.getRGB(w, h));
                double[] yiq = rgbparaYIQ(cores.getRed() * multiplicativo, cores.getGreen(), cores.getBlue());
                yiq = yiqparaRGB(yiq[0], yiq[1], yiq[2]);

                int red = validaLimitesRGB(yiq[0]);
                int green = validaLimitesRGB(yiq[1]);
                int blue = validaLimitesRGB(yiq[2]);

                Color corFinal = new Color(red, green, blue);

                imgSaida.setRGB(w, h, corFinal.getRGB());
                x++;
            }
        }
        return imgSaida;
    }

    public static BufferedImage negativoY(BufferedImage imagem){
        int width = imagem.getWidth();
        int height = imagem.getHeight();

        BufferedImage imgSaida = new BufferedImage(
                width,
                height,
                BufferedImage.TYPE_INT_BGR);

        int x = 0;
        for(int w=0; w<width; w++){
            for(int h=0; h<height; h++){
                Color cores = new Color(imagem.getRGB(w, h));
                double[] yiq = rgbparaYIQ(cores.getRed(), cores.getGreen(), cores.getBlue());
                yiq = yiqparaRGB(255 - yiq[0], yiq[1], yiq[2]);

                int red = validaLimitesRGB(yiq[0]);
                int green = validaLimitesRGB(yiq[1]);
                int blue = validaLimitesRGB(yiq[2]);

                Color corFinal = new Color(red, green, blue);

                imgSaida.setRGB(w, h, corFinal.getRGB());
                x++;
            }
        }
        return imgSaida;
    }
}
