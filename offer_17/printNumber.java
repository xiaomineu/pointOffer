package offer_17;


public class printNumber {
    public void PrintListNumber(int n)
    {
        double max=Math.pow(10,n);
        for(int i=1;i<max;i++)
        {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        printNumber lis=new printNumber();
        lis.PrintListNumber(3);
    }
}
