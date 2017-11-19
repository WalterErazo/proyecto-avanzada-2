/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyecto_2;

/**
 *
 * @author walte
 */
public class DynQueue<E> implements Queue <E>{
    public class Node<E>{
        private E element;
        private Node <E> next;
        public Node(E element, Node<E> next){
            this.element=element;
            this.next=next;            
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public String toString() {
            return "element=" + element;
        }  
    }
    private Node<E> first;
    private Node<E> last;
    private int Size;
    public  DynQueue(){
        first = null;
        last = null;
        Size=0;
    }
    
    public int size() {
        return Size;
    }

    public boolean isEmpty() {
        return Size==0;
    }

    public void enqueue(E e) {
        Node<E> aux = new Node(e, null);
        if(isEmpty()){
            first = aux;
            last = aux;
        }else{
            if(size() == 1){               
               first.setNext(aux);
            }else{
                last.setNext(aux);                
            }
            last=aux;
        }
        Size++;
    }
    
    public E first() {
       if (isEmpty())
       { 
           return null;
       }                
       return first.getElement();
    }

    public E dequeue() {
        if (isEmpty()){
            return null;
        } 
        E element = first.getElement();
        Node<E> aux = first.getNext();
        first=null;
        first =aux;
        Size--;
        if(isEmpty()){
            last=null;
        }
        return element ;
    }
    public String toString(){
       String cadena="";
        if(isEmpty()){
           return "La lista esta vacia";
       }else{        
           Node<E> aux =first;
           while(aux!=null){
               cadena+=aux;
               aux=aux.getNext();
           }
       }        
       return cadena;
    }
}
