#include <stdio.h>

void bubbleSort(int arr[], int length) {
	int prev;
	for (int i = 0; i < length; i++) {
		for (int j = 0; j < (length - i - 1); j++) {
			if (arr[j] > arr[j + 1]) {
				prev = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = prev;
			}
		}
	}
}

void selectionSort(int arr[], int length) {
	int prev;
	int j;
	for (int i = 0; i < length; i++) {
		prev = arr[i];
		j = (i - 1);
		while (j >= 0 && prev < arr[j]) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = prev;
	}
}

void printArray(int arr[], int length) {
  for (int i = 0; i < length; i++) {
    printf("%d ", arr[i]);
  }
  printf("\n");
}
	

int main() {
	int nums[] = {1, 3, 2, 4, 5};
	bubbleSort(nums, 5);
	// selectionSort(nums, 4);
	printArray(nums, 5);
	return 0;
}