import java.awt.MouseInfo;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Scanner;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        int size = 15;
        int mineCount = 50;
        Scanner scan = new Scanner(System.in);
        File file;
        BufferedImage bImage = new BufferedImage(10*size+1,10*size+1, BufferedImage.TYPE_INT_RGB);
        System.out.println("Paste in the path to board.png");
        file = new File(scan.next());
        FunkyStuff fs = new FunkyStuff();
        Board board = new Board();
        fs.updateImage(bImage, file);

        for (int x = 0; x < 10*size+1; x++) {
            for (int y = 0; y < 10*size+1; y++) {
                bImage.setRGB(x, y, Art.zero.getRGB());
            }
        }

        fs.updateImage(bImage, file);
        
        int mouseX = -1;
        int mouseY = -1;
        while (mouseX < 0 || mouseX > size || mouseY < 0 || mouseY > size) {
            FunkyStuff.clearTerminal();
            System.out.println("Enter in starting cordinates\nFormat it as two ints separated by a space\n("+size+" by "+size+" board)");
            mouseX = scan.nextInt()-1;
            mouseY = size-scan.nextInt();
            System.out.println("Invalid coordinates.");
        }

        board.GenerateBoard(mineCount, size, mouseX, mouseY);
        FunkyStuff.clearTerminal();
        System.out.println("Finished Generating Board.");
        board.GenerateNums(size);
        System.out.println("Finished Generating Mines.");
        int temp = -1;
        while (temp != 0) {
            temp = board.spreadAwareness(size);
        };
        board.drawBoard(bImage, size);
        fs.updateImage(bImage, file);
        while (true) {
            System.out.println(MouseInfo.getPointerInfo().getLocation().getX()+" "+MouseInfo.getPointerInfo().getLocation().getY());
            // board.BoardClick(scan.nextInt()-1, size-scan.nextInt(), scan.nextInt()==1, size, bImage, file);
            // temp = -1;
            // while (temp != 0) {
            //     temp = board.spreadAwareness(size);
            // };
            // board.drawBoard(bImage, size);
            // fs.updateImage(bImage, file);
        }
    }
}