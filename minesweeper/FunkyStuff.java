import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FunkyStuff {
    public void updateImage(BufferedImage bufImg, File fil) {
        try {
            ImageIO.write(bufImg, "png", fil);
        } catch (IOException e) {
            System.out.println("OH NO!");
            System.exit(0);
        }
    }

    public static void clearTerminal() {
        // Source - https://stackoverflow.com/a/10241460
        // Posted by Joni, modified by community. See post 'Timeline' for change history
        // Retrieved 2026-08-16, License - CC BY-SA 3.0

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}