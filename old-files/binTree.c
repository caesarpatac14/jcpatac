#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

typedef struct BinTree {
  char name[10];
  int value;
  struct BinTree* left;
  struct BinTree* right;
} BinTree;

bool isMember(BinTree* root, char name[]) {
	if (root == NULL) {
		return false;
	}else {
		bool leftCompare = isMember((root->left), name);
		bool rightCompare = isMember((root->right), name);
		return (leftCompare || rightCompare || (strcmp((root->name), name) == 0));
	}
}

int salesMoreThan(BinTree* root, int sales) {
    if (root == NULL) {
    	return 0;
    }else {
    	int count = 0;
    	if ((root->value) > sales) {
    		count += 1;
    	}
    	int countLeft = salesMoreThan((root->left), sales);
    	int countRight = salesMoreThan((root->right), sales);
    	return (count + countRight + countLeft);
    }
}

bool allNull(BinTree* nothing) {
	return ((nothing->left == NULL) && (nothing->right == NULL));
}

void displayNoRecruits(BinTree* root) {
	if (root == NULL) {
		// do nothing
	}else {
		if (allNull(root) == true) {
			printf("%s\n", root->name);
		}
		displayNoRecruits(root->left);
		displayNoRecruits(root->right);
	}
}

int main() {
    BinTree jean = {"Jean", 24, NULL, NULL}; 
    BinTree jeane = {"Jeane", 27, NULL, NULL}; 
    BinTree icel = {"Icel", 10, NULL, NULL}; 
    BinTree candace = {"Candace", 48, &jean, &jeane}; 
    BinTree lovely = {"Lovely", 9, &icel, NULL}; 
    BinTree honey = {"Honey", 40, &lovely, NULL}; 
    BinTree jj = {"JJ", 3, &honey, &candace}; 

    printf("%d\n", isMember(&jj, "Icel"));
    printf("%d\n", isMember(&jj, "George"));

    printf("%d\n", salesMoreThan(&jj, 30));
    printf("%d\n", salesMoreThan(&jj, 20));
    printf("%d\n", salesMoreThan(&jj, 50));
    printf("%d\n", salesMoreThan(&jj, 1));
    
    displayNoRecruits(&jj);

    return 0;
}