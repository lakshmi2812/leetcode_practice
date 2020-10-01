public class RemoveDuplicates {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
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

    public static ListNode deleteDuplicates(ListNode head) {
        //Base Case
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        //we use (current.next != null) condition to avoid null pointer exception
        //while checking current.next.val
        while(current != null && current.next != null){
            if(current.val == current.next.val){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
        int[] arr = {1,1,2};
        LinkedList ll = new LinkedList(arr);
        ListNode newHead = deleteDuplicates(ll.head);
        ListNode current = newHead;
        while(current != null){
            System.out.print(current.val + "->");
            current = current.next;
        }
    }
}
