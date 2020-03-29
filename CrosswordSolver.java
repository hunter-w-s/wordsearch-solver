import java.util.*;
import java.lang.StringBuilder;

/**
 * Write a description of class CrosswordSolver here.
 *
 * @author Hunter Stingel
 * @version 3/28/2020
 */
public class CrosswordSolver
{

    private int cols,rows;
    private String search;
    private char[] inputs = {'*'};
    public CrosswordSolver(){
        cols = 0;
        rows = 0;
        search = null;        
    }

    public CrosswordSolver(int newRow, int newCol){
        cols = newCol;
        rows = newRow;
        search = null;
    }

    public void fillCrossword(char nextChar){
        inputs = Arrays.copyOf(inputs, inputs.length+1);
        inputs[inputs.length - 1] = nextChar;
    }

    public String findWord(String newSearch){
        int[] confirmedIndexLocs = {0};
        int itemIndex = 1,confirmIndex=1;
        int xIndex, yIndex;
        int wordLength = newSearch.length();
        int repeatSearchTime = (newSearch.length()-1);
        int searchPosition = 0;
        boolean leftPoss=true, rightPoss=true, upPoss=true, downPoss=true, luPoss=true, ldPoss=true, ruPoss=true, rdPoss=true;
        boolean wordNotFound = true, continueSearch = true;
        boolean returnTrue = false;
        char firstLetter = newSearch.charAt(0);
        char charSearch;

        String returnStatement = ("The index(es) of the first character are/is ");
        for(char cW: inputs){
            if(cW == firstLetter){
                leftPoss=true;
                rightPoss=true;
                upPoss=true;
                downPoss=true;
                luPoss=true;
                ldPoss=true;
                ruPoss=true;
                rdPoss=true;
                confirmedIndexLocs = Arrays.copyOf(confirmedIndexLocs, confirmedIndexLocs.length+1);
                confirmedIndexLocs[confirmedIndexLocs.length - 1] = itemIndex;
                xIndex = ((itemIndex-1)%cols);
                yIndex = ((((itemIndex-1)*rows)/(cols*rows))+1);

                if(xIndex==0){
                    xIndex=cols;   
                }

                

                if(xIndex < wordLength){
                    leftPoss = false;
                    luPoss = false;
                    ldPoss = false;
                }
                if(yIndex < wordLength){
                    upPoss = false;
                    luPoss = false;
                    ruPoss = false;
                }
                if((cols-xIndex+1) < wordLength){
                    rightPoss = false;
                    ruPoss = false;
                    rdPoss = false;
                }
                if((rows-yIndex+1) < wordLength){
                    downPoss = false;
                    ldPoss = false;
                    rdPoss = false;
                }

                
                if(leftPoss && wordNotFound){
                    continueSearch = true;
                    searchPosition = 1;
                    while(continueSearch && repeatSearchTime > 0){
                        charSearch = newSearch.charAt(searchPosition);
                        if(charSearch != inputs[(itemIndex-1)-searchPosition]){
                            continueSearch = false;
                        }                        

                        if(searchPosition+1 == wordLength && charSearch == inputs[(itemIndex-1)-searchPosition]){
                            wordNotFound = false;   
                        }
                        searchPosition++;
                        repeatSearchTime--;
                    }
                }
                repeatSearchTime = (newSearch.length()-1);
                if(rightPoss && wordNotFound){
                    searchPosition = 1;
                    continueSearch = true;
                    while(continueSearch && repeatSearchTime > 0){
                        charSearch = newSearch.charAt(searchPosition);
                        if(charSearch != inputs[(itemIndex-1)+searchPosition]){
                            continueSearch = false;
                        }                        

                        if(searchPosition+1 == wordLength && charSearch == inputs[(itemIndex-1)+searchPosition]){
                            wordNotFound = false;   
                        }
                        searchPosition++;
                        repeatSearchTime--;
                    }
                }
                repeatSearchTime = (newSearch.length()-1);
                if(upPoss && wordNotFound){
                    continueSearch = true;
                    searchPosition = 1;
                    while(continueSearch && repeatSearchTime > 0){
                        charSearch = newSearch.charAt(searchPosition);
                        if(charSearch != inputs[(itemIndex-1)-cols*searchPosition]){
                            continueSearch = false;
                        }                        

                        if(searchPosition+1 == wordLength && charSearch == inputs[(itemIndex-1)-cols*searchPosition]){
                            wordNotFound = false;   
                        }
                        searchPosition++;
                        repeatSearchTime--;
                    }
                }
                repeatSearchTime = (newSearch.length()-1);
                if(downPoss && wordNotFound){ 
                    searchPosition = 1;
                    continueSearch = true;
                    while(continueSearch && repeatSearchTime > 0){
                        charSearch = newSearch.charAt(searchPosition);
                        if(charSearch != inputs[(itemIndex-1)+cols*searchPosition]){
                            continueSearch = false;
                        }                        

                        if(searchPosition+1 == wordLength && charSearch == inputs[(itemIndex-1)+cols*searchPosition]){
                            wordNotFound = false;   
                        }
                        searchPosition++;
                        repeatSearchTime--;
                    }
                }
                repeatSearchTime = (newSearch.length()-1);
                if(ldPoss && wordNotFound){ 
                    searchPosition = 1;
                    continueSearch = true;
                    while(continueSearch && repeatSearchTime > 0){
                        charSearch = newSearch.charAt(searchPosition);
                        if(charSearch != inputs[(itemIndex-1)+(cols-1)*searchPosition]){
                            continueSearch = false;
                        }                        

                        if(searchPosition+1 == wordLength && charSearch == inputs[(itemIndex-1)+(cols-1)*searchPosition]){
                            wordNotFound = false;   
                        }
                        searchPosition++;
                        repeatSearchTime--;
                    }
                }
                repeatSearchTime = (newSearch.length()-1);
                if(luPoss && wordNotFound){ 
                    searchPosition = 1;
                    continueSearch = true;
                    while(continueSearch && repeatSearchTime > 0){
                        charSearch = newSearch.charAt(searchPosition);
                        if(charSearch != inputs[(itemIndex-1)-(cols+1)*searchPosition]){
                            continueSearch = false;
                        }                        

                        if(searchPosition+1 == wordLength && charSearch == inputs[(itemIndex-1)-(cols+1)*searchPosition]){
                            wordNotFound = false;   
                        }
                        searchPosition++;
                        repeatSearchTime--;
                    }
                }
                repeatSearchTime = (newSearch.length()-1);
                if(ruPoss && wordNotFound){ 
                    searchPosition = 1;
                    continueSearch = true;
                    while(continueSearch && repeatSearchTime > 0){
                        charSearch = newSearch.charAt(searchPosition);
                        if(charSearch != inputs[(itemIndex-1)-(cols-1)*searchPosition]){
                            continueSearch = false;
                        }                        

                        if(searchPosition+1 == wordLength && charSearch == inputs[(itemIndex-1)-(cols-1)*searchPosition]){
                            wordNotFound = false;   
                        }
                        searchPosition++;
                        repeatSearchTime--;
                    }
                }
                repeatSearchTime = (newSearch.length()-1);
                if(rdPoss && wordNotFound){ 
                    searchPosition = 1;
                    continueSearch = true;
                    while(continueSearch && repeatSearchTime > 0){
                        charSearch = newSearch.charAt(searchPosition);
                        if(charSearch != inputs[(itemIndex-1)+(cols+1)*searchPosition]){
                            continueSearch = false;
                        }                        

                        if(searchPosition+1 == wordLength && charSearch == inputs[(itemIndex-1)+(cols+1)*searchPosition]){
                            wordNotFound = false;   
                        }
                        searchPosition++;
                        repeatSearchTime--;
                    }
                }
                
                if(wordNotFound == false){
                    returnStatement = (returnStatement + "X "+ (xIndex) + " Y " + (yIndex));
                    returnTrue = true;
                }
            }            
            itemIndex++;
            wordNotFound = true;
        }
        
        if(returnTrue == true){
            return (returnStatement);
        }
        else
        {
            return ("No word found found");   
        }

    }

    public int getCols(){
        return cols;   
    }

    public int getRows(){
        return rows;   
    }

}
