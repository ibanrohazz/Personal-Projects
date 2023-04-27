using ChessBoardModel;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Chess
{
    class Program
    {
        static Board myBoard = new Board(8);
        static void Main(String[] args )
        {
            // show the empty chess board
            printBoard( myBoard );

            // ask the user for x and y coordinates for the piece
            Cell cell = setCurrentCell();
            cell.CurrentlyOccupied = true;

            // ask the user for the type of piece default is Knight
            string piece = "Knight";
            try
            {
                Console.WriteLine("Enter the type of piece \n Knight | Bishop | Rook | King | Queen");
                piece = Console.ReadLine();
            } catch (Exception e)
            {
                Console.WriteLine("Invalid input");
            }

            // calculate all the legal moves for that piece
            myBoard.MarkNextLegalMoves( cell, piece );

            // print the chess board with the legal moves marked, X is the piece, + is a legal move, . is an empty cell
            printBoard( myBoard );

            // wait for the user to press a key before ending the program
            Console.ReadLine();
        }

        private static Cell setCurrentCell()
        {
            // ask the user for x and y coordinates for the piece and return the cell location
            try
            {
                Console.WriteLine("Enter the row number for the piece");
                int row = Convert.ToInt32(Console.ReadLine());
                Console.WriteLine("Enter the column number for the piece");
                int col = Convert.ToInt32(Console.ReadLine());

                myBoard.theGrid[row, col].CurrentlyOccupied = true;
                return myBoard.theGrid[row, col];
            }
            catch (Exception e)
            {
                Console.WriteLine("Invalid input");
                return setCurrentCell();
            }

        }

        private static void printBoard( Board myBoard )
        {
            // print the board to the console use X for the piece, + for a legal move, and . for an empty cell
            Console.WriteLine("=================");
            for (int r = 0; r < myBoard.Size; r++)
            {
                Console.WriteLine("-----------------");
                for (int c = 0; c < myBoard.Size; c++)
                {
                    Console.Write("|");
                    Cell cell = myBoard.theGrid[r, c];
                    if (cell.CurrentlyOccupied)
                    {
                        Console.Write("X");
                    }
                    else if (cell.LegalNextMove)
                    {
                        Console.Write("+");
                    }
                    else
                    {
                        Console.Write(".");
                    }
                }
                Console.WriteLine("|");
            }
            Console.WriteLine("=================");
        }
    }

}