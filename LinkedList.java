class ListNode{
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

public class LinkedList{
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

    //printList
    public void printList(){
        ListNode current = this.head;
        if(current == null){
            System.out.println("Empty List!");
        }
        while(current != null){
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("");
    }

    //find
    public Boolean find(int data){
        if(this.head == null){
            return false;
        }

        ListNode current = this.head;
        while(current != null){
            if(current.data == data){
                return true;
            }else{
                current = current.next;
            }
        }
        return false;
    }

    //find the length of the linked list
    public int listLength(ListNode head){
        if(head == null){
            return 0;
        }
        ListNode current = head;
        int count = 1;
        while(current.next != null){
            count ++;
            current = current.next;
        }
        return count;
    }

    //insertNth -> insert an element at the index n
    public void insertNth(ListNode head, int index, int data){
        if(head == null){
            head = new ListNode(data);
        }
        if(index < 0 || index > this.listLength(head)){
            return;
        }
        ListNode dummyNode = new ListNode(-1);
        //insert the element at head
        if(index == 0){
            ListNode newNode = new ListNode(data);
            dummyNode.next = newNode;
            newNode.next = head;
            head = newNode;
            dummyNode.next = null;
        }
        int count = 0;
        ListNode current = head;
        while(count < index-1){
            current = current.next;
            count++;
        }
        ListNode newNode = new ListNode(data);
        newNode.next = current.next;
        current.next = newNode;
    }

    //remove -> We need to remove only the first occurence of the node. 
    //Remember - because of the above condition, if we have found the node and removed it, we do not advance current pointer.
    //Otherwise, it leads to Null pointer exception
    public void remove(int data){
        if(this.head == null){
            return;
        }

        ListNode dummyNode = new ListNode(-1);
        if(this.head.data == data){
            dummyNode.next = this.head;
            dummyNode.next = dummyNode.next.next;
            this.head = dummyNode.next;
            return;
        }

        ListNode current = this.head;
        while(current.next != null){
            if(current.next.data == data){
                current.next = current.next.next;
                return;
            }else{
                current = current.next;
            }
        }
    }

    //TEST
    public static void main(String[] args){
        int[] arr = {10,20,30};
        LinkedList ll = new LinkedList(arr);
        ll.printList();
        ll.insertNth(ll.head, 1, 50);
        ll.printList();
        System.out.println("Finding 50: "+ll.find(50));
        System.out.println("Finding 30: "+ll.find(30));
        /*Testing Remove function*/
        //Remove middle element
        ll.remove(20);
        System.out.println("After removing 20:");
        ll.printList();
        //Remove head element
        ll.remove(10);
        System.out.println("After removing 10:");
        ll.printList();
        //Remove last element
        ll.remove(30);
        System.out.println("After removing 30:");
        ll.printList();
        int[] arr2 = {1};
    }

}