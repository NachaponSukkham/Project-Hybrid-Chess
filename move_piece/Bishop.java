package move_piece;

import main.GamePanel;

public class Bishop extends Piece {

    public Bishop(int color, int col, int row) {
        super(color, col, row);

        if (color == GamePanel.WHITE) {
            image = getImage("/pieces/chess_piece_images_one/w-Bishop");
        }
        else {
            image = getImage("/pieces/chess_piece_images_one/b-Bishop");
        }
    }
}