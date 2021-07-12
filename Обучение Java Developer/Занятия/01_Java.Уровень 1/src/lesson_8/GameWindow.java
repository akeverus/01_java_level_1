package lesson_8;

import com.sun.deploy.panel.RuleSetViewerDialog;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private BattleMap battleMap;
    private Setting setting;

    public GameWindow() {
        setTitle("TicTacToe");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(500, 500, 500, 500);

        JPanel panel = new JPanel(new GridLayout(1,2));
        JButton buttonStart = new JButton("Start New Game");
        JButton buttonExit = new JButton("Exit");

        panel.add(buttonStart);
        panel.add(buttonExit);
        add(panel, BorderLayout.SOUTH);

        battleMap = new BattleMap(this);
        add(battleMap, BorderLayout.CENTER);
        setting = new Setting(this);

        buttonStart.addActionListener(e -> setting.setVisible(true));
        buttonExit.addActionListener(e -> System.exit(0));

        setVisible(true);
    }

    void startNewGame(int fieldSize,int dotsToWin){
        battleMap.startNewGame(fieldSize, dotsToWin);
    }

}

