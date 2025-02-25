package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

    public Pawn(Board board, Color color){
        super(board, color);
    }

    @Override
    public String toString(){
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

        Position p = new Position(0,0);

        int direction = (getColor() == Color.WHITE) ? -1 : 1;
        int startRow = (getColor() == Color.WHITE) ? 6 : 1;

        p.setValues(position.getRow() + direction, position.getColumn());
        if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }


        p.setValues(position.getRow() + (2 * direction), position.getColumn());
        Position p2 = new Position(position.getRow() + direction, position.getColumn());
        if (getBoard().positionExists(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p) && !getBoard().thereIsAPiece(p2) && position.getRow() == startRow) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //
        p.setValues(position.getRow() + direction, position.getColumn() - 1);
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }


        p.setValues(position.getRow() + direction, position.getColumn() + 1);
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat[p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
