  #include <stdio.h>

// char -> char
// Capitalizes the given character
char toUpper(char letter) {
  if ('a' <= letter && letter <= 'z') {
    // return letter - ('a' - 'A');
    return letter - 32;
  } else {
    return letter;
  }
}

void capitalize(char letters[]) {
  for (int i = 0; letters[i] != '\0'; i++) {
    letters[i] = toUpper(letters[i]);
  }
}

void titleCase(char phrase[]) {
  char prev = ' ';
  for (int i = 0;  phrase[i] != '\0'; i++) {
    if (prev == ' ' && phrase[i] != ' ') {
      phrase[i] = toUpper(phrase[i]);
    }
    prev = phrase[i];
  }
}

int main() {
  char letter = 'a';
  char b = letter + 1;

  /* printf("%c\n", letter); */
  /* printf("%c\n", b); */
  /*  */
  /* printf("%c == %c\n", toUpper('a'), 'A'); */
  /* printf("%c == %c\n", toUpper('z'), 'Z'); */
  /* printf("%c == %c\n", toUpper('Z'), 'Z'); */

  char letters[5] = {'a', 'b', 'c', 'd', 'e'};

  for (int i = 0; i < 5; i++) {
    printf("%c ", letters[i]);
  }
  printf("\n");

  //long way to declare and initialize a string
  //char string[8] = {'a', 'b', 'c', ' ', 'h', 'e', 'f', '\0'};

  char string[] = "string literals are surrounded by double quotes";
  //         ^ length can be optionally omitted because it's
  //          implied from the length of the string literal;
  //          if omitted, array length will be length of literal + 1
  //          (what's the +1 for?)
  //
  //          A '\0' is automatically inserted at the end of the literal

  printf("%s\n", string);

  titleCase(string);
  printf("%s == %s\n", string, "String Literals Are Surrounded By Double Quotes");

  capitalize(string); 
  printf("%s == %s\n", string, "STRING LITERALS ARE SURROUNDED BY DOUBLE QUOTES");

  return 0;
}
