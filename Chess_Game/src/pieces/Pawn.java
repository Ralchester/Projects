package pieces;

import Main.board;

import java.awt.image.BufferedImage;

public class Pawn extends Piece{

    public Pawn(board Board, int col, int row, boolean isWhite) {
        super(Board);
        this.col = col;
        this.row = row;
        this.xPos = col * Board.tileSize;
        this.yPos = row * Board.tileSize;
        
        this.isWhite = isWhite;
        this.name = "Pawn";

        this.sprite = sheet.getSubimage(5 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(Board.tileSize, Board.tileSize, BufferedImage.SCALE_SMOOTH);


    }
    public boolean isValidMovement (int col, int row) {

        int colorIndex = isWhite ? 1 : -1;

        // push pawn 1
        if(this.col == col && row == this.row - colorIndex && Board.getPiece(col, row) == null)
            return true;

        // push pawn 2
        if(isFirstMove && this.col == col && row == this.row - colorIndex * 2 && Board.getPiece(col, row) == null && Board.getPiece(col, row + colorIndex) == null)
            return true;

        // capture to the left
        if(col == this.col - 1 && row == this.row - colorIndex && Board.getPiece(col, row) != null )
            return true;

        // capture to the right
        if(col == this.col + 1 && row == this.row - colorIndex && Board.getPiece(col, row) != null )
            return true;

        //en passant left
        if (Board.getTileNum(col, row) == Board.enPassantTile && col == this.col - 1 && row == this.row - colorIndex && Board.getPiece(col, row +colorIndex) != null)
            return true;

        //en passant right
        if (Board.getTileNum(col, row) == Board.enPassantTile && col == this.col + 1 && row == this.row - colorIndex && Board.getPiece(col, row +colorIndex) != null)
            return true;

        return false;

    }

}
