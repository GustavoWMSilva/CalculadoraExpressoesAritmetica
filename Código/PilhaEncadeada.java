import java.util.EmptyStackException;
public class PilhaEncadeada {
    

    
  private class Node {
    public String element;
    public Node next;

    public Node(String element) {
        this.element = element;
        next = null;
    }
    
    public Node(String element, Node next) {
        this.element = element;
        this.next = next;
    }        
}
private Node head;
private int count;
    //Insere o elemento no topo da lista
    public void push(String element)
    {
        Node n = new Node(element);
        n.next = head;
        head = n;
        count++;
    }
    
    //remove e retorna o elemento do topo da pilha
    //erro se a pilha estiver vazia
public String pop()
{
if (count == 0)
{
    throw new EmptyStackException();
}
String elemRemovido = head.element;
            head = head.next;
            count--;
return elemRemovido;
}
//Retorna e retorna o elemento do topo da pilha
    //erro se a pilha estiver vazia
    public String top()
    {
       return head.element;
    }
    //Retorna o numero de elementos da pilha
public int size()
    {
        return count;
    }

     // retorna true se a pilha estiver vazia, e false caso contrário
     public boolean isEmpty() {
        return (head == null);
    }

    // esvazia a pilha
    public void clear() {
        head = null;
        count=0;
    }   
}



