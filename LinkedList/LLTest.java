
public class LLTest {

	public static void main (String[] args) {
		LinkedList myList = new LinkedList();
		for (int i = 1; i<=5; i++) {
			myList.add(i);
		}
		
		printMyList(myList);
		
		myList.insert(6, 10);
		
		printMyList(myList);
		
		Node nodeToAccess = myList.get(2);
		System.out.println(nodeToAccess.getData());
		
		myList.remove(6);
		printMyList(myList);
		
		System.out.println("This Linked List contains " + myList.size() + " elements");
		
	}
	
	public static void printMyList (LinkedList myList) {
		for (int i = 0; i < myList.size(); i++) {
			System.out.print(((Node) myList.get(i)).getData() + ", ");
		}
		System.out.println();
	}

}
