package com.sayon;

public class LL {
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    private Node head;
    public LL(){
        head=null;
    }
    // Inserting functions
    public void insert_first(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            return;
        }
        node.next=head;
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
        
    }
    public void display(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public void insert(int val,int pos){
        Node node=new Node(val);
        if(pos==0){
            insert_first(val);
            return;
        }
        int total=0;
        Node temp=head;
        while(temp!=null){
            total++;
            temp=temp.next;
        }
        if(pos==total){
            insert_last(val);
            return;
        }
        Node tempnew=head;
        for(int i=0;i<pos-1;i++){
            tempnew=tempnew.next;
        }   
        node.next=tempnew.next;
        tempnew.next=node;
    }

    // Deleting functions
    public void delete_first(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        head=head.next;
    }
    public void delete_last(){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(head.next==null){
            head=null;
            return;
        }
        Node temp=head;
        Node prev=null;
        while(temp.next!=null){
            prev=temp;
            temp=temp.next;
        }
        if(prev!=null){
            prev.next=null;
        }
    }
    public void delete(int pos){
        if(head==null){
            System.out.println("List is empty");
            return;
        }
        if(pos==0){
            delete_first();
            return;
        }
        int total=0;
        Node temp=head;
        while(temp!=null){
            total++;
            temp=temp.next;
        }
        if(pos==total-1){
            delete_last();
            return;
        }
        Node tempnew=head;
        Node prev=null;
        while(pos-->0){
            prev=tempnew;
            tempnew=tempnew.next;
        }
        if(prev!=null){
            prev.next=tempnew.next;
        }
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

