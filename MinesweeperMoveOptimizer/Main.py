"""
@Author: Ivan Rojas
"""


from GetGame import get_game


def main():
    """
    Main function that controls the solving process of the minesweeper board
    """
    game = get_game()
    print( game )
    
if __name__ == "__main__":
    main()