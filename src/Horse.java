public class Horse extends ChessPiece{
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine > -1 && toLine < 8 && toColumn > -1 && toColumn < 8) {return false;}

        if (chessBoard.board[toLine][toColumn] == null || chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return ((Math.abs(toLine - line) == 2) && (Math.abs(toColumn - column) == 1)) || ((Math.abs(toLine - line) == 1) && (Math.abs(toColumn - column) == 2));
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
