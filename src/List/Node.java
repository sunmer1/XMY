package List;

public class Node {
 protected Node next;
 public String data;
 
 public Node(String data)
 {
	 this.data=data;
 }

public void display()
 {
	System.out.print(data + " ");
 }
 
}
