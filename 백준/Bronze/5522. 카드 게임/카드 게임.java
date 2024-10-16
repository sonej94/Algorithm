import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int result =0;
        for(int i = 0; i<5; i++){
            result += sc.nextInt();
        }

        System.out.println(result);
    }
}