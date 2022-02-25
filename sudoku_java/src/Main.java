
package src;

import src.start.Play;

public class Main{
    
    public static void main(String[] args){
        byte[][] sudoku1 = {
            {-1,  6, -1, -1, -1, -1,  4,  2,  5},
            { 5,  7, -1, -1, -1, -1, -1,  8,  1},
            {-1, -1, -1,  4,  3, -1,  9, -1, -1},
            {-1,  5, -1,  9,  2, -1, -1,  7,  4},
            {-1, -1, -1,  3,  8,  4, -1, -1, -1},
            { 8,  4, -1,  5,  6,  7, -1,  9, -1},
            {-1, -1,  2, -1,  1, -1, -1, -1, -1},
            {-1,  3,  9, -1, -1,  6,  7, -1,  8},
            {-1, -1, -1, -1, -1,  9,  6, -1, -1}
        };

        Play game = new Play(sudoku1);
        game.start();
        
    }

}
