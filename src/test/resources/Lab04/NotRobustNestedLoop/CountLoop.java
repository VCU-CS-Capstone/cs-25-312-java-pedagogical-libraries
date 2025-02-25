/* Algorithm
create scanner
ask user for input number
int countTo = input.nextInt()
int count = 0
int num = 1

while (num <= countTo)
	count = count + num
	num++
print count

do
	count = count + num
	num++
while (num <=countTo)
	
for (count = 0; num <= countTo; num++)
	count = count + num
*/
import java.util.Scanner;
public class CountLoop{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		//Enter user input
		System.out.println("Enter a number");
		int countTo = input.nextInt();
		
		//Initialize count and starting number
		int count = 0;
		int num = 1;
		
		while (num <= countTo){
			//Adding current number to the previously counted numbers
			count = count + num;
			//Incrementing number by 1
			num++;
		}
		//Output sum of all numbers
		System.out.println(count);
		
		//Initialize count and starting number
		count = 0;
		num = 1;
		
		do {
			//Adding current number to the previously counted numbers
			count = count + num;
			//Incrementing the number by 1
			num++;
		} while (num <= countTo);
		//Output sum of all numbers
		System.out.println(count);
		
		//Initalize starting number
		num = 1;
		
		for (count = 0; num <= countTo; num++){
			//Adding current number to the previously counted numbers
			count = count + num;
			
		}
		//Output sum of all numbers
		System.out.println(count);
	}
}