#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <math.h>
 
int board[20];
int count;

// FOR PRINTING THE SOLUTION
void printSolution(int n) { 
   printf("\n\nSolution %d:\n\n", ++count);
   for (int i = 1; i <= n; i++) {
      printf("\t%d", i);
   }
   for (int i = 1; i <= n; i++) {
      printf("\n\n%d", i);
      for (int j = 1; j <= n; j++) {
         if (board[i] == j) {
            printf("\tQ");
         }else {
            printf("\t_"); // empty slot
         }
      }
   }
}

// CHECK FOR CONFLICTS
bool conflictCheck(int row, int column) {
   for (int i = 1; i <= (row - 1); i++) {
      if ((board[i] == column) || (abs(board[i] - column) == abs(i - row))) {
         return false;
      }
   }
   return true;
}

// CHECK FOR POSITIONING OF QUEEN
void queenPosition(int row, int queenNumber) {
   for (int column = 1; column <= queenNumber; column++) {
      if (conflictCheck(row, column) == true) {
         board[row] = column; // Place if no Conflicts
         if (row == queenNumber) {
            printSolution(queenNumber); // If dead end print board
         }else {
            queenPosition((row + 1), queenNumber); // If there's a conflict, try to next cell.  Then recurse.
         }
      }
   }
}

int main() {
   int number;
   printf("\n\nEnter number of Queens:");
   scanf("%d", &number);
   queenPosition(1, number);
   return 0;
}