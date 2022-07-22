import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class bracketsChecker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Bracket arrayList for checking inputs from user
		// In a function we could add this as parameter to allow to check more than just the parenthesis.
		ArrayList<String> openBrackets = new ArrayList<String>(Arrays.asList("("));
		ArrayList<String> closeBrackets = new ArrayList<String>(Arrays.asList(")"));
		
		Stack<String> stack = new Stack<>();
		
		// Files to be checked for validity
		ArrayList<String> files = new ArrayList<String>(
				Arrays.asList("C:/Users/danie/OneDrive/Documents/interview/Availity/validateParenthesisLisp/parenthesisComplete.lisp",
						       "C:/Users/danie/OneDrive/Documents/interview/Availity/validateParenthesisLisp/parenthesisIncomplete.lisp"));
		
		Scanner scanner = null;
		for(String file: files)
		{
		    Boolean fileValid = true;
		    try
		    {
		    	// Reading file for processing
			    scanner = new Scanner(new File(file));				    
			    scanner.useDelimiter("");		    
		    }
			catch(Exception error)
			{
				System.out.println(error);
			}
			System.out.println(file);
			
			// processing file to check for the correct brackets
			while(scanner.hasNext() && fileValid)
			{
				String bracket = scanner.next();
			
				if(openBrackets.contains(bracket))
				{
					System.out.print(bracket + " ");
					
					stack.add(bracket);
				}
				else if(closeBrackets.contains(bracket))
				{
					System.out.print(bracket + " ");
					
					if(stack.contains(openBrackets.get(closeBrackets.indexOf(bracket)))) 
					{
						stack.pop();
					}
					else
					{
						fileValid = false;
					}		
				}
			}
			
			System.out.println("");
			
			// print results of the file
			if(stack.empty())
				System.out.println("Lisp File Valid" + "\n");
			else
				System.out.println("Lisp File is not Valid" + "\n");
		
			// close file for security and avoidance of error
			scanner.close();

		}
			
	
	}

}
