package offer_18;

class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}


//删除排序链表重复节点

public class DeleteRepeatNode {

    public void DeleteNode(Node Head)
    {
        //链表长度为0或者为1时，直接返回
        if(Head==null||Head.next==null)
        {
            return;
        }
        Node pre=null;
        Node rear=Head;
        Node fin=Head.next;
        boolean needDelete=false;
        //节点重复，应将当前节点的前一节点与后边未重复的节点相连;
        while(fin.next!=null)
        {
            //当前节点与之后节点重复，查找重复个数，找出重复边界
            if(rear.data==fin.data) {
                fin=fin.next;
                needDelete=true;
            }
            //不相等时，判断是否之前是否有重复点，有重复点，删除重复点;
            else if(needDelete&&rear.data!=fin.data) {
                if (pre == null) {
                    Head=null;
                }
                else {
                    pre.next = fin;
                }
                rear=fin;
                fin=fin.next;
                needDelete=false;
            }
            //不存在重复节点，依次向后遍历;
            else{
                pre=rear;
                rear=fin;
                fin=fin.next;
            }
        }
    }

    public static void main(String[] args) {

        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(2);
        head.next.next.next=new Node(3);
        head.next.next.next.next=new Node(4);
        Node rear=head;
        while(rear!=null)
        {
            System.out.println(rear.data);
            rear=rear.next;
        }
        DeleteRepeatNode exp=new DeleteRepeatNode();
        exp.DeleteNode(head);
        Node tem=head;
        while(tem!=null)
        {
            System.out.println(tem.data);
            tem=tem.next;
        }

    }
}
