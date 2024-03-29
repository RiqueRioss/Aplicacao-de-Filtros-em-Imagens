package aplicacao;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ManipularImagem {

    public void exibirImagem(String titulo, BufferedImage... imagens){
        JFrame frame = new JFrame();
        frame.setTitle(titulo);
        frame.getContentPane().setLayout(new FlowLayout());
        for(BufferedImage imagem : imagens){
            JLabel label = new JLabel(new ImageIcon(imagem));
            frame.getContentPane().add(label);
        }
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void salvarImagem(BufferedImage img, File arq) throws IOException {
        ImageIO.write(img, "png", arq);
    }
}
