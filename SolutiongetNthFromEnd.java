
public class SolutiongetNthFromEnd {
    
    static class ListNode{
        int data;
        ListNode next;
        //constructors
        ListNode(int data){
            this.data = data;
            this.next = null; 
        }
    
        ListNode(int data, ListNode n){
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList{
        ListNode head;

        //constructors
        LinkedList(){
            this.head = null;
        }

        LinkedList(ListNode head){
            this.head = head;
        }

        LinkedList(int[] arr){
            if(arr.length == 0){
                return;
            }
            this.head = new ListNode(arr[0]);
            ListNode current = this.head;
            for(int i = 1; i < arr.length; i++){
                current.next = new ListNode(arr[i]);
                current = current.next;
            }
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        //case 1 - head is null
        if(head == null){
            return head;
        }
        
        if(head.next == null){
            return null;
        }
        
        int count = 0;
        ListNode current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        
        int deleteNode = count - n;
        ListNode current1 = dummyNode;
        int deleteCount = 0;
        while(current1.next != null && deleteCount < deleteNode){
            deleteCount++;
            current1 = current1.next;
        }
        current1.next = current1.next.next;
        if(deleteNode == 0){
            head = current1.next;
        }
        return head;
    }

    public static void main(String[] args){
        int[] arr = {1,2};
        LinkedList newList = new LinkedList(arr);
        ListNode newHead = removeNthFromEnd(newList.head, 2);
        System.out.println(newHead.data);
    }
}