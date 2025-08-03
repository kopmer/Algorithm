import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
	static char[] arr; // 괄호들 저장할 char배열
	static Stack<Character> stack; //괄호 스택
	static boolean correct; // 유효함
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int testCase = 1;testCase <= 10; testCase++) {
			int stLen = Integer.parseInt(br.readLine()); // 테스트케이스 길이 입력
			String st = br.readLine(); // 테스트케이스 입력
			
			arr = new char[stLen]; 
			arr = st.toCharArray();//"()" -> char배열 생성{'(' , ')'...}
			
			stack = new Stack<Character>();
			correct = true; //유효함 default true
			
			for(int i = 0;i < stLen;i++) {
				char word = arr[i];
				//여는 괄호면 스택에 추가
				if(word == '(' || word == '{' || word == '[' || word == '<') {
					stack.add(word);
				}
				
				else {
					//닫는 괄호가 나왔는데 스택이 비어있으면 유효하지 않음
					if(stack.isEmpty()) {
						correct = false;
						break;
					}
					// 유효하면 stack pop, 유효하지 않으면 correct = false
					isEqual(stack.peek(),word);
				}
				// 유효하지 않으면 반복문 탈출
				if(correct == false) {
					break;
				}
			}
			if(correct) {
				System.out.println("#"+testCase+" 1");
			}
			else {
				System.out.println("#"+testCase+" 0");
			}
		}
	}
	static public boolean isEqual(char open, char close) {
		// open과 close가 유효하면 true 리턴
		// 유효하지 않으면 유효함 = false후 false리턴
		switch(open) {
		case '{':
			if(close == '}') {
				stack.pop();
				return true;
				}
			else {
				correct = false;	
				return false;					
			}
		case '[':
			if(close == ']') {
				stack.pop();
				return true;
				}
			else {
				correct = false;	
				return false;					
			}
		case '<':
			if(close == '>') {
				stack.pop();
				return true;
				}
			else {
				correct = false;	
				return false;					
			}
		case '(':
			if(close == ')') {
				stack.pop();
				return true;
				}
			else {
				correct = false;	
				return false;					
			}
		default:
			correct = false;
			return false;
		}

	}
	

}