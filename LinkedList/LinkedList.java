import java.util.ArrayList;

public class LinkedList
{
    private int listCount;
    private Node head;
    ArrayList myLinkedList;
    
    public LinkedList()
    {
        head = new Node();
        myLinkedList = new ArrayList<Node>();
        myLinkedList.add(head);
        listCount = 1;
    }
    
    public void add(Node nodeToAdd) {
    	myLinkedList.add(listCount, nodeToAdd);
    	if (size() > 1) {
    		((Node) myLinkedList.get(listCount-1)).setNextNode(nodeToAdd);
    	}
    	
    	listCount++;
    }
    
    public void add(int element) {
    	Node nodeToAdd = new Node(element);
    	myLinkedList.add(listCount, nodeToAdd);
    	if (size() > 1) {
    		((Node) myLinkedList.get(listCount-1)).setNextNode(nodeToAdd);
    	}
    	listCount++;
    }
    
    public void insert(int index, int element) {
    	if (index <= listCount && index >= 0) {
    		Node nodeToAdd = new Node(element);
    		myLinkedList.add(index, nodeToAdd);
    		
    		if (index == listCount) {
    			((Node) myLinkedList.get(index-1)).setNextNode(nodeToAdd);
    		}
    		
    		else if (index > 0) {
    			((Node) myLinkedList.get(index-1)).setNextNode(nodeToAdd);
    			((Node) myLinkedList.get(index)).setNextNode(((Node) myLinkedList.get(index+1)));
    		}
    		
    		else {
    			((Node) myLinkedList.get(index)).setNextNode(((Node) myLinkedList.get(index+1)));
    		}
    		
    		listCount++;
    	}
    	
    	else {
    		System.out.println("This is not a valid index!");
    	}
    }
    
    public void insert(int index, Node nodeToAdd) {
    	if (index <= listCount && index >= 0) {
    		myLinkedList.add(index, nodeToAdd);
    		
    		if (index == listCount) {
    			((Node) myLinkedList.get(index-1)).setNextNode(nodeToAdd);
    		}
    		
    		else if (index > 0) {
    			((Node) myLinkedList.get(index-1)).setNextNode(nodeToAdd);
    			((Node) myLinkedList.get(index)).setNextNode(((Node) myLinkedList.get(index+1)));
    		}
    		
    		else {
    			((Node) myLinkedList.get(index)).setNextNode(((Node) myLinkedList.get(index+1)));
    		}
    		
    		listCount++;
    	}
    	
    	else {
    		System.out.println("This is not a valid index!");
    	}
    }
    
    public Node get (int index) {
		if (myLinkedList != null) {
			if (index < listCount && index >= 0) {
				return (Node) myLinkedList.get(index);
			}
			
			else {
				System.out.println("You have entered an invalid index!");
				return null;
			}
		}
		else {
			System.out.println("Cannot get a node from an empty Linked List!");
			return null;
		}
    }
    
    public void remove (int index) {
    	if (myLinkedList != null) {
    		if (index < listCount && index >= 0) {
    			myLinkedList.remove(index);
    			listCount --;
    		}
    		
    		else {
    			System.out.println("You have entered an invalid index!");
    		}
    	}
    	else System.out.println("Cannot remove nodes from an empty Linked List!");
    }
    
    public int size () {
    	if (myLinkedList != null) {
    		return myLinkedList.size();
    	}
    	else return 0;
    }
}