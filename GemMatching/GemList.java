/**
 * Author: Reva Choudha
 * Objective:  to manage a player's gems using a custom LinkedList
 */

public class GemList 
{
	private int size;
	private Node head;

	private class Node {
		private Gem gem;
		private Node next;

		public Node (Gem gem) {
			this.gem = gem;
			this.next = null;
		}
	}

	public GemList() {
		head = null;
		size = 0;
	}
	public static void main(String [] args)
	{
		GemList list = new GemList();
		System.out.println(list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.9);		
		
		list.insertBefore(new Gem(GemType.BLUE, 10), 0);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.8);
		
		list.insertBefore(new Gem(GemType.BLUE, 20), 99);  //not a mistake, should still work
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.7);
		
		list.insertBefore(new Gem(GemType.ORANGE, 30), 1);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.6);
		
		list.insertBefore(new Gem(GemType.ORANGE, 10), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.5);
		
		list.insertBefore(new Gem(GemType.ORANGE, 50), 3);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.4);
		
		list.insertBefore(new Gem(GemType.GREEN, 50), 2);
		System.out.println("\n" + list);
		System.out.println("size = " + list.size() + ", score = " + list.score());
		list.draw(0.3);		
	}

	public int size() {
		// return the number of gems in the list
		return size;
	}
	public void draw(double y) {
		// draw all gems in the list at the given Y-coordinate
		Node current = head;
        for (int i = 0; i < size; i++) {
            current.gem.draw(GemGame.indexToX(i), y);
            current = current.next;
        }

	}
	
	public String toString() {
		// return a string representation of the list
		if (head == null) return "<none>";
        
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.gem.getType());
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        return sb.toString();
    }
	
	public void insertBefore(Gem gem, int index) {
		//insert the given gem before the 0-based index
		Node newNode = new Node(gem);
		if (head == null || index <= 0) {
            newNode.next = head;
            head = newNode;
        } else {
			//if index is >= size, the new gem is inserted at end
			Node current = head;
			for (int i = 0; i < index - 1 && current.next != null; i++) {
				current = current.next;
			}
			newNode.next = current.next;
			current.next = newNode;
		}
		size++;
	}

	public int score() {
		// calculate the total score of the list
		if(head == null) {
			return 0;
		}
        
        int totalScore = 0;
        Node current = head;
        
        while (current != null) {
            GemType currentColor = current.gem.getType();
            int blockSum = 0;
            int blockCount = 0;
            
            while (current != null && current.gem.getType() == currentColor) {
                blockSum += current.gem.getPoints();
                blockCount++;
                current = current.next;
            }
            totalScore += (blockSum * blockCount);
        }
        return totalScore;
	}
	
	
	
}

