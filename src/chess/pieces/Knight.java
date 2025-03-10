package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {

    public Knight(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        int[][] moves = {
                {-2, -1}, {-2, 1},
                {2, -1}, {2, 1},
                {-1, -2}, {-1, 2},
                {1, -2}, {1, 2}
        };

        for (int[] mov : moves) {
            p.setValues(position.getRow() + mov[0], position.getColumn() + mov[1]);

            if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }

        return mat;
    }
}
