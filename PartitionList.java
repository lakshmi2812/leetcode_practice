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
        ListNode currentNewGreater = dummyHeadGreater;
        currentSmaller.next = dummyHeadGreater.next;
        // while(currentNewGreater.next != null){
        //     currentSmaller.next = currentNewGreater.next;
        //     currentSmaller = currentSmaller.next;
        //     currentNewGreater = currentNewGreater.next;
        // }
        return dummyHeadSmaller.next;
    }
}
