package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

    public Bishop(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString(){
        return "B";
    }

    private boolean canMove(Position position){
        ChessPiece p = (ChessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        int [][] directions = {
            {-1, -1},
            {-1,  1},
            { 1, -1},
            { 1,  1}
        };

        for (int[] dir : directions) {
            p.setValues(position.getRow() + dir[0], position.getColumn() + dir[1]);

            while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
                p.setValues(p.getRow() + dir[0], p.getColumn() + dir[1]);
            }

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        }
        return mat;
    }
}
