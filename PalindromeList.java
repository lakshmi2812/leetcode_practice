import java.util.ArrayList;

public class PalindromeList {

    static class ListNode{
        int val;
        ListNode next;
        //constructors
        ListNode(int val){
            this.val = val;
            this.next = null; 
        }
    
        ListNode(int val, ListNode n){
            this.val= val;
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

    public boolean isPalindrome(ListNode head) {
        //if the list is empty or has only one element
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode current = head;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        while(current != null){
            arr.add(current.val);
            current = current.next;
        }
        
        int n = arr.size();
        int halfLength = (int)Math.floor(n/2);
        for(int i = 0; i < halfLength; i++){
            System.out.println("**"+arr.get(i));
            System.out.println("***"+arr.get(n-1-i));
            if(arr.get(i).intValue() != arr.get(n-1-i).intValue()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] arr = {-129, -129};
        LinkedList ll = new LinkedList(arr);
        PalindromeList list = new PalindromeList();
        System.out.println(list.isPalindrome(ll.head));
    }

}