package com.sayon;

public class CLL {

    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head;

    public CLL() {
        head = null;
    }

    // ===================== INSERT FUNCTIONS =====================
    public void insert_first(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            node.next = head;
            return;
        }
        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        node.next = head;
        tail.next = node;
        head = node;
    }

    public void insert_last(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = node;
            node.next = head;
            return;
        }
        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        tail.next = node;
        node.next = head;
    }

    public void insert(int val, int pos) {
        if (pos == 0) {
            insert_first(val);
            return;
        }
        int totalnum = count();
        if (pos == totalnum) {
            insert_last(val);
            return;
        }
        if (pos > totalnum || pos < 0) {
            System.out.println("Invalid position");
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node(val);
        node.next = temp.next;
        temp.next = node;
    }

    // ===================== COUNT FUNCTION =====================
    public int count() {
        if (head == null) return 0;
        Node temp = head;
        int total = 0;
        do {
            total++;
            temp = temp.next;
        } while (temp != head);
        return total;
    }

    // ===================== DISPLAY FUNCTION =====================
    public void display() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node temp = head;
        do {
            System.out.print(temp.value + "  ");
            temp = temp.next;
        } while (temp != head);
        System.out.println();
    }

    // ===================== DELETE FUNCTIONS =====================
    public void delete_first() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        head = head.next;
        tail.next = head;
    }

    public void delete_last() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == head) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != head) {
            temp = temp.next;
        }
        temp.next = head;
    }

    public void delete(int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        int totalnum = count();
        if (pos < 0 || pos >= totalnum) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 0) {
            delete_first();
            return;
        }
        if (pos == totalnum - 1) {
            delete_last();
            return;
        }
        Node temp = head;
        for (int i = 0; i < pos - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
    }

    // ===================== SEARCH FUNCTION =====================
    public void search(int val) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        do {
            if (temp.value == val) {
                System.out.println("Key found");
                return;
            }
            temp = temp.next;
        } while (temp != head);
        System.out.println("Key not found");
    }
}
