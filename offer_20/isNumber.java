package offer_20;

/**
 * 整数，小数，指数分别判断
 * 数值字符串满足A[.[B][e|EC];
 */
public class isNumber {
    public static boolean judeg(String str)
    {
        if(str.length()==0)
        {
            return false;
        }

        //判断整数部分;
        int index=0;
        if(str.charAt(index)=='+'||str.charAt(index)=='-')
        {
            index++;
        }
        index=judegeInteger(str,index);

        if(index==str.length())
        {
            return true;
        }


        //判断小数部分
        if(str.charAt(index)=='.')
        {
            index++;
        }
        index=judegeInteger(str,index);

        if(str.length()==index)
        {
            return true;
        }

        //判断指数部分
        if(str.charAt(index)=='e'||str.charAt(index)=='E')
        {
            index++;
        }
        if(str.charAt(index)=='+'||str.charAt(index)=='-')
        {
            index++;
        }
        index=judegeInteger(str,index);
        if(index==str.length())
        {
            return true;
        }
        else
            return false;

    }

    public static int judegeInteger(String str,int index)
    {
        while(index<str.length()&&str.charAt(index)>='0'&&str.charAt(index)<='9')
        {
                ++index;
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(judeg("+11222.666e-6"));
        System.out.println(judeg(".199928e11"));
        System.out.println(judeg("12e+5.4"));
    }
}
