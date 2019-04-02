package exp;

import java.util.Scanner;

public class Num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str=in.nextLine();

        //使用split方法切分,以" "为分隔符;
        String [] list=str.split(" ");
        for(int i=0;i<list.length;i++)
        {
            for(int j=0;j<list.length;j++)
            {
                //判断末尾是否有标记
                if(((list[i].charAt(list[i].length()-1)<'z')&&(list[i].charAt(list[i].length()-1)>'a'))||((list[i].charAt(list[i].length()-1)<'Z')&&(list[i].charAt(list[i].length()-1)>'A'))||((list[i].charAt(list[i].length()-1)<'9')&&(list[i].charAt(list[i].length()-1)>'0')))
                {

                }
                else
                {
                    //使用substring方法，将标点移至最前;
                    list[i]=list[i].substring(list[i].length()-1,list[i].length())+list[i].substring(0,list[i].length()-1);
                }

            }
        }
        for(int i=list.length-1;i>-1;i--)
        {
            if(i==0)
            {
                System.out.print(list[i]);
            }
            else
                System.out.print(list[i]+" ");
        }
    }
}
