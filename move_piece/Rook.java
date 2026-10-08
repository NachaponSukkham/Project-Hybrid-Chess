package move_piece;

import main.GamePanel;

public class Rook extends Piece {

    public Rook(int color, int col, int row) {
        super(color, col, row);

        if (color == GamePanel.WHITE) {
            image = getImage("/pieces/chess_piece_images_one/w-rook");
        }
        else {
            image = getImage("/pieces/chess_piece_images_one/b-rook");
        }
    }
}