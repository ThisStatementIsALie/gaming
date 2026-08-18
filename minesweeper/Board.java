import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.ThreadLocalRandom;

public class Board {
    public int intBoard[][]; // 9 is secret, 10 is mine, 11 is flag
    public boolean boolBoard[][];
    public boolean flagBoard[][];
    public int minesLeft;

    /**
     * Generates board
     * @param mineCount Amount of mines to spawn on the board
     * @param boardSize Assumes an equal length an width of the board
     * @param x Where on the X axis the initial click was
     * @param y Where on the Y axis the initial click was
     */
    public void GenerateBoard(int mineCount, int boardSize, int x, int y) {
        System.out.println("Generating "+boardSize+" x "+boardSize+"Board with "+mineCount+" mines...");
        intBoard = new int[boardSize][boardSize];
        boolBoard = new boolean[boardSize][boardSize];
        flagBoard = new boolean[boardSize][boardSize];

        if (ThreadLocalRandom.current().nextInt(0, 101) == 0) {
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    intBoard[i][j] = 10;
                }
            }
            intBoard[x][y] = 9;
            return;
        }
        
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                boolBoard[i][j] = false;
                flagBoard[i][j] = false;
            }
        }
        boolBoard[y][x] = true;

        int randX, randY;
        for (int minesLeft = mineCount; minesLeft > 0; minesLeft+=0) {
            randX = ThreadLocalRandom.current().nextInt(0, boardSize);
            randY = ThreadLocalRandom.current().nextInt(0, boardSize);
            if (intBoard[randY][randX] != 10 && !isAdjacent(x, y, randX, randY)) {
                intBoard[randY][randX] = 10;
                minesLeft--;
            }
            FunkyStuff.clearTerminal();
            System.out.println("Generating "+boardSize+" x "+boardSize+" board with "+mineCount+" mines...");
            System.out.println("MINES LEFT: " + minesLeft);
        }
    }

    public void GenerateNums(int size) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (intBoard[y][x] != 10) {
                    intBoard[y][x] = amountAdjacent(x, y, size);
                }
            }
        }
    }

    /**
     * Updates revealed spaces on board given mouse click
     * @param x X-coordinate of where to check
     * @param y Y-coordinate of where to check]
     * @param dig True is dig, False is flag
     */
    public void BoardClick(int x, int y, boolean dig, int size, BufferedImage bim, File fil) {
        if (intBoard[y][x] == 10 && dig && !flagBoard[y][x]) {
            failCondition(size, bim, fil);
            return;
        }
        if (dig) {
            boolBoard[y][x] = true;
            flagBoard[y][x] = false;
        } else {
            if (!boolBoard[y][x] && !flagBoard[y][x]) {
                flagBoard[y][x] = true;
            } else if (flagBoard[y][x]) {
                flagBoard[y][x] = false;
            }
        }
    }

    /**
     * Makes a Bufferedimage of board state
     * @param bIm BufferedImage to update
     * @param board Current board
     * @param size Board size
     */
    public void drawBoard(BufferedImage bIm, int size) {
        for (int y = 0; y < 10*size+1; y++) {
            for (int x = 0; x < 10*size+1; x++) {
                if (y%10 == 0 || x%10 == 0) {
                    bIm.setRGB(x, y, Color.black.getRGB());
                } else if (((y+1)%10 == 0) || ((y-1)%10 == 0) || ((x+1)%10 == 0) || ((x-1)%10 == 0)) {
                    bIm.setRGB(x, y, Art.zero.getRGB());
                } else {
                    if (boolBoard[(y-y%10)/10][(x-x%10)/10]) {
                        bIm.setRGB(x, y, numToArt(x, y).getRGB());
                    } else if (flagBoard[(y-y%10)/10][(x-x%10)/10]){
                        bIm.setRGB(x, y, numToArt(x, y).getRGB());
                    } else {
                        bIm.setRGB(x, y, Art.blank.getRGB());
                    }
                }
            }
        }
    }

    // Don't stare at it for too long.
    public int spreadAwareness(int size) {
        int amountAdded = 0;
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (!boolBoard[y][x]) {
                    for (int x2 = -1; x2 < 2; x2++) {
                        for (int y2 = -1; y2 < 2; y2++) {
                            if (x+x2 >= 0 && x+x2 < size && y+y2 >= 0 && y+y2 < size) {
                                if (intBoard[y+y2][x+x2] == 0 && boolBoard[y+y2][x+x2]) {
                                    boolBoard[y][x] = true;
                                    amountAdded++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return amountAdded;
        
    }

    private void failCondition(int size, BufferedImage bim, File fil) {
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                boolBoard[y][x] = true;
            }
        }
        FunkyStuff.clearTerminal();
        System.out.println("YOU LOSE");
        drawBoard(bim, size);
        new FunkyStuff().updateImage(bim, fil);
        System.exit(0);
    }

    private Color numToArt(int x, int y) {
        int num = intBoard[(y-y%10)/10][(x-x%10)/10];
        int cx = x%10-2;
        int cy = y%10-2;
        if (flagBoard[(y-y%10)/10][(x-x%10)/10]) {
            return Art.flag[cy][cx];
        } else if (num == 0) {
            return Art.zero;
        } else if (num == 1) {
            return Art.one[cy][cx];
        } else if (num == 2) {
            return Art.two[cy][cx];
        } else if (num == 3) {
            return Art.three[cy][cx];
        } else if (num == 4) {
            return Art.four[cy][cx];
        } else if (num == 5) {
            return Art.five[cy][cx];
        } else if (num == 6) {
            return Art.six[cy][cx];
        } else if (num == 7) {
            return Art.seven[cy][cx];
        } else if (num == 8) {
            return Art.eight[cy][cx];
        } else if (num == 9) {
            return Art.nine[cy][cx];
        } else if (num == 10) {
            return Art.mine[cy][cx];
        } else {
            return Color.white; // Error
        }
    }

    private boolean isAdjacent(int x1, int y1, int x2, int y2) {
        return (Math.abs(x1-x2) < 2) && (Math.abs(y1-y2) < 2);
    }

    private int amountAdjacent(int initX, int initY, int size) {
        int count = 0;
        for (int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if (initX+x >= 0 && initX+x < size && initY+y >= 0 && initY+y < size) {
                    if (intBoard[initY+y][initX+x] == 10) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}