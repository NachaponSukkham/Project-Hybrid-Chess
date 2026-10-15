package move_piece;

import main.GamePanel;

public class Pawn extends Piece {

    public Pawn(int color, int col, int row) {
        super(color, col, row);

        if (color == GamePanel.WHITE) {
            image = getImage("/pieces/chess_piece_images_one/w-pawn");
        }
        else {
            image = getImage("/pieces/chess_piece_images_one/b-pawn");
        }
    }
    
    public boolean canMove(int targetCol, int targetRow) {

        //Difine the move value based on its color
        int moveValue;
        if (color == GamePanel.WHITE) {
            moveValue = -1;
        }
        else {
            moveValue = 1;
        }

        if (isWithinBoard(targetCol, targetRow)
                && isSameSquare(targetCol, targetRow) == false) {

            // Check the hitting piece
            hittingP = getHittingP(targetCol, targetRow);

            // 1 square movement
            if (targetCol == preCol
                    && targetRow == preRow + moveValue
                    && hittingP == null) {
                return true;
            }

            // 2 squares movement
            if (targetCol == preCol
                    && targetRow == preRow + moveValue * 2
                    && hittingP == null
                    && moved == false
                    && pieceIsOnStraightLine(targetCol, targetRow) == false) {
                return true;
            }

            // Diagonal movement & capture
            if (Math.abs(targetCol - preCol) == 1
                    && targetRow == preRow + moveValue
                    && hittingP != null
                    && hittingP.color != color) {
                return true;
            }
        }

        return false;
    }
}