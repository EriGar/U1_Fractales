package fractales_erika;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

public class Mandelbrot_4 extends JFrame{
    private final int MAX_ITER = 1000;
    private final double ZOOM = 150;
    private BufferedImage I;
    
    public Mandelbrot_4(){
        super("Mandelbrot_4");
        setBounds(100, 100, 800, 600);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < getHeight(); y++) {
            for (int x = 0; x < getWidth(); x++) {
                double zx, zy, cX, cY;
                zx = zy = 0;
                cX = (x - 400) / ZOOM;
                cY = (y - 300) / ZOOM;
                int iter = MAX_ITER;
                while (zx * zx + zy * zy < 4 && iter > 0) {
                    double tmp = zx * zx * zx * zx - 6 * zx * zx * zy * zy + zy * zy * zy * zy + cX;
                    zy = 4 * zx * zx * zx * zy - 4 * zx * zy * zy * zy + cY;
                    zx = tmp;
                    iter--;
                }
               if (iter == 0) {
                    I.setRGB(x, y, Color.BLACK.getRGB());
                } else {
                    I.setRGB(x, y, Color.CYAN.getRGB());
                }
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        g.drawImage(I, 0, 0, this);
    }

    public static void main(String[] args) {
        new Mandelbrot_4().setVisible(true);
    }
}

//ERIKA JANET GARCIA GARCIA