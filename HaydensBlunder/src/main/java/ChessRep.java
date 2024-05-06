// This class is used to represent a chess board.
// the chessboard is represented by a bitboard, which is a 64-bit integer

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChessRep {
    private long whitePieces;
    private long blackPieces;

    public ChessRep() {
        whitePieces = 0b0000000;
        blackPieces = 0b0000000;
    }

    public ChessRep(long whitePieces, long blackPieces) {
        this.whitePieces = whitePieces;
        this.blackPieces = blackPieces;
    }

    public ChessRep(ChessRep chessRep) {
        this.whitePieces = chessRep.getWhitePieces();
        this.blackPieces = chessRep.getBlackPieces();
    }

    public long getWhitePieces() {
        return whitePieces;
    }

    public long getBlackPieces() {
        return blackPieces;
    }

    public void setWhitePieces(long whitePieces) {
        this.whitePieces = whitePieces;
    }

    public void setBlackPieces(long blackPieces) {
        this.blackPieces = blackPieces;
    }

    public void setPieces(long whitePieces, long blackPieces) {
        this.whitePieces = whitePieces;
        this.blackPieces = blackPieces;
    }

    public void setPieces(ChessRep chessRep) {
        this.whitePieces = chessRep.getWhitePieces();
        this.blackPieces = chessRep.getBlackPieces();
    }

    public void addWhitePiece(long piece) {
        whitePieces |= piece;
    }

    public void addBlackPiece(long piece) {
        blackPieces |= piece;
    }

    public void removeWhitePiece(long piece) {
        whitePieces &= ~piece;
    }

    public void removeBlackPiece(long piece) {
        blackPieces &= ~piece;
    }

    public void removePiece(long piece) {
        whitePieces &= ~piece;
        blackPieces &= ~piece;
    }

    public void removePieces(long whitePieces, long blackPieces) {
        this.whitePieces &= ~whitePieces;
        this.blackPieces &= ~blackPieces;
    }

    public void removePieces(ChessRep chessRep) {
        this.whitePieces &= ~chessRep.getWhitePieces();
        this.blackPieces &= ~chessRep.getBlackPieces();
    }

    public void clear() {
        whitePieces = 0b0000000;
        blackPieces = 0b0000000;
    }
}