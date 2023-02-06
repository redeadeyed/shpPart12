package com.shpp.p2p.cs.rmamaiev.assignment12;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Main implements ArraysOfImage {

    private static final String FILE_NAME = "assets/111.jpg";

    public static int width;
    public static int height;
    public static ArrayList<PixelColor> pixels = new ArrayList<>();
    public static byte[][] byteImg = new byte[width][height];

    public static void main(String[] args) throws IOException {
        BufferedImage bImage = ImageIO.read(new File(FILE_NAME));
        width = bImage.getWidth();
        height = bImage.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(bImage.getRGB(i,j));
                int red = c.getRed();
                int green = c.getGreen();
                int blue = c.getBlue();
                if (pixels.isEmpty()){
                    pixels.add(new PixelColor(red,green,blue));
                }else {
                    for (int k = 0; k < pixels.size(); k++) {
                        PixelColor p = pixels.get(k);
                        if ((p.getRed() <= red+10 && p.getRed() >= red-10)
                                && (p.getGreen() <= green+10 && p.getGreen() >= green-10)
                                && (p.getBlue() <= blue+10 && p.getBlue() >= blue-10)){
                            p.plusCount();
                            break;
                        }
                        if (k == pixels.size()-1){
                            pixels.add(new PixelColor(red,green,blue));
                        }
                    }
                }
            }
        }
        for (PixelColor p:pixels) {
            System.out.println(p.getCount());
        }
    }
}
