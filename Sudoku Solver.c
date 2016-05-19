#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
// #include <math.h>

int system (const char* command);

// int boardSize;
// int subBoard;
// Stores entries for sudoku
int table[9][9];

void solveSudoku(int row, int column);

// int elementCount(FILE* fp) {
//     FILE* fp1 = fp;
//     int count = 0;
//     int ch = 0;
//     while (!feof(fp1)) {
//         fscanf(fp1, "%d", &ch);
//         count++;
//     }
//     return count;
// }

void start() {
    // subBoard = (sqrt(boardSize));
    char name[20];
    // int size;
    // printf("Enter Sudoku Board Size:\n");
    // scanf("%d", &size);
    //boardSize = size;
    int grid[9][9];
    printf("Enter File Name: ");
    scanf("%s", name);
    FILE* fp = fopen(name, "r");

    if (fp == NULL) {
        // char save[20];
        // printf("Save Results to:\n");
        // scanf("%s", save);
        // FILE* ofp = fopen(save, "w");
        //fprintf(ofp, "Error: No Such File or Directory!\n");
        printf("\nError: No Such File or Directory!\n\n");
        system("pause");
        //fclose(ofp);
        exit(1);
    } else /*if (elementCount(fp) == 81)*/ {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                fscanf(fp, "%d", &grid[i][j]);
            }
        }
        memcpy(table, grid, sizeof(table));
        solveSudoku(0, 0); // The solving starts by passing parameters
        exit(1);
    } /*else {
        char save[20];
        printf("Save Results to:\n");
        scanf("%s", save);
        FILE* ofp = fopen(save, "w");
        fprintf(ofp, "Error: Invalid Sudoku Inputs!\n");
        fclose(ofp);
        exit(1);
    }*/
    fclose(fp);
    exit(1);
}

// Prints the solved Sudoku
void solutionPrint() {
    char save[20];
    printf("\nSave Results to: ");
    scanf("%s", save);
    FILE* ofp = fopen(save, "w");
    int countAcross = 0;
    //int countDown = 0;

    fprintf(ofp, "The Solution of the Sudoku Puzzle is: \n");
    fprintf(ofp, "\n+-----------+-----------+-----------+\n");
    for (int row = 0; row < 9; row++) {
        fprintf(ofp, "|");
        for (int column = 0; column < 9; column++) {
            // countDown++;
            // if (countDown == 3 || countDown == 6 || countDown == 9) {
            //     fprintf(ofp, " %d |", table[row][column]);
            // }else {
                fprintf(ofp, " %d |", table[row][column]);
            //}
        }
        //countDown = 0;
        countAcross++;
        if (countAcross == 3 || countAcross == 6) {
            fprintf(ofp, "\n|===========#===========#===========|");
        }else if (countAcross != 9){
            fprintf(ofp, "\n|---+---+---|---+---+---|---+---+---|");
        }
        fprintf(ofp, "\n");
    }
    fprintf(ofp, "+-----------+-----------+-----------+\n");
    fclose(ofp);
    system(save);
    exit(1);
}

// Checks if no conflict in rows
bool rowCheck(int row, int n) {
    for(int column = 0; column < 9; column++) {
        if(table[row][column] == n) {
            return false; // if number is already found in the row
        }
    }
    return true; // number can be one of the solutions in the row
}

// Checks if no conflict column
bool columnCheck(int column, int num) {
    for(int row = 0; row < 9; row++) {
        if(table[row][column] == num) {
            return false; // if number is already found in the column
        }
    }
    return true; // number can be one of the solutions in the column
}

// Checks if no conflict in a 3x3 box
bool boxCheck(int row, int column, int n) {
    row = ((row / 3) * 3) ;
    column = (column / 3) * 3;
    for(int r = 0; r < 3; r++) {
        for(int c = 0; c < 3; c++) {
            if (table[row + r][column + c] == n) {
                return false; // if number is already found in the 3x3 grid
            }
        }
    }
    return true; // number can be one of the solutions in the 3x3 grid
}

// Move to next cell when its filled already
void nextCell(int row, int column) {
    if(column < 8) {
        solveSudoku(row, (column + 1));
    }else {
        solveSudoku((row + 1), 0);
   }
}

// Solution for the puzzle by Backtracking
void solveSudoku(int row, int column) {
    if (row == 9) { // Means that all cells are filled
        solutionPrint();
    }
    if (table[row][column] != 0) { // If a cell is not a zero, it means we have to move to the next cell
        nextCell(row, column);
    }else {
        for (int counter = 1; counter <= 9; counter++) { // Checks if numbers 1-9 can be put on a cell
            if ((rowCheck(row, counter) == true) && (columnCheck(column, counter) == true) && (boxCheck(row, column, counter) == true)) { // If looks promising
                table[row][column] = counter; // Make tentative assignment
                nextCell(row, column);
            }
        }
        table[row][column] = 0; // If doesn't lead to a solution, reset to 0. This triggers the backtracking
        // Note this backtracking step, a very important step**
        // We come at this position, this step, this line when we have already checked all possible values at 
        // sudoku[i][j] and we couldn't find the solution
        // Put any value does not solves our board implies that we must have made wrong choice earlier
        // so we make this sudoku[i][j] again a vacant cell and try to correct our previous guesses/choices.
    }
}

int main() {
    start();
    return 0;
}