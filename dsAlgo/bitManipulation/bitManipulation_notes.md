### Notes

1. Kernighans algo
`
int count=0;
while(n!=0) {
    int rsbm = n & -n;	//right most set bit 
    n -= rsbm;	//subtract rsbm from N
    count++;	//increase the count of 1s for that number.
}

2. position of rightmost set bit = `log(n & -n, 2) + 1` 
3. rightmost set bit = `rsbm = n & -n`
4. print binary form of a decimal number: 
	`Integer.toBinaryString(num)`
5. 