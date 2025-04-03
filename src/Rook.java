public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {

        if (toLine > -1 && toLine < 8 && toColumn > -1 && toColumn < 8) {return false;}

        boolean notStayingFigure = true;

        if (chessBoard.board[toLine][toColumn] == null || !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            if (toLine == line && toColumn != column) {

                if (Math.abs(toColumn - column) == 1) {return true;}

                for (int i = 1; i < Math.abs(toColumn - column); i++) {
                    for (int j = 1; j < i; j++) {

                        int deltaColumn = toColumn - column;

                        if (deltaColumn < 0 && chessBoard.board[line][column - j] != null) {
                            notStayingFigure = false;
                            break;
                        }

                        if (deltaColumn > 0 && chessBoard.board[line][column + j] != null) {
                            notStayingFigure = false;
                            break;
                        }
                    }
                }
                return notStayingFigure;
            }
            if (toLine != line && toColumn == column) {

                if (Math.abs(toLine - line) == 1) {return true;}

                for (int i = 1; i < Math.abs(toLine - line); i++) {
                    for (int j = 1; j < i; j++) {

                        int deltaLine = toLine - line;

                        if (deltaLine < 0 && chessBoard.board[line - j][column] != null) {
                            notStayingFigure = false;
                            break;
                        }

                        if (deltaLine > 0 && chessBoard.board[line + j][column] != null) {
                            notStayingFigure = false;
                            break;
                        }
                    }
                }
                return notStayingFigure;
            }
            return false;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}