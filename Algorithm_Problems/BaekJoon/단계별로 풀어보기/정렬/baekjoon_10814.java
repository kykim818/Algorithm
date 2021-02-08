import java.util.*;
import java.io.*;


public class baekjoon_10814 {
    // 나이순 정렬
    static class Person implements Comparable<Person>{
        String name;
        int age;
        int idx;
        Person(int age,String name,int idx){
            this.name = name;
            this.age = age;
            this.idx = idx;
        }

        @Override
        public int compareTo(Person p){
            if(this.age == p.age){
                return this.idx - p.idx;
            }
            return this.age - p.age;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Person[] list = new Person[N];
        for(int i = 0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            list[i] = new Person(Integer.parseInt(st.nextToken()),st.nextToken(),i);
        }

        Arrays.sort(list);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < list.length; i++){
            sb.append(list[i].age).append(" ").append(list[i].name).append("\n");
        }
        System.out.println(sb);
    }

    
}
