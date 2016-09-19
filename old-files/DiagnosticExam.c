#include <stdio.h>
#include <string.h>

// 1

int Multiple3And5(int n) {
	int integer = n;
	while (integer % 3 != 0 || integer % 5 != 0) {
		integer--;
	}
	return integer;
}

// 2

int AreEqual(char str1[], char str2[]) {
	if (strlen(str1) != strlen(str2)) {
		return 0;
	}
	for (int i = 0; str1[i] != '\0'; i++) {
		if (str1[i] != str2[i]) {
			return 0;
		}
	}
	return 1;
}

// 3

int IsFound(int arr[], int length, int n) {
	for (int i = 0; i <= length; i++) {
		if (arr[i] == n) {
			return 1;
		}
	}
	return 0;
}

// 4

int SumOfCubes(int n) {
	int result = 0;
	for (int i = 1; i <= n; i++) {
		result = result + (i * i * i);
	}
	return result;
}

// 5

int ArrayFound(float arr1[], int length1, float arr2[], int length2) {
	for (int i = 0; i < length1; i++) {
		int there = 0;
		for (int j = 0; j < length2; j++) {
			if (arr1[i] == arr2[j]) {
				there = 1;
			}
		}
		if (!there) {
			return 0;
		}
	}
	return 1;
}


int main () {

	char string1[] = "Curry";
	char string2[] = "Curry";
	char string3[] = "Stephen";
	int array1[] = {1, 2, 3, 4, 5};
	float array2[] = {1.0, 2.0, 3.0};
	float array3[] = {2.0, 1.0};
	float array4[] = {1.0, 2.1, 4.1, 5.0};
	float array5[] = {3.0, 1.0, 2.0};

	printf("Test for Multiple3And5\n");
	printf("%d\n", Multiple3And5(21));
	printf("%d\n", Multiple3And5(199));
	printf("%d\n", Multiple3And5(0));
	printf("%d\n", Multiple3And5(45));
	printf("%d\n", Multiple3And5(102));
	printf("%d\n", Multiple3And5(12));
	printf("Test for AreEqual\n");
	printf("%d\n", AreEqual(string1, string2));
	printf("%d\n", AreEqual(string1, string3));
	printf("%d\n", AreEqual(string2, string3));
	printf("Test for IsFound\n");
	printf("%d\n", IsFound(array1, 5, 3));
	printf("%d\n", IsFound(array1, 5, 6));
	printf("Test for SumOfCubes\n");
	printf("%d\n", SumOfCubes(0));
	printf("%d\n", SumOfCubes(1));
	printf("%d\n", SumOfCubes(2));
	printf("%d\n", SumOfCubes(3));
	printf("%d\n", SumOfCubes(4));
	printf("Test for ArrayFound\n");
	printf("%d\n", ArrayFound(array2, 3, array3, 2));
	printf("%d\n", ArrayFound(array3, 2, array2, 3));
	printf("%d\n", ArrayFound(array2, 3, array4, 4));
	printf("%d\n", ArrayFound(array3, 2, array4, 4));
	printf("%d\n", ArrayFound(array2, 3, array5, 3));
	return 0;
}