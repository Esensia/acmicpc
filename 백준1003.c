#include<stdio.h>
#include<stdlib.h>
#include<string.h>


int main() {
	int n,i, j, k;
	
	scanf("%d", &n);
	
	int fibo[41];

	fibo[0] = 0;
	fibo[1] = 1;
	
	for (i = 2; i <= 40; i++) {
		fibo[i] = fibo[i - 2] + fibo[i - 1];
	
	}

	for (j = 0; j < n; j++) {
		scanf("%d", &k);
		if (k == 0) {
			printf("%d %d\n",fibo[1],fibo[0]);
		}
		else { printf("%d %d\n", fibo[k-1], fibo[k]); }

	}
	return 0;
}
