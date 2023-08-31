#include <stdio.h>
int main()
    {
        for(int i = 0; i <10; i++){
            printf("%d \n", i);
        };

        int number;
   
        printf("Enter an integer: ");  
        
        // reads and stores input
        scanf("%d", &number);

        // displays output
        printf(": %d\n", number);
        

        return 0;
    }