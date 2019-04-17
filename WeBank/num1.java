package WeBank;

import java.util.Scanner;

public class num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int num=in.nextInt();
        int [] list=new int[N+1];
        boolean [] flag=new boolean[N+1];

        int left=N;

        int i=1;
        int count=1;
        for(i=1;i<=list.length;i++)
        {
            if(left==1)
                break;

            if(i==list.length)
            {
                i=0;
                continue;
            }
            if(flag[i]==true)
            {
                continue;
            }

            if(count<num)
            {
                count++;
            }
            else//淘汰
            {
                flag[i]=true;
                count=1;
                left--;
                if(left>1)
                {
                    System.out.print(i+" ");
                }
                else
                    System.out.println(i);

            }
        }
        for(int j=1;j<flag.length;j++)
        {
            if(flag[j]!=true)
            {
                System.out.println(j);
                break;
            }
        }

    }
}
