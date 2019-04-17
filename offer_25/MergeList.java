package offer_25;



class ListNode{
    int data;
    ListNode next;

    public ListNode(int data) {
        this.data = data;
    }

    public ListNode() {
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

public class MergeList {
    public static void main(String[] args) {
        ListNode list01=new ListNode(1);
        list01.next=new ListNode(3);
        list01.next.next=new ListNode(5);
        list01.next.next.next=new ListNode(7);
        list01.next.next.next.next=new ListNode(9);
        ListNode list02=new ListNode(2);
        list02.next=new ListNode(2);
        list02.next.next=new ListNode(4);
        list02.next.next.next=new ListNode(6);
        list02.next.next.next.next=new ListNode(8);
        list02.next.next.next.next.next=new ListNode(10);
        ListNode node=Merge(list01,list02);
        System.out.println(node);
    }


    public static ListNode Merge(ListNode first, ListNode second){
        if(first==null&&second==null){
            return null;
        }
        ListNode p1=first;//第一个链表
        ListNode p2=second;//第二个链表
        ListNode rear=new ListNode();
        ListNode fresh=rear;
        while(p1!=null&&p2!=null){
            if(p1.data<p2.data){
                fresh.next=p1;
                p1=p1.next;
            }
            else{
                fresh.next=p2;
                p2=p2.next;
            }
            fresh=fresh.next;
        }
        while(p1!=null){
            fresh.next=p1;
            p1=p1.next;
            fresh=fresh.next;
        }
        while(p2!=null){
            fresh.next=p2;
            p2=p2.next;
            fresh=fresh.next;
        }
        return rear.next;
    }
}
