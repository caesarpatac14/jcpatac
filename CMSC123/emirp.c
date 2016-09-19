#include <stdio.h>
#include <stdbool.h>

int system (const char* command);

bool isPrime(int n) {
	for (int i = 2; i <= n / 2; i++) {
		if (n % i == 0) {
			return false;
		}
	}
	return true;
}

int multiplier(int n) {
	int count = 1;
	int num = n;
	while (num > 10) {
		num /= 10;
		count *= 10;
	}
	return count;
}

int reverse(int n) {
	if (n < 10) {
		return n;
	}else {
		int sthng = (n % 10);
		int result1 = (sthng * multiplier(n));
		n = (n / 10);
		int result2 = reverse(n);
		return result1 + result2;
	}
}

bool isEmirp(int n) {
	if (isPrime(n)) {
		if (isPrime(reverse(n))) {
			return true;
		}
	}
	return false;
}

int main() {
	// printf("%d\n", isPrime(23));
	printf("%d\n", isEmirp(4));
	// printf("%d\n", reverse(123));
	return 0;
}