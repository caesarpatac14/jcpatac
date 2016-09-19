#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>


// You can create additional functions if needed.
#define PASSING_SCORE 60

typedef struct LinkedList
{
	char name[10];
	int value;
	struct LinkedList* rest;
} LinkedList;

// must be a recursive solution
int maximum(LinkedList* head) {
	if (head == NULL) {
		return 0;
	}else {
		int maxHead = 0;
		if (head->value >= maxHead) {
			maxHead = (head->value);
		}
		int maxRest = maximum(head->rest);
		return fmax(maxHead, maxRest);
	}
}

char firstChar(char word[]) {
  return word[0];
}

// must be a recursive solution
void printPalindromeOfFirstLetters(LinkedList* head) {
	if (head == NULL) {
		//do nothing
	}else {
		printf("%c", firstChar(head->name));
		printPalindromeOfFirstLetters(head->rest);
		printf("%c", firstChar(head->name));
	}
}

int numPassers(LinkedList* head) {
	if (head == NULL) {
		return 0;
	}else {
		int count = 0;
		if ((head->value) >= PASSING_SCORE) {
			count += 1;
		}
		int countRest = numPassers(head->rest);
		return (count + countRest);
	}    
}

int totalScoresOfPassers(LinkedList* head) {
	if (head == NULL) {
		return 0;
	}else {
		int sum = 0;
		if ((head->value) >= PASSING_SCORE) {
			sum += (head->value);
		}
		int sumRest = totalScoresOfPassers(head->rest);
		return (sum + sumRest);
	}
}

// not necessary a recursive solution
int averageScoreOfPassers(LinkedList* head) {
	return (totalScoresOfPassers(head) / numPassers(head));
}

int main() {
    LinkedList cris = {"Cris", 61, NULL};
	LinkedList ivan = {"Ivan", 55, &cris};
	LinkedList vic = {"Vic", 60, &ivan};
	LinkedList iris = {"Iris", 59, &vic};
	LinkedList carl = {"Carl", 70, &iris};
    
    printf("%d\n", maximum(&carl));

	printPalindromeOfFirstLetters(&carl);
	
	printf("\n");

	printf("%d\n", numPassers(&carl));
	printf("%d\n", totalScoresOfPassers(&carl));
	printf("%d\n", averageScoreOfPassers(&carl));
}