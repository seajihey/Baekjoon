#include <stdio.h>
#include <stdlib.h>

int main() {
	int score[1000];
	int size;
	int max=0;
	double sum = 0;
	scanf("%d", &size);

	for (int i = 0; i < size; i++) {
		scanf("%d", &score[i]);
	}

	for (int i = 0; i < size; i++) {
		if (max < score[i]) {
			max = score[i];
		}
	}

	for (int i = 0; i < size; i++) {
		sum += (double)score[i] / max * 100;
	}
	printf("%lf", sum / size);
	return 0;
	
}

