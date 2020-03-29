import java.util.*;
import java.io.*;
import java.util.StringTokenizer;
/**
 * Write a description of class Driver here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Driver
{
    public static void main (String [] args) throws IOException
    {
        int col,row;
        char newItem;
        String newWord, inputRead, tokenString;
        StringTokenizer token;
        Scanner in = new Scanner(System.in);
        Scanner fileInput;        
        System.out.println("How many columns");
        col = in.nextInt();
        System.out.println("How many rows");
        row = in.nextInt();
        
        CrosswordSolver mike = new CrosswordSolver(row,col);

        fileInput = new Scanner(new File("wordSearchRaw.txt"));
        inputRead = inputRead = fileInput.nextLine();
        token = new StringTokenizer(inputRead, ",");
        for(int i = 1; i < (mike.getRows()*mike.getCols()+1); i++){
            tokenString = token.nextToken();
            newItem = tokenString.charAt(0);
            mike.fillCrossword(newItem);            
        }

        System.out.println("What word do you want to look for?");
        newWord = in.next();
        System.out.println(mike.findWord(newWord));

    }
}