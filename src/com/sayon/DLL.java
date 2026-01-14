package com.sayon;

public class DLL {
    public class Node{
        int value;
        Node next;
        Node prev;
        Node(int value){
            this.value=value;
            this.next=null;
            this.prev=null;
        }
    }
    private Node head;
    public DLL(){
        head=null;
    }
    //Inserting functions
    public void insert_first(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            return;
        }
        node.next=head;
        head.prev=node;
        head=node;
    }
    public void insert_last(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=node;
        node.prev=temp;
    }

    public void insert(int val,int pos){
        Node node=new Node(val);
        if(pos==0){
            insert_first(val);
            return;
        }
        int totalnum=count();
        if(pos==totalnum){
            insert_last(val);
            return;
        }
        Node temp=head;
        while(pos-->0){
            temp=temp.next;
        }
        temp.prev.next=node;
        node.prev=temp.prev;
        node.next=temp;
        temp.prev=node;
    }
    //  counting the total number of nodes
    public int count(){
        Node temp=head;
        int total=0;
        while(temp!=null){
            total++;
            temp=temp.next;
        }
        return total;
    }
    // Display Function
    public void display(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+ "  ");
            temp=temp.next;
        }
        System.out.println();
    }
    //Deleting function
    public void delete_first(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        head=head.next;
        if(head!=null){
            head.prev=null;
        }
    }
    public void delete_last(){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.prev.next=null;
    }
    public void delete(int pos){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        if(pos==0){
            delete_first();
            return;
        }
        int totalnum=count();
        if(pos==totalnum-1){
            delete_last();
            return;
        }
        Node temp=head;
        while(pos-->0){
            temp=temp.next;
        }
        temp.prev.next=temp.next;
        if(temp.next!=null){
            temp.next.prev=temp.prev;
        }
    }

    //search function
    public void search(int val){
        if(head==null){
            System.out.println("The list is empty");
            return;
        }
        Node temp=head;
        while(temp!=null && temp.value!=val){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Value not found");
        }
        else{
            System.out.println("Value is found in the list");
        }
    }
    
}
