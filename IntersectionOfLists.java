public class IntersectionOfLists {
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

        //  //printList
        // public void printList(){
        //     ListNode current = this.head;
        //     if(current == null){
        //         System.out.println("Empty List!");
        //     }
        //     while(current != null){
        //         System.out.print(current.data + " -> ");
        //         current = current.next;
        //     }
        //     System.out.println("");
        // }
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //find length of listA
        ListNode currentA = headA;
        int lengthA = 0;
        while(currentA != null){
            lengthA++;
            currentA = currentA.next;
        }
        //find length of listB
        ListNode currentB = headB;
        int lengthB = 0;
        while(currentB != null){
            lengthB++;
            currentB = currentB.next;
        }
        ListNode startA = headA;
        ListNode startB = headB;
        if(lengthA > lengthB){
            int countA = 0;
            while(countA < (lengthA-lengthB)){
                countA++;
                startA = startA.next;
            }
        }else{
            int countB = 0;
            while(countB < (lengthB-lengthA)){
                countB++;
                startB = startB.next;
            }
        }
        while(startA != startB){
            startA = startA.next;
            startB = startB.next;
        }
        return startA;
    }

    public static void main(String[] args){
        int[] arr1 = {4,1,8,4,5};
        LinkedList ll1 = new LinkedList(arr1);
        int[] arr2 = {5,6,1,8,4,5};
        ListNode currentA = ll1.head;
        LinkedList ll2 = new LinkedList();
        ListNode ll2Head = new ListNode(5);
        ll2.head = ll2Head;
        ListNode ll26 = new ListNode(6);
        ll2.head.next = ll26;
        //Intersection node
        ll2.head.next.next = new ListNode(1);
        ll2.head.next.next.next = ll1.head.next.next;
        // ll1.printList();
        // ll2.printList();
        ListNode intersectionNode = getIntersectionNode(ll1.head, ll2.head);
        System.out.println(intersectionNode.val);
    }
}
