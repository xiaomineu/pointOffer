package offer_15;

/*移位运算对于负数，不可简单右移移位
设立标记位1，将其不断左移，取与运算，即可计算出1的个数
 */

public class NumberOf2 {
    public int count(int number)
    {
        int count=0;
        int flag=1;
        if(number>0)
        {
            /*flag右移为0,不可采用相同的方法
            while(flag<=number)
            {
                if((flag&number)!=0)
                {
                    count++;
                }
                flag=flag>>1;
            }
            */
            while(number!=0)
            {
                if((number&1)!=0)
                {
                    count++;
                }
                number=number>>1;
            }
        }
        else
        {
            while(flag>number)
            {
                if((flag&number)!=0)
                {
                    count++;
                }
                flag=flag<<1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        NumberOf2 num=new NumberOf2();
        int value=num.count(11);
        System.out.println(value);
    }
}
