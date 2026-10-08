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
}