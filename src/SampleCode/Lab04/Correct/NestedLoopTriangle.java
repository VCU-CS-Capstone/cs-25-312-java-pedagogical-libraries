public class NestedLoopTriangle{
	public static void main(String[] args){
	
	//height variable, can be changed to any number to make a triangle of that height
	int height = 10; 
	//loop prints 1 right triangle of 'height' lines tall
	for(int i = 1; i <= height; i++)
	{
		for(int j = 1; j <= i * 2 - 1; j++)
		{
			System.out.print("*"); 
		}
		System.out.println("");
	}
	
	//loop utilizes a second nested for loop to print height - i number of spaces before stars, making a pyramid shape 
	for(int i = 1; i <= height; i++)
	{
		for(int s = height - i; s > 0; s--)
		{
			System.out.print(" "); 
		}
		for (int j = 1; j <= (2 * i - 1); j++) //2 * i - 1 causes in increase of 2 stars being printed on the next line, and allows the pyramid shape to be symetrical. 
		{                                      //ex: if I is 1, the loop will run untill j is more than i. 1 star is printed because j and i = 1. when i is 2. the loop will end when j <= 3, printing 3 stars and so on 
                System.out.print("*");
		}
		System.out.println("");
	}
	
	}
}