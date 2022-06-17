package org.example.panels;

import org.example.frames.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.util.Random;

/**
 * suprafata pe care va incepe desenatul
 * este reporezentata de o tabla alba peste care vor aparea diferite obiecte desenate
 */

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    BufferedImage image;
    Graphics2D offscreen;

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        createOffscreenImage();
        init(frame.configPanel.getRows(), frame.configPanel.getCols());

    }

    private void createOffscreenImage() {
        image = new BufferedImage(canvasWidth, canvasHeight, BufferedImage.TYPE_INT_ARGB);
        offscreen = image.createGraphics();
        offscreen.setColor(Color.WHITE); //fill the image with white
        offscreen.fillRect(0, 0, canvasWidth, canvasHeight);
    }

    final void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
    }

    @Override
    protected void paintComponent(Graphics graphics) {
//        Graphics2D g = (Graphics2D) graphics;
//        g.setColor(Color.WHITE);
//        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid();
        paintHorizontalSticks();
        paintVerticalSticks();

        graphics.drawImage(image, 0, 0, this);



        //paintStones(g);
    }

    private void paintGrid() {
        offscreen.setColor(Color.DARK_GRAY);
        offscreen.setStroke(new BasicStroke(1));
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(x1, y1, x2, y2);
        }
        //vertical lines TODO
        for (int col = 0; col < cols; col++){
            int x1 = padX;
            int y1 = padY + col * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            offscreen.drawLine(y1, x1, y2, x2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                offscreen.setColor(Color.LIGHT_GRAY);
                offscreen.setStroke(new BasicStroke(1));
                offscreen.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);

            }
        }


    }

    private void paintHorizontalSticks(){
        Random random = new Random();
        offscreen.setColor(Color.RED);
        offscreen.setStroke(new BasicStroke(3));
        for (int row = 0; row < rows; row++) {
            if (random.nextBoolean()){
                int x1 = padX;
                int y1 = padY + row * cellHeight;
                int x2 = x1 + cellWidth;
                int y2 = y1;
                for (int col = 0; col < cols - 1; col++)
                {


                    if (random.nextBoolean()){
                    offscreen.drawLine(x1, y1, x2, y2);


                }
                    x1 = x1 + cellWidth;
                    x2 = x1 + cellWidth;

                }

            }

        }

    }

    private void paintVerticalSticks(){
        Random random = new Random();
        offscreen.setColor(Color.RED);
        offscreen.setStroke(new BasicStroke(3));
        for (int row = 0; row < rows; row++) {
            if (random.nextBoolean()){
                int x1 = padX;
                int y1 = padY + row * cellHeight;
                int x2 = x1 + cellWidth;
                int y2 = y1;
                for (int col = 0; col < cols - 1; col++)
                {


                    if (random.nextBoolean()){
                        offscreen.drawLine(y1, x1, y2, x2);


                    }
                    x1 = x1 + cellWidth;
                    x2 = x1 + cellWidth;

                }

            }

        }

    }

    @Override
    public void update(Graphics g) { } //No need for update

    //Draw the offscreen image, using the original graphics

    public int getRows() {
        return rows;
    }
}