/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.tic.tac.toe;


import java.util.Scanner;

/**
 *
 *
 */


public class TicTacToe {

    public static String board[][]=new String[3][3];//To save the value for the cell
    public static boolean boardEmptySet[][]=new boolean[3][3];// array to check if the cell empty or not
    public static char  ch='X';// to exchange the x and o
    public static int count=0; // variable to check if the place is empty or not 
    public static int numOfPlayer=1;// exchange between palyer 1 and player 2
    public static int numOfCellPlaceTheBoard=0;//To calculate the number of X and O in the board to check if the cell are full or not
    public static Scanner input=new Scanner(System.in);
    
    
    
    public static void main(String[] args) {//The main method 
        prapereTheBoard();// to parpere the board for the first time
        int z=1;// to save the number of who has the role(palyer1 or player 2 and the change X and O)
        
        while(true)//The operaion it will repeat untill the user wanna get out from it 
        {
        if(z%2==0)
        {ch='O';numOfPlayer=2;}
        else {ch='X';numOfPlayer=1;}
        paintBoard();//To draw to board
        enterPlace();// ask user to enter the number where he wanna put there charactor and check if it valid or not
        if(checkMove()!=0)//Check if there's a winner 
        {
            System.out.println("The winner is Player "+numOfPlayer);
            System.out.println("Wanna repeat the game ? enter 1 if YES or 0 to NO");
            int num=input.nextInt();
            if(num==1)
            {
                prapereTheBoard();// draw the first board with number and without x and o
                numOfPlayer=1;// here we returned everything to play the game again
                ch='X';
                count=0;
                z=1;
            }
            else // if he entered no then the game will finish
            {
                break;
            }
        }
       else z++;//to change the palyer and the charactor
        if(numOfCellPlaceTheBoard==9)//if all the cell are full and no one has win
        {
            System.out.println("There is no winner");
            System.out.println("Wanna repeat the game ? enter 1 if YES or 0 to NO");
            int num=input.nextInt();
            if(num==1)
            {
                prapereTheBoard();
                numOfPlayer=1;
                ch='X';
                count=0;
                z=1;
            }
            else 
            {
                break;
            }
        }
        else z++;
        
        
    }
    }
public static void prapereTheBoard()//to praper the board
{
    int counter=0;// to change the number in the cell
    for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
                board[i][j]=Integer.toString(++counter);// give the array valude from 1 to 9
        }
         for(int i=0;i<3;i++)//give the array value (true)
        {
            for(int j=0;j<3;j++)
                boardEmptySet[i][j]=true;
        }
}
    
    public static void enterPlace()//to enter the number 
    {
        
       if(count==0)
       {System.out.println("Player "+numOfPlayer+"  ,please enter the number of the square where you want to place your "+ch+" :");}
        else System.out.println("Invalid input,please enter a valid move :");
       
        int numOfSquare=input.nextInt();
         if(numOfSquare>10||numOfSquare<1)//if the number is out of the range 
        {
            count++;//change the count to one to enter another statement 
            enterPlace();//repeat the method to enter another value
        }
       else {
            count=0;
            checkPlace(numOfSquare);//to check if the cell are empty or not
        }
        if(count!=0)//after the method above
            enterPlace();
        else count=0;
            
     }
    
    
    public static void checkPlace(int numOfSquare)//to check if the number of the cell is empty or not
    {
        int c=0;
         for(int i=0;i<3;i++)
        {
            
            for(int j=0;j<3;j++)
            {
                if(!(board[i][j].equals("X"))&& !(board[i][j].equals("O"))&&
                        Integer.parseInt(board[i][j])==numOfSquare)
                {
                    if(boardEmptySet[i][j]==true)//if it empty
                    {
                        if(ch=='X')//assign the charactor into the board and change the number
                        board[i][j]="X";
                        else 
                            board[i][j]="O";
                        
                        boardEmptySet[i][j]=false;// to tell that the cell is not empty
                        numOfCellPlaceTheBoard++;// to save the number of the X and O in the board
                    }
                    else // if it's not empty 
                    {
                        
                        count++; // to repeat the method and enter another number 
                        enterPlace();
                    }
                    c++;
                    break;
                }
            }
            if(c!=0)break;
        }
         if(c==0){
         count++;
         enterPlace();
         }
    }
    /*
1 | 2 | 3
--+---+---
4 | 5 | 6
--+---+---
7 | 8 | 9
*/
 public static void paintBoard()//Draw the board above 
{
  for(int i=0;i<3;i++)
  {
      for(int j=0;j<3;j++)
      {
         System.out.print(board[i][j]);//print the value ( X ,O or number)
          if(j!=2)
          System.out.print(" | ");
      }
      System.out.println();
      if(i!=2)
          System.out.print("--+---+---");
      System.out.println();
     
  }
}
 public static int checkMove()//to check if there's a winner or not after every move
 {
   
     for(int i=0;i<3;i++)
     {
       
         if(board[i][0].equals(board[i][1])&&board[i][1].equals(board[i][2]))// X X X or O O O 
         {
             return 1;
         }
         if(board[0][i].equals(board[1][i])&&board[0][i].equals(board[2][i]))
         {
             /*
             X   O
             X   O
             X   O
                                                                              
             */   
         
             return 1;
         }
        
         if(board[0][0].equals(board[1][1])&&board[1][1].equals(board[2][2]))
         {
             /*
             X 
               X
                 X
             or
             O
               O
                 O
             */
             return 1;
         }
         if(board[0][2].equals(board[1][1])&&board[1][1].equals(board[2][0]))
         {
             /*
                X
               X
              X   
             or
                O
               O
              O
             */
             return 1;
         }
         
     }
     return 0;//if there's no winner
 }
}

