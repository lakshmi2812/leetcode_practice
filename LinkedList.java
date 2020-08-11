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
    public void insertNth(int index, int data){
        //Case - the list is empty
        if(this.head == null){
            this.head = new ListNode(data);
            return;
        }
        //Case - Given index is invalid
        if(index < 0 || index > this.listLength(this.head)){
            return;
        }
        //Case - insert the element at head
        if(index == 0){
            ListNode newNode = new ListNode(data);
            newNode.next = this.head;
            this.head = newNode;
            return;
        }
        int count = 0;
        ListNode current = this.head;
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
        /* Testing INSERT function */
        //Insert in the middle of the list
        ll.insertNth(1, 50);
        ll.printList();
        //Insert at the end of the list
        ll.insertNth(4, 100);
        ll.printList();
        //Insert at the head
        ll.insertNth(0, 5000);
        ll.printList();
        /* Testing INSERT function */
        //Finding middle element 
        System.out.println("Finding 30: "+ll.find(30));
        //Finding head element
        System.out.println("Finding 5000: "+ll.find(5000));
        //Finding last element
        System.out.println("Finding 100: "+ll.find(100));
        /*Testing Remove function*/
        //Remove middle element
        ll.remove(20);
        System.out.println("After removing 20:");
        ll.printList();
        //Remove head element
        ll.remove(5000);
        System.out.println("After removing 5000:");
        ll.printList();
        //Remove last element
        ll.remove(100);
        System.out.println("After removing 100:");
        ll.printList();
    }

}