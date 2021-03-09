package ImbarcarePasageri;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//Proprietatile membrilor din heap
/**
 * @author Stoian Miruna
 * Am folosit o clasa interna pentru 
 * sortarea si inserarea elementelor in MaxHeap
 */
public  class MaxHeap {

    private class HeapMember {
        String id;
        int priority;

        HeapMember(String s,int p) {
            id = s;
            priority = p;

        }
    }
    private HeapMember[] Heap;
    private int size;
    private int maxsize;
    BufferedWriter out;
    private int checkList;

    // Constructor cu care initializez 
    //un max heap egal cu cea mai mare valoare 
    // primita
    public MaxHeap(int maxsize, BufferedWriter out) throws IOException {
        this.maxsize = maxsize;
        this.size = 0;
        Heap = new HeapMember[this.maxsize + 1];
        Heap[0] = new HeapMember("max", Integer.MAX_VALUE);
        this.out = out;
        this.checkList = 0;
    }

    public void setCheckList() {
        this.checkList = 1;
    }

    // Returnez pozitia parintelui 
    private int parent(int pos) {

        return pos / 2;
    }

    // Returnez copilul stang
    private int leftChild(int pos) {

        return (2 * pos);
    }
    //Returnez copilul drept
    private int rightChild(int pos) {

        return (2 * pos) + 1;
    }

    //Returnez true daca nodul dat este frunza
    private boolean isLeaf(int pos) {
        if (pos >= (size / 2) && pos <= size) {
            return true;
        }
        return false;
    }
    //Schimb valorile intre ele
    private void swap(int fpos, int spos) {
        HeapMember tmp;
        tmp = Heap[fpos];
        Heap[fpos] = Heap[spos];
        Heap[spos] = tmp;
    }

    //Folosesc o functie recursiva cu care Fixez root-ul
    private void maxHeapify(int pos) {

        if (Heap[pos] == null) {
            return;
        }

        if ((( Heap[leftChild(pos)] != null ) && (Heap[pos].priority < Heap[leftChild(pos)].priority)) ||
                (( Heap[rightChild(pos)] != null ) && Heap[pos].priority < Heap[rightChild(pos)].priority)) {
            if (( Heap[rightChild(pos)] != null ) && Heap[leftChild(pos)].priority < Heap[rightChild(pos)].priority) {
                swap(pos, rightChild(pos));
                maxHeapify(rightChild(pos));
            }
            else {
                swap(pos, leftChild(pos));
                maxHeapify(leftChild(pos));
            }
        }

    }

    // Inserez un element  noi in maxheap

    public void insert(Pasager c, int priority)
    {

        Heap[++size] = new HeapMember(c.getId(), c.getPriority());

        // Traverse up and fix violated property
        int current = size;
        while (Heap[current].priority > Heap[parent(current)].priority) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public void list() throws IOException {
        StringBuilder s = new StringBuilder();
        list1(1, s);
        s.setLength(s.length() - 1);
        String str = s.toString();

        if(this.checkList == 0) {
            out.append(str);
            this.setCheckList();
        } else {
            out.append("\n" + str);
        }

    }
    //Folosesc o functie recursiva pentru
    //a afisa in preordine
    public void list1(int index, StringBuilder s)  {
        // StringBuilder s = new StringBuilder();
        if(index > size)
            return ;
        s.append(Heap[index].id + " ");

        list1(2*index, s);
        list1(2*index+1, s);

    }
    // Elimin un element din maxheap
    public void embark ()
    {
        Heap[1]=Heap[size];
        Heap[size] = null;
        size--;
        maxHeapify(1);
    }



}
