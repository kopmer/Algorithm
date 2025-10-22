import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        if(N <= Short.MAX_VALUE && N >= Short.MIN_VALUE){
            System.out.println("short");
            return;
        } else if(N <= Integer.MAX_VALUE && N >= Integer.MIN_VALUE){
            System.out.println("int");
            return;
        } else{
            System.out.println("long long");
            return;
        }
    }
}