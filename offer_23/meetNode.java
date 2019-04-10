package offer_23;

class Node
{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}


public class meetNode {
    public static void main(String[] args) {

    }

    public static Node EntryNode(Node Head)
    {
        Node markNode=MeetNode(Head);
        if(markNode==null)
        {
            return null;
        }
        int count=1;
        Node tem=markNode;
        while(tem.next!=markNode)
        {
            tem=tem.next;
            count++;
        }
        //先移动第一个节点，次数为环中节点
        Node pNode=Head;
        for(int i=0;i<count;i++)
        {
            pNode=pNode.next;
        }
        //再移动pNode与pNode2
        Node pNode2=Head;
        while(pNode!=pNode2)
        {
            pNode=pNode.next;
            pNode2=pNode2.next;
        }
        return pNode;
    }

    public static Node MeetNode(Node head)
    {
        if(head==null)
        {
            return null;
        }

        Node slowNode=head.next;//慢指针
        if(slowNode==null)
        {
            return null;
        }
        Node quickNode=slowNode.next;//快指针
        while(quickNode!=null&&slowNode!=null)
        {
            if(quickNode==slowNode)
            {
                return slowNode;
            }
            slowNode=slowNode.next;
            quickNode=quickNode.next;
            if(quickNode.next!=null)
            {
                quickNode=quickNode.next;
            }
        }
        return null;
    }
}
