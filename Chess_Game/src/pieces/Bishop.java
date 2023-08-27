package pieces;

import Main.board;

import java.awt.image.BufferedImage;

public class Bishop extends Piece{

    public Bishop(board Board, int col, int row, boolean isWhite) {
        super(Board);
        this.col = col;
        this.row = row;
        this.xPos = col * Board.tileSize;
        this.yPos = row * Board.tileSize;
        
        this.isWhite = isWhite;
        this.name = "Bishop";

        this.sprite = sheet.getSubimage(2 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH);


    }

    public boolean isValidMovement (int col, int row) {
        return Math.abs(this.col - col) == Math.abs(this.row - row);
    }

    public boolean moveCollidesWithPiece(int col, int row) {

        //upper left
        if (this.col > col && this.row > row)
            for(int i = 1; i < Math.abs(this.col - col); i++)
                if (Board.getPiece(this.col - i, this.row - i) != null)
                    return true;

        //upper right
        if (this.col < col && this.row > row)
            for(int i = 1; i < Math.abs(this.col - col); i++)
                if (Board.getPiece(this.col + i, this.row - i) != null)
                    return true;

        //bottom left
        if (this.col > col && this.row < row)
            for(int i = 1; i < Math.abs(this.col - col); i++)
                if (Board.getPiece(this.col - i, this.row + i) != null)
                    return true;

        //bottom right
        if (this.col < col && this.row < row)
            for(int i = 1; i < Math.abs(this.col - col); i++)
                if (Board.getPiece(this.col + i, this.row + i) != null)
                    return true;

        return false;
    }
}
