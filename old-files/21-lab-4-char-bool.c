#include <stdio.h>

int isRetired(int age) {
	return (age >= 65);
}

int isAcid(float phLevel) {
	return (phLevel <= 7);
}

int isTeenager(int age) {
	return ((age >= 13) && (age <= 19));
}

int isEven(int x) {
	return (x % 2 == 0);
}

int isMultipleOf10(int x) {
	return (x % 10 == 0);
}

int isVowel(char letter) {
	return (letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U');
}

int isConsonant(char letter) {
	return !(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u' || letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U');
}

char toUpper(char letter) {
	if ('a' <= letter && letter <= 'z') {
		return letter - 32;
    }
    
    return letter;
}

char toLower(char letter) {
	if ('A' <= letter && letter <= 'Z') {
		return letter + 32;
    }
  	
  	return letter;
}

int toInt(char number) {
	if (number >= '0' && number <= '9') {
		return number - 48;
	}

	return -1;
}

char toChar(int number) {
	if (toInt('0') <= number && number <= toInt('9')){
		return number + 48;
	}

	return '\0';
}


int main() {
	printf("%d\n", isConsonant('E'));
	printf("%c\n", toChar(9));
	printf("%d\n", toInt('2'));
	return 0;
}