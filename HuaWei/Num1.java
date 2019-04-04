package HuaWei;

import java.util.ArrayList;

import java.util.Scanner;

public class Num1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);

        String k=in.nextLine();

        int N=Integer.parseInt(k);

        ArrayList<Integer> arrayList=new ArrayList<>();

        ArrayList<String> stringArrayList=new ArrayList<>();
        String s;
        while(in.hasNextLine())
        {
            s=in.nextLine();
            if(s==null)
            {
                break;
            }
            stringArrayList.add(s);
        }
//        stringArrayList.add("2");
//        stringArrayList.add("1,7,4,3,4");
        int maxLength=0;
        for(int i=0;i<stringArrayList.size();i++)
        {
            if(maxLength<(stringArrayList.get(i).length()))
            {
                maxLength=(stringArrayList.get(i).length());
            }
        }
        int count=0;
        int times=0;
        if((maxLength+1)%(2*N)==0)
        {
            times=(maxLength+1)/(2*N);
        }
        else
            times=(maxLength/(2*N)+1);
        while(times!=0)
        {
            for(int i=0;i<stringArrayList.size();i++)
            {

                int left=count*N;
                int right=left+N;
                String [] list=stringArrayList.get(i).split(",");
                InsertInteger(arrayList,left,right,list);
            }
            times--;
            count++;
        }
        for(int i=0;i<arrayList.size();i++)
        {
            if(i==arrayList.size()-1)
            {
                System.out.print(arrayList.get(i));
            }
            else
            {
                System.out.print(arrayList.get(i)+",");
            }
        }
    }
    public static void InsertInteger(ArrayList<Integer>arrayList,int left,int right,String[] string)
    {
        if(left>string.length)
        {
            return;
        }
        if(string.length>right)
        {
            while(left<right)
            {
                arrayList.add(Integer.parseInt(string[left++]));
            }
        }
        else
        {
            while(left<string.length)
            {
                arrayList.add(Integer.parseInt(string[left++]));
            }
        }
    }

}
