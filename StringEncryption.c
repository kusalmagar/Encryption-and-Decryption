#include<stdio.h>
  

//using Ceaser Cypher Algorithm to encrypt and decrypt string
char encryption(char str[100])
{
    for( int i = 0; (i <100 && str[i] != '\0'); i++)
    {
        str[i] = str[i] + 3;   //the key for encryption is 3 that is added to ASCII value
    }
    return *str;
}
char decryption(char str[100])
{
    for(int i =0; (i < 100 && str[i] != '\0'); i++)
    {
        str[i] = str[i] - 3;  //the key decryption is 3 that is subtracted to ASCII value
    }
    return *str;
}
int main()
{
    // int i;
    char str[100];
    printf("Enter the message that is to be encrypted \n");
    gets(str);   //this method is unsafe
    // scanf("%s", &*str);   // characters after the space is not scanned
    printf("the message for  encryption is %s \n",str);
    encryption(str);
    printf(" \nthe message after encryption is %s \n",str);
    decryption(str);
    printf(" \nthe message after decryption is %s \n",str);
    return 0;

}