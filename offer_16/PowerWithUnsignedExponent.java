package offer_16;

import java.util.Scanner;

public class PowerWithUnsignedExponent {

    //底数为0时，指数<=0时，无意义;
    public double solation(double num,int Exponent)
    {
        if(num==0.0&&Exponent<=0)
        {
            return 0;
        }

        //快速幂提高效率，降低时间复杂度，数字过大时，会做取模处理
        int exp=Math.abs(Exponent);
        double result=powerValue(num,exp);
        if(Exponent<0)
        {
            result=1.0/result;
        }
        return result;
    }

    public double powerValue(double num, int exp)
    {
        if(exp==1)
        {
            return num;
        }
        if((exp%2)!=0)
        {
            return powerValue(num,exp/2)*powerValue(num,(exp+1)/2);
        }
        else
            return powerValue(num,exp/2)*powerValue(num,(exp+1)/2);

    }

    public static void main(String[] args) {
        PowerWithUnsignedExponent exp=new PowerWithUnsignedExponent();
        Scanner in=new Scanner(System.in);
        double base=in.nextDouble();
        int e=in.nextInt();
        double result=exp.solation(base,e);
        System.out.println(result);
    }
}
