#include <stdio.h>
#include <string.h>
typedef struct _contact {
	char name[20];
	char phone[20];
}contact;
void main() {

	contact ct[100];
	char surf[20];
	int num = 0;
	
	while (1) {
		printf("검색할 이름 : ");
		scanf("%s", &surf);
		if (!strcmp(surf, "."))
			break;
		int checker = 0;
		
		for (int i = 0; i < num; i++) {
			if (!strcmp(surf, ct[i].name)) {
				checker = 1;
				printf("찾은 전화번호 : %s\n", ct[i].phone);
				break;
			}
		}
		
		if (checker == 0) {
			
			printf("저장되지 않은 연락처입니다. 저장하시겠습니까? (Y/N) : ");
			char yn[20];
			char yes[] = "y";
			scanf("%s", &yn);
			
			if (!strcmp(yn,yes)) {
				strcpy(ct[num].name, surf);
				printf("전화번호 입력 : ");
				char phone[20];
				scanf("%s", &phone);
				strcpy(ct[num].phone, phone);
				num++;
			}
			else {

			}
		}
		printf("\n");
	}
}