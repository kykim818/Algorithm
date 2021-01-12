public class baekjoon_15596 {
    // 15596 정수 N개의 합
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        sum(arr);
    }
    public static long sum(int[] a){
        long ret = 0;
        for(int val : a){
            ret += val;
        }
        return ret;
    }
}
