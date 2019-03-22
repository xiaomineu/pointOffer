package offer_15;

import javafx.scene.transform.Scale;

import java.util.Scanner;

public class countNum {
    public void num()
    {
        Scanner in=new Scanner(System.in);
        int value=in.nextInt();
        int count=0;
        while(value>0)
        {
            if(value%2!=0)
            {
                count++;
            }
            value/=2;
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        countNum lis=new countNum();
        lis.num();
    }
}
