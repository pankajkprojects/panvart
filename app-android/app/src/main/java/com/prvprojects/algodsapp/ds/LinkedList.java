package com.prvprojects.algodsapp.ds;


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

    Node head;

    public LinkedList(Node head) {
        this.head = head;
        this.LOGGER.setLevel(Level.INFO);
    }

    public static void main(String args[]){

        // Creating a linked list
        Node fifthNode = new Node(10);
        Node fourthNode = new Node(9, fifthNode);
        Node thirdNode = new Node(8, fourthNode);
        Node secondNode = new Node(7, thirdNode);
        Node headNode = new Node(6, secondNode);

        // Creating a linked list
        Node fifthNode2 = new Node(5);
        Node fourthNode2 = new Node(4, fifthNode2);
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

        //invokeInsertionMethods(headNode);

        //invokeDeletionMethods(headNode);

        LinkedList linkedList = new LinkedList(headNode);
        LinkedList linkedList2 = new LinkedList(headNode2);

//        Node node1 = secondNode;
//        Node node2 = headNode;
//        linkedList.printLinkedList("BEFORE SWAP "+node1.data+" and "+node2.data);
//        linkedList.swapNodes(node1, node2);
//        linkedList.printLinkedList("AFTER SWAP "+node1.data+" and "+node2.data);

        int position1 = 1;
        int position2 = 3;

//        linkedList.printLinkedList("BEFORE SWAP "+position1+" and "+position2);
//        linkedList.swapNodes(position1, position2);
//        linkedList.printLinkedList("AFTER SWAP "+position1+" and "+position2);

//        linkedList.printLinkedList("Before REVERSE");
//        linkedList.reverse();
//        linkedList.printLinkedList("After REVERSE");

        sortedMerge(headNode, headNode2).printLinkedList("After SORTED MERGE - LIST");



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
    public void reverse() {

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

        while(curr1!=null && curr2!=null) {

            Node newNode = null;
            // Used only when both nodes being compared have same data value
            Node newNode2 = null;
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

                } else if(curr2.data < curr1.data) {

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

}
