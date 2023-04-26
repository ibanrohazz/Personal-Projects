using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace ChessBoardModel
{
    public class Board
    {
        // the size of the board
        public int Size { get; set; }
        public Cell[,] theGrid { get; set; }

        /** Constructor
         * @param s the size of the board
         */
        public Board(int s)
        {
            Size = s;
            theGrid = new Cell[Size, Size];
            // populate the grid with new cells
            for (int r = 0; r < Size; r++)
            {
                for (int c = 0; c < Size; c++)
                {
                    theGrid[r, c] = new Cell(r, c);
                }
            }
        }

        public void MarkNextLegalMoves(Cell currentCell, string chessPiece)
        {
            // clear all previous legal moves
            ResetCells();
            switch (chessPiece)
            {
                case "Knight":
                    MarkKnightMoves(currentCell);
                    break;
                case "King":
                    MarkKingMoves(currentCell);
                    break;
                case "Rook":
                    MarkRookMoves(currentCell);
                    break;
                case "Bishop":
                    MarkBishopMoves(currentCell);
                    break;
                case "Queen":
                    MarkQueenMoves(currentCell);
                    break;
                default:
                    break;
            }
        }
        private void ResetCells()
        {
            // clear all previous legal moves
            foreach (Cell c in theGrid)
            {
                c.LegalNextMove = false;
            }
        }

        private void MarkKnightMoves( Cell cell )
        {
            // check each possible move for the knight
            // 2 up 1 right
            if (cell.RowNumber - 2 >= 0 && cell.ColumnNumber + 1 < Size)
            {
                theGrid[cell.RowNumber - 2, cell.ColumnNumber + 1].LegalNextMove = true;
            }
            // 2 up 1 left
            if (cell.RowNumber - 2 >= 0 && cell.ColumnNumber - 1 >= 0)
            {
                theGrid[cell.RowNumber - 2, cell.ColumnNumber - 1].LegalNextMove = true;
            }
            // 2 down 1 right
            if (cell.RowNumber + 2 < Size && cell.ColumnNumber + 1 < Size)
            {
                theGrid[cell.RowNumber + 2, cell.ColumnNumber + 1].LegalNextMove = true;
            }
            // 2 down 1 left
            if (cell.RowNumber + 2 < Size && cell.ColumnNumber - 1 >= 0)
            {
                theGrid[cell.RowNumber + 2, cell.ColumnNumber - 1].LegalNextMove = true;
            }
            // 1 up 2 right
            if (cell.RowNumber - 1 >= 0 && cell.ColumnNumber + 2 < Size)
            {
                theGrid[cell.RowNumber - 1, cell.ColumnNumber + 2].LegalNextMove = true;
            }
            // 1 up 2 left
            if (cell.RowNumber - 1 >= 0 && cell.ColumnNumber - 2 >= 0)
            {
                theGrid[cell.RowNumber - 1, cell.ColumnNumber - 2].LegalNextMove = true;
            }
            // 1 down 2 right
            if (cell.RowNumber + 1 < Size && cell.ColumnNumber + 2 < Size)
            {
                theGrid[cell.RowNumber + 1, cell.ColumnNumber + 2].LegalNextMove = true;
            }
            // 1 down 2 left
            if (cell.RowNumber + 1 < Size && cell.ColumnNumber - 2 >= 0)
            {
                theGrid[cell.RowNumber + 1, cell.ColumnNumber - 2].LegalNextMove = true;
            }
        }

        private void MarkKingMoves( Cell cell )
        {
            // check each possible move for the king
            // up
            if (cell.RowNumber - 1 >= 0)
            {
                theGrid[cell.RowNumber - 1, cell.ColumnNumber].LegalNextMove = true;
            }
            // down
            if (cell.RowNumber + 1 < Size)
            {
                theGrid[cell.RowNumber + 1, cell.ColumnNumber].LegalNextMove = true;
            }
            // left
            if (cell.ColumnNumber - 1 >= 0)
            {
                theGrid[cell.RowNumber, cell.ColumnNumber - 1].LegalNextMove = true;
            }
            // right
            if (cell.ColumnNumber + 1 < Size)
            {
                theGrid[cell.RowNumber, cell.ColumnNumber + 1].LegalNextMove = true;
            }
            // up left
            if (cell.RowNumber - 1 >= 0 && cell.ColumnNumber - 1 >= 0)
            {
                theGrid[cell.RowNumber - 1, cell.ColumnNumber - 1].LegalNextMove = true;
            }
            // up right
            if (cell.RowNumber - 1 >= 0 && cell.ColumnNumber + 1 < Size)
            {
                theGrid[cell.RowNumber - 1, cell.ColumnNumber + 1].LegalNextMove = true;
            }
            // down left
            if (cell.RowNumber + 1 < Size && cell.ColumnNumber - 1 >= 0)
            {
                theGrid[cell.RowNumber + 1, cell.ColumnNumber - 1].LegalNextMove = true;
            }
            // down right
            if (cell.RowNumber + 1 < Size && cell.ColumnNumber + 1 < Size)
            {
                theGrid[cell.RowNumber + 1, cell.ColumnNumber + 1].LegalNextMove = true;
            }
        }

        private void MarkRookMoves( Cell cell )
        {
            // check each possible move for the rook
            // up
            for (int r = cell.RowNumber - 1; r >= 0; r--)
            {
                if (theGrid[r, cell.ColumnNumber].CurrentlyOccupied == false)
                {
                    theGrid[r, cell.ColumnNumber].LegalNextMove = true;
                }
                else
                {
                    break;
                }
            }
            // down
            for (int r = cell.RowNumber + 1; r < Size; r++)
            {
                if (theGrid[r, cell.ColumnNumber].CurrentlyOccupied == false)
                {
                    theGrid[r, cell.ColumnNumber].LegalNextMove = true;
                }
                else
                {
                    break;
                }
            }
            // left
            for (int c = cell.ColumnNumber - 1; c >= 0; c--)
            {
                if (theGrid[cell.RowNumber, c].CurrentlyOccupied == false)
                {
                    theGrid[cell.RowNumber, c].LegalNextMove = true;
                }
                else
                {
                    break;
                }
            }
            // right
            for (int c = cell.ColumnNumber + 1; c < Size; c++)
            {
                if (theGrid[cell.RowNumber, c].CurrentlyOccupied == false)
                {
                    theGrid[cell.RowNumber, c].LegalNextMove = true;
                }
                else
                {
                    break;
                }
            }
        }

        private void MarkBishopMoves( Cell cell )
        {
            // check each possible move for the bishop
            // up left
            for (int r = cell.RowNumber - 1, c = cell.ColumnNumber - 1; r >= 0 && c >= 0; r--, c--)
            {
                if (theGrid[r, c].CurrentlyOccupied == false)
                {
                    theGrid[r, c].LegalNextMove = true;
                }
                else
                {
                    break;
                }
            }
            // up right
            for (int r = cell.RowNumber - 1, c = cell.ColumnNumber + 1; r >= 0 && c < Size; r--, c++)
            {
                if (theGrid[r, c].CurrentlyOccupied == false)
                {
                    theGrid[r, c].LegalNextMove = true;
                }
                else
                {
                    break;
                }
            }
            // down left
            for (int r = cell.RowNumber + 1, c = cell.ColumnNumber - 1; r < Size && c >= 0; r++, c--)
            {
                if (theGrid[r, c].CurrentlyOccupied == false)
                {
                    theGrid[r, c].LegalNextMove = true;
                }
                else
                {
                    break;
                }
            }
            // down right
            for (int r = cell.RowNumber + 1, c = cell.ColumnNumber + 1; r < Size && c < Size; r++, c++)
            {
                if (theGrid[r, c].CurrentlyOccupied == false)
                {
                    theGrid[r, c].LegalNextMove = true;
                }
                else
                {
                    break;
                }
            }
        }

        private void MarkQueenMoves( Cell cell )
        {
            // check the diagonal moves
            MarkBishopMoves(cell);
            // check the straight moves
            MarkRookMoves(cell);
        }
    }
}
