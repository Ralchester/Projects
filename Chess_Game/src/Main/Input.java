package Main;

import pieces.Piece;

import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input extends MouseAdapter {

    board Board;
    public Input(board Board) {
        this.Board = Board;
    }

    @Override
    public void mousePressed(MouseEvent e) {

        int col = e.getX() / Board.tileSize;
        int row = e.getY() / Board.tileSize;

        Piece pieceXY = Board.getPiece(col, row);
        if (pieceXY != null) {
            Board.selectedPiece = pieceXY;

        }

    }
    @Override
    public void mouseDragged(MouseEvent e) {

        if(Board.selectedPiece != null) {
            Board.selectedPiece.xPos = e.getX() - Board.tileSize / 2;
            Board.selectedPiece.yPos = e.getY() - Board.tileSize / 2;

            Board.repaint();
        }

    }



    @Override
    public void mouseReleased(MouseEvent e) {


        int col = e.getX() / Board.tileSize;
        int row = e.getY() / Board.tileSize;

        if (Board.selectedPiece != null) {
            Move move = new Move(Board, Board.selectedPiece, col, row);

            if (Board.isValidMove(move)) {
                Board.makeMove(move);
            } else {
                Board.selectedPiece.xPos = Board.selectedPiece.col * Board.tileSize;
                Board.selectedPiece.yPos = Board.selectedPiece.row * Board.tileSize;
            }
        }

        Board.selectedPiece = null;
        Board.repaint();

    }



}
