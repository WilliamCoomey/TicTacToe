import java.util.Scanner;

public class Main
{
	static char[][] map = new char[3][3];
	static Scanner k = new Scanner(System.in);
	
	public static void main(String args[])
	{
		fillMap();
		for(int i=0;i<9;i++)
		{
			printMap();
			getInput();
		}
		printMap();
		
		System.out.println("\nIt's a tie\nGame Over");
	}
	
	public static void insertInMap(int x, int y, char value)
	{
		map[y][x] = value;
		checkLocation(x, y, value);
	}

	public static void fillMap()
	{
		for(int y=0;y<map.length;y++)
			for(int x=0;x<map.length;x++)
				insertInMap(x, y, '_');
	}
	
	public static void printMap()
	{
		System.out.println("\n  -------------");
		System.out.println("  |_0_|_1_|_2_|");
		for(int y=0;y<map.length;y++)
		{
			System.out.print(y+" |");
			for(int x=0;x<map[y].length;x++)
			{
				System.out.print(" "+map[y][x]+" |");
			}
			System.out.println();
		}
		System.out.println("  -------------");
	}
	
	public static void getInput()
	{
		int x, y;
		char value;
		char[] validChars = {'x','o'};
		
		System.out.print("\nEnter the X cords: ");
		x = getIntWithLimits(0, 2);
		
		System.out.print("Enter the Y cords: ");
		y = getIntWithLimits(0, 2);
		
		System.out.print("Enter the value(x/o): ");
		value = getSpecficChars(validChars);
		
		insertInMap(x, y, value);
	}
	
	public static int getIntWithLimits(int lowerLimit, int upperLimit)
	{
		int num = -1;
		boolean valid = false;
		
		if(upperLimit < lowerLimit)
		{
			System.err.println("Upper limit must be greater than lower limit");
			return -1;
		}
			
		while(!valid)
		{
			try
			{
				num = k.nextInt();
				
				if(num >= lowerLimit && num <= upperLimit)
					valid = true;
				else
					System.out.print("Input must be between "+lowerLimit+" and "+upperLimit+"\nTry again: ");
			}
			catch(Exception e)
			{
				System.out.print("Input must be an Integer\nTry again: ");
			}
			
			k.nextLine();
		}
		
		
		return num;
	}
	
	public static char getSpecficChars(char[] validChars)
	{
		String input;
		char returnValue = (char) -1;
		
		while(true)
		{
			input = k.nextLine();
			
			if(!input.isEmpty())
			{
				returnValue = input.charAt(0);
				
				for(char validChar : validChars)
				{
					if(returnValue == validChar)
					{
						return returnValue;
					}
				}
				
				System.out.print("Input was not a recognised character\nTry again: ");
			}
			else
				System.out.print("Input is not valid\nTry again: ");
		}
	}
	

	
	public static void checkLocation(int x, int y, char value)
	{
		if(value != '_')
		{
			checkRow(x, y, value);
			checkColumn(x, y, value);
			checkDiagonal(x, y, value);
		}
	}
	
	public static void checkRow(int x, int y, char value)
	{
		if(x == 0)
		{
			if(map[y][x+1] == value && map[y][x+2] == value)
				System.out.println("Right row");
		}
		else if(x == 2)
		{
			if(map[y][x-1] == value && map[y][x-2] == value)
				System.out.println("Left row");
		}
		else if(x == 1)
		{
			if(map[y][x-1] == value && map[y][x+1] == value)
				System.out.println("Middle row");
		}
	}
	
	public static void checkColumn(int x, int y, char value)
	{
		if(y == 0)
		{
			if(map[y+1][x] == value && map[y+2][x] == value)
				System.out.println("Down column");
		}
		else if(y == 2)
		{
			if(map[y-1][x] == value && map[y-2][x] == value)
				System.out.println("Up column");
		}
		else if(y == 1)
		{
			if(map[y-1][x] == value && map[y+1][x] == value)
				System.out.println("Middle column");
		}
	}
	
	public static void checkDiagonal(int x, int y, char value)
	{
		if(x == 0 && y == 0)
		{
			if(map[y+1][x+1] == value && map[y+2][x+2] == value)
				System.out.println("Bottom-right diagonal");
		}
		else if(x == 0 && y == 2)
		{
			if(map[y-1][x+1] == value && map[y-2][x+2] == value)
				System.out.println("Top-right diagonal");
		}
		else if(x == 2 && y == 0)
		{
			if(map[y+1][x-1] == value && map[y+2][x-2] == value)
				System.out.println("Bottom-left diagonal");
		}
		else if(x == 2 && y == 2)
		{
			if(map[y-1][x-1] == value && map[y-2][x-2] == value)
				System.out.println("Top-left diagonal");
		}
		else if(x == 1 && y == 1)
		{
			if(map[y-1][x-1] == value)
			{
				if(map[y+1][x+1] == value)
					System.out.println("Middle-left diagonal");
			}
			else if(map[y-1][x+1] == value)
			{
				if(map[y+1][x-1] == value)
					System.out.println("Middle-right diagonal");
			}
		}
	}
}


















