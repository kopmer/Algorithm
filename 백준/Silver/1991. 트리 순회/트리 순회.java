import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static class Node{
		char left;
		char right;
		
		Node(char left, char right){
			this.left = left;
			this.right = right;
		}
	}
	static Node[] tree = new Node[26];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for(int i = 0;i < N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char parent = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			tree[parent - 'A'] = new Node(left,right);
			
		}
		preorder('A');
        System.out.println();
        inorder('A');
        System.out.println();
        postorder('A');
        System.out.println();
    }
    
    static void preorder(char current) {// 전위 순회 
        if (current == '.') return;
        System.out.print(current);
        preorder(tree[current - 'A'].left);
        preorder(tree[current - 'A'].right);
    }
    
    static void inorder(char current) {// 중위 순회
        if (current == '.') return;
        inorder(tree[current - 'A'].left);
        System.out.print(current);
        inorder(tree[current - 'A'].right);
    }
    
    static void postorder(char current) {// 후위 순회
        if (current == '.') return;
        postorder(tree[current - 'A'].left);
        postorder(tree[current - 'A'].right);
        System.out.print(current);
    }

}