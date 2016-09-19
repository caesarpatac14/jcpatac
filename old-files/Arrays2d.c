#include <stdio.h>

//int, int, int arr[][], int, int -> int
//Returns 1 if a row and column index (i and j) is at the corner of a 2D array
int corner(int rowLen, int colLen, int grid[rowLen][colLen], int i, int j){
	return ((i == 0 && j == 0) || (i == 0 && j == (colLen - 1)) || (i == (rowLen - 1) && j == 0) || (i == (rowLen - 1) && j == (colLen - 1)));
}

//int, int, int arr[][], int, int -> int
//Determines if a row or index (i and j) is at the edge of a 2D array
int edge(int rowLen, int colLen, int grid[rowLen][colLen], int i, int j) {
    return (((rowLen - 1) == i) || ((colLen - 1) == j) || (0 == i) || (0 == j));
}

//int, int, int arr[][], int -> int
//Calculates the sum of a specified row index
int rowSum(int rowLen, int colLen, int grid[rowLen][colLen], int rowIndex) {
    int sum = 0;
    for (int i = 0; i < colLen; i++){
        sum += grid[rowIndex][i];
    }
    
    return sum;

}

//int, int, int arr[][], int -> int
//Calculates the sum of specified column index
int colSum(int grid_size_rows, int grid_size_cols, int grid[grid_size_rows][grid_size_cols], int colIndex) {
    int sum = 0;
    for (int i = 0; i < grid_size_rows; i++){
        sum += grid[i][colIndex];
    }
    
    return sum;

}

//int, int, int arr[][] -> int
//Calculates the sum of the top left to bottom right diagonal
int TLBRDiagonalSum(int rowLen, int colLen, int grid[rowLen][colLen]){
	int diagSum = 0;
	for(int i = 0; i < rowLen; i++){
    	diagSum += grid[i][i];
    }
    return diagSum;
}

//int, int, int arr[][] -> int
//Calculates the sum of the top right to bottom left diagonal
int TRBLDiagonalSum(int rowLen, int colLen, int grid[rowLen][colLen]){
	int diagSum = 0;
	int col_index = 0;
	for (int i = (rowLen - 1); i >= 0; i--){
		diagSum += grid[i][col_index];
		col_index++;
	}

	return diagSum;
}

//int, int, int arr[][] -> int
//Returns 1 if a given integer array is a magic square
int isMagicSquare(int rowLen, int colLen, int grid[rowLen][colLen]){
	int TLBRDiagSum = TLBRDiagonalSum(rowLen, colLen, grid);
	int TRBLDiagSum = TRBLDiagonalSum(rowLen, colLen, grid);
	int truthvalue = 0;

	int col_sum = 0;
	int row_sum = 0;
	if ((TRBLDiagSum == TLBRDiagSum) && (rowLen == colLen)){
		for (int i = 0; i < rowLen; i++){
			col_sum += colSum(rowLen, colLen, grid, i);
			row_sum += rowSum(rowLen, colLen, grid, i);
			truthvalue = ((row_sum == col_sum) && (col_sum == TLBRDiagSum) && (row_sum == TLBRDiagSum));
			
			if (truthvalue != 1){
				return 0;
			}

		return 1;
		}
	}

	return 0;
}


int main(){
	int grid1[3][3] = {
		{2, 2, 2},
		{2, 2, 2},
		{2, 2, 2}
	};

	int grid2[4][3] = {
		{2, 2, 2},
		{2, 2, 2},
		{2, 2, 2},
		{2, 2, 2}
	};

	printf("%s\n", "This is a series of tests for grid 1");
	printf("6 == %d\n", colSum(3, 3, grid1, 0));
	printf("6 == %d\n", colSum(3, 3, grid1, 1));
	printf("6 == %d\n", colSum(3, 3, grid1, 2));
	printf("6 == %d\n", rowSum(3, 3, grid1, 0));
	printf("6 == %d\n", rowSum(3, 3, grid1, 1));
	printf("6 == %d\n", rowSum(3, 3, grid1, 2));
	printf("1 == %d\n", isMagicSquare(3, 3, grid1));
	printf("6 == %d\n", TRBLDiagonalSum(3, 3, grid1));
	printf("6 == %d\n\n", TLBRDiagonalSum(3, 3, grid1));

	printf("%s\n", "This is a series of tests for grid 2");
	printf("8 == %d\n", colSum(4, 3, grid2, 0));
	printf("8 == %d\n", colSum(4, 3, grid2, 1));
	printf("8 == %d\n", colSum(4, 3, grid2, 2));
	printf("6 == %d\n", rowSum(4, 3, grid2, 0));
	printf("6 == %d\n", rowSum(4, 3, grid2, 1));
	printf("6 == %d\n", rowSum(4, 3, grid2, 2));
	printf("6 == %d\n", rowSum(4, 3, grid2, 3));
	printf("0 == %d\n", isMagicSquare(4, 3, grid2));
	return 0;
}