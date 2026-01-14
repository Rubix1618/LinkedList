package com.sayon;

public class CLL {
    public class Node{
        int value;
        Node next;
        Node(int value){
            this.value=value;
            this.next=null;
        }
    }
    private Node head;
    public CLL(){
        head=null;
    }
    //Inserting functions
    public void insert_first(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            node.next=head;
            return;
        }
        Node tail=head;
        while(tail.next!=head){
            tail=tail.next;
        }
        tail.next=node;
        node.next=head;
        head=node;
    }
    public void insert_last(int val){
         Node node=new Node(val);
        if(head==null){
            head=node;
            node.next=head;
            return;
        }
        Node tail=head;
        while(tail.next!=head){
            tail=tail.next;
        }
        node.next=tail.next;
        tail.next=node;
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
        for(int i=0;i<pos-1;i++){
            temp=temp.next;
        }
        node.next=temp.next;
        temp.next=node;
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
            System.out.println("List is Empty");
            return;
        }
        if(head.next==head){
            head=null;
            return;
        }
        Node tail=head;
        while(tail.next!=head){
            tail=tail.next;
        }
        head=head.next;
        tail.next=head;
    }
    public void delete_last(){
         if(head==null){
            System.out.println("List is Empty");
            return;
        }
        if(head.next==head){
            head=null;
            return;
        }
        Node temp=head;
        while(temp.next.next!=head){
            temp=temp.next;
        }
        temp.next=head;

    }
    public void delete(int pos){
         if(head==null){
            System.out.println("List is Empty");
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
        for(int i=0;i<pos-1;i++){
            temp=temp.next;
        }
        temp.next=temp.next.next;
    }


    //searching functions
    public void search(int val){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp!=null && temp.value!=val){
            temp=temp.next;
        }
        if(temp==null){
            System.out.println("Key not found");
        }
        else{
            System.out.println("Key found");
        }
    }
    
}
