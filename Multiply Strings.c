// Given two numbers represented as strings, return multiplication of the numbers as a string.
// Note: The numbers can be arbitrarily large and are non-negative
char* multiply(char* num1, char* num2) {
    int len1, len2;
    int *r_mul;
    char *result;
    int i, j;
    int carry;
    if (!num1 || !num2)
    return "";
    len1 = strlen(num1);
    len2 = strlen(num2);
    if ( (len1 == 1) && (num1[0] == '0')) return "0";
    if ( (len2 == 1) && (num2[0] == '0')) return "0";
    r_mul = (int *)malloc(sizeof(int) * (len1+len2));
    memset(r_mul, 0, sizeof(int) * (len1+len2));
    for( i=len1-1; i>=0; i-- )
        for (j=len2-1; j>=0; j--)
        {
          r_mul[i+j+1] += ((int)num1[i]-48)*((int)num2[j]-48);
        }
    carry = 0;
    for( i=len1+len2-1; i >= 0; i--)
    {
        r_mul[i] += carry;
        carry = r_mul[i] / 10;
        r_mul[i] = r_mul[i] % 10;
    }
    if (r_mul[0] == 0)
    {
        result = (char*)malloc(len1+len2);
        for(i=0; i< len1+len2-1; i++)
        result[i] = r_mul[i+1] + 48;
    } else {
        result = (char*)malloc(len1+len2+1);
        for(i=0; i< len1+len2; i++)
        result[i] = r_mul[i] + 48;
    }
    result[i] = '\0';
    free(r_mul);
    return result;
  }

