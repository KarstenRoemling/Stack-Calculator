
/**
* Beschreiben Sie hier die Klasse Stack.
* 
* @author (Ihr Name) 
* @version (eine Versionsnummer oder ein Datum)
*/
public class Stack<T>
{
    
    private StackNode top;
    
    private class StackNode {
        
        private T content;
        private StackNode nextNode;
        
        public StackNode(T pContent) {
            content = pContent;
        }
        
        public void setNext(StackNode pNext) {
            nextNode = pNext;
        }
        
        public StackNode getNext() {
            return nextNode;
        }
        
        public void setContent(T pContent) {
            content = pContent;
        }
        
        public T getContent() {
            return content;
        }
        
    }
    
    public Stack() {
        top = null;
    }
    
    public T top() {
        if(isEmpty()) {
            return null;
        }
        return top.getContent();
    }
    
    public void push(T pContent) {
        StackNode node = new StackNode(pContent);
        node.setNext(top);
        top = node;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public T pop() {
        if(isEmpty()) {
            return null;
        }
        StackNode node = top;
        top = top.getNext();
        return node.getContent();
    }
    
    public void clear() {
        top = null;   
    }
    
}
