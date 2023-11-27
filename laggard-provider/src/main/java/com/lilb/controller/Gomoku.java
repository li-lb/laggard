package com.lilb.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Gomoku extends JPanel {
    private static final long serialVersionUID = 1L;
    private static final int BOARD_SIZE = 500;
    private static final int CELL_SIZE = BOARD_SIZE / 15;
    private static final Color BLACK = Color.BLACK;
    private static final Color WHITE = Color.WHITE;
    private static final int WIN_COUNT = 5;

    private List<Point> blackList = new ArrayList<>();
    private List<Point> whiteList = new ArrayList<>();
    private boolean isBlackTurn = true;

    public void drawBoard(Graphics g) {
        g.setColor(BLACK);
        for (int i = 0; i < 15; i++) {
            g.drawLine(CELL_SIZE, i * CELL_SIZE + CELL_SIZE, BOARD_SIZE - CELL_SIZE, i * CELL_SIZE + CELL_SIZE);
            g.drawLine(i * CELL_SIZE + CELL_SIZE, CELL_SIZE, i * CELL_SIZE + CELL_SIZE, BOARD_SIZE - CELL_SIZE);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(WHITE);
        drawBoard(g);
        drawPieces(g);
    }

    public void drawPieces(Graphics g) {
        for (Point p : blackList) {
            g.setColor(BLACK);
            g.fillOval(p.x - CELL_SIZE / 2, p.y - CELL_SIZE / 2, CELL_SIZE, CELL_SIZE);
        }
        for (Point p : whiteList) {
            g.setColor(WHITE);
            g.fillOval(p.x - CELL_SIZE / 2, p.y - CELL_SIZE / 2, CELL_SIZE, CELL_SIZE);
        }
    }

    public boolean hasWon(List<Point> list) {
        for (Point p : list) {
            int x = p.x;
            int y = p.y;
            if (checkWin(x, y, 1, 0, list) || checkWin(x, y, 0, 1, list) || checkWin(x, y, 1, 1, list) || checkWin(x, y, 1, -1, list)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWin(int x, int y, int dx, int dy, List<Point> list) {
        int count = 1;
        for (int i = 1; i < WIN_COUNT; i++) {
            Point p = new Point(x + i * dx, y + i * dy);
            if (list.contains(p)) {
                count++;
            } else {
                break;
            }
        }
        for (int i = 1; i < WIN_COUNT; i++) {
            Point p = new Point(x - i * dx, y - i * dy);
            if (list.contains(p)) {
                count++;
            } else {
                break;
            }
        }
        return count >= WIN_COUNT;
    }

    public void addPiece(int x, int y) {
        if (isBlackTurn) {
            blackList.add(new Point(x, y));
            if (hasWon(blackList)) {
                JOptionPane.showMessageDialog(this, "黑方胜利！");
                restart();
            }
        } else {
            whiteList.add(new Point(x, y));
            if (hasWon(whiteList)) {
                JOptionPane.showMessageDialog(this, "白方胜利！");
                restart();
            }
        }
        isBlackTurn = !isBlackTurn;
        repaint();
    }

    public void restart() {
        blackList.clear();
        whiteList.clear();
        isBlackTurn = true;
        repaint();
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("五子棋");
        Gomoku game = new Gomoku();
        game.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = (e.getX() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
                int y = (e.getY() / CELL_SIZE) * CELL_SIZE + CELL_SIZE / 2;
                game.addPiece(x, y);
            }
        });
        window.setContentPane(game);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(BOARD_SIZE, BOARD_SIZE);
        window.setVisible(true);
    }
}