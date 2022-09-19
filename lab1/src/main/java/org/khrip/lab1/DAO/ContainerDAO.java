package org.khrip.lab1.DAO;



import org.khrip.lab1.models.NumbersNode;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ContainerDAO {
    private NumbersNode head;
    private NumbersNode tail;

    public void add(int number)
    {
        if (head==null)
        {
            head=new NumbersNode();
            tail=new NumbersNode();
            head.setNumber(number);
            head.setNext(null);
            tail=head;
        }else {
            tail.setNext(new NumbersNode());
            tail.getNext().setNumber(number);
            tail.getNext().setNext(null);
            tail=tail.getNext();
        }
    }

    public void delete(int number)
    {
        NumbersNode current=head;
        NumbersNode precurrent=head;
        while(current!=null)
        {
            if(current.getNumber()==number && current==head)
            {
                head=head.getNext();
                current=null;
                current=head;
            }else if(current.getNumber()==number && current!=tail)
            {
                precurrent.setNext(current.getNext());
                current=null;
                current=precurrent.getNext();
            } else if (current.getNumber()==number) {
                tail=precurrent;
                current=null;
            }
            if(current!=null) {
                precurrent = current;
                current = current.getNext();
            }
        }
    }
    public void show1()
    {
        NumbersNode current=head;
        while (current!=null)
        {
            System.out.println(current.getNumber());
            current=current.getNext();
        }
    }

    public ArrayList<NumbersNode> show()
    {
        ArrayList<NumbersNode> numbersNodes=new ArrayList<>();
        NumbersNode current=head;
        while (current!=null)
        {
            numbersNodes.add(current);
            current=current.getNext();
        }
        return numbersNodes;
    }
}
