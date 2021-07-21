package me.mat4pat.project2;

public class Class1
{
    int data; // what value each object holds, not necessary for the purpose of counting nodes
    Class1 next;
    static int amountOfNodes=0;

    public Class1(int data) {
        this.data = data;
    }

     static int countNodes(Class1 head) {
        amountOfNodes++;
        if (head.next!=null) { // if the object is still linked it will recurse, until the last node will have no links.
            countNodes(head.next);
        }
        return amountOfNodes;
    }

    public static void main(String[] args) { // create how many nodes as you like
        Class1 node1 = new Class1(5);
        Class1 node2 = new Class1(9);
        Class1 node3 = new Class1(1);
        Class1 node4 = new Class1(2);
        Class1 node5 = new Class1(2);
        Class1 node6 = new Class1(2);
        Class1 node7 = new Class1(2);
        Class1 node8 = new Class1(2);

        // here you link the nodes
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;

        System.out.println(countNodes(node1)); // print amount of nodes
    }
}
