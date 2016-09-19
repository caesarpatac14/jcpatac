#include <stdio.h>

// int -> int
// Checks if a given integer is a prime number.

// stub
// int isPrime(int num) {
//     return 0;
// }

// template
// int isPrime(int num) {
//     int result = 0;
//     for (int i = 2; i <= (num / 2); ++i) {
//         ...
//     }
//     return result;
// }

int isPrime(int num) {
    for (int i = 2; i <= (num / 2); i++) {
        if (num % i == 0) {
            return 0;
        }
    }
    return 1;
}

// int -> int
// Determines if a given integer is a humble number.

// stub
// int isHumble(int num) {
// 	return 0;
// }

// template
// int isHumble(int num) {
// 	return ... num;
// }

int isHumble(int num) {
	int result = 0;
	if (isPrime(num) && (num == 1 || num == 2 || num == 3 || num == 5 || num == 7)) {
		return 1;
	} else {
		for (int x = 2; x <= (num / 2); x++) { 
			if (isPrime(x) && num % x == 0) {
				if (x % 2 == 0 || x % 3 == 0 || x % 5 == 0 || x % 7 == 0) {
					result = 1;
				} else {
					result = 0;
				}
			}
		}
	}
	return result; 
}

int main() {
	printf("Test for isPrime \n");
	printf("Expect 1 \n");
	printf("%d\n", isPrime(2)); // expect 1
	printf("%d\n", isPrime(3));
	printf("%d\n", isPrime(5));
	printf("%d\n", isPrime(7));
	printf("%d\n", isPrime(11));
	printf("%d\n", isPrime(13));
	printf("%d\n", isPrime(17));
	printf("%d\n", isPrime(19));
	printf("%d\n", isPrime(23));
	printf("Expect 0 \n");
	printf("%d\n", isPrime(4));
	printf("%d\n", isPrime(6));
	printf("%d\n", isPrime(8));
	printf("%d\n", isPrime(9));
	printf("%d\n", isPrime(10));
	printf("%d\n", isPrime(12));
	printf("%d\n", isPrime(14));
	printf("%d\n", isPrime(15));
	printf("%d\n", isPrime(16));
	printf("Test for isHumble \n");
	printf("Expect 1 \n");
	printf("%d\n", isHumble(1)); //expect 1
	printf("%d\n", isHumble(2));
	printf("%d\n", isHumble(3));
	printf("%d\n", isHumble(4));
	printf("%d\n", isHumble(5));
	printf("%d\n", isHumble(6));
	printf("%d\n", isHumble(7));
	printf("%d\n", isHumble(8));
	printf("%d\n", isHumble(9));
	printf("%d\n", isHumble(10));
	printf("%d\n", isHumble(12));
	printf("%d\n", isHumble(14));
	printf("%d\n", isHumble(15));
	printf("%d\n", isHumble(16));
	printf("%d\n", isHumble(18));
	printf("%d\n", isHumble(20));
	printf("%d\n", isHumble(21));
	printf("%d\n", isHumble(24));
	printf("%d\n", isHumble(25));
	printf("%d\n", isHumble(27));
	printf("Expect 0 \n");
	printf("%d\n", isHumble(11));
	printf("%d\n", isHumble(13));
	printf("%d\n", isHumble(17));
	printf("%d\n", isHumble(19));
	printf("%d\n", isHumble(22));
	printf("%d\n", isHumble(23));
	printf("%d\n", isHumble(26));
	printf("%d\n", isHumble(29));
	printf("%d\n", isHumble(31));
	printf("%d\n", isHumble(33));
	printf("%d\n", isHumble(34));
	printf("%d\n", isHumble(37));
	printf("%d\n", isHumble(38));
	printf("%d\n", isHumble(39));
	printf("%d\n", isHumble(41));
	printf("%d\n", isHumble(43));
	printf("%d\n", isHumble(44));
	printf("%d\n", isHumble(46));
	printf("%d\n", isHumble(47));
	printf("%d\n", isHumble(51)); //expect 0
	return 0;
}