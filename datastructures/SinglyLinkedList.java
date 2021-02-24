package datastructures;

import java.util.HashSet;

public class SinglyLinkedList {
    Node head = null;

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new Node(1);
        list.head.next = new Node(2);
        list.head.next.next = new Node(3);
        list.head.next.next.next = new Node(4);
        list.head.next.next.next.next = new Node(5);
        list.head.next.next.next.next.next = new Node(6);
        list.head.next.next.next.next.next.next = new Node(7);
        list.head.next.next.next.next.next.next.next = new Node(8);
        list.head.next.next.next.next.next.next.next.next = new Node(9);
        list.head.next.next.next.next.next.next.next.next.next = new Node(10);

        //printLinkedList(kthToLastWithPointers(list.head, 5));
        printLinkedList(reverse(list.head));
    }

    // Add a new node and return the head of the list
    static Node insertNode(SinglyLinkedList linkedList, int data) {
        Node newNode = new Node(data);

        if (linkedList.head == null) {
            linkedList.head = newNode;
            return linkedList.head;
        }

        Node current = linkedList.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        return linkedList.head;
    }

    // Delete an existing Node and return the head of the list
    static Node deleteNode(SinglyLinkedList linkedList, int data) {

        Node node = linkedList.head;

        if (linkedList.head == null) {
            return null;
        }

        if (node.val == data) {
            linkedList.head = node.next;
            return linkedList.head;
        }

        while (node.next != null) {
            if (node.next.val == data) {
                node.next = node.next.next;
                return linkedList.head;
            }
            node = node.next;
        }
        return linkedList.head;
    }

    static void printLinkedList(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.val + " -> ");
            currentNode = currentNode.next;
        }
    }

    /**
     * reverse linked list (iterative solution)
     */
    static Node reverse(Node headNode) {
        if (headNode == null || headNode.next == null) {
            return headNode;
        }

        Node reversedList = headNode;
        Node leftOverList = headNode.next;
        reversedList.next = null;

        while (leftOverList != null) {
            Node currentNode = leftOverList;
            leftOverList = leftOverList.next;
            currentNode.next = reversedList;
            reversedList = currentNode;
        }
        return reversedList;
    }

/*
    */
/**
     * reverse linked list (recursive solution)
     *//*

    static Node reverseList(Node node) {

    }
*/

    /**
     * The RUNNER technique
     * Iterate through a linked list with 2 pointers simultaneously. One of the pointer is fast
     * and the other pointer is slow... i.e. the fast pointer always moves e.g 2 steps while the slow pointer
     * moves 1 step. Length of the linked list is unknown but an even number.
     */
    static Node runThroughList(Node node) {
        Node pointer1 = node;
        Node pointer2 = node.next;

        while (pointer2.next != null) {
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;
        }

        pointer2 = node;

        while (pointer1.next != null && pointer2.next != null) {
            Node temp = pointer2.next;
            pointer2.next = new Node(pointer1.next.val);
            pointer2.next.next = temp;
            pointer2 = pointer2.next.next;
            pointer1.next = pointer1.next.next;
        }
        return node;
    }

    /**
     * Delete duplicates in linked list
     */

    static Node deleteDuplicate(SinglyLinkedList node) {

        HashSet<Integer> hashTable = new HashSet<>();
        Node previousNode = null;
        Node currentNode = node.head;

        while (currentNode != null) {
            if (hashTable.contains(currentNode.val)) {
                // remove current node
                previousNode.next = currentNode.next;
            } else {
                hashTable.add(currentNode.val);
                previousNode = currentNode;
            }

            currentNode = currentNode.next;
        }
        return node.head;
    }

    /**
     * Delete duplicates in sorted linked list
     */
    public Node deleteDuplicates(Node head) {

        if (head == null) {
            return null;
        }

        Node previousNode = head;
        Node currentNode = head.next;
        int data = head.val;

        while (currentNode != null) {
            if (data == currentNode.val) {
                previousNode.next = currentNode.next;
            } else {
                previousNode = currentNode;
            }
            data = currentNode.val;
            currentNode = currentNode.next;
        }
        return head;

    }

    /**
     * return kth to last element (e.g. 2nd to last element of a linked list)
     */
    static int indexCount = 0;
    static Node kthToLast(Node node, int k) {
        if (node == null) {
            return null;
        }

        Node currentNode = kthToLast(node.next, k);
        indexCount++;
        if (indexCount == k) {
            return node;
        }
        return currentNode;
    }

    /**
     * return kth to last element using 2 pointers
     * the pointers are distance k apart...
     * on each iteration, by the time p2 is at the end,
     * p1 is k elements away.
     */

    static Node kthToLastWithPointers(Node node, int k) {
        Node p1 = node;
        Node p2 = node;

        // move p2 k elements into the list
        for (int i = 0; i < k; i++) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }

        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    /**
     * sum two linked lists in reverse order
     */
    static Node sumList(Node element1, Node element2, int carry) {
        if (element1 == null && element2 == null && carry == 0) {
            return null;
        }

        Node result = new Node();
        int value = carry;

        if (element1 != null) {
            value += element1.val;
        }
        if (element2 != null) {
            value += element2.val;
        }

        result.val = value % 10;

        if (element1 != null || element2 != null) {
            Node more = sumList(element1 == null ? null : element1.next,
                    element2 == null ? null : element2.next,
                    value >= 10 ? 1 : 0);
            result.next = more;
        }
        return result;
    }

    static class Node {
        Node next = null;
        int val;

        Node(int data) {
            this.val = data;
        }

        Node() {

        }

        void appendToTail(int data) {
            Node newTail = new Node(data);
            Node linkedList = this;

            while (linkedList.next != null) {
                linkedList = linkedList.next;
            }
            linkedList.next = newTail;
        }
    }
}
