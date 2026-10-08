package move_piece;

import main.GamePanel;

public class Knight extends Piece {

    public Knight(int color, int col, int row) {
        super(color, col, row);

        if (color == GamePanel.WHITE) {
            image = getImage("/pieces/chess_piece_images_one/w-Knight");
        }
        else {
            image = getImage("/pieces/chess_piece_images_one/b-Knight");
        }
    }
}