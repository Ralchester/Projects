package pieces;

import Main.board;

import java.awt.image.BufferedImage;

public class Knight extends Piece{

    public Knight(board Board, int col, int row, boolean isWhite) {
        super(Board);
        this.col = col;
        this.row = row;
        this.xPos = col * Board.tileSize;
        this.yPos = row * Board.tileSize;
        
        this.isWhite = isWhite;
        this.name = "Knight";

        this.sprite = sheet.getSubimage(3 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH);


    }

    public boolean isValidMovement (int col, int row) {
        return Math.abs(col - this.col) * Math.abs(row - this.row) == 2;

    }
}
