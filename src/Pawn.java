public class Pawn extends ChessPiece{
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > -1 && toLine < 8 && toColumn > -1 && toColumn < 8) {
            if (chessBoard.board[toLine][toColumn] == null && toColumn == column) {
                if (check) {
                    if (this.getColor().equals("White")) {
                        if (chessBoard.board[line + 1][column] != null) {
                            return false;
                        }
                        return (toLine - line == 1) || (toLine - line == 2);
                    } else {
                        if (chessBoard.board[line - 1][column] != null) {
                            return false;
                        }
                        return (toLine - line == -1) || (toLine - line == -2);
                    }
                } else {
                    if (this.getColor().equals("White")) {
                        return (toLine - line == 1);
                    } else {
                        return (toLine - line == -1);
                    }
                }
            }
            if (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
                if (this.getColor().equals("White")) {
                    return (toLine - line == 1) && (Math.abs(toColumn - column) == 1);
                } else {
                    return (toLine - line == -1) && (Math.abs(toColumn - column) == 1);
                }
            }
            return false;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}