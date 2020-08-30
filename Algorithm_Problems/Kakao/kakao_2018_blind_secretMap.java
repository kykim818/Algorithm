import java.util.Arrays;

public class kakao_2018_blind_secretMap{
    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9,20,28,18,11};
        int[] arr2 = {30,1,21,17,28};


        String[] sarr1 = new String[n]; 
        String[] sarr2 = new String[n];
        String[] answer = new String[n]; 
        Arrays.fill(answer, "");
        
        for(int i = 0; i < n; i++){
            String tmp = "";
            sarr1[i] = Integer.toBinaryString(arr1[i]);
            for(int j = 0; j < n-sarr1[i].length(); j++){
                tmp += "0";
            }
            sarr1[i] = tmp + sarr1[i];

            tmp = "";
            sarr2[i] = Integer.toBinaryString(arr2[i]);
            for(int j = 0; j < n-sarr2[i].length(); j++){
                tmp += "0";
            }
            sarr2[i] = tmp + sarr2[i];
        }
        
        for(int i = 0; i < n ; i++){
            for(int j = 0;  j < n ; j++){
                if(((sarr1[i].charAt(j)-'0') | (sarr2[i].charAt(j)-'0')) == 1) {
                	answer[i] += '#';
                }else {
                	answer[i] += ' ';
                }
            }
        }
       for(int i = 0; i< n; i++){
           System.out.println(answer[i]);
       }
    }

}