#include <stdio.h>
#include <string.h>
#include <math.h>

typedef struct {
	int numerator;
	int denominator;
} Fraction;

int multiplier(float nums) {
	float sthng;
	float difference = nums;
	int num;
	int result = 0;
	int denominator = 10;
	while (difference != 0) {
		sthng = (difference * denominator);
		num = sthng;
		difference = (sthng - num);
		denominator = (pow(denominator, 2));
		result++;
	}
	return result;
}

int maximum(int x, int y) {
	if (x > y) {
		return x;
	} else {
		return y;
	}
	return x;
}

int gcd(int x, int y) {
	int result = 0;
	for (int i = 2; i <= maximum(x, y); i++) {
		if ((x % i == 0) && (y % i == 0) && (i > result)) {
			result = i;
		}
	}
	return result;
}

Fraction lowestTerm(Fraction fraction) {
	int gcdFraction = (gcd(fraction.numerator, fraction.denominator));
	if (gcdFraction != 0) {
		fraction.numerator = (fraction.numerator / gcdFraction);
		fraction.denominator = (fraction.denominator / gcdFraction);
	}
	return (Fraction) {fraction.numerator, fraction.denominator};
}

Fraction decToFraction(float number) {
	float numerator = (number * (pow(10, (multiplier(number)))));
	float denominator = (pow(10, (multiplier(number))));
	Fraction result = {numerator, denominator};
	return (lowestTerm(result));
}

void displayPoint(Fraction f) {
  printf("decimal To Fraction: %d / %d\n", f.numerator, f.denominator);
}

int main () {
	float x = 0.25;
	displayPoint(decToFraction(x));
	return 0;
}