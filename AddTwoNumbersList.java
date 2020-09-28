
class AddTwoNumbersList {

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

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current1 = l1;
        ListNode current2 = l2;
        int carry = 0;
        // ListNode currentSum = null;
        ListNode dummyHead = new ListNode(-1);
        // dummyHead.next = currentSum;
        ListNode currentSum = dummyHead;
        while(current1 != null && current2 != null){
            int sum = current1.val + current2.val + carry;
            carry = 0;
            if(sum >= 10){
                sum = sum - 10;
                carry = 1;
            }
            // currentSum = new ListNode(sum);
            // System.out.println(dummyHead.next);
            // currentSum = currentSum.next;
            currentSum.next = new ListNode(sum);
            //System.out.println(currentSum.next.val);
            currentSum = currentSum.next;
            current1 = current1.next;
            current2 = current2.next;
        }
        
        //if list1 is bigger and not yet empty
        while(current1 != null){
            int sum = current1.val + carry;
            carry = 0;
            if(sum >= 10){
                sum = sum - 10;
                carry = 1;
            }
            currentSum.next = new ListNode(sum);
            currentSum = currentSum.next;
            current1 = current1.next;
        }
        
        //if list2 is bigger and not yet empty
        while(current2 != null){
            int sum = current2.val + carry;
            carry = 0;
            if(sum >= 10){
                sum = sum - 10;
                carry = 1;
            }
            currentSum.next = new ListNode(sum);
            currentSum = currentSum.next;
            current2 = current2.next;
        }
        
        if(current1 == null && current2 == null){
            if(carry > 0){
                currentSum.next = new ListNode(carry);
            }
        }
        return dummyHead.next;    
    }

    public static void main(String[] args){
        int[] arr1 = {2,4,3};
        int[] arr2 = {5,6,4};
        LinkedList ll1 = new LinkedList(arr1);
        LinkedList ll2 = new LinkedList(arr2);
        ListNode outputListNode = addTwoNumbers(ll1.head, ll2.head);
        System.out.println(outputListNode.val);
        ListNode current = outputListNode;
        //This code is probably not working correctly!
        while(current != null){
            System.out.println("Current value:");
            System.out.println(current.val);
            current = current.next;
        }

    }

}
