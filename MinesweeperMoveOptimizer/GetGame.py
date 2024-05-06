""" 
This file will be used to get the game from the user via screen capture methods
"""
import cv2
import numpy as np
import pyautogui

def get_game():
    """
    Function that gets the game from the user via screen capture methods
    """
    screen = get_screen()
    game = get_board(screen)
    return game

def get_screen():
    """
    Function that gets the screen from the user via screen capture methods
    """
    screen = pyautogui.screenshot()
    screen = cv2.cvtColor(np.array(screen), cv2.COLOR_RGB2BGR)
    return screen

def get_board(screen):
    """
    Function that gets the board from the screen
    """
    
    # Define the upper and lower boundaries for the color of the board in BGR format
    lower = np.array([0, 0, 0])
    upper = np.array([255, 255, 255])

    # Create a mask that only includes colors within the defined boundaries
    mask = cv2.inRange(screen, lower, upper)

    # Find the contours in the mask
    contours, _ = cv2.findContours(mask, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)

    # Find the largest contour, which should be the game board
    board_contour = max(contours, key=cv2.contourArea)

    # Get the bounding rectangle around the game board
    x, y, w, h = cv2.boundingRect(board_contour)

    # Extract the game board from the screen
    board = screen[y:y+h, x:x+w]

    return board

    
    