package ACSLPrograms;
import java.util.*;
/*
ACSL Tiles is a one-person game played with rectangular tiles. Each tile has a single-digit number between 1 and 9 inclusive at each end.
At the start of the game, there are 4 rows, each with a number.
The goal of the game is to build rows by placing a tile at the right end of a row whose last number matches a number on the tile.
Tiles can be re-oriented; thus, the tiles 34 and 43 are the same tile. If a tile cannot be placed on any row it is placed in the discard pile.
When all tiles have been played or discarded, find the sum of the single-digit numbers on all the tiles in the discard pile.

At each turn, try the next tile in your hand to see if it can be added to one of the rows, starting with the row after the one where the last tile was placed, rotating back to Row 1 if necessary.
Start looking at Row 1 when the game starts.
However, if the last tile placed was a double (i.e., both numbers are the same), another tile must be placed on that row before any other match can be considered.
If the tile cannot be placed, add it to the discard pile.

EXAMPLE

Input:
5934
56 27 73 34 99 45 32 19 64 57 18
Output:
21

Explanation:
The game starts with 4 rows having numbers 5,9,2,3.
The tile 56 is placed on Row 3.
The tile 73 is placed on Row 4 as 37 because Row 4 is checked first after a tile is placed on Row 3.
The tile 34 is placed on the discard pile.
The tile 99 is placed on Row 2.
The 45 and 32 tiles are placed in the discard pile because they don't match the 99 tile.
The tile 19 is placed on Row 2 as 91.
The tile 64 is placed on Row 1.
The tile 57 is placed on Row 3 as 75.
The tile 18 is placed on Row 2.
The sum of the single-digit numbers on the tiles in the discard pile is 3+4+4+5+3+2 = 21.

TASK:
Complete the function findDiscardSum
    - the function has two parameters: a 4-digit integer, originalRows, representing the initial numbers from Row 1 to Row 4 and a string of 2-digit numbers, tiles, each separated by a single space.
      Each 2-digit number represents the two numbers on each tile, both between 1 and 9 inclusive.
    - The function returns an integer representing the sum of all the single-digit numbers on the tiles in the discard pile.

Constraints:
    - The 4 digit number will not contain the digit 0 and there will be no more than 50 tiles, none of which will contain the digit 0.

 */
public class ACSLTiles {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int originalRows = scan.nextInt();
        scan.nextLine();
        String tiles = scan.nextLine();
        System.out.print(findDiscardSum(originalRows, tiles));
    }
    public static int findDiscardSum(int originalRows, String tiles) {
        String[] tile = tiles.split(" ");
        char[] lastChar = new char[4];
        int discardpile = 0;

        String originalrows = originalRows + "";
        for (int i = 0; i < 4; i++) {
            lastChar[i] = originalrows.charAt(i);
        }
        int r = 0;
        boolean Double = false;
        for (int i = 0; i < tile.length; i++) {
            if (!Double) {
                for (int count = 0; count < 4; count++) {
                    if (lastChar[r] == tile[i].charAt(0)) {
                        lastChar[r] = tile[i].charAt(1);
                        if (tile[i].charAt(1) == tile[i].charAt(0)) Double = true;
                        else{ r++; r %= 4; }
                        break;
                    } else if (lastChar[r] == tile[i].charAt(1)) {
                        lastChar[r] = tile[i].charAt(0);
                        r++; r %= 4;
                        break;
                    } else if (count == 3) {
                        discardpile += (tile[i].charAt(0) - '0') + (tile[i].charAt(1) - '0');
                        r -= 3; if (r < 0) r += 4;
                    } else { r ++; r %= 4; }
                }
            } else {
                if (lastChar[r] == tile[i].charAt(0)) {
                    lastChar[r] = tile[i].charAt(1);
                    if (!(tile[i].charAt(1) == tile[i].charAt(0))) { r++; r %= 4; Double = false;}
                } else if (lastChar[r] == tile[i].charAt(1)) {
                    lastChar[r] = tile[i].charAt(0);
                    r++; r %= 4;
                    Double = false;
                } else discardpile += (tile[i].charAt(0) - '0') + (tile[i].charAt(1) - '0');
            }
        }
        return discardpile;
    }
}
