import java.io.*;

public class baekjoon_1157 {
    // 1157 단어공부
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        input = input.toLowerCase();
        int[] arr = new int[26];
        //int[] tmp = new int[26];
        for(int i = 0; i < input.length(); i++){
            arr[input.charAt(i)-'a']++;
            //tmp[input.charAt(i)-'a']++;
        }

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 0; i < 26; i++){
            if(max < arr[i]){
                max = arr[i];
                idx = i;
            }else if(max == arr[i]){
                idx = -1;
            }
        }

        if(idx == -1) System.out.println("?");
        else{
            System.out.println((char)('A'+idx));
        }



        // Arrays.sort(tmp);
        // if(tmp[25] == tmp[24]) System.out.println("?");
        // else{
        //     for(int i = 0; i < 26; i++){
        //         if(arr[i] == tmp[25]){
        //             System.out.println((char)('A'+i));
        //         }
        //     }
        // }
    }
    
}
