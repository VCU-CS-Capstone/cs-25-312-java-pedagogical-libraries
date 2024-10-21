/* Algorithm
first triangle
for (int row = 1; row <= 10; row ++)
	print "*"
use println so that each row is printed as its own
second triangle
for (int row = 1; row <= 10; row++) 
	for (int space = 1; space <= (10 - row); space++)
		print " "
	for (int length = 1; length <= (row * 2) - 1; length++)
		use (row * 2) - 1 to increment length of each row by odd numbers
		print "*"
use println so that each row is printed as its own
	

*/
public class NestedLoopTriangle {
	public static void main(String[] args) {	
		
		//Loop for amount of rows
		for (int row = 1; row <= 10; row++){
			//Nested loop for length (how many *'s) of each row
			for (int length = 1; length <= (row * 2) - 1; length++){
				//Printing each * for row
				System.out.print("*");
			}
			System.out.println();
			//Ensures that each row is printed on its own line
		}
		
		//Loop for amount of rows
		for (int row = 1; row <= 10; row ++){
			//Nested loop for amount of spaces at beginning of each row
			for (int space = 1; space <= (10 - row); space++){
				//Printing spaces for each row
				System.out.print(" ");
			}
				//Nested loop for length (how many *'s) of each row
				for (int length = 1; length <= (row * 2) - 1; length++){
					//Printing each * for row
					System.out.print("*");
				}
		//Ensures that each row is printed on its own line
		System.out.println();
			
		}
	}
}