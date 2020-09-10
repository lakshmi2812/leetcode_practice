import java.util.HashMap;
public class LinkedListCycle {
    static class ListNode{
        //instance variables
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
    //this method works. But, it is not suitable for lists with duplicate elements but do not have a cycle
    // public boolean hasCycle(ListNode head) {
    //     HashMap<Integer, Integer> nodeMap = new HashMap<Integer, Integer>();
    //     int count = 0;
    //     ListNode current = head;
    //     while(current != null && nodeMap.get(current.val) == null){
    //         Integer currentValInteger = new Integer(current.val);
    //         Integer countInteger = new Integer(count);
    //         nodeMap.put(currentValInteger, countInteger);
    //         current = current.next;
    //         count++;
    //     }
    //     if(current == null){
    //         return false;
    //     }else{
    //         return true;
    //     }
    // }

    //Floyd's cycle detection algorithm to detect loops(this algo was originally meant to find loops in a graph. But, it is applicable here too)
    //Main concept here - if there is no loop, there is no way that 2 pointers of different speeds will ever meet!
    public static boolean hasCycle(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args){
        int[] arr = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};
        LinkedList ll = new LinkedList(arr);
        boolean llHasCycle = hasCycle(ll.head);
        //Expected value - false, because the given ll does not have a cycle though it has some duplicate elements
        System.out.println("Does the given list have a cycle? :"+llHasCycle);
    }
}