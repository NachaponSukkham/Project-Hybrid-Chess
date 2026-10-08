package move_piece;

import main.GamePanel;

public class Queen extends Piece {

    public Queen(int color, int col, int row) {
        super(color, col, row);

        if (color == GamePanel.WHITE) {
            image = getImage("/pieces/chess_piece_images_one/w-Queen");
        }
        else {
            image = getImage("/pieces/chess_piece_images_one/b-Queen");
        }
    }
}