#include <stdio.h>
#include <math.h>
#include <string.h>
#include <stdlib.h>

int system (const char* command);

int testBinary(int number) // Tests if a number is binary
{
  int nums = number;
  int dv;
  while(nums!=0) {
    dv = nums % 10;
    if (dv > 1)
      return 0;
    nums = nums/10;
  }
  return 1;
}

int AreEqual(char str1[], char str2[]) {  // Checks if two strings are equal
  if (strlen(str1) != strlen(str2)) {
    return 0;
  }
  int i;
  for (i = 0; str1[i] != '\0'; i++) {
    if (str1[i] != str2[i]) {
      return 0;
    }
  }
  return 1;
}

int decimal_binary(int n) {  // Function to convert decimal to binary.
    int rem, i=1, binary=0;
    while (n!=0) {
        rem = n % 2;
        n/=2;
        binary+=rem * i;
        i*=10;
    }
    return binary;
}

int binary_decimal(int n) {  // Function to convert binary to decimal.
    int decimal=0, i=0, rem;
    while (n!=0) {
        rem = n%10;
        n/=10;
        decimal += rem*pow(2,i);
        ++i;
    }
    return decimal;
}

void start() {
  int binary1;
  int binary2;
  char use[100];
  int result;
  char name[100];
  char save[100];
  printf("Enter the file name:\n");
  scanf("%s", name);
  FILE *fp = fopen(name, "r");


  if (fp != NULL) {
    while (fscanf(fp, "%d%d%s", &binary1, &binary2, use) == 3) {
      if ((testBinary(binary1) == 0) || (testBinary(binary2) == 0)) {
        printf("ERROR!\n");
        system("pause");
      } 
      else if ((AreEqual(use, "XOR")) || (AreEqual(use, "OR")) || (AreEqual(use, "AND"))) {
        int convertBinary1 = binary_decimal(binary1);
        int convertBinary2 = binary_decimal(binary2);
        if (AreEqual(use, "XOR")) {
          result = convertBinary1 ^ convertBinary2;
      } 
      else if (AreEqual(use, "OR")) {
        result = convertBinary1 | convertBinary2;
      } 
      else if (AreEqual(use, "AND")) {
        result = convertBinary1 & convertBinary2;
      }
      printf("Save the result/s to:\n");
      scanf("%s", save);
      FILE *ofp = fopen(save, "w");
      fprintf(ofp, "%d\n", decimal_binary(result));
      fclose(ofp);
      } 
      else {
        printf("ERROR!\n");
        system("pause");
      } 
    }
    fclose(fp);
    system(save);
    exit(1);
  } 
  else {
    printf("Can't open file!\n");
    system("pause");
  }
}

int main() {
  start();
  return 0;
}
