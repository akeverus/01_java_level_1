package lesson_8;

import javax.swing.*;
import java.awt.*;

public class Setting extends JFrame{

    private final int MIN_FIELD_SIZE = 3;
    private final int MAX_FIELD_SIZE = 10;

    private GameWindow gameWindow;

    private JSlider slFieldSize;
    private JSlider slDotsToWin;

    public Setting(GameWindow gameWindow) {

        this.gameWindow = gameWindow;

        setBounds (550,550,450,450);
        setTitle ("TicTacToe setting");

        setLayout(new GridLayout(5,1));
        slFieldSize = new JSlider(MIN_FIELD_SIZE, MAX_FIELD_SIZE, MIN_FIELD_SIZE);
        slFieldSize.setMajorTickSpacing(1);
        slFieldSize.setPaintTicks(true);
        slFieldSize.setPaintLabels(true);
        slDotsToWin = new JSlider(MIN_FIELD_SIZE, MIN_FIELD_SIZE, MIN_FIELD_SIZE);
        slDotsToWin.setMajorTickSpacing(1);
        slDotsToWin.setPaintTicks(true);
        slDotsToWin.setPaintLabels(true);

        slFieldSize.addChangeListener(e -> slDotsToWin.setMaximum(slFieldSize.getValue()));

        setLayout(new GridLayout(5,1));
        add(new Label("Field Size:"));
        add(slFieldSize);
        add(new Label("Winning Line:"));
        add(slDotsToWin);

        JButton button = new JButton("Start a New Game");
        add(button);

        button.addActionListener(e -> {

            int fieldSize = slFieldSize.getValue();
            int dotsToWin = slDotsToWin.getValue();

            Logic.SIZE = fieldSize;
            Logic.DOTS_TO_WIN = dotsToWin;
            Logic.initMap();
            Logic.printMap();
            Logic.isGameFinished = false;

            gameWindow.startNewGame(fieldSize, dotsToWin);

            setVisible(false);
        });

        setVisible(false);

    }

}
