
/**
* Beschreiben Sie hier die Klasse Stack.
* 
* @author (Ihr Name) 
* @version (eine Versionsnummer oder ein Datum)
*/
public class Stack<T>
{
    
    private StackNode head;
    
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
        head = null;
    }
    
    public T top() {
        if(isEmpty()) {
            return null;
        }
        return head.getContent();
    }
    
    public void push(T pContent) {
        StackNode node = new StackNode(pContent);
        node.setNext(head);
        head = node;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * WICHTIG!
     * 
     * Die pop-Methode muss so in der Klausur nicht implementiert werden.
     * Der alte Head muss nicht zurückgegeben werden. Es genügt daher:
     * 
     * public void pop() {
     *     if(!isEmpty()) {
     *          head = head.getNext();
     *     }
     * }
     * 
     */
    public T pop() {
        if(isEmpty()) {
            return null;
        }
        StackNode node = head;
        head = head.getNext();
        return node.getContent();
    }
    
}
