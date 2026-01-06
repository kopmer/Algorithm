import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st = br.readLine();
		Stack<Character> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		boolean isIn = false;
		for(char c : st.toCharArray()) {
			if(c == ' ') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				sb.append(" ");
			}
			else if(c == '<') {
				while(!stack.isEmpty()) {
					sb.append(stack.pop());
				}
				isIn = true;
				sb.append("<");
			}
			else if(c == '>') {
				isIn = false;
				sb.append(">");
			}
			else {
				if(isIn) {
					sb.append(c);
				}
				else {
					stack.add(c);
				}
				
			}
		}
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		System.out.println(sb);
	}

}
