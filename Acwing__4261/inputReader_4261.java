import java.util.*;
import java.io.*;

public class inputReader_4261 {
    public static void main(String[] args) {
        InputReader in = new InputReader(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = in.nextInt();
        char[] cs = in.next().toCharArray();
        int[] l = new int[n], r = new int[n];
        int lg = -1, lh = -1;
        for (int i = 0; i < n; ++i) {
            char c = cs[i];
            if (c == 'G') {
                if (lg != -1) l[i] = i - lg;
                else l[i] = i + 1;
                lg = i;
            } else {
                if (lh != -1) l[i] = i - lh;
                else l[i] = i + 1;
                lh = i;
            }
        }
        lg = -1; lh = -1;
        for (int i = n - 1; i >= 0; --i) {
            char c = cs[i];
            if (c == 'G') {
                if (lg != -1) r[i] = lg - i;
                else r[i] = n - i;
                lg = i;
            } else {
                if (lh != -1) r[i] = lh - i;
                else r[i]= n - i;
                lh = i;
            }
        }
        long ans = 0L;
        for (int i = 0; i < n; ++i) {
            long all = (long)l[i] * r[i] - 1L;
            if (l[i] > 1) --all;
            if (r[i] > 1) --all;
            if (all > 0) ans += all;
        }
        out.println(ans); out.flush();
    }
}

class InputReader {
    private final BufferedReader buf;
    private StringTokenizer tkl;

    public InputReader(InputStream is) {
        buf = new BufferedReader(new InputStreamReader(is));
    }

    public boolean hasNext() {
        try {
            while (tkl == null || !tkl.hasMoreElements()) tkl = new StringTokenizer(buf.readLine());
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public String next() {
        return hasNext() ? tkl.nextToken() : null;
    }

    public int nextInt() {
        return Integer.parseInt(next());
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }
}