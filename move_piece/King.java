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
}