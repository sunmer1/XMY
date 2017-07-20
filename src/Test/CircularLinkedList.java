package Test;

public class CircularLinkedList {  
    //java中循环单链表  
    private class Node {//创建一个内部节点类  
        private Node next = null;  
        private Object value = null;  
  
        public Node() {  
  
        }  
  
        public Node(Object value) {  
            this.value = value;  
        }  
    }  
  
    private Node head = null;//新建一个null的头结点  
  
    public CircularLinkedList() {//初始化头结点信息  
        head = new Node(null);  
        head.next = head;  
    }  
  
    public void insertNode(Object insertValue) {//在尾部添加节点  
        Node node = new Node(insertValue);  
        if (head.next == head) {  
            head.next = node;  
            node.next = head;  
        } else {  
            Node temp = head;  
            while (temp.next != head) {  
                temp = temp.next;  
            }  
            temp.next = node;  
            node.next = head;  
        }  
    }  
  
    public void deleteNode(Object deleteValue) {//删除值为deleteValue的节点  
        Node temp = head;  
        while (temp.next != head) {  
            if (temp.next.value.equals(deleteValue)) {  
                temp.next = temp.next.next;  
            } else {  
                temp = temp.next;  
            }  
        }  
    }  
  
    public Object getIndexValue(int index) {//查找位置为index的节点值  
        if (index < 0 || index >= getSize()) {  
            return null;  
        } else {  
            Node node = new Node();  
            int count = 0;  
            Node temp = head;  
            while (temp.next != head) {  
                if (count == index) {  
                    node.value = temp.next.value;  
                    break;  
                }   
                temp = temp.next;  
  
            }  
            return node.value;  
        }  
    }  
  
    public int getValue(Object value) {//查找值为value的节点  
        int count = 0;  
        Node temp = head;  
        while (temp.next != head) {  
            if (temp.next.value.equals(value)) {  
                return count;  
            }  
            count++;  
            temp = temp.next;  
        }  
        return -1;  
    }  
  
    public int getSize() {//获取循环单链表的长度  
        Node temp = head;  
        int size = 0;  
        while (temp.next != head) {  
            size++;  
            temp = temp.next;  
        }  
        return size;  
    }  
  
    public boolean isContain(Object value) {//查找是否包含值为value的节点  
        Node temp = head;  
        while (temp.next != head) {  
            if (temp.next.value.equals(value)) {  
                return true;  
            }  
            temp = temp.next;  
        }  
        return false;  
    }  
  
    public void disPlay() {//打印所有节点数据  
        Node temp = head;  
        while (temp.next != head) {  
            System.out.print(temp.next.value + "\t");  
            temp = temp.next;  
        }  
        System.out.println();  
    }  
      
    public static void main(String[] args) {  
        CircularLinkedList c=new CircularLinkedList();  
        c.insertNode(10);  
        c.insertNode(21);  
        c.insertNode(12);  
        c.insertNode(13);  
        c.insertNode(40);  
        c.disPlay();  
//      System.out.println(c.getSize());  
//      System.out.println(c.getIndexValue(-1));  
//      System.out.println(c.getValue(40));  
//      c.deleteNode(10);  
//      c.disPlay();  
//      c.deleteNode(40);  
//      c.disPlay();  
//      c.deleteNode(12);  
//      c.disPlay();  
        System.out.println(c.isContain(21));
        c.getSize();
        System.out.println(c.getSize());
    }  
}  
