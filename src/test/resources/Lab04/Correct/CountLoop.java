import java.util.Scanner;
public class CountLoop{
	public static void main(String[] args){
	
	Scanner input = new Scanner(System.in); 
	int n = input.nextInt(); 
	int sum = 0; 
	//for loop totaling numbers 1 - n
	for(int i = 1; i <= n; i++)
	{
		sum += i; 
	}
	System.out.println(sum);
	
	sum = 0;//reset variables
	int count = 1;
	//while loop totaling numbers 1 - n
	while(count <= n) 
	{
		sum += count; 
		count++; 
	}
	System.out.println(sum);
	
	sum = 0;//reset variables
	count = 1; 
	//do while loop totaling numbers 1 - n
	do{
		sum += count; 
		count++;
	} while(count <= n); 
	System.out.println(sum);
	
	}//sum always adds count to itself first so that the initial value of count, 1, will be added, and so that the first thing that happens after count iterates is checking if count is <= to n, preventing an extra number being added
}
	