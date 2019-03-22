package offer_15;

//使用移位运算符，比除法的效率高很多;
public class NumberOf {
    public int number(int value)
    {
        int count=0;
        while(value!=0)
        {
            if((value&1)!=0)
            {
                count++;

            }
            value=value>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf n=new NumberOf();
        int value=n.number(9);
        System.out.println(value);
    }
}
