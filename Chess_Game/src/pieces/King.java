package pieces;

import Main.board;

import java.awt.image.BufferedImage;

public class King extends Piece{

    public King(board Board, int col, int row, boolean isWhite) {
        super(Board);
        this.col = col;
        this.row = row;
        this.xPos = col * Board.tileSize;
        this.yPos = row * Board.tileSize;
        
        this.isWhite = isWhite;
        this.name = "King";

        this.sprite = sheet.getSubimage(0 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH);


    }
    public boolean isValidMovement (int col, int row) {
        return Math.abs((col - this.col) * (row - this.row)) == 1 || Math.abs(col - this.col) + Math.abs(row - this.row) == 1;
    }
}
