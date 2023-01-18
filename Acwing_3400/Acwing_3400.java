import java.util.Scanner;

public class text {
    public static void main(String[] args) {
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();


        for (int i = 1; i <= n; i ++) {
            int t = i;
            while (t > 0) {
                if (t % 10 == a) sum ++;
                t /= 10;
            }
        }

        System.out.print(sum);
    }
}

