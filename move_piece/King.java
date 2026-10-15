package move_piece;

import main.GamePanel;

public class King extends Piece {

    public King(int color, int col, int row) {
        super(color, col, row);

        if (color == GamePanel.WHITE) {
            image = getImage("/pieces/chess_piece_images_one/w-king");
        }
        else {
            image = getImage("/pieces/chess_piece_images_one/b-king");
        }
    }

    public  boolean canMove(int targetCol, int targetRow) {

        if (isWithinBoard(targetCol, targetRow)) {
            
            //MOVEMENT
            if(Math.abs(targetCol - preCol) + Math.abs(targetRow - preRow) == 1 ||
                    Math.abs(targetCol - preCol) * Math.abs(targetRow - preRow) == 1) {
                
                if(isValidSquare(targetCol,targetRow)) {
                        return true;
                }
            }

            // CASTLING
            if (moved == false && targetRow == preRow) {

                // Right castling
                if (targetCol == preCol + 2) {
                    boolean pieceBetween = false;
                    Piece rook = null;

                    for (Piece piece : GamePanel.simPieces) {
                        if (piece != this && piece.row == preRow) {

                            if (piece.col == preCol + 1
                                    || piece.col == preCol + 2) {
                                pieceBetween = true;
                            }

                            if (piece.col == preCol + 3
                                    && piece.color == color
                                    && piece instanceof Rook) {
                                rook = piece;
                            }
                        }
                    }

                    if (!pieceBetween && rook != null
                            && !rook.moved) {
                        GamePanel.castlingP = rook;
                        return true;
                    }
                }

                // Left castling
                if (targetCol == preCol - 2) {
                    boolean pieceBetween = false;
                    Piece rook = null;

                    for (Piece piece : GamePanel.simPieces) {
                        if (piece != this && piece.row == preRow) {

                            if (piece.col == preCol - 1
                                    || piece.col == preCol - 2
                                    || piece.col == preCol - 3) {
                                pieceBetween = true;
                            }

                            if (piece.col == preCol - 4
                                    && piece.color == color
                                    && piece instanceof Rook) {
                                rook = piece;
                            }
                        }
                    }

                    if (!pieceBetween && rook != null
                            && !rook.moved) {
                        GamePanel.castlingP = rook;
                        return true;
                    }
                }
            }
        }

        return false;
    }
}