package offer_15;

//将一个整数n的二进制与n-1的二级制进行位运算
/*
一次位运算可将该数字的最右边的数字1变为0;
所以二进制数中有几个1可进行几次该运算;
 */
public class NumberOf3 {
    public int timesOf(int number)
    {
        int count=0;
        while(number>0)
        {
            number=number&(number-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf3 value=new NumberOf3();
        int SumOf=value.timesOf(11);
        System.out.println(SumOf);
    }
}
