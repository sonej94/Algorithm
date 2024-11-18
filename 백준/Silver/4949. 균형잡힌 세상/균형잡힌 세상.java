import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringBuilder sb = new StringBuilder();
       String line;
       
       while( !(line = br.readLine()).equals(".") ){
    	   
    	   if( isBalance(line) ) {
    		   sb.append("yes\n");
    	   }else {
    		   sb.append("no\n");
    	   }
    	   
       }
 
        System.out.println(sb);
    }
    
    public static boolean isBalance(String str) {
    	
    	Stack<Character> stack = new Stack<>();
    	
    	for(char ch : str.toCharArray()) {
    		
    		if(ch == '(' || ch == '[') {
    			stack.push(ch);
    			
    		}else if( ch == ')' ) {
    			
    			if(stack.isEmpty() || stack.peek() != '(' ){
    				return false;
    			}
    			stack.pop();
    			
    		} else if (ch == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false; 
                }
                stack.pop(); 
            }
    	}
    	
    	return stack.isEmpty();
    }
}
