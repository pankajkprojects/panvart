package com.prvprojects.algodsapp.ds;


import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Pankaj on 08/08/17.
 */

public class LinkedList {

    private final static Logger LOGGER = Logger.getLogger(LinkedList.class.getCanonicalName());

    static class Node {
        int data;
        Node next;
        public Node(int data1, Node next1){
            data = data1;
            next = next1;
        }
        Node(int data){
            this(data, null);
        }

    }

    // Linked list head
    Node head;

    public LinkedList(Node head) {
        this.head = head;
        this.LOGGER.setLevel(Level.INFO);
    }

    public static void main(String args[]){


        //sortedMerge(headNode, headNode2).printLinkedList("After SORTED MERGE - LIST");

        //runMergeSortSample();

        //runReverseMethods();

        //runRemoveLoopMethods();

        //runNumberAdditionUsingLinkedList();

        runRotationExample();

    }

    /**
     * Method to run a sample on rotation of linked list
     */
    public static void runRotationExample(){

        LinkedList linkedList = convertIntegerToLinkedList(123456789);
        linkedList.printLinkedList("Original Linked List:");

        int k = 3;
        linkedList.rotateAntiClockwise_nonOptimized(k);

        linkedList.printLinkedList("Rotating Linked List by k="+k+" nodes.");

    }

    /**
     * Invoke misc methods
     */
    private static void invokeMiscMethods(){

        // Creating a linked list
        Node fifthNode = new Node(10);
        Node fourthNode = new Node(9, fifthNode);
        Node thirdNode = new Node(8, fourthNode);
        Node secondNode = new Node(5, thirdNode);
        Node headNode = new Node(4, secondNode);

        // Creating a linked list
        Node fifthNode2 = new Node(9);
        Node fourthNode2 = new Node(6, fifthNode2);
        Node thirdNode2 = new Node(3, fourthNode2);
        Node secondNode2 = new Node(2, thirdNode2);
        Node headNode2 = new Node(1, secondNode2);

        /*
        // Another way of creating a linked list
        Node thirdNode = new Node(8);
        Node secondNode = new Node(45);
        Node headNode = new Node(32);
        headNode.next = secondNode;
        secondNode.next = thirdNode;
        */

        invokeInsertionMethods(headNode);

        invokeDeletionMethods(headNode);

        LinkedList linkedList = new LinkedList(headNode);
        LinkedList linkedList2 = new LinkedList(headNode2);

        Node node1 = secondNode;
        Node node2 = headNode;
        linkedList.printLinkedList("BEFORE SWAP "+node1.data+" and "+node2.data);
        linkedList.swapNodes(node1, node2);
        linkedList.printLinkedList("AFTER SWAP "+node1.data+" and "+node2.data);

        int position1 = 1;
        int position2 = 3;

        linkedList.printLinkedList("BEFORE SWAP "+position1+" and "+position2);
        linkedList.swapNodes(position1, position2);
        linkedList.printLinkedList("AFTER SWAP "+position1+" and "+position2);

    }

    /**
     * Call the insertion related methods in Linked List
     * @param headNode
     */
    private static void invokeInsertionMethods(Node headNode){

        LinkedList linkedList = new LinkedList(headNode);
        linkedList.printLinkedList("Before PUSH");
        linkedList.push(12);
        linkedList.printLinkedList("After PUSH");

        int position = 1;
        linkedList.printLinkedList("Before insertAfter position "+position);
        linkedList.insertAfter(position, 12);
        linkedList.printLinkedList("After insertAfter position "+position);

        linkedList.printLinkedList("Before APPEND");
        linkedList.append(23);
        linkedList.printLinkedList("After APPEND");

    }

    /**
     * Call the deletion related methods in Linked List
     * @param headNode
     */
    private static void invokeDeletionMethods(Node headNode){

        LinkedList linkedList = new LinkedList(headNode);
        linkedList.push(12);
        linkedList.push(14);
        linkedList.push(17);

//        int key = -17;
//        linkedList.printLinkedList("Before DELETE key "+key);
//        linkedList.deleteKey(key);
//        linkedList.printLinkedList("After DELETE key "+key);

//        int position = 1;
//        linkedList.printLinkedList("Before DELETE Node at position "+position);
//        linkedList.deleteNode(position);
//        linkedList.printLinkedList("After DELETE Node at position "+position);
//
//        LOGGER.info("Count of nodes in list: "+linkedList.getCount()+" [Recurive: "+linkedList.getCountRec(linkedList.head)+"]");

    }

    /**
     * 1. We request two numbers from user using keyboard/console.
     * 2. We convert numbers to separate linked lists
     * 3. We create new linked list containing sum of the two numbers
     * 4. We print the sum as number
     */
    public static void runNumberAdditionUsingLinkedList(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter an integer number. Waiting for input...");
        int num1 = scanner.nextInt();

        System.out.println("Please enter one more integer number. Waiting for input");
        int num2 = scanner.nextInt();

        LinkedList number1 = convertIntegerToLinkedList(num1);
        LinkedList number2 = new LinkedList(convertIntegerToLinkedList_Recursively(num2));

        number1.printLinkedList("First number "+num1+" as linked list:");
        number2.printLinkedList("Second number "+num2+" as linked list:");

        LinkedList sum = addIntegerNumbersUsingLinkedList(number1, number2);
        sum.printLinkedList("Sum of numbers "+num1+" and "+num2+" represented as linked list:");

        LOGGER.info("Using Linked Lists: "+num1+" + "+num2+" = "+convertLinkedListToInteger(sum));



    }

    /**
     * Method to create linked list and call remove loop methods
     * DOESNT WORK ON CYCLIC LINKED LIST
     */
    public static void runRemoveLoopMethods(){

        Node loopStart = new Node(67);
        Node loopMerge = new Node(5);

        //<editor-fold desc="Linked List ends with a loop">
//        LinkedList linkedList_LoopSmallerThanNonLoopList = new LinkedList(loopMerge);
//        linkedList_LoopSmallerThanNonLoopList.push(12);
//        linkedList_LoopSmallerThanNonLoopList.push(11);
//        linkedList_LoopSmallerThanNonLoopList.push(10);
//        linkedList_LoopSmallerThanNonLoopList.push(41);
//        linkedList_LoopSmallerThanNonLoopList.push(42);
//        linkedList_LoopSmallerThanNonLoopList.push(9);
//        linkedList_LoopSmallerThanNonLoopList.push(8);
//        linkedList_LoopSmallerThanNonLoopList.push(7);
//        linkedList_LoopSmallerThanNonLoopList.push(6);
//        linkedList_LoopSmallerThanNonLoopList.push(loopStart);
//        linkedList_LoopSmallerThanNonLoopList.push(4);
//        linkedList_LoopSmallerThanNonLoopList.push(3);
//        linkedList_LoopSmallerThanNonLoopList.push(2);
//        linkedList_LoopSmallerThanNonLoopList.push(52);
//        linkedList_LoopSmallerThanNonLoopList.push(53);
//        linkedList_LoopSmallerThanNonLoopList.push(1);
//        loopMerge.next = loopStart;
//
//        // Cant use it because it will cause JVM heap memory issue
//        //linkedList_LoopSmallerThanNonLoopList.printlinkedList_LoopSmallerThanNonLoopList("BEFORE REMOVING LOOP");
//        linkedList_LoopSmallerThanNonLoopList.removeLoop();
//        linkedList_LoopSmallerThanNonLoopList.printLinkedList("AFTER REMOVING LOOP");
//
//
//        LinkedList linkedList_LoopLargerThanNonLoopList = new LinkedList(loopMerge);
//        linkedList_LoopLargerThanNonLoopList.push(12);
//        linkedList_LoopLargerThanNonLoopList.push(11);
//        linkedList_LoopLargerThanNonLoopList.push(loopStart);
//        linkedList_LoopLargerThanNonLoopList.push(10);
//        linkedList_LoopLargerThanNonLoopList.push(41);
//        linkedList_LoopLargerThanNonLoopList.push(42);
//        linkedList_LoopLargerThanNonLoopList.push(9);
//        linkedList_LoopLargerThanNonLoopList.push(8);
//        linkedList_LoopLargerThanNonLoopList.push(7);
//        linkedList_LoopLargerThanNonLoopList.push(6);
//        linkedList_LoopLargerThanNonLoopList.push(4);
//        linkedList_LoopLargerThanNonLoopList.push(3);
//        linkedList_LoopLargerThanNonLoopList.push(2);
//        linkedList_LoopLargerThanNonLoopList.push(52);
//        linkedList_LoopLargerThanNonLoopList.push(53);
//        linkedList_LoopLargerThanNonLoopList.push(1);
//        loopMerge.next = loopStart;
//
//        // Cant use it because it will cause JVM heap memory issue
//        //linkedList_LoopLargerThanNonLoopList.printlinkedList("BEFORE REMOVING LOOP");
//        linkedList_LoopLargerThanNonLoopList.removeLoop();
//        linkedList_LoopLargerThanNonLoopList.printLinkedList("AFTER REMOVING LOOP");
        //</editor-fold>

        // DOESNT WORK FOR A CYCLIC LINKED LIST

        //<editor-fold desc="Linked List starts with a loop i.e. is a loop">
        LinkedList linkedList_LoopSmallerThanNonLoopList = new LinkedList(loopMerge);
        linkedList_LoopSmallerThanNonLoopList.push(12);
        linkedList_LoopSmallerThanNonLoopList.push(11);
        linkedList_LoopSmallerThanNonLoopList.push(10);
        linkedList_LoopSmallerThanNonLoopList.push(41);
        linkedList_LoopSmallerThanNonLoopList.push(42);
        linkedList_LoopSmallerThanNonLoopList.push(9);
        linkedList_LoopSmallerThanNonLoopList.push(8);
        linkedList_LoopSmallerThanNonLoopList.push(7);
        linkedList_LoopSmallerThanNonLoopList.push(6);
        linkedList_LoopSmallerThanNonLoopList.push(4);
        linkedList_LoopSmallerThanNonLoopList.push(3);
        linkedList_LoopSmallerThanNonLoopList.push(2);
        linkedList_LoopSmallerThanNonLoopList.push(52);
        linkedList_LoopSmallerThanNonLoopList.push(53);
        linkedList_LoopSmallerThanNonLoopList.push(1);
        linkedList_LoopSmallerThanNonLoopList.push(loopStart);
        loopMerge.next = loopStart;

        // Cant use it because it will cause JVM heap memory issue
        //linkedList_LoopSmallerThanNonLoopList.printlinkedList_LoopSmallerThanNonLoopList("BEFORE REMOVING LOOP");
        linkedList_LoopSmallerThanNonLoopList.removeLoop();
        linkedList_LoopSmallerThanNonLoopList.printLinkedList("AFTER REMOVING LOOP");
        //</editor-fold>

    }

    /**
     * Method to crete linked list and call reverse methods
     */
    public static void runReverseMethods(){

        LinkedList linkedList = new LinkedList(new Node(9));
        linkedList.push(8);
        linkedList.push(7);
        linkedList.push(6);
        linkedList.push(5);
        linkedList.push(4);
        linkedList.push(3);
        linkedList.push(2);
        linkedList.push(1);

        int subsetSize = 3;

//        linkedList.printLinkedList("Before REVERSE");
//        linkedList.reverse_Iterative();
//        linkedList.printLinkedList("After REVERSE");

//        linkedList.printLinkedList("BEFORE ITERATIVE REVERSE BY SUBSET SIZE: "+subsetSize );
//        linkedList.reverse_Iterative(subsetSize);
//        linkedList.printLinkedList("AFTER ITERATIVE REVERSE BY SUBSET SIZE: "+subsetSize );

        linkedList.printLinkedList("BEFORE RECURSIVE REVERSE BY SUBSET SIZE: "+subsetSize );
        linkedList.reverse_Recursive(subsetSize);
        linkedList.printLinkedList("AFTER RECURSIVE REVERSE BY SUBSET SIZE: "+subsetSize );

    }

    public static void runMergeSortSample(){

        LinkedList linkedList = new LinkedList(new Node(9));
        linkedList.push(8);
        linkedList.push(7);
        linkedList.push(6);
        linkedList.push(5);
        linkedList.push(4);
        linkedList.push(3);
        linkedList.push(2);
        linkedList.push(1);

        linkedList.printLinkedList("BEFORE MERGE SORT");
        linkedList.mergeSort();
    }

    /**
     * Print data in linked list from head to tail using simple loop
     */
    public void printLinkedList(String message){

        if(message==null || message.length()<1)
            message = "";

        StringBuilder strBuilder = new StringBuilder("Printing data of Linked List: "+message+"\n\n");

        Node curr = head;

        if(curr==null) {
            strBuilder.append("NULL");
        } else {
            while(curr!=null) {
                //LOGGER.info("["+curr.data+"] --> ");
                strBuilder.append("["+curr.data+"] --> ");
                curr = curr.next;
                if(curr==null)
                    strBuilder.append("NULL");
            }
        }
        strBuilder.append("\n\n");
        LOGGER.info(strBuilder.toString());

    }

    /**
     * Pushes a new Node at front of the Linked List
     * Time - O(1)
     * @param data
     */
    public void push(int data){

        Node newNode = new Node(data);

        newNode.next = head;

        head = newNode;

    }

    /**
     * Pushes a new Node at front of the Linked List
     * Time - O(1)
     * @param node
     */
    public void push(Node node){

        if(node!=null) {
            node.next = head;
            head = node;
        }

        else
            LOGGER.info("Cannot push NULL node at head.");


    }

    /**
     * Inserts given data after given node in linked list
     * @param node
     * @param data
     */
    public void insertAfter(Node node, int data) {

        if(node!=null) {

            Node newNode = new Node(data);

            if(node==null)
                node = newNode;
            else {
                newNode.next = node.next;
                node.next = newNode;
            }


        } else {
            LOGGER.info("Target node is null.");
        }

    }

    /**
     * Inserts a node next to given position
     * @param position [0 , LinkedList.Length-1]
     */
    public void insertAfter(int position, int data) {

        if(head!=null) {
            Node curr = head;
            int currNodePosition = 0;
            while(curr!=null) {

                if(currNodePosition==position) {

                    insertAfter(curr, data);
                    break;
                }
                curr = curr.next;
                currNodePosition++;

            }
            // If given position is more than the length of Linked List
            if(currNodePosition!=position) {
                LOGGER.info("Target position exceeds the length of linked list or is less than 0");
            }

        } else {
            insertAfter(head, data);
        }

    }

    /**
     * Appends a node at the end of linkedlist
     * @param data
     */
    public void append(int data) {

        Node newNode = new Node(data);
        if(head==null)
            head = newNode;

        Node curr = head;
        while(curr.next != null)
            curr = curr.next;

        curr.next = newNode;

    }

    /**
     * Deletes node containing the first occurrence of given key from linked list
     * @param key
     */
    public void deleteKey(int key){

        if(head==null)
            LOGGER.info("Empty linked list.");

        else if(head.data==key) {
            Node temp = head;
            head = head.next;
            temp = null;
            return;
        } else {
            Node curr = head;
            Node prev = curr;

            while(curr!=null) {

                if(key == curr.data) {
                    prev.next = curr.next;
                    curr = null;
                    return;
                }

                prev = curr;
                curr = curr.next;
            }
            LOGGER.info("Key "+key+" not found");
        }

    }

    /**
     * Deletes the node at given position
     * @param position [0, LinkedList.length-1]
     */
    public void deleteNode(int position) {

        if(head==null) {
            LOGGER.info("Linked List is empty.");
            return;
        }

        if(position==0) {
            Node temp = head;
            head = head.next;
            temp = null;
        }
        else {
            Node curr = head;
            Node prev = curr;
            int currNodePosition = 0;

            while(curr!=null) {

                if(currNodePosition==position) {
                    Node temp = curr;
                    prev.next = curr.next;
                    temp = null;
                }

                prev = curr;
                curr = curr.next;
                currNodePosition++;
            }
            LOGGER.info("Given position not available in linked list.");
        }

    }

    /**
     * Returns count of nodes in linked list
     * @return
     */
    public int getCount(){

        Node curr = head;
        int count=0;
        while(curr!=null) {
            count++;
            curr = curr.next;
        }

        return count;

    }

    /**
     * Returns count of nodes in linked list by recurrsion
     * @param node
     * @return
     */
    public int getCountRec(Node node){

        if(node==null)
            return 0;

        return 1 + getCountRec(node.next);

    }

    /**
     * Swap the given nodes by reference not by exchanging data
     * @param node1
     * @param node2
     */
    public void swapNodes(Node node1, Node node2) {

        if(head==null) {
            LOGGER.info("Empty Linked List");
        } else if(node1 == node2) {
            LOGGER.info("Both nodes are same. No swapping applicable.");
        } else {

            Node prev1 = null;
            Node prev2 = null;

            Node curr = head;
            Node prev = curr;
            while(curr!=null) {

                if(node1==curr)
                    prev1 = prev;

                if(node2==curr)
                    prev2 = prev;

                prev = curr;
                curr = curr.next;
            }

            if(node1!=head && node2!=head) {

                Node temp = node2.next;

                prev1.next = node2;
                node2.next = node1.next;

                prev2.next = node1;
                node1.next = temp;

            } else if(node1==head && node2!=head){

                // Node 1 moved to node 2 position
                prev2.next = node1;
                Node temp = node1.next;
                node1.next = node2.next;

                // Node 2 set as header
                node2.next = temp;
                head = node2;

            } else if(node1!=head && node2==head){

                // Node 2 moved to node 1 position
                prev1.next = node2;
                Node temp = node2.next;
                node2.next = node1.next;

                // Node 1 set as header
                node1.next = temp;
                head = node1;

            }

        }

    }

    /**
     * Swap nodes at given positions using pointers. Dont swap data.
     * @param position1
     * @param position2
     */
    public void swapNodes(int position1, int position2) {

        if(position1==position2) {
            LOGGER.info("Both positions are same. No swapping applicable.");
        } else if(head==null) {
            LOGGER.info("Linked List is empty.");
        } else {

            position1 = Math.min(position1, position2);
            position2 = Math.max(position1, position2);

            Node node1 = null;
            Node node2 = null;

            Node prev1 = null;
            Node prev2 = null;

            Node curr = head;
            Node prev = curr;
            int currNodePosition = 0;
            while(curr!=null) {

                if(currNodePosition==position1) {
                    node1 = curr;
                    prev1 = prev;
                }
                if(currNodePosition==position2) {
                    node2 = curr;
                    prev2 = prev;
                }

                prev = curr;
                curr = curr.next;
                currNodePosition++;
            }

            LOGGER.info(position1+": "+prev1.data+" -> "+node1.data);
            LOGGER.info(position2+": "+prev2.data+" -> "+node2.data);
            if(currNodePosition<Math.max(position1, position2)) {
                LOGGER.info("Positions entered are beyond the range of linked list item count.");
                return;
            }

            if(node1==null || node2==null) {
                LOGGER.info("Nodes not found");
                return;
            }

            // If one of the nodes to be swapped is Head of linked list
            if(node1==head) {

                head = node2;
                // if the nodes are adjacent to each other
                if(node1.next == node2) {

                    Node temp = node2.next;
                    node2.next = node1;
                    node1.next = temp;

                } else {

                    prev2.next = node1;
                    Node temp = node1.next;
                    node1.next = node2.next;

                    node2.next = temp;
                    head = node2;

                }

            } else if(node1.next == node2) {

                // If the nodes are adjacent

                if(prev1!=null)
                    prev1.next = node2;
                Node temp = node2.next;
                node2.next = node1;

                node1.next = temp;

            } else if(node2.next==node1) {

                // Node2 will always come after Node1 as we sorted the position indices

            } else {

                // If the nodes are not adjacent

                if(prev1!=null)
                    prev1.next = node2;
                Node temp = node2.next;
                node2.next = node1.next;

                if(prev2!=null)
                    prev2.next = node1;
                node1.next = temp;

            }

        }

    }

    /**
     * Reverse the linked list
     */
    public void reverse_Iterative() {

        // Prev -> Curr -> Next

        // Prev <- Curr <- Next

        if(head==null) {
            LOGGER.info("Empty linked list.");
            return;
        }

        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr!=null) {

            next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;

        }

        head = prev;

    }

    /**
     * Merge two sorted linked lists in ascending order
     * @param node1
     * @param node2
     * @return
     */
    public static Node sortedMerge_Recursive(Node node1, Node node2) {

        Node result = null;
        /* Base cases */
        if (node1 == null)
            return node2;
        if (node2 == null)
            return node1;

        /* Pick either a or b, and recur */
        if (node1.data <= node2.data) {
            result = node1;
            result.next = sortedMerge_Recursive(node1.next, node2);
        }

        else {
            result = node2;
            result.next = sortedMerge_Recursive(node1, node2.next);
        }
        return result;

    }

    /**
     * Merge two linked lists which are already sorted
     * @param head1
     * @param head2
     */
    public static LinkedList sortedMerge(Node head1, Node head2){

        // A: 1 -> 2 -> 4 ->4

        // B: 0 -> 3 -> 5 ->100

        if(head1 == null && head2 == null) {

            LOGGER.info("Both lists are empty.");
            return null;

        }

        Node curr1 = head1;
        Node curr2 = head2;
        Node currNewList = null;
        Node newListHead = null;

        while(curr1!=null || curr2!=null) {

            Node newNode;

            if(curr1==null && curr2!=null) {

                newNode = new Node(curr2.data);
                curr2 = curr2.next;

            } else if(curr1!=null && curr2==null) {

                newNode = new Node(curr1.data);
                curr1 = curr1.next;

            } else {

                if(curr1.data < curr2.data) {

                    newNode = new Node(curr1.data);
                    curr1 = curr1.next;

                } else if(curr1.data > curr2.data) {

                    newNode = new Node(curr2.data);
                    curr2 = curr2.next;

                } else {

                    newNode = new Node(curr1.data);
                    newNode.next = new Node(curr2.data);
                    curr1 = curr1.next;
                    curr2 = curr2.next;

                }

            }

            if(newListHead==null) {
                newListHead = newNode;
                currNewList = newListHead;
            } else {
                currNewList.next = newNode;
                currNewList = currNewList.next;
                if(currNewList.next!=null)
                    currNewList = currNewList.next;
            }

        }

        return new LinkedList(newListHead);

    }

    /**
     * Sorts the current Linked List using Merge Sort
     *
     * 1. Split the linked list in two halves with middle Node as pivot point
     */
    public void mergeSort(){

        printLinkedList("BEFORE MERGE SORT");
        LinkedList sortedList = new LinkedList(mergeSort(head));
        sortedList.printLinkedList("AFTER MERGE SORT");

    }

    /**
     * This method is used to split linked list using middle node as split point and merging the single nodes into new list
     * @param head
     * @return
     */
    private static Node mergeSort(Node head){

        if(head==null || head.next==null)
            return head;

        Node midNode = getMiddleNodeOfLinkedList(head);

        Node leftHead = head;
        Node rightHead = midNode.next;
        midNode.next = null;

        Node leftSortedList = mergeSort(leftHead);
        Node rightSortedList = mergeSort(rightHead);

        LinkedList temp = sortedMerge(leftSortedList, rightSortedList);

        return temp==null?null:temp.head;

    }

    /**
     * Returns the middle node of linked list
     * @return
     */
    private static Node getMiddleNodeOfLinkedList(Node head){

        if(head==null) {
            LOGGER.info("Linked list is empty");
            return null;
        }

        if(head.next==null) {
            LOGGER.info("Linked list has only one item");
            return head;
        }

//        if(head.next.next==null) {
//            LOGGER.info("Linked list has only two items. Returning first one as middle");
//            return head.next;
//        }

        // (HEAD)A -> B -> C -> D -> E -> F

        Node fastNode = head.next;
        Node slowNode = head;

        while(fastNode!=null) {
            fastNode = fastNode.next;
            if(fastNode!=null) {
                slowNode = slowNode.next;
                fastNode = fastNode.next;
            };
        }

        LOGGER.info("Middle NODE DATA: "+slowNode.data);

        return slowNode;

    }

    /**
     * Reverse subset of linked list with given subset size
     *
     * USES ITERATIVE METHOD
     *
     * e.g.
     * i/p - 1, 2, 3,  4, 5, 6,  7, 8, 9 with subset size 3
     * o/p - 3, 2, 1,  6, 5, 4,  9, 8, 7
     *
     * @param subsetSize
     */
    public void reverse_Iterative(int subsetSize) {

        if(subsetSize<1) {
            LOGGER.info("Subset size is less than one - Reverse by subset not applicable");
            return;
        }

        if(head==null) {
            LOGGER.info("Empty linked list - Reverse by subset not applicable");
            return;
        }

        Node curr = head;

        // I/P: 1->2->3->4 -> 5->6
        // O/P: 4->3->2->1 -> 6->5
        Node newhead = null;
        Node currNext = null;
        Node currPrev = null;
        while(curr!=null) {

            LOGGER.info("Curr Data: "+curr.data);
            Node subsetCurr = curr;
            Node subsetPrev = subsetCurr;
            Node subsetNext = null;
            for(int i=0; i<subsetSize && subsetCurr!=null; i++) {

                LOGGER.info("Subset Curr Data: "+subsetCurr.data);

                subsetNext = subsetCurr.next;
                subsetCurr.next = subsetPrev;
                subsetPrev = subsetCurr;
                subsetCurr = subsetNext;

            }

            if(newhead==null)
                newhead = subsetPrev;

            if(currPrev!=null)
                currPrev.next = subsetPrev;

            currPrev = curr;

            curr.next = subsetCurr;
            curr = curr.next;

        }
        head = newhead;

    }

    /**
     * Reverse subset of linked list with given subset size
     *
     * USES RECURSIVE METHOD
     *
     * e.g.
     * i/p - 1, 2, 3,  4, 5, 6,  7, 8, 9 with subset size 3
     * o/p - 3, 2, 1,  6, 5, 4,  9, 8, 7
     *
     * @param subsetSize
     */
    public void reverse_Recursive(int subsetSize) {

        head = reverse(head, subsetSize);

    }

    /**
     * Reverse the given linked list by subsets of given size using recursion
     * @param subsetHead
     * @param subsetSize
     * @return new Head of subset list
     */
    private Node reverse(Node subsetHead, int subsetSize) {

        if(subsetHead==null || subsetSize<1)
            return null;

        Node curr = subsetHead;
        Node next = null;
        Node prev = null;

        int count = 0;
        while(curr!=null && count<subsetSize) {

            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;

        }

        subsetHead.next = reverse(next, subsetSize);

        // Prev is the last element of original list, which is now the first element of reversed list;
        return prev;

    }

    /**
     * Removes the loop from a linked list
     */
    private void removeLoop(){

        Node nodeOnLoop = getANodeOnLoop();
        if(nodeOnLoop==null) {
            LOGGER.info("No loop found.");
            return;
        }

        removeLoop(nodeOnLoop);

        LOGGER.info("Node on loop: "+nodeOnLoop.data);

    }

    /**
     * We have a node on loop. if we start pointer from that node and from any other node on linked list,
     * we will reach the node which starts the loop in some unknown countable number of loops.
     * @param nodeOnLoop
     */
    private void removeLoop(Node nodeOnLoop){

        if(head==null) {
            LOGGER.info("Cannot remove loop as Linked list is empty.");
            return;
        }

        if(nodeOnLoop==null) {
            LOGGER.info("Cannot remove loop as given node on loop is NULL.");
            return;
        }

        Node node1 = head;
        Node node2 = nodeOnLoop;

        final boolean INFINITE_LOOP = true;

        while (INFINITE_LOOP) {

            if(node1.next == node2.next) {
                LOGGER.info("Loop Starting at: "+node2.next.data);
                node2.next = null;
                return;
            }
            node1 = node1.next;
            node2 = node2.next;

        }

    }

    /**
     *
     * @return returns null if no loop, else a Node on loop
     */
    private Node getANodeOnLoop(){

        if(head==null) {
            LOGGER.info("Empty Linked List");
            return null;
        }

        Node nodeOnLoop = null;

        Node fastNode = head;
        Node slowNode = head;

        while(slowNode!=null && fastNode!=null && fastNode.next!=null) {

            slowNode = slowNode.next;
            fastNode = fastNode.next.next;

            if(fastNode==slowNode) {
                nodeOnLoop = slowNode;
                break;
            }

        }


        return nodeOnLoop;

    }

    /**
     * Converts linked list to number
     * Linked List [7 -> 3 -> 2 -> 6 -> 1 -> NULL] is converted to 16237
     * @param numberList
     * @return
     */
    private static int convertLinkedListToInteger(LinkedList numberList){

        if(numberList==null)
            throw new RuntimeException("Empty linked list cannot be converted to integer");

        Node head = numberList.head;

        if(head==null)
            throw new RuntimeException("Given linked list has null node");

        int number = 0;
        int digitPlace = 0;

        while(head!=null) {

            number += head.data * Math.pow(10, digitPlace);
            head = head.next;
            digitPlace++;

        }

        return number;

    }

    /**
     * NOTE: DOES NOT WORK ON 0
     * The number 12345 becomes (HEAD) 5 -> 4 -> 3 -> 2 -> 1 -> NULL
     * @param number
     * @return returns head of linkedlist representing given number
     */
    private static Node convertIntegerToLinkedList_Recursively(int number) {

        if(number==0)
            return null;

        // 1234
        int digit = number%10;
        number = number/10;

        return new Node(digit, convertIntegerToLinkedList_Recursively(number));

    }


    /**
     * Add two positive integer numbers represented by two linked lists
     * @param linkedList1
     * @param linkedList2
     * @return linked list representing sum of two positive integers represented by given linked list
     */
    private static LinkedList addIntegerNumbersUsingLinkedList(LinkedList linkedList1, LinkedList linkedList2){

        if(linkedList1==null)
            return linkedList2;

        if(linkedList2==null)
            return linkedList1;


        Node head1 = linkedList1.head;
        Node head2 = linkedList2.head;

        if(head1==null)
            return linkedList2;

        if(head2==null)
            return linkedList1;

        Node curr1 = head1;
        Node curr2 = head2;
        Node sumHead = null;
        Node currSumNode = null;
        Node prevSumNode = null;
        int prevSumCarry = 0;

        while(!(curr1==null && curr2==null)) {

            int currSummedDigit = prevSumCarry;

            if(curr1!=null)
                currSummedDigit += curr1.data;

            if(curr2!=null)
                currSummedDigit += curr2.data;

            prevSumCarry = currSummedDigit>=10?currSummedDigit / 10 : 0;

            currSummedDigit %= 10;

            currSumNode = new Node(currSummedDigit);

            if(prevSumNode!=null)
                prevSumNode.next = currSumNode;
            if(sumHead==null)
                sumHead = currSumNode;

            prevSumNode = currSumNode;

            if(curr1!=null)
                curr1 = curr1.next;

            if(curr2!=null)
                curr2 = curr2.next;

        }

        // Carry shall be always less than equal to 1. E.g. 99 + 99 = 198
        if(prevSumCarry>0) {
            currSumNode = new Node(prevSumCarry);
            prevSumNode.next = currSumNode;
        }

        return new LinkedList(sumHead);

    }

    /**
     * The number 12345 becomes (HEAD) 5 -> 4 -> 3 -> 2 -> 1 -> NULL
     * @param number
     * @return returns LinkedList representing given number
     */
    private static LinkedList convertIntegerToLinkedList(int number){

        Node head = null;

        if(number==0)
            head = new Node(number);
        else {
            Node curr = head;
            Node prev;
            for(int num = number; num>0; num = num/10) {

                // Take the least value digit/ leftmost digit form number
                int digit = num % 10;

                prev = curr;

                curr = new Node(digit);

                if(prev!=null)
                    prev.next = curr;
                if(head==null) {
                    head = curr;
                }

            }
        }



        return new LinkedList(head);

    }

    /**
     * Rotate linked list by k nodes in anti clockwise direction
     * @param k
     */
    public void rotateAntiClockwise_nonOptimized(int k){

        int numNodes = this.getCount();

        if(k>numNodes) {
            LOGGER.info("Cannot rotate linked list by a value greater than the number of nodes in the list");
            return;
        }

        if(k<0) {
            LOGGER.info("Rotating a linked list by 0 nodes not meaning ful.");
            return;
        }

        Node prev = head;
        Node prevPrev = null;
        for (int i=numNodes-1; i>k; i--) {

            if(prev==null) {
                LOGGER.info("Linked list length is shorter than rotation constant");
                return;
            }

            prevPrev = prev;
            prev = prev.next;

        }

        Node newhead = prev;
        prev.next = head;
        head = newhead;
        if(prevPrev!=null)
            prevPrev.next = null;

    }
    

}
