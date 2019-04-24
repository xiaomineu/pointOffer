package Test;


import java.util.Scanner;

public class num360 {
    public static void main(String[] args) {
        String str="";
        System.out.println(ChangeNum(str));
    }
    public static long ChangeNum(String string){
//        Scanner in=new Scanner(System.in);
//        String string=in.nextLine();
        int count=0;
        boolean correct=false;
        for(int i=0;i<string.length();i++){
            if(string.charAt(i)=='.'&&count==0){
                count++;
                correct=true;
            }else if(string.charAt(i)=='.'&&count>0){
                return 0;
            }else if(string.charAt(i)<'0'||string.charAt(i)>'9'){
                return 0;
            }
        }
        int j=string.length()-1;
        if(correct){
            while(string.charAt(j)!='.'){
                j--;
            }
        }
        long value=0;
        int position=0;
        if(j!=string.length()-1){
            j--;
        }
        while(j>=0){
            int p=(int)string.charAt(j);
            int m=p-48;
            value+=m*Math.pow(10,position);
            position++;
            j--;
        }
        return value;
    }
}
