#include <stdio.h>
#include <math.h>

int decimal_binary(int n) {
    int rem;
    int i = 1;
    int binary = 0;
    while (n != 0) {
        rem = n % 2;
        n /= 2;
        binary += rem * i;
        i *= 10;
    }
    return binary;
}

int decimal_octal(int n) {
    int rem;
    int i = 1;
    int binary = 0;
    while (n != 0) {
        rem = n % 8;
        n /= 8;
        binary += rem * i;
        i *= 10;
    }
    return binary;
}

int decimal_hexa(int n) {
    int rem;
    int i = 1;
    int binary = 0;
    while (n != 0) {
        rem = n % 16;
        n /= 16;
        binary += rem * i;
        i *= 10;
    }
    return binary;
}

int binary_decimal(int n) {
    int  rem;
    int decimal = 0;
    int i = 0;
    while (n != 0) {
        rem = n % 10;
        n /= 10;
        decimal += rem * pow(2, i);
        i++;
    }
    return decimal;
}

int octal_decimal(int n) {
    int  rem;
    int decimal = 0;
    int i = 0;
    while (n != 0) {
        rem = n % 10;
        n /= 10;
        decimal += rem * pow(8, i);
        i++;
    }
    return decimal;
}

int bitWise(int binary1, int binary2) {
	return binary1 ^ binary2;
}

int main() {
	printf("binary: %d\n", decimal_binary(31));
 //    printf("hexa: %d\n", decimal_hexa(16));
 //    printf("octal: %d\n", decimal_octal(8));
	// printf("decimal: %d\n", octal_decimal(765));
	// printf("bitwise: %d\n", bitWise(5, 107));
	return 0;
}
