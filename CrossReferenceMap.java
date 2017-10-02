
import java.io.*;
import java.util.*;

public class CrossReferenceMap {

	public static void main(String [] args)
	{

//		if (args.length != 1)
//		{
//			System.out.println("Usage: java CrossMapReference <filename>");
//		    System.exit(1);
//    	}

    	

    	BufferedReader source;

		String line;
		String reservedWords[] = {"abstract", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "extends", "false", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "null", "operator", "package", "private", "protected", "public", "rest", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "true", "try", "void", "volatile", "while"};
		int lineNo = 1;
		LinkedList listsList = new LinkedList();
		LinkedList lineList;
		BinarySearchTree tree = new BinarySearchTree(listsList);
		boolean reserved = false;
		String line2;
		//LinkedList interimList;

		// other variables : to be defined by you!
        //     ....
        //     ....

		try
		{
			source = new BufferedReader(new FileReader("Test.java"));
			line = source.readLine();

			while ( line != null)
			{
				line = line.replace("\"", "`");
				//System.out.println(line);
				StringTokenizer st1 = new StringTokenizer(line," .,;()[]{}+-*/!=<>\t'");
				while (st1.hasMoreTokens())
				{
			       String s1 = st1.nextToken();

			       if(s1.startsWith("`") == false)
			       {
				       for (int i=0; i<reservedWords.length; i++)
				       {
				    	   if ( s1.equals(reservedWords[i]) )
				    		   reserved = true;
				       }
				       
				       if(reserved == false)
				       {
				    	   if( tree.search(s1) == false )
				    		  {
				    		   lineList = new LinkedList();
				    		   lineList.addToHead(s1);
				    			   
				   			   listsList.addToHead(lineList);
	
				   			   tree.insert(s1);
				    		   }
				    		   
				    	   ListNode current = listsList.getHead();
				    	   while(current != null)
				    	   {
				    		   LinkedList node = (LinkedList)current.getData();
				   			   if( node.getHead().getData().equals(s1) )
				   				   node.addToTail(lineNo);
				   			   current = current.getNext();
				   		   }
				    		
				       }
				       reserved = false;
			       }
				}
				//reserved = false;
				lineNo++;
     			line = source.readLine();
			}
			source.close();
		}
		catch ( IOException iox )
	    {
			System.out.println(iox);
	        System.out.println("Problem encountered in reading file!" );
	    }

		System.out.print("Cross Map Reference :- \n");

		tree.inorder();
		//  retrieve and print out each identifier together with the line numbers
		//  to be completed by you!
		//   ....
		//   ....

	}
	
}  // end of class