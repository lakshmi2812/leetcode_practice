public class PartitionList {
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

    public static ListNode partition(ListNode head, int x) {
        ListNode current = head;
        ListNode dummyHeadSmaller = new ListNode(-1);
        ListNode dummyHeadGreater = new ListNode(-1);
        ListNode currentSmaller = dummyHeadSmaller;
        ListNode currentGreater = dummyHeadGreater;
        while(current != null){
            if(current.val < x){
                currentSmaller.next = new ListNode(current.val);
                currentSmaller = currentSmaller.next;
            }else{
                currentGreater = new ListNode(current.val);
                currentGreater = currentGreater.next;
            }
            current = current.next;
        }
        currentGreater = dummyHeadGreater;
        while(currentGreater.next != null){
            currentSmaller.next = currentGreater.next;
            currentSmaller = currentSmaller.next;
            currentGreater = currentGreater.next;
        }
        return dummyHeadSmaller.next;
    }
}
