import java.io.File;
import java.util.Random;

/** 
 * In this class, the goal is to represent Waldo in a unknow
 * auditorium seat. In an auditorium, seats are arranged in rows and 
 * identified by alphabetic letters and seats with numbers. Seat 
 * numbers increase from the audience's left as row letters ascend 
 * from the stage to the back of the auditorium.This class will be 
 * used by the main driver program called "PlayWaldoGame.java." 
 *
 * @author Binal Dhaliwal 
 * @version 2023/01/11 
 */
public class WhereIsWaldo {
   /** 
    * This field name indicates the 2- D array of char used to 
    * simulate seats in the auditorium.
    */
   private char[][] myAuditorium;
   /** 
    * This field name is an int that holds the row on where
    *  Waldo is hiding. 
    */
   private int myRowLocation;
   /** 
    * This field name is an int that holds the seat on where
    *  Waldo is hiding. 
    */
   private int mySeatLocation;
   /** 
    * This field name is an char which assigns the player who
    * finds Waldo as a winner. '1' or '2' used to distigush 
    * between the players. 
    */
   private char myWinner;
   /** 
    * This field name is a boolean which is set to true when Waldo
    * is found.
    */
   private boolean myFound;
   
   /**
    * WhereIsWaldo method is a constructor that establishes Waldo's
    * location and the auditorium. In more detail, the constructor
    * recieves two int paramaters(theRows and theSeats) for the 
    * number of seats and rows in the auditorium for where Waldo 
    * is hiding.
    *
    * @param theRows is a int that recieves the user's input for the
    * number of rows in the auditorium (in which Waldo is hidden).
    * @param theSeats is an int that recieves the user's input for 
    * the number of seats per row in the auditorium (in which Waldo
    * is hidden).
    */ 
   public WhereIsWaldo(int theRows, int theSeats) {
      // 2D array is a char array with the first parameter being
      // theRows as rows and second, theSeats as columns.
      myAuditorium = new char[theRows][theSeats];
      /* This for loop initializes the auditorium cells to contain
         a space(' '). This for loops goes through the rows. */
      for (int row = 0; row < theRows; row++) {
         /* This for loop initializes for the auditorium cells to
            contain a space(' '). This for loops goes through
            the columns (seat's). */
         for (int col = 0; col < theSeats; col++) {
            myAuditorium[row][col] = ' ';
         }
      }
      // Sets Waldo on a random row and seat location.
      Random r = new Random();
      myRowLocation = r.nextInt(theRows);
      mySeatLocation = r.nextInt(theSeats);
      myAuditorium[myRowLocation][mySeatLocation] = 'W';
      // myWinner is set to a single space.
      myWinner = ' ';
      // myFound set to false.
      myFound = false;
   }
   
   /**
    * seatSearchedAlready method is a accessor method that recieves
    * a char parameter (theRows) and an int parameter(theSeats) to 
    * see if the seat has already been searched, the variable 
    * (variable) is returned as false, otherwise true.
    *
    * @param theRows is a char that recieves the row, such as
    * (A, B, C, etc.) to go through the rows and see if that row has
    * been searched, and followed by the seat to see if that certain
    * location has been searched.
    * @param theSeats is an int that goes through the seats
    * (subtract 1 to index the column in the myAuditorium array) in
    * correspondance with the row to establish if or if not the seat
    * has been searched.
    * @return variable which returns false establishing that if the
    * row and column hasn't been searched, and true otherwise.
    */ 
   public boolean seatSearchedAlready(char theRows, int theSeats) {
      boolean variable = true;
      // If statement to determine if player 1 or player 2 have been
      // established in the picked seats. If the space is empty, the 
      // seat hasn't been searched yet. 
      if (myAuditorium [theRows - 'A'] [theSeats - 1] != 1 && 
         myAuditorium [theRows - 'A'] [theSeats - 1] != 2) { 
         variable = false;     
      }
      // returns the boolean variable.
      return variable;
   }
   
   /**
    * waldoLocation method is a accessor method that recieves
    * a char parameter (theRows) and an int parameter(theSeats) to 
    * variable see if the row and seat is where Waldo is hiding,    
    * than the (variable) is returned as true, otherwise false.
    *
    * @param theRows is a char that recieves the row, such as
    * (A, B, C, etc.) to go through the rows and see if that row has
    * Waldo hiding, and followed by the seat to see if that certain
    * location is where Waldo is.
    * @param theSeats is an int that goes through the seats
    * (subtract 1 to index the column in the myAuditorium array) in
    * correspondance with the row to establish if or if not Waldo is
    * hiding at that location.
    * @return variable which returns true establishing that if the
    * row and column has Waldo hiding there, and false otherwise.
    */
   public boolean waldoLocation(char theRows, int theSeats) {
      boolean variable = false;
      // If statement to determine if Waldo has been established in
      // the pciked seat by the player. If so, variable is set to
      // true.
      if (myAuditorium [theRows - 'A'] [theSeats - 1] == 'W') {
         variable = true;
      }
      // returns the boolean variable.
      return variable;
   }
   
   /**
    * indicesOK method is a accessor method that recieves
    * a char parameter (theRows) and an int parameter(theSeats) to 
    * see if the row and seat values are within the range of the 
    * array indices, than the variable (variable) is returned as  
    * true, otherwise false.
    *
    * @param theRows is a char that recieves the row, such as
    * (A, B, C, etc.) to go through the rows and see if that row
    * is within the array indices range, and followed by the seat to
    * see if the seat is also within the array indices range.
    * @param theSeats is an int that goes through the seats
    * (subtract 1 to index the column in the myAuditorium array) in
    * correspondance with the row to establish if or if not the seat
    * values are within the array indices range.  
    * @return variable which returns true establishing that if the
    * row and column are within the array indices range, and false
    * otherwise.
    */
   public boolean indicesOK(char theRows, int theSeats) {
      boolean variable = false;
      int indexRow = theRows - 'A';
      int indexSeat = theSeats - 1;
      // If statement to go through the rows and seats to see if
      // the indices are valid. If so, variable is returned as true.
      if (indexRow >= 0 && indexRow < myAuditorium.length &&
          indexSeat >= 0 && indexSeat < myAuditorium[0].length) {
          variable = true;
      }
      // returns the boolean variable.
      return variable;
   }
   
   /**
    * numberOfRows method is a accessor method, where the number of
    * rows in the auditorium is returned as an int.
    *
    * @return myAuditorium.length, returns the number of rows in the
    * auditorium that is established.
    */ 
   public int numberOfRows() {
      return myAuditorium.length;
   }
   
   /**
    * numberOfSeats method is a accessor method, where the number of
    * seats in the auditorium is returned as an int.
    *
    * @return myAuditorium[0].length, returns the number of seats in
    * the auditorium that is established.
    */ 
   public int numberOfSeats() {
      return myAuditorium[0].length;
   }
   
   /**
    * searchSeat method is a accessor method that recieves
    * a char parameter (theRows), an int parameter(theSeats), and 
    * an char paramter(theCurrentPlayer) to be searched to see if 
    * the row, seat and current player find Waldo, than the variable
    * (variable) is returned as true, otherwise false.
    *
    * @param theRows is a char that recieves the row, such as
    * (A, B, C, etc.) to go through the rows and see if that row has
    * found Waldo, and followed by the seat to see if the seat is 
    * also where Waldo is found on.
    * @param theSeats is an int that goes through the seats
    * (subtract 1 to index the column in the myAuditorium array) in
    * correspondance with the row to establish if or if not Waldo
    * is found.
    * @param theCurrentPlayer is an char that that established  
    * player 1 or 2, and with the row and seat, it searches if Waldo  
    * is found at a particular location.
    * @return variable which returns true establishing that when the
    * row, seat, and currentPlayer are in a specific location and  
    * find Waldo, variable returns as true.
    */ 
   public boolean searchSeat(char theRows, int theSeats, 
                                  char theCurrentPlayer) {
      boolean variable = false;
      // If statement to go through the rows and seats to see if
      // Waldo is there, and if found. If so, variable and myFound
      // is returned as true. Also, the winner is set to the player
      // who finds Waldo.
      if (myAuditorium[theRows - 'A'][theSeats - 1] == 'W') {
         myWinner = theCurrentPlayer;
         myFound = true;
         variable = true;
      } 
      // else if statement states that if Waldo is not found, the
      // array sets the row and seat location to the recieved player
      // ( 1 or 2).
      else if (myAuditorium[theRows - 'A'][theSeats - 1] == ' ') {
         myAuditorium[theRows - 'A'][theSeats - 1] =
                                    theCurrentPlayer;
      }
      // returns the boolean variable.
      return variable;
   }
   
   /**
    * toString method is a accessor method that displays the current
    * myAuditorium array, but not Waldo's location. When Waldo is
    * found, toString will be called (by the driver) and the player
    * who found Waldo and a 'W' will be displayed together.
    *
    * @ return result which returns a String to display the current
    * auditorium, and it's contents besides Waldo's location. Waldo
    * is displayed when toString is called by the driver, as 
    * states above.
    */ 
   public String toString() {
      String result = "";
      /* This for loop goes through the seat's  of the auditorium to 
         print out the equal (=) signs as needed. */
      for (int seatLocation = 0; seatLocation < numberOfSeats() + 2;
                                                   seatLocation++) {
         /* This for loop goes through the row's of the auditorium  
            to print out the equal (=) signs as needed. */
         for (int rowLocation = numberOfRows() - 1; rowLocation >= 0;
                                                    rowLocation--) {
            //If statement to determine if the seat is set to
            //zero or if the seats is equivalent to the number
            //of seats that is provided by the user + 1.
            if (seatLocation == 0 || seatLocation == 
                                     numberOfSeats() + 1) {
               result += "====";
            }
            //If the above if statement is not satisfied, the
            //String result prints out the "(" as needed for the
            //auditorium.
            else {
               result += "(";
               char character = myAuditorium[rowLocation]
                                            [seatLocation - 1];
               //If statement to say that if Waldo is not found,
               //there is an another if/else statement within to
               //initiate if or not Waldo is found alongisde the
               //player.
               if (!myFound) {
                  //If statement to determine that if Waldo
                  //is found, a "W" will be shown in the cell.
                  if (character == 'W') {
                     result += "  ";
                  } 
                  else {
                     result += character + " ";
                  }
               }
               else {
                  //If statement to determine if Waldo is found, 
                  //the "W" will be shown alongside the player
                  //(1 or 2).
                  if (character == 'W') {
                     result += character + "" + myWinner;
                  } 
                  else {
                     result += character + " ";
                  }
              }
              result += "|";
            }    
         }
         result += "\n";
      }
      //returns the String result.
      return result;
   }
}
