package offer_24;
class listNode{
    int data;
    listNode next;

    public listNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "listNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}

public class ReverseList {
    public static void main(String[] args) {
        listNode head=new listNode(1);
        head.next=new listNode(2);
        head.next.next=new listNode(3);
        head.next.next.next=new listNode(4);
        head.next.next.next.next=new listNode(5);
        head.next.next.next.next.next=new listNode(6);
        listNode currentNode=Reverse(head);
        System.out.println(currentNode);
    }

    public static listNode Reverse(listNode head){
        if(head==null){
            return null;
        }
        listNode preNode=null;
        listNode currentNode=head;
        listNode nextNode=null;
        while(currentNode.next!=null){
            //每次翻转之前，应记下当前节点的下一个节点
            nextNode=currentNode.next;
            //翻转当天节点
            currentNode.next=preNode;
            //翻转完成后，将preNode向后移动一位
            preNode=currentNode;
            currentNode=nextNode;
        }
        if(currentNode.next==null){
            currentNode.next=preNode;
        }
        return currentNode;
    }
}
