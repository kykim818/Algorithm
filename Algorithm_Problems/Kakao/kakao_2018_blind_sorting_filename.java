import java.util.Arrays;

public class kakao_2018_blind_sorting_filename {
    // [3차] 파일명 정렬
    static class File implements Comparable<File>{
        String head;
        String number;
        String tail;
        public File(String head,String number,String tail){
            this.head = head;
            this.number = number;
            this.tail = tail;
        }
        @Override
        public int compareTo(File o){
            String fileHead1 = this.head.toLowerCase();
            String fileHead2 = o.head.toLowerCase();
            int fileNum1 = Integer.parseInt(this.number);
            int fileNum2 = Integer.parseInt(o.number);

            if(fileHead1.equals(fileHead2)){
                if(fileNum1 == fileNum2){
                    return 0;
                }else{
                    return fileNum1 - fileNum2;
                }
            }else{
                return fileHead1.compareTo(fileHead2);
            }
        }
    }
    public static void main(String[] args) {
        // String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files = {"F-5 Freedom Fighter", "a-00210.zip", "A-10 Thunderbolt II", "F5"};
        // String[] files = {"f5"};
        String[] answer = new String[files.length];
        File[] list = new File[files.length];
        
        // 파일명 분리하기 머리 숫자 꼬리
        String name = null;
        boolean number = false;

        String fileHead = null;
        String fileNum = null;
        int numIdx = 0;
        String fileTail = null;

        for(int i = 0; i < files.length; i++){
            name = files[i];
            // 초기화
            number = false;
            numIdx = 0;
            fileHead = null;
            fileNum = null;
            fileTail = null;

            for(int j = 0; j < name.length(); j++){
                if(number == true){ 
                    if(isNum(name.charAt(j)) == false){
                        fileNum = name.substring(numIdx, j);
                        fileTail = name.substring(j);
                        break;
                    }
                    else if(j == name.length()-1){
                        fileNum = name.substring(numIdx);
                        break;
                    }  
                }

                if(number == false && isNum(name.charAt(j)) ){
                    number = true;
                    numIdx = j;
                    fileHead = name.substring(0, j);
                    if(j == name.length()-1){
                        fileNum = name.substring(numIdx);
                        break;
                    }
                }
            } // 파일이름 나누기

            list[i] = new File(fileHead,fileNum,fileTail);
        }
        Arrays.sort(list);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < files.length; i++){
            sb.append(list[i].head).append(list[i].number);
            if(list[i].tail != null){
                sb.append(list[i].tail);
            }
            answer[i] = sb.toString();
            sb.setLength(0);            
        }
        System.out.println(Arrays.toString(answer));
    }
    private static boolean isNum(char c){
        return c >= '0' && c <= '9';
    }    
}
