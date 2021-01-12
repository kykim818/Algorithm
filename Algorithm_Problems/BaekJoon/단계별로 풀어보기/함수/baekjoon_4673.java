import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class baekjoon_4673 {
    // 4673 셀프넘버
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] list = new boolean[10000];
        for(int i = 1; i < 10000; i++){
            if(list[i] == false){
                selfNumber(i,list);
            }
        }

        for(int i = 1; i < 10000; i++){
            if(list[i] == false){
                bw.write(String.valueOf(i)+"\n");
                bw.flush();
            }
        }
        bw.close();
    }

    private static void selfNumber(int N, boolean[] list){
        if(N >= 10000) return;
        if(list[N] == true) return;

        int ret = 0;
        ret += N;
        int len = (int) Math.log10((double) N);
        int tmp = len;
        for(int i = 0; i <= len; i++){
            ret += N / Math.pow(10, tmp);
            N %= Math.pow(10,tmp);
            tmp--;
        }
        selfNumber(ret, list);
        if(ret < 10000){
            list[ret] = true; 
        }
    }
    
}
