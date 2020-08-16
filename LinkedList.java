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

    /* **************************** */
    //STANFORD CS LIBRARY PRACTICE
    
    //Assume that the list nodes contain only positive integers as data

    //1. count - takes an integer data and returns the number of times that data appears in the list
    public int count(int data){
        if(this.head == null){
            return 0;
        }

        int numCount = 0;

        ListNode current = this.head;
        while(current != null){
            if(current.data == data){
                numCount++;
            }
            current = current.next;
        }
        return numCount;
    }

    //2. getNth - takes an integer index and returns the data at that index(Note that index is zero-based)
    public int getNth(int index){
        if(index < 0  || index > this.listLength(this.head)-1){
            //-1 indicates invalid index
            return -1;
        }

        if(this.head == null){
            return -1;
        }

        int _count = 0;
        ListNode current = this.head;
        while(current.next != null && _count < index){
            _count++;
            current = current.next;
        }
        return current.data;

    }

    //3. deleteList -> deletes the current list
    public void deleteList(){
        this.head = null;
    }

    //4. pop -> deletes the head node and returns the data of the head node
    public int pop(){
        if(this.head == null){
            //Let -1 denote that the list is empty
            return -1;
        }
        ListNode current = this.head;
        this.head = this.head.next;
        return current.data;
    }

    //5.insertNth - already coded above and tested

    //6. sortedInsert - given a sorted list and a new node, insert the new node in the correct position in the list
    //Example list : [23,45,79,100,900,1000]
    public void sortedInsert(ListNode head, ListNode newNode){
        int data = newNode.data;
        if(head == null){
            head = newNode;
        }
        ListNode current = this.head;
        //newNode data is less than that of the head node
        if(data < current.data){
            newNode.next = current;
            head = newNode;
        }
        while(current.next!= null){
            if(data > current.data && data < current.next.data){
                ListNode tempNode = current.next;
                current.next = newNode;
                newNode.next = tempNode;
            }
            current = current.next;
        }
        //newNode data is greater than the node having largest data value in the list
        if(data > current.data){
            current.next = newNode;
        }
    }

    //7. insertSort -> sort the given list
    public void insertSort(){
        //If the list is empty or has only one element, there is nothing to be done
        if(this.head == null || this.head.next == null){
            return;
        }

        ListNode current = this.head;
        LinkedList ll_unsorted = new LinkedList(current.next);
        ListNode current_unsorted = ll_unsorted.head;
        while(current_unsorted.next != null){
            sortedInsert(this.head, current_unsorted);
            current_unsorted = current_unsorted.next;
        }

        sortedInsert(this.head, current_unsorted);

    }

    //8. append -> given 2 lists, append one list at the end of the other
    public ListNode append(LinkedList ll1, LinkedList ll2){
        if(ll1.head == null){
            return ll2.head;
        }

        if(ll2.head == null){
            return ll1.head;
        }

        ListNode current = ll1.head;
        //Traverse to the end of ll1
        while(current.next != null){
            current = current.next;
        }

        current.next = ll2.head;
        ll2.head.next = null;

        return ll1.head;
    }

    //9. FrontBackSplit -> split a list into 2 lists(front and back). If the list length is odd, the extra element should be in the front list
    public void FrontBackSplit(){
        if(this.head == null){
            System.out.println("The list is empty!");
            return;
        }
        LinkedList front = new LinkedList();
        LinkedList back = new LinkedList();
        int listLength = this.listLength(this.head);
        if(listLength < 2){
            front.head = this.head;
            front.printList();
            back.printList();
            return;
        }

        int splitPoint;
        if(listLength % 2 == 0){
            splitPoint = (int)((listLength/2)-1);
        }else{
            splitPoint = (int)Math.floor(listLength/2);
        }

        int count = 0;
        ListNode current = this.head;
        ListNode frontCurrent = front.head;
        while(count < splitPoint){
            frontCurrent.next = current.next;
            current = current.next;
            frontCurrent = frontCurrent.next;
            count++;
        }
        back.head = current.next;
        ListNode backCurrent = back.head;
        while(current.next != null){
            backCurrent.next = current.next;
            backCurrent = backCurrent.next;
            current = current.next;
        }
        backCurrent.next = current.next;

        front.printList();
        back.printList();
    }

    //10. removeDuplicates -> Given a list sorted in increasing order, remove duplicates from the list
    public void removeDuplicates(){
        //if the list is empty or has only one node, do nothing
        if(this.head == null || this.head.next == null){
            return;
        }

        ListNode current = this.head;
        while(current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }

    //11. moveNode -> given two lists, dest and source, remove the front(head) node from the source list and push it 
    //to the front(head) of the dest list
    public void moveNode(LinkedList dest, LinkedList source){
        ListNode current = source.head;
        source.head = current.next;
        current.next = null;
        if(dest.head == null){
            dest.head = current;
        }

        current.next = dest.head;
        dest.head = current;
    }

    //12. alternatingSplit -> given a list, make two lists from this list using alternating elements
    public void alternatingSplit(){
        if(this.head == null || this.head.next == null){
            System.out.println("The list has less than 2 elements. It cannot be split!");
            return;
        }

        int count = 0;
        ListNode current = this.head;
        ListNode currentOdd;
        int listLength = this.listLength(this.head);
        LinkedList list1 = new LinkedList();
        LinkedList list2;
        while(count < listLength){
            if(count % 2 == 0){
                currentOdd = current.next;
                current.next = current.next.next;
                currentOdd.next = null;
                list2 = new LinkedList(currentOdd);
                moveNode(list1, list2);
            }
            count++;
        }
    }

    //Helper function addToEnd for shuffleMerge -> adds a node to the end of the list
    public void addToEnd(int data, ListNode head){
        if(head == null){
            head = new ListNode(data);
        }

        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }

        current.next = new ListNode(data);
    }

    //13. shuffleMerge -> given two lists, form a new list by taking alternating nodes from each list
    public LinkedList shuffleMerge(LinkedList list1, LinkedList list2){
        if(list1.head == null){
            return list2;
        }
        if(list2.head == null){
            return list1;
        }
        ListNode current1 = list1.head;
        ListNode current2 = list2.head;
        LinkedList listMerged = new LinkedList();
        ListNode currentMerged = listMerged.head;
        while(current1.next != null && current2.next != null){
            currentMerged = new ListNode(current1.data);
            current1 = current1.next;
            currentMerged = currentMerged.next;
            currentMerged = new ListNode(current2.data);
            currentMerged = currentMerged.next;
            current2 = current2.next;
        }

        while(current1.next != null){
            currentMerged.next = new ListNode(current1.data);
            current1 = current1.next;
            currentMerged = currentMerged.next;
        }

        while(current2.next != null){
            currentMerged.next = new ListNode(current2.data);
            current2 = current2.next;
            currentMerged = currentMerged.next;
        }

        return listMerged;
    }

    //14. sortedMerge -> given two lists sorted in increasing order, merge them to form a new list sorted in increasing order
    public LinkedList sortedMerge(LinkedList list1, LinkedList list2){
        if(list1.head == null){
            return list2;
        }
        if(list2.head == null){
            return list1;
        }

        ListNode current1 = list1.head;
        ListNode current2 = list2.head;
        LinkedList sortedList = new LinkedList();
        ListNode sortedCurrent = sortedList.head;

        while(current1.next != null && current2.next != null){
            if(current1.data < current2.data){
                sortedCurrent = new ListNode(current1.data);
                current1 = current1.next;
            }else{
                sortedCurrent = new ListNode(current2.data);
                current2 = current2.next;
            }
            sortedCurrent = sortedCurrent.next;
        }

        while(current1.next != null){
            sortedCurrent.next = new ListNode(current1.data);
            current1 = current1.next;
            sortedCurrent = sortedCurrent.next;
        }
        while(current2.next != null){
            sortedCurrent.next = new ListNode(current2.data);
            current2 = current2.next;
            sortedCurrent = sortedCurrent.next;
        }

        return sortedList;
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
        /* Testing count function */
        //Element 1 is not present in the list
        System.out.println("No. of. times 1 appears in the list: "+ll.count(1));
        //Element 1 appears multiple times
        int[] arrCount = {1,2,3,4,1,5,6,1};
        LinkedList llCount = new LinkedList(arrCount);
        llCount.printList();
        System.out.println("No. of. times 1 appears in the list: "+llCount.count(1));
        //Element 1 appears only once in the list
        int[] arrCount1 = {1,2,3,4,5,6};
        LinkedList llCount1 = new LinkedList(arrCount1);
        llCount1.printList();
        System.out.println("No. of. times 1 appears in the list: "+llCount1.count(1));
    }
}