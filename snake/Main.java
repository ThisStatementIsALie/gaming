import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.imageio.ImageIO;

public class Main {
    public static void main(String[] args) {
        int size = 0; // Size of board (Width and Height)
        int pick = 0; // Option selected when prompted
        Scanner scannyboi = new Scanner(System.in);
        int MoveRate = 0; // Seconds per movement
        boolean MovementEnabled; // If the snake should move on keypress

        System.out.println("== SNAKE ==\n\nSelect a Board Size...\n'1' - 8 x 8 Board\n'2' - 16 x 16 Board\n'3' - 32 x 32 Board\n'4' - It is highly recommended that you do NOT press 4.\n-----------------");
        pick = scannyboi.nextInt();

        if (pick < 4) {
            size = 8 * pick;
        } else if (pick == 4) {
            size = 100;
            FunTimes();
        } else {
            System.out.println(pick+"found Invalid.");
            System.exit(0);
        }
        
        BufferedImage bImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
        System.out.println("-----------------\nPaste in the path to 'snakeBoard.png' below.\n-----------------");
        File file = new File(scannyboi.next());
        updateImage(bImage, file);
    }

    public static void FunTimes() {
        System.out.println("You gave in.\n\nAfter many games or none... you pressed '4'.\n\nH a v e   F u n  .");
    }

    private static void updateImage(BufferedImage bage, File fil) {
        try {
            ImageIO.write(bage, "png", fil);
        } catch (IOException e) {
            System.out.println("OH NO!");
            System.exit(0);
        }
    }
}