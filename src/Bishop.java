public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > -1 && toLine < 8 && toColumn > -1 && toColumn < 8 && line != toLine) {
            if (Math.abs(toLine - line) == Math.abs(toColumn - column)) {
                if ((chessBoard.board[toLine][toColumn] == null) || (chessBoard.board[toLine][toColumn] != null && !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor()))) {
                    if (Math.abs(toLine - line) == 1) {
                        return true;
                    }
                    boolean figure = true;
                    for (int i = 1; i < Math.abs(toLine - line); i++) {
                        for (int j = 1; j < i; j++) {
                            int deltaLine = toLine - line;
                            int deltaColumn = toColumn - column;
                            if (deltaLine > 0 && deltaColumn < 0 && chessBoard.board[line + j][column + j] != null) {
                                figure = false;
                                break;
                            }
                            if (deltaLine < 0 && deltaColumn < 0 && chessBoard.board[line - j][column + j] != null) {
                                figure = false;
                                break;
                            }
                            if (deltaLine > 0 && deltaColumn > 0 && chessBoard.board[line + j][column - j] != null) {
                                figure = false;
                                break;
                            }
                            if (deltaLine < 0 && deltaColumn < 0 && chessBoard.board[line - j][column - j] != null) {
                                figure = false;
                                break;
                            }
                        }
                    }
                    return figure;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}