#include <stdio.h>
#include <stdbool.h>

typedef struct {
  int numerator;
  int denominator;
} Fraction;

int LCM(int x, int y) {
  int result = (x * y);
  for (int i = x; i < (x * y); i++) {
    if ((i % x == 0) && (i % y == 0)) {
      return i; 
    }
  }
  return result;
}

int maximum(int x, int y) {
  if (x > y) {
    return x;
  }else {
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

Fraction lowestTerm(Fraction f) {
  int gcdFraction = (gcd(f.numerator, f.denominator));
  if (gcdFraction != 0) {
    f.numerator = (f.numerator / gcdFraction);
    f.denominator = (f.denominator / gcdFraction);
  }
  return (Fraction) {f.numerator, f.denominator};
}

Fraction addFractions(Fraction f1, Fraction f2) {
  int LCMFraction = (LCM(f1.denominator, f2.denominator));
  f1.numerator = (((f1.numerator * LCMFraction) / f1.denominator) + ((f2.numerator * LCMFraction) / f2.denominator));
  f1.denominator =  LCMFraction;
  return lowestTerm((Fraction) {f1.numerator, f1.denominator});
}

Fraction subtractFractions(Fraction f1, Fraction f2) {
  int LCMFraction = (LCM(f1.denominator, f2.denominator));
  f1.numerator = (((f1.numerator * LCMFraction) / f1.denominator) - ((f2.numerator * LCMFraction) / f2.denominator));
  f1.denominator =  LCMFraction;
  return lowestTerm((Fraction) {f1.numerator, f1.denominator});
}

Fraction multiplyFractions(Fraction f1, Fraction f2) {
  f1.numerator = (f1.numerator * f2.numerator);
  f1.denominator = (f1.denominator * f2.denominator);
  return lowestTerm((Fraction) {f1.numerator, f1.denominator});
}

Fraction divideFractions(Fraction f1, Fraction f2) {
  f1.numerator = (f1.numerator * f2.denominator);
  f1.denominator = (f1.denominator * f2.numerator);
  return lowestTerm((Fraction) {f1.numerator, f1.denominator});
}

void displayPoint(Fraction f) {
  printf("addFractions: %d %d\n", f.numerator, f.denominator);
}

int main () {
  Fraction f;
  f.numerator = 2;
  f.denominator = 4;
  Fraction g;
  g.numerator = 1;
  g.denominator = 3;
  printf("f: %d %d\n", f.numerator, f.denominator);
  printf("%d\n", gcd(4, 8));
  printf("%d\n", LCM(2, 4));
  displayPoint(divideFractions(f, g));
  return 0;
}