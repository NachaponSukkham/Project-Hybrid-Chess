
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import move_piece.Piece;
import move_piece.Pawn;
import move_piece.Rook;
import move_piece.Knight;
import move_piece.Bishop;
import move_piece.Queen;
import move_piece.King;

public class GameSave {

    private static final String SAVE_FILE = "chess_save.csv";

    // Save the game
    public static void saveGame(
            ArrayList<Piece> pieces,
            int currentColor) {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(SAVE_FILE))) {

            writer.write("TURN," + currentColor);
            writer.newLine();

            writer.write("TYPE,COLOR,COL,ROW,MOVED,TWO_STEPPED");
            writer.newLine();

            for (Piece piece : pieces) {
                writer.write(
                    piece.type + ","
                    + piece.color + ","
                    + piece.col + ","
                    + piece.row + ","
                    + piece.moved + ","
                    + piece.twoStepped
                );
                writer.newLine();
            }

            System.out.println("Game saved successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load the game
    public static boolean loadGame(GamePanel panel) {

        File file = new File(SAVE_FILE);

        if (!file.exists()) {
            System.out.println("No saved game found.");
            return false;
        }

        ArrayList<Piece> loadedPieces = new ArrayList<>();
        int loadedColor = GamePanel.WHITE;

        try (BufferedReader reader =
                new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if (data.length == 2
                        && data[0].equals("TURN")) {

                    loadedColor = Integer.parseInt(data[1]);
                    continue;
                }

                if (data.length != 6
                        || data[0].equals("TYPE")) {
                    continue;
                }

                String type = data[0];
                int color = Integer.parseInt(data[1]);
                int col = Integer.parseInt(data[2]);
                int row = Integer.parseInt(data[3]);
                boolean moved = Boolean.parseBoolean(data[4]);
                boolean twoStepped =
                        Boolean.parseBoolean(data[5]);

                Piece piece = createPiece(type, color, col, row);

                if (piece == null) {
                    throw new IOException(
                        "Unknown piece type: " + type
                    );
                }

                piece.moved = moved;
                piece.twoStepped = twoStepped;

                piece.x = piece.getX(col);
                piece.y = piece.getY(row);
                piece.preCol = col;
                piece.preRow = row;

                loadedPieces.add(piece);
            }

            if (loadedPieces.isEmpty()) {
                System.out.println("Save file contains no pieces.");
                return false;
            }

            // Replace the current board
            GamePanel.pieces.clear();
            GamePanel.pieces.addAll(loadedPieces);

            GamePanel.simPieces.clear();
            GamePanel.simPieces.addAll(loadedPieces);

            panel.currentColor = loadedColor;
            panel.activeP = null;
            panel.checkingP = null;
            GamePanel.castlingP = null;

            panel.canMove = false;
            panel.validSquare = false;
            panel.promotion = false;
            panel.gameover = false;
            panel.stalemate = false;

            panel.repaint();

            System.out.println("Game loaded successfully!");
            return true;

        } catch (IOException | NumberFormatException e) {
            System.out.println("Cannot load game: " + e.getMessage());
            return false;
        }
    }

    // Create the correct piece
    private static Piece createPiece(
            String type, int color, int col, int row) {

        switch (type) {
            case "PAWN":
                return new Pawn(color, col, row);

            case "ROOK":
                return new Rook(color, col, row);

            case "KNIGHT":
                return new Knight(color, col, row);

            case "BISHOP":
                return new Bishop(color, col, row);

            case "QUEEN":
                return new Queen(color, col, row);

            case "KING":
                return new King(color, col, row);

            default:
                return null;
        }
    }
}
