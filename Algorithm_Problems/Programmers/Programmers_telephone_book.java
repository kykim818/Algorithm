
public class Programmers_telephone_book {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean answer = true;
		String[] phone_book = {"119", "97674223", "1195524421"};
        String tmp = "";
        int len = 0;
        for(int i = 0; i < phone_book.length; i++){
            tmp = phone_book[i];
            len = phone_book[i].length();
            String tmp1 = "";
            for(int j = i+1 ;  j < phone_book.length; j++ ){
                tmp1 = phone_book[j];
                if(tmp.length() > tmp1.length()) continue;
                else if(tmp.length() == tmp1.length()){
                    if(tmp.equals(tmp1)){
                        answer = false;
                        break;
                    }
                }
                else{
                	System.out.println(tmp1.substring(0,len));
                    if(tmp.equals(tmp1.substring(0,len))){
                        answer = false;
                        break;    
                    }
                }
            }
            if(answer == false) break;
        }
        System.out.println(answer);
//        return answer;
	}

}
