package com.jlgg.two;


import java.util.HashSet;
import java.util.Set;

/**
 * Write code to remove duplicates from an unsorted linked list.
 */
public class One {

    static Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void insertEnd(int data) {
        Node newNode = new Node(data);
        // Empty list
        if (head == null) {
            head = newNode;
            return;
        }
        // Get the last node
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        // Point the last node to the new Node
        last.next = newNode;
        // Point the new node to null (new node is now the last)
        newNode.next = null;
    }

    static void populateList(int[] data) {
        for (int el : data) {
            insertEnd(el);
        }
    }

    static void printList() {
        Node n = head;
        while (n.next != null) {
            System.out.print(n.data + ", ");
            n = n.next;
        }
        System.out.println(n.data);

    }

    /**
     * This approach uses a Set as help to store unique elements
     * <p>
     * Time Complexity:
     * O(N) - Linear, N = number of elements in the list
     * Space Complexity:
     * O(N) - Linear, N = number of elements in the list (worst case)
     */
    static void removeDuplicates() {
        Set<Integer> set = new HashSet<>();
        Node current = head, previous = null;
        while (current != null) {
            if (set.contains(current.data)) {
                // bypass current element (point previous node to next node)
                previous.next = current.next;
            } else {
                set.add(current.data);
                previous = current;
            }
            // move forward in the list
            current = current.next;
        }
    }

    /**
     * No Buffer allowed Solution
     * Iterates with 2 pointers:
     * a) "current" through the all list,
     * b) "runner" checks subsequent nodes to remove duplicates
     * <p>
     * Time Complexity:
     * O(N^2) - Quadratic, N = number of elements in the list
     * Space Complexity:
     * O(1) - Constant
     */
    static void removeDuplicatesNoBuffer() {
        Node runner;
        Node current = head;
        while (current != null) {
            runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    // bypass runner.next
                    runner.next = runner.next.next;
                } else {
                    // move forward in the list
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }


    public static void main(String[] args) {
        int[] data = {1, 2, 1, 4, 5, 2, 3, 3, 8, 9, 10, 11, 2, 10};
        // populate list
        populateList(data);
        // Remove Duplicates
        removeDuplicatesNoBuffer();
        // Print Results
        printList();
    }
}
