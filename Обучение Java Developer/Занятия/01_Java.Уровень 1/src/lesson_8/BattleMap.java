package lesson_8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BattleMap extends JPanel {

    private GameWindow gameWindow;
    private int fieldSize;
    private int dotsToWin;
    private int cellWidth;
    private int cellHeight;

    private boolean isInit;

    public BattleMap(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.WHITE);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                int cellX = e.getX() / cellWidth;
                int cellY = e.getY() / cellHeight;

                if(isInit && !Logic.isGameFinished) {
                    Logic.humanTurn(cellY, cellX);
                }
                repaint();
            }
        });
    }

    void startNewGame(int fieldSize,int dotsToWin){

        this.fieldSize = fieldSize;
        this.dotsToWin = dotsToWin;

        isInit = true;

        repaint();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!isInit) {
            return;
        }

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        cellWidth = panelWidth / fieldSize;
        cellHeight = panelHeight / fieldSize;

        g.setColor(Color.BLACK);
        ((Graphics2D)g).setStroke(new BasicStroke(2f));

        for (int i = 0; i < fieldSize; i++) {
            int y = i * cellHeight;
            g.drawLine(0, y, panelWidth, y);
        }

        for (int i = 0; i < fieldSize; i++) {
            int x = i * cellWidth;
            g.drawLine(x, 0, x, panelHeight);
        }

        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == Logic.DOT_X) {
                    drawX(g,j,i);
                } else if (Logic.map[i][j] == Logic.DOT_O) {
                    drawO(g,j,i);
                }
            }
        }

        drawWinLine(g, Logic.DOT_X);
        drawWinLine(g, Logic.DOT_O);

    }

    private void drawX (Graphics g, int x, int y) {
        g.setColor(Color.RED);
        ((Graphics2D) g).drawLine(x * cellWidth, y * cellHeight, (x+1) * cellWidth, (y+1) * cellHeight);
        ((Graphics2D) g).drawLine((x+1) * cellWidth, y * cellHeight, x * cellWidth, (y+1) * cellHeight);
    }

    private void drawO (Graphics g, int x, int y) {
        g.setColor(Color.GREEN);
        ((Graphics2D) g).drawOval(x * cellWidth , y * cellHeight , cellWidth, cellHeight);
    }

    private void drawWinLine (Graphics g, char symb) {

        g.setColor(Color.YELLOW);

        int counter;

        // Проверка по строкам

        for (int i = 0; i < fieldSize; i++) {
            counter = 0;
            for (int j = 0; j < fieldSize; j++) {
                if (Logic.map[i][j] == symb) counter++;
            }
            if (counter == dotsToWin) {
                for (int j = 0; j < fieldSize; j++) {
                    if (Logic.map[i][j] == symb) {
                        ((Graphics2D) g).drawRect(j * cellWidth , i * cellHeight , cellWidth, cellHeight);
                    }
                }
            }
        }

        // Проверка по столбцам

        for (int j = 0; j < fieldSize; j++) {
            counter = 0;
            for (int i = 0; i < fieldSize; i++) {
                if (Logic.map[i][j] == symb) counter++;
            }
            if (counter == dotsToWin) {
                for (int i = 0; i < fieldSize; i++) {
                    if (Logic.map[i][j] == symb) {
                        ((Graphics2D) g).drawRect(j * cellWidth , i * cellHeight , cellWidth, cellHeight);
                    };
                }
            }
        }

        // Проверка по диагоналям слева-направо
        counter = 0;
        for (int k = dotsToWin - fieldSize; k <= fieldSize - dotsToWin; k++) {
            for (int i = 0; i < fieldSize; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    if (i - j == k && Logic.map[i][j] == symb) counter++;
                }
            }
        }
        if (counter == dotsToWin) {
            for (int k = dotsToWin - fieldSize; k <= fieldSize - dotsToWin; k++) {
                for (int i = 0; i < fieldSize; i++) {
                    for (int j = 0; j < fieldSize; j++) {
                        if (i - j == k && Logic.map[i][j] == symb) {
                            ((Graphics2D) g).drawRect(j * cellWidth , i * cellHeight , cellWidth, cellHeight);
                        };
                    }
                }
            }
        }

        // Проверка по диагонали справо-налево
        counter = 0;
        for (int k = dotsToWin - fieldSize; k <= fieldSize - dotsToWin; k++) {
            for (int i = 0; i < fieldSize; i++) {
                for (int j = 0; j < fieldSize; j++) {
                    if (i - (fieldSize - 1 - j) == k && Logic.map[i][j] == symb) counter++;
                }
            }
        }
        if (counter == dotsToWin) {
            for (int k = dotsToWin - fieldSize; k <= fieldSize - dotsToWin; k++) {
                for (int i = 0; i < fieldSize; i++) {
                    for (int j = 0; j < fieldSize; j++) {
                        if (i - (fieldSize - 1 - j) == k && Logic.map[i][j] == symb) {
                            ((Graphics2D) g).drawRect(j * cellWidth , i * cellHeight , cellWidth, cellHeight);
                        }
                    }
                }
            }
        }
    }
}
