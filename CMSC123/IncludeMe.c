#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <stdbool.h>

int system (const char* command);

FILE* sfp; 


void printFile(char* file) {
	char search[] = "#include";
	char save[200];
	char line[200];
	FILE* ofp = fopen(file, "r");
	if (ofp) {
		while (fgets(save, 250, ofp) != NULL) {
			sscanf(save, "%s", line);
			if (strstr(line, search) == NULL) {
				fprintf(sfp, "%s", save);
			}
		}
	}
	fclose(ofp);
}


void found(char* file) {
	char line[200];
	//int length;
	FILE *ofp = fopen(file, "r");
	char search_string[]="#include";
	char *subString; // the "result"

	if (!ofp) {
		perror("File not found");
		exit(1);
	}
	while (fgets(line, 200, ofp) != NULL) {
		if (strstr(line, search_string) == NULL) {
			printFile(file);
			fprintf(sfp, "\n\n");
			break;
		}else {
			subString = strtok(line,"\"");
			subString = strtok(NULL,"\"");
			found(subString);
		}
	}
	fclose(ofp);
}

int main() {
	sfp = fopen("outputFile.out", "w");
	found("inputFile.c");
	fclose(sfp);
	return 0;
}